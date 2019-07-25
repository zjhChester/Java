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

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/code")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("exipres", "0");
		
		int width = 130;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		//��ȡ����
		Graphics g = img.getGraphics();
		//���
		g.setColor(Color.PINK);
		g.fillRect(1, 1, width-2, height-2);
		//���ƿ��
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		//���������
		g.setFont(new Font("����",Font.BOLD|Font.ITALIC, 22));
	
		int poi = 20;
		for (int i = 0; i < 4; i++) {
			g.drawString(""+(char)(new Random().nextInt('Z'-'A')+'A'), poi, 20);
			poi+=20;
		}
		//���ɸ�����
		g.setColor(Color.BLUE);
		for (int i = 0; i < 5; i++) {
			g.drawLine(new Random().nextInt(width), new Random().nextInt(height), new Random().nextInt(width), new Random().nextInt(height));
		}
		
		ImageIO.write(img, "png", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
