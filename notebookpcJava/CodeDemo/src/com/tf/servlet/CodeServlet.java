package com.tf.servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/code")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("exipres", "0");
		
		
		//ͼƬ��֤��
		int width = 110;
		int height = 30;
		//����һ��������ͼƬ
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//��ȡһ������
		Graphics g = img.getGraphics();
		
		//���ñ������ɫ
		g.setColor(Color.PINK);
		//�������ͣ�ǰ������xy��Ŀ�ʼ���� �����ǻ��ƵĴ�С
		g.fillRect(1, 1, width-2, height-2);
		
		//���Ʊ߿�
		g.setColor(Color.BLUE);
		//�������ͣ�ǰ������xy��Ŀ�ʼ���� �����ǻ��ƵĴ�С
		g.drawRect(0, 0, width-1, height-1);
		
		//������֤������
		g.setColor(Color.BLACK);
		//�������ͣ��������ͣ��Ӵֺ���б�м���|�ָ����������С
		g.setFont(new Font("����",Font.BOLD|Font.ITALIC,25));
		
		//����������֤�����ֵ�����
		int position = 20;
		for (int i = 0; i < 2; i++) {
			//�������ͣ����Ƶ����ݣ����Ƶ����� x,y 
			g.drawString(new Random().nextInt(10)+"", position, 24);
			g.drawString((char)(new Random().nextInt('Z'-'A')+'A')+"", position+20, 24);
			position+=40;
		}
		
		//���Ƹ�����
		g.setColor(Color.GREEN);
		for (int i = 0; i < 9; i++) {
		//��������  ��ʼλ��(x1,y1)    ��ֹλ��(x2,y2)
			g.drawLine(new Random().nextInt(width), new Random().nextInt(height), new Random().nextInt(width), new Random().nextInt(height));
		}
		
		
		
		//�����ͼƬ  ��ͼƬ��������
		//�������ͣ�������ͼƬ����ͼƬ��ʽ�������ͼƬ�ķ�ʽ
		ImageIO.write(img, "png", response.getOutputStream());
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
