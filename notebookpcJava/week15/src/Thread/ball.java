package Thread;



import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class ball {
public static void main(String[] args) {
	 JFrame jf = new JFrame();
	 
	 jf.setSize(800,800);
	 Mypanel mp = new Mypanel();
	 mp.init();
	 Thread t = new Thread(mp);
	 t.start();
	 mp.setBackground(Color.BLACK);
	 jf.add(mp);
	 jf.setLocationRelativeTo(null);
	 jf.setVisible(true);
	 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}	
class Mypanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x,y,n,m,a,b,c,d,e,f,g1,h;
	void init() {
		x =(int)(Math.random()*200);y=(int)(Math.random()*500);
//		m =(int)(Math.random()*500);n=(int)(Math.random()*300);
//		a =(int)(Math.random()*300);e=(int)(Math.random()*500);
//		b =(int)(Math.random()*400);f=(int)(Math.random()*800);
//		c =(int)(Math.random()*300);g1=(int)(Math.random()*500);
//		d =(int)(Math.random()*200);h=(int)(Math.random()*600);
	}
	public void paint(Graphics g) {
	
		super.paint(g);
		g.setColor(Color.WHITE);
		for(int i =0;i<300;i++) {
//		g.drawString("*", (int)(Math.random()*800), (int)(Math.random()*800));
				g.drawString("*", (int)(Math.random()*500),(int)(Math.random()*500));
		
			
		}
	}
	@Override
	public void run() {
		while(true) {
			repaint();
			while(x>800&&y>800) init();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

