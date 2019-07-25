package com.SUM;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calculatorweek13 extends JFrame {
	public static void main(String[] args) {
		new calculatorweek13();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b0;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton cheng;
	JButton chu;
	JButton jian;
	JButton jia;
	JButton clean;
	JButton deng;
	JButton point;
	JButton exit;
	JButton delete;
	JTextField t, t0;
	JLabel jLabel;
	String s = "", c = "";
	double num1 = 0;
	double num2 = 0;
	String symbol = "";
	String check = "";
	int Exit = 0;

	public calculatorweek13() {
		t0 = new JTextField(20);
		t = new JTextField(20);

		b0 = new JButton(" 0 ");
		b1 = new JButton(" 1 ");
		b2 = new JButton(" 2 ");
		b3 = new JButton(" 3 ");
		b4 = new JButton(" 4 ");
		b5 = new JButton(" 5 ");
		b6 = new JButton(" 6 ");
		b7 = new JButton(" 7 ");
		b8 = new JButton(" 8 ");
		b9 = new JButton(" 9 ");
		deng = new JButton(" = ");
		jia = new JButton(" + ");
		jian = new JButton(" - ");
		cheng = new JButton(" * ");
		chu = new JButton(" / ");
		clean = new JButton(" C ");
		exit = new JButton(" 退出 ");
		point = new JButton(" . ");
		delete = new JButton(" ← ");
		jLabel = new JLabel("designed by 张小皮   ", JLabel.CENTER);
		jLabel.setFont(new Font("隶书", Font.BOLD, 12));
		jLabel.setForeground(Color.RED);
		Container c = getContentPane();
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		jPanel1.setLayout(new GridLayout(2, 1));
		jPanel2.setLayout(new GridLayout(4, 4, 5, 5));
		jPanel3.setLayout(new GridLayout(2, 1));
		c.setLayout(new GridLayout(3, 1));
		c.add(jPanel1);
		c.add(jPanel2);
		c.add(jPanel3);

		t.setFont(new Font("楷体", Font.BOLD, 70));
		jia.setFont(new Font("楷体", Font.BOLD, 22));
		jian.setFont(new Font("楷体", Font.BOLD, 22));
		cheng.setFont(new Font("楷体", Font.BOLD, 22));
		chu.setFont(new Font("楷体", Font.BOLD, 22));
		deng.setFont(new Font("楷体", Font.BOLD, 22));
		clean.setFont(new Font("楷体", Font.BOLD, 22));
		b0.setFont(new Font("楷体", Font.BOLD, 22));
		b1.setFont(new Font("楷体", Font.BOLD, 22));
		b2.setFont(new Font("楷体", Font.BOLD, 22));
		b3.setFont(new Font("楷体", Font.BOLD, 22));
		b4.setFont(new Font("楷体", Font.BOLD, 22));
		b5.setFont(new Font("楷体", Font.BOLD, 22));
		b6.setFont(new Font("楷体", Font.BOLD, 22));
		b7.setFont(new Font("楷体", Font.BOLD, 22));
		b8.setFont(new Font("楷体", Font.BOLD, 22));
		b9.setFont(new Font("楷体", Font.BOLD, 22));
		point.setFont(new Font("楷体", Font.BOLD, 22));
		exit.setFont(new Font("楷体", Font.BOLD, 22));
		delete.setFont(new Font("楷体", Font.BOLD, 22));
		exit.setForeground(Color.RED);

		b0.setBackground(Color.green);
		b0.setForeground(Color.white);
		b1.setBackground(Color.green);
		b1.setForeground(Color.white);
		b2.setBackground(Color.green);
		b2.setForeground(Color.white);
		b3.setBackground(Color.green);
		b3.setForeground(Color.white);
		b4.setBackground(Color.green);
		b4.setForeground(Color.white);
		b5.setBackground(Color.green);
		b5.setForeground(Color.white);
		b6.setBackground(Color.green);
		b6.setForeground(Color.white);
		b7.setBackground(Color.green);
		b7.setForeground(Color.white);
		b8.setBackground(Color.green);
		b8.setForeground(Color.white);
		b9.setBackground(Color.green);
		b9.setForeground(Color.white);
		point.setBackground(Color.green);
		point.setForeground(Color.white);

		jia.setBackground(Color.cyan);
		jia.setForeground(Color.white);
		jian.setBackground(Color.CYAN);
		jian.setForeground(Color.white);
		cheng.setBackground(Color.CYAN);
		cheng.setForeground(Color.white);
		chu.setBackground(Color.CYAN);
		chu.setForeground(Color.white);
		delete.setBackground(Color.CYAN);
		delete.setForeground(Color.blue);
		deng.setBackground(Color.orange);
		t.setBackground(Color.BLACK);
		t.setForeground(Color.WHITE);

		t0.setBackground(Color.gray);
		t0.setForeground(Color.WHITE);
		exit.setBackground(Color.pink);
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.black);

		clean.setBackground(Color.LIGHT_GRAY);
		clean.setForeground(Color.BLACK);
		jPanel1.add(t0);
		jPanel1.add(t);
		jPanel2.add(b7);
		jPanel2.add(b8);
		jPanel2.add(b9);
		jPanel2.add(chu);
		jPanel2.add(b4);
		jPanel2.add(b5);
		jPanel2.add(b6);
		jPanel2.add(cheng);
		jPanel2.add(b1);
		jPanel2.add(b2);
		jPanel2.add(b3);
		jPanel2.add(jian);
		jPanel2.add(b0);
		jPanel2.add(point);
		jPanel2.add(deng);
		jPanel2.add(jia);
		jPanel3.add(clean);
		jPanel3.add(delete);
		jPanel3.add(exit);

		jPanel3.add(jLabel);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.setTitle("  豪哥的计算器  ");
		this.setSize(350, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyListenner myListenner = new MyListenner();
		b0.addActionListener(myListenner);
		b1.addActionListener(myListenner);
		b2.addActionListener(myListenner);
		b3.addActionListener(myListenner);
		b4.addActionListener(myListenner);
		b5.addActionListener(myListenner);
		b6.addActionListener(myListenner);
		b7.addActionListener(myListenner);
		b8.addActionListener(myListenner);
		b9.addActionListener(myListenner);
		deng.addActionListener(myListenner);
		jia.addActionListener(myListenner);
		jian.addActionListener(myListenner);
		cheng.addActionListener(myListenner);
		chu.addActionListener(myListenner);
		clean.addActionListener(myListenner);
		point.addActionListener(myListenner);
		delete.addActionListener(myListenner);
		exit.addActionListener(myListenner);
		

	}

	public class MyListenner implements ActionListener {
		int i = 0;

		public void actionPerformed(ActionEvent e) {

			i++;
			t.setFont(new Font("楷体", Font.BOLD, 50));
			t0.setFont(new Font("楷体", Font.BOLD, 30));
			if (i % 2 == 0) {
				jLabel.setBackground(Color.YELLOW);
				jLabel.setForeground(Color.BLACK);
				if (i % 4 == 0) {
					jLabel.setBackground(Color.magenta);
					jLabel.setForeground(Color.black);
				}
			}
			if (i % 2 != 0) {
				jLabel.setBackground(Color.BLACK);
				jLabel.setForeground(Color.red);
				if (i % 3 == 0) {

					jLabel.setBackground(Color.BLUE);
					jLabel.setForeground(Color.GREEN);

				}
				if (i % 5 == 0) {
					jLabel.setBackground(Color.pink);
					jLabel.setForeground(Color.blue);
				}

			}
			if (e.getSource() == exit) {

				if (Exit == 1) {

					JOptionPane.showMessageDialog(null, "豪哥欢迎你下次使用", "Message", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}

				t.setFont(new Font("楷体", Font.BOLD, 16));
				t.setText("谢谢使用！再次按下“退出”结束程序");

				t0.setText("豪哥欢迎你下次使用！");
				Exit++;

			}
			if (e.getSource() == delete) {
				num1 = 0;
				t.setText(t.getText().substring(0, t.getText().length() - 1));
				t0.setText(t0.getText().substring(0, t0.getText().length() - 1));
				s = t.getText();
				c = t0.getText();
				num1 = Double.parseDouble(t.getText());
			}
			if (e.getSource() == point) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}
				if (num1 == 0) {
					s = "0";
					c = "0";
				}

				s = s + ".";

				t.setText(String.valueOf(s));

				num1 = Double.parseDouble(s);

				c = c + ".";
				t0.setText(c);
			}
			if (e.getSource() == b0) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}
				s = s + "0";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "0";
				t0.setText(c);
			}
			if (e.getSource() == b1) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}
				s = s + "1";
				num1 = Double.parseDouble(s);

				t.setText(String.valueOf(s));
				c = c + "1";
				t0.setText(c);
			}
			if (e.getSource() == b2) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}
				s = s + "2";
				num1 = Double.parseDouble(s);

				t.setText(String.valueOf(s));
				c = c + "2";
				t0.setText(c);
			}
			if (e.getSource() == b3) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}

				s = s + "3";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "3";
				t0.setText(c);
			}
			if (e.getSource() == b4) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}

				s = s + "4";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "4";
				t0.setText(c);
			}
			if (e.getSource() == b5) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}
				s = s + "5";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "5";
				t0.setText(c);
			}
			if (e.getSource() == b6) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}

				s = s + "6";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "6";
				t0.setText(c);
			}
			if (e.getSource() == b7) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}

				s = s + "7";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "7";
				t0.setText(c);
			}
			if (e.getSource() == b8) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}

				s = s + "8";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "8";
				t0.setText(c);
			}
			if (e.getSource() == b9) {
				if (check == "完成") {
					s = "";
					c = "";
					check = "";
				}

				s = s + "9";
				num1 = Double.parseDouble(s);
				t.setText(String.valueOf(s));
				c = c + "9";
				t0.setText(c);
			}
			if (e.getSource() == jia) {

				if (num2 != 0) {
					if (symbol == "+")
						num2 += num1;
					if (symbol == "-")
						num2 -= num1;
					if (symbol == "*")
						num2 *= num1;
					if (symbol == "/")
						num2 /= num1;

					if (num1 == 0) {

					}
				} else {
					num2 = num1;
				}

				num1 = 0;
				s = "";
				symbol = "+";
				t.setText("+");
				c = c + " + ";
				t0.setText(c);
			}
			if (e.getSource() == jian) {

				if (num2 != 0) {
					if (symbol == "+")
						num2 += num1;
					if (symbol == "-")
						num2 -= num1;
					if (symbol == "*")
						num2 *= num1;
					if (symbol == "/")
						num2 /= num1;
					if (num1 == 0) {

					}
				} else {
					num2 = num1;
				}

				num1 = 0;
				s = "";
				symbol = "-";
				t.setText("-");
				c = c + " - ";
				t0.setText(c);
			}
			if (e.getSource() == cheng) {
				if (num2 != 0) {
					if (symbol == "+")
						num2 += num1;
					if (symbol == "-")
						num2 -= num1;
					if (symbol == "*")
						num2 *= num1;
					if (symbol == "/")
						num2 /= num1;
					if (num1 == 0) {

					}
				} else {
					num2 = num1;
				}
				num1 = 0;
				s = "";
				symbol = "*";
				t.setText("*");
				c = c + " * ";
				t0.setText(c);
			}
			if (e.getSource() == chu) {
				if (num2 != 0) {
					if (symbol == "+")
						num2 += num1;
					if (symbol == "-")
						num2 -= num1;
					if (symbol == "*")
						num2 *= num1;
					if (symbol == "/")
						num2 /= num1;
					if (num1 == 0) {

					}
				} else {
					num2 = num1;
				}
				num1 = 0;
				s = "";
				symbol = "/";
				t.setText("/");
				c = c + " / ";
				t0.setText(c);
			}
			if (e.getSource() == clean) {
				s = "";
				c = "";
				num2 = 0;
				num1 = 0;
				t.setFont(new Font("", Font.BOLD, 20));
				t.setText("clean! pls input:");
				t0.setText("欢迎使用豪哥计算器！");
			}
			if (e.getSource() == deng) {
				check = "完成";
				if (symbol == "+") {
					num2 += num1;

					t.setText(String.valueOf(num2));
				}
				if (symbol == "-") {
					num2 -= num1;

					t.setText(String.valueOf(num2));
				}
				if (symbol == "*") {
					num2 *= num1;

					t.setText(String.valueOf(num2));
				}
				if (symbol == "/") {
					num2 /= num1;

					t.setText(String.valueOf(num2));
				}
				c = c + " = " + num2;
				t0.setText(c);
				num1 = 0;
				num2 = 0;
			}
			System.out.println(num1);
		}
	}
}
