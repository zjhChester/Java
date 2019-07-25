package com.SUM;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Sum extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tf1, tf2, result;
	JLabel jia;
	JButton deng;
	int c;
	public Sum() {
		// TODO Auto-generated constructor stub

		tf1 = new JTextField(5);
		tf2 = new JTextField(5);
		result = new JTextField(10);
		jia = new JLabel(" + ");
		
		deng = new JButton(" 等于 ");
		setTitle("加法计算");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(tf1);
		container.add(jia);
		container.add(tf2);

		container.add(deng);
		container.add(result);
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		deng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				if(e.getSource() == deng)
				c=Integer.parseInt(tf1.getText())+Integer.parseInt(tf2.getText());
				result.setText(String.valueOf(c));
			}
		});
	}

	public static void main(String[] args) {
		new Sum();
	}
}
