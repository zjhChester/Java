package com.yll.arcsoft.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.arcsoft.AFD_FSDKLibrary;
import com.arcsoft.AFD_FSDK_FACERES;
import com.arcsoft.AFR_FSDKLibrary;
import com.arcsoft.AFR_FSDK_FACEINPUT;
import com.arcsoft.AFR_FSDK_FACEMODEL;
import com.arcsoft.ASVLOFFSCREEN;
import com.arcsoft.ASVL_COLOR_FORMAT;
import com.arcsoft.CLibrary;
import com.arcsoft.FaceInfo;
import com.arcsoft.MRECT;
import com.arcsoft._AFD_FSDK_OrientPriority;
import com.arcsoft.utils.BufferInfo;
import com.arcsoft.utils.ImageLoader;
import com.jzg.buildworker.common.CommonConstants.Symbol;
import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
 
public final class ArcsoftUtil
{
    public static final int FD_WORKBUF_SIZE = 20 * 1024 * 1024;
    public static final int FR_WORKBUF_SIZE = 40 * 1024 * 1024;
    public static final int MAX_FACE_NUM = 50;
    public static final boolean bUseRAWFile = false;
    public static final boolean bUseBGRToEngine = true;
    private static final Logger logger = LoggerFactory.getLogger(ArcsoftUtil.class);
    private static Pointer pFDWorkMem = CLibrary.INSTANCE.malloc(FD_WORKBUF_SIZE);
    private static Pointer pFRWorkMem = CLibrary.INSTANCE.malloc(FR_WORKBUF_SIZE);
    
    public static Pointer getFDEngine() throws Exception {
        PointerByReference phFDEngine = new PointerByReference();
        if(!CommonUtils.isExist(pFDWorkMem)) {
            pFDWorkMem = CLibrary.INSTANCE.malloc(FD_WORKBUF_SIZE);
        }
        NativeLong ret = AFD_FSDKLibrary.INSTANCE.AFD_FSDK_InitialFaceEngine(Config.ARCSORT_APPID, Config.ARCSORT_FD_SDKKEY, pFDWorkMem, FD_WORKBUF_SIZE, phFDEngine, _AFD_FSDK_OrientPriority.AFD_FSDK_OPF_0_HIGHER_EXT, 32, MAX_FACE_NUM);
        if (ret.longValue() != 0) {
            throw new Exception(String.format("AFD_FSDK_InitialFaceEngine code:",Integer.valueOf(ret.longValue()+Symbol.EMPTY_STR, 16)));
        }
        return phFDEngine.getValue();
    }
    
    public static Pointer getFREngine() throws Exception {
        PointerByReference phFREngine = new PointerByReference();
        if(!CommonUtils.isExist(pFRWorkMem)) {
            pFRWorkMem = CLibrary.INSTANCE.malloc(FR_WORKBUF_SIZE);
        }
        NativeLong ret = AFR_FSDKLibrary.INSTANCE.AFR_FSDK_InitialEngine(Config.ARCSORT_APPID, Config.ARCSORT_FR_SDKKEY, pFRWorkMem, FR_WORKBUF_SIZE, phFREngine);
        if (ret.longValue() != 0) {
            throw new Exception(String.format("AFD_FSDK_InitialFaceEngine ret 0x%x",ret.longValue()));
        }
        return phFREngine.getValue();
    }
    
    public static AFR_FSDK_FACEMODEL getImageFaceFeature(String imagePath) throws Exception {
        ASVLOFFSCREEN inputImg = loadImage(imagePath);
        FaceInfo[] faceInfos = doFaceDetection(ArcsoftUtil.getFDEngine(), inputImg);
        if (faceInfos.length < 1) {
            logger.warn("no face in Image of Input! ");
            return null;
        }
        AFR_FSDK_FACEMODEL faceFeature = extractFRFeature(ArcsoftUtil.getFREngine(), inputImg, faceInfos[0]);
        if (faceFeature == null) {
            logger.warn("extract face feature in Image failed");
        }
        return faceFeature;
    }
    
    public static AFR_FSDK_FACEMODEL getRAWImageFaceFeature(String imagePath) throws Exception {
        ASVLOFFSCREEN inputImg = loadRAWImage(imagePath, 640, 480, ASVL_COLOR_FORMAT.ASVL_PAF_I420);
        FaceInfo[] faceInfos = doFaceDetection(ArcsoftUtil.getFDEngine(), inputImg);
        if (faceInfos.length < 1) {
            logger.warn("no face in Image of Input! ");
        }
        AFR_FSDK_FACEMODEL faceFeature = extractFRFeature(ArcsoftUtil.getFREngine(), inputImg, faceInfos[0]);
        if (faceFeature == null) {
            logger.warn("extract face feature in Image  failed");
        }
        return faceFeature;
    }
    
    public static FaceInfo[] doFaceDetection(Pointer hFDEngine, ASVLOFFSCREEN inputImg) {
        FaceInfo[] faceInfo = new FaceInfo[0];

        PointerByReference ppFaceRes = new PointerByReference();
        NativeLong ret = AFD_FSDKLibrary.INSTANCE.AFD_FSDK_StillImageFaceDetection(hFDEngine, inputImg, ppFaceRes);
        if (ret.longValue() != 0) {
            logger.warn(String.format("AFD_FSDK_StillImageFaceDetection ret 0x%x" , ret.longValue()));
            return faceInfo;
        }

        AFD_FSDK_FACERES faceRes = new AFD_FSDK_FACERES(ppFaceRes.getValue());
        if (faceRes.nFace > 0) {
            faceInfo = new FaceInfo[faceRes.nFace];
            for (int i = 0; i < faceRes.nFace; i++) {
                MRECT rect = new MRECT(new Pointer(Pointer.nativeValue(faceRes.rcFace.getPointer()) + faceRes.rcFace.size() * i));
                int orient = faceRes.lfaceOrient.getPointer().getInt(i * 4);
                faceInfo[i] = new FaceInfo();
                faceInfo[i].left = rect.left;
                faceInfo[i].top = rect.top;
                faceInfo[i].right = rect.right;
                faceInfo[i].bottom = rect.bottom;
                faceInfo[i].orient = orient;
            }
        }
        return faceInfo;
    }
    
    public static AFR_FSDK_FACEMODEL extractFRFeature(Pointer hFREngine, ASVLOFFSCREEN inputImg, FaceInfo faceInfo) throws Exception {
        AFR_FSDK_FACEINPUT faceinput = new AFR_FSDK_FACEINPUT();
        faceinput.lOrient = faceInfo.orient;
        faceinput.rcFace.left = faceInfo.left;
        faceinput.rcFace.top = faceInfo.top;
        faceinput.rcFace.right = faceInfo.right;
        faceinput.rcFace.bottom = faceInfo.bottom;

        AFR_FSDK_FACEMODEL faceFeature = new AFR_FSDK_FACEMODEL();
        NativeLong ret = AFR_FSDKLibrary.INSTANCE.AFR_FSDK_ExtractFRFeature(hFREngine, inputImg, faceinput, faceFeature);
        if (ret.longValue() != 0) {
            logger.warn(String.format("AFR_FSDK_ExtractFRFeature ret code" ,Integer.valueOf(ret.longValue()+Symbol.EMPTY_STR, 16)));
            return null;
        }
        return faceFeature.deepCopy();
    }
    
    public static ASVLOFFSCREEN loadImage(String filePath) throws IOException {
        ASVLOFFSCREEN inputImg = new ASVLOFFSCREEN();
        if (bUseBGRToEngine) {
            BufferInfo bufferInfo = ImageLoader.getBGRFromFile(filePath);
            inputImg.u32PixelArrayFormat = ASVL_COLOR_FORMAT.ASVL_PAF_RGB24_B8G8R8;
            inputImg.i32Width = bufferInfo.width;
            inputImg.i32Height = bufferInfo.height;
            inputImg.pi32Pitch[0] = inputImg.i32Width * 3;
            inputImg.ppu8Plane[0] = new Memory(inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[0].write(0, bufferInfo.buffer, 0, inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[1] = Pointer.NULL;
            inputImg.ppu8Plane[2] = Pointer.NULL;
            inputImg.ppu8Plane[3] = Pointer.NULL;
        } else {
            BufferInfo bufferInfo = ImageLoader.getI420FromFile(filePath);
            inputImg.u32PixelArrayFormat = ASVL_COLOR_FORMAT.ASVL_PAF_I420;
            inputImg.i32Width = bufferInfo.width;
            inputImg.i32Height = bufferInfo.height;
            inputImg.pi32Pitch[0] = inputImg.i32Width;
            inputImg.pi32Pitch[1] = inputImg.i32Width / 2;
            inputImg.pi32Pitch[2] = inputImg.i32Width / 2;
            inputImg.ppu8Plane[0] = new Memory(inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[0].write(0, bufferInfo.buffer, 0, inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[1] = new Memory(inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[1].write(0, bufferInfo.buffer, inputImg.pi32Pitch[0] * inputImg.i32Height, inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[2] = new Memory(inputImg.pi32Pitch[2] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[2].write(0, bufferInfo.buffer, inputImg.pi32Pitch[0] * inputImg.i32Height + inputImg.pi32Pitch[1] * inputImg.i32Height / 2, inputImg.pi32Pitch[2] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[3] = Pointer.NULL;
        }
        inputImg.setAutoRead(false);
        return inputImg;
    }
    public static ASVLOFFSCREEN loadRAWImage(String yuv_filePath, int yuv_width, int yuv_height, int yuv_format) throws Exception {
        int yuv_rawdata_size = 0;
        ASVLOFFSCREEN inputImg = new ASVLOFFSCREEN();
        inputImg.u32PixelArrayFormat = yuv_format;
        inputImg.i32Width = yuv_width;
        inputImg.i32Height = yuv_height;
        if (ASVL_COLOR_FORMAT.ASVL_PAF_I420 == inputImg.u32PixelArrayFormat) {
            inputImg.pi32Pitch[0] = inputImg.i32Width;
            inputImg.pi32Pitch[1] = inputImg.i32Width / 2;
            inputImg.pi32Pitch[2] = inputImg.i32Width / 2;
            yuv_rawdata_size = inputImg.i32Width * inputImg.i32Height * 3 / 2;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_NV12 == inputImg.u32PixelArrayFormat) {
            inputImg.pi32Pitch[0] = inputImg.i32Width;
            inputImg.pi32Pitch[1] = inputImg.i32Width;
            yuv_rawdata_size = inputImg.i32Width * inputImg.i32Height * 3 / 2;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_NV21 == inputImg.u32PixelArrayFormat) {
            inputImg.pi32Pitch[0] = inputImg.i32Width;
            inputImg.pi32Pitch[1] = inputImg.i32Width;
            yuv_rawdata_size = inputImg.i32Width * inputImg.i32Height * 3 / 2;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_YUYV == inputImg.u32PixelArrayFormat) {
            inputImg.pi32Pitch[0] = inputImg.i32Width * 2;
            yuv_rawdata_size = inputImg.i32Width * inputImg.i32Height * 2;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_RGB24_B8G8R8 == inputImg.u32PixelArrayFormat) {
            inputImg.pi32Pitch[0] = inputImg.i32Width * 3;
            yuv_rawdata_size = inputImg.i32Width * inputImg.i32Height * 3;
        } else {
            throw new Exception("unsupported  your format");
        }

        // load YUV Image Data from File
        byte[] imagedata = new byte[yuv_rawdata_size];
        File f = new File(yuv_filePath);
        try(InputStream ios = new FileInputStream(f);){
            ios.read(imagedata,0,yuv_rawdata_size);

        } 
        if (ASVL_COLOR_FORMAT.ASVL_PAF_I420 == inputImg.u32PixelArrayFormat) {
            inputImg.ppu8Plane[0] = new Memory(inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[0].write(0, imagedata, 0, inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[1] = new Memory(inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[1].write(0, imagedata, inputImg.pi32Pitch[0] * inputImg.i32Height, inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[2] = new Memory(inputImg.pi32Pitch[2] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[2].write(0, imagedata, inputImg.pi32Pitch[0] * inputImg.i32Height + inputImg.pi32Pitch[1] * inputImg.i32Height / 2, inputImg.pi32Pitch[2] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[3] = Pointer.NULL;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_NV12 == inputImg.u32PixelArrayFormat) {
            inputImg.ppu8Plane[0] = new Memory(inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[0].write(0, imagedata, 0, inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[1] = new Memory(inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[1].write(0, imagedata, inputImg.pi32Pitch[0] * inputImg.i32Height, inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[2] = Pointer.NULL;
            inputImg.ppu8Plane[3] = Pointer.NULL;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_NV21 == inputImg.u32PixelArrayFormat) {
            inputImg.ppu8Plane[0] = new Memory(inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[0].write(0, imagedata, 0, inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[1] = new Memory(inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[1].write(0, imagedata, inputImg.pi32Pitch[0] * inputImg.i32Height, inputImg.pi32Pitch[1] * inputImg.i32Height / 2);
            inputImg.ppu8Plane[2] = Pointer.NULL;
            inputImg.ppu8Plane[3] = Pointer.NULL;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_YUYV == inputImg.u32PixelArrayFormat) {
            inputImg.ppu8Plane[0] = new Memory(inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[0].write(0, imagedata, 0, inputImg.pi32Pitch[0] * inputImg.i32Height);
            inputImg.ppu8Plane[1] = Pointer.NULL;
            inputImg.ppu8Plane[2] = Pointer.NULL;
            inputImg.ppu8Plane[3] = Pointer.NULL;
        } else if (ASVL_COLOR_FORMAT.ASVL_PAF_RGB24_B8G8R8 == inputImg.u32PixelArrayFormat) {
            inputImg.ppu8Plane[0] = new Memory(imagedata.length);
            inputImg.ppu8Plane[0].write(0, imagedata, 0, imagedata.length);
            inputImg.ppu8Plane[1] = Pointer.NULL;
            inputImg.ppu8Plane[2] = Pointer.NULL;
            inputImg.ppu8Plane[3] = Pointer.NULL;
        } else {
            throw new Exception("unsupported your format");
        }
        inputImg.setAutoRead(false);
        return inputImg;
    }
}
