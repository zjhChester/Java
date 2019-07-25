package com.Jframe;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Myball  {
	
	public static void main(String[] args) {

		Frame w = new Frame();
		w.setSize(600, 600);
		Mypanel mp = new Mypanel();

		w.add(mp);
		mp.addKeyListener(mp);
		w.addKeyListener(mp);
		w.setVisible(true);
		mywindowlistener mw = new mywindowlistener();
		w.addWindowListener(mw);
	}

	

}

class mywindowlistener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class Mypanel extends Panel implements KeyListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread t;
	int x = 30;
	int y = 30;
	int grade = 0;
	int x1 = (int) (Math.random() * 300 + 30);
	int y1 = (int) (Math.random() * 300 + 30);

	public void init() {
		x1 = (int) (Math.random() * 300 + 30);
		y1 = (int) (Math.random() * 300 + 30);
	}

	public void paint(Graphics g) {
		g.setFont(new Font("楷体", Font.BOLD, 20));
		g.drawString("移动图标到指定地点获得得分：20分       当前分数：\t" + grade, 20, 20);
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.red);
		g.fillOval(x1, y1, 30, 30);
		x1++;
		y1++;
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if (Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y)) > 10) {
			if (e.getKeyCode() == 37) {
				x -= 10;
			}
			if (e.getKeyCode() == 38) {
				y -= 10;
			}
			if (e.getKeyCode() == 39) {
				x += 10;
			}
			if (e.getKeyCode() == 40) {
				y += 10;
			}
		} else {
			if (e.getKeyCode() == 37) {
				x -= 1;
			}
			if (e.getKeyCode() == 38) {
				y -= 1;
			}
			if (e.getKeyCode() == 39) {
				x += 1;
			}
			if (e.getKeyCode() == 40) {
				y += 1;
			}
			
		}
		if (x1 == x && y1 == y) {
			
			grade += 20;
			init();
		}
		repaint();

	}

	public void keyTyped(KeyEvent e) {
	}

	
}