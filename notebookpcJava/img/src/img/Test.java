package img;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	int codelength = 64;

	public String getCode(BufferedImage image) {

		StringBuffer sb = new StringBuffer();
		StringBuffer sbr = new StringBuffer();
		StringBuffer sbg = new StringBuffer();
		StringBuffer sbb = new StringBuffer();

		int x, y;

		for (y = 0; y < image.getHeight(); y++) // 按行扫描
		{
			for (x = 0; x < image.getWidth(); x++) {

				int pixel = image.getRGB(x, y);
				// int alpha = (pixel >> 24) & 0xFF;
				int red = (pixel >> 16) & 0xFF;
				int green = (pixel >> 8) & 0xFF;
				int blue = pixel & 0xFF;

				/*
				 * 将颜色值合转换为二进制数
				 */
				if (red > 128) {
					sbr.append(1);
				} else {
					sbr.append(0);
				}

				if (green > 128) {
					sbg.append(1);
				} else {
					sbg.append(0);
				}

				if (blue > 128) {
					sbb.append(1);
				} else {
					sbb.append(0);
				}

			}
		}
		
		
		
		sb.append(sbr).append(sbg).append(sbb);
		int hebing = 0;
		hebing = sb.length() / codelength;
		if (sb.length() % codelength != 0) {
			hebing++;
		}

		int sumcode = 0;
		StringBuffer s = new StringBuffer();
		for (int i = 1; i < sb.length() + 1; i++) {
			if (sb.charAt(i - 1) == '1') {
				sumcode++;
			}
			// 够合并的长度合并
			if (i % hebing == 0) {
				if (sumcode >= (hebing / 2)) {
					s.append(1);
				} else {
					s.append(0);
				}
				sumcode = 0;
			}

		}

		// 末尾补充,最后合并时不一定正好够长度，需要将未合并的进行补充。
		if (s.length() < codelength) {
			if (sumcode >= (hebing / 2)) {
				s.append(1);
			} else {
				s.append(0);
			}

		}

		sbr.setLength(0);
		sbg.setLength(0);
		sbb.setLength(0);
		sb.setLength(0);
		return s.toString();
	}

	public static void main(String[] args) throws IOException {

		File filepath = new File("D:\\Documents\\Tencent Files\\358737741\\FileRecv\\MobileFile\\7.jpg");
		BufferedImage image = ImageIO.read(filepath);
		String hashcode = new Test().getCode(image);
		System.out.println(hashcode);

	}

}