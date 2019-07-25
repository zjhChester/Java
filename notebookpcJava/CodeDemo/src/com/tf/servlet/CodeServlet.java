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
		
		
		//图片验证码
		int width = 110;
		int height = 30;
		//创建一个缓存型图片
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//获取一个画笔
		Graphics g = img.getGraphics();
		
		//设置背景填充色
		g.setColor(Color.PINK);
		//参数解释：前两个是xy轴的开始坐标 后面是绘制的大小
		g.fillRect(1, 1, width-2, height-2);
		
		//绘制边框
		g.setColor(Color.BLUE);
		//参数解释：前两个是xy轴的开始坐标 后面是绘制的大小
		g.drawRect(0, 0, width-1, height-1);
		
		//绘制验证码内容
		g.setColor(Color.BLACK);
		//参数解释：字体类型，加粗和倾斜中间用|分隔开，字体大小
		g.setFont(new Font("黑体",Font.BOLD|Font.ITALIC,25));
		
		//给定出现验证码文字的坐标
		int position = 20;
		for (int i = 0; i < 2; i++) {
			//参数解释：绘制的内容，绘制的坐标 x,y 
			g.drawString(new Random().nextInt(10)+"", position, 24);
			g.drawString((char)(new Random().nextInt('Z'-'A')+'A')+"", position+20, 24);
			position+=40;
		}
		
		//绘制干扰线
		g.setColor(Color.GREEN);
		for (int i = 0; i < 9; i++) {
		//参数解释  起始位置(x1,y1)    终止位置(x2,y2)
			g.drawLine(new Random().nextInt(width), new Random().nextInt(height), new Random().nextInt(width), new Random().nextInt(height));
		}
		
		
		
		//输出该图片  以图片输出流输出
		//参数解释：缓存型图片对象，图片格式，传输该图片的方式
		ImageIO.write(img, "png", response.getOutputStream());
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
