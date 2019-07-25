package test;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class bgcolor extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new bgcolor();
	}
	JFrame jFrame;
	public bgcolor() {
		// TODO Auto-generated constructor stub
	jFrame = new JFrame();
	Container container = jFrame.getContentPane();
	
	container.setBackground(Color.red);
	jFrame.setSize(500,500);
	jFrame.setVisible(true);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
