package week7_mon_TestDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\工作文档\\爱剪辑-B站视频第三期.mp4")));
		int len= 0;
		char[] b = new char[1024];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\copy.mp4")));
		while((len=br.read(b))!=-1)
		{
			bw.write(b, 0, len);
		}
		bw.flush();
		bw.close();
		br.close();
		//输出
		
		
		
	}
}
