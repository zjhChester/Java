package test;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class yanzhengma extends JFrame implements ActionListener {

	/**
	 * 
	 */
	public static void main(String[] args) {
		new yanzhengma();
	}

	private static final long serialVersionUID = 1L;
	JFrame mywidow, yjf;
	JButton btn, frash, enter;
	JTextField jtx1;
	JLabel jLabel, jLabel2;

	int[] n = new int[4];
	Random rand = new Random();

	public yanzhengma() {
		// TODO Auto-generated constructor stub
		mywidow = new JFrame();
		yjf = new JFrame();
		btn = new JButton("获取验证码");
		frash = new JButton("刷新");
		enter = new JButton("确定");

		jtx1 = new JTextField(5);
	
		jLabel = new JLabel();
		jLabel.setFont(new Font("Courier", Font.BOLD, 25));
		mywidow.setLayout(new FlowLayout());
		mywidow.setSize(300, 200);
		mywidow.setLocation(500, 300);
		mywidow.add(btn);
		mywidow.setVisible(true);
		mywidow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(this);
		frash.addActionListener(this);
		enter.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			n[0] = (int) (Math.random() * 26 + 97);
			n[1] = (int) (Math.random() * 26 + 65);
			n[2] = (int) (Math.random() * 9 + 1);
			n[3] = (int) (Math.random() * 9 + 1);
			jLabel.setText((char) n[0] + " " + (char) n[1] + " " + n[2] + " " + n[3] + " ");
			yjf.add(jLabel);
			yjf.add(jtx1);
			yjf.add(frash);
			yjf.add(enter);
			yjf.setSize(200, 300);
			yjf.setVisible(true);
			yjf.setLayout(new FlowLayout());
			yjf.setLocation(500, 300);
			yjf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		if (e.getSource() == frash) {
			
			n[0] = (int) (Math.random() * 26 + 97);
			n[1] = (int) (Math.random() * 26 + 65);
			n[2] = (int) (Math.random() * 9 + 1);
			n[3] = (int) (Math.random() * 9 + 1);
			jLabel.setText((char) n[0] + " " + (char) n[1] + " " + n[2] + " " + n[3] + " ");
			
			jtx1.setText("");
		}
		if (e.getSource() == enter) {
			if (jtx1.getText().equals(String.valueOf((char) n[0] + "" + (char) n[1] + "" + n[2] + "" + n[3]))) {
				jtx1.setText("");
				n[0] = (int) (Math.random() * 26 + 97);
				n[1] = (int) (Math.random() * 26 + 65);
				n[2] = (int) (Math.random() * 9 + 1);
				n[3] = (int) (Math.random() * 9 + 1);
				jLabel.setText((char) n[0] + " " + (char) n[1] + " " + n[2] + " " + n[3] + " ");
				JOptionPane.showMessageDialog(null, "奈斯正确！", "验证登录信息", JOptionPane.PLAIN_MESSAGE);

			} else {
				n[0] = (int) (Math.random() * 26 + 97);
				n[1] = (int) (Math.random() * 26 + 65);
				n[2] = (int) (Math.random() * 9 + 1);
				n[3] = (int) (Math.random() * 9 + 1);
				jLabel.setText((char) n[0] + " " + (char) n[1] + " " + n[2] + " " + n[3] + " ");
				JOptionPane.showMessageDialog(null, "输错啦小傻瓜！", "验证登录信息", JOptionPane.PLAIN_MESSAGE);
				// System.out.println(Integer.parseInt(jtx1.getText()==Integer.parseInt(n[0]+n[1]+n[2]+n[3])));
				jtx1.setText("");
			}
		}

	}

}
