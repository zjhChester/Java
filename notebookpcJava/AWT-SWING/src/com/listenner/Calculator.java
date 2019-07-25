package com.listenner;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends Applet implements ActionListener {
	/**
	 * 
	 */
	public static void main(String[] args) {
		new Calculator();
		
	}

	private static final long serialVersionUID = 1L;

	Panel p1 = new Panel(new GridLayout());
	Panel p2 = new Panel(new GridLayout(4, 4, 10, 10));
	TextField t = new TextField(20);
	Button b0 = new Button(" 0 ");
	Button b1 = new Button(" 1 ");
	Button b2 = new Button(" 2 ");
	Button b3 = new Button(" 3 ");
	Button b4 = new Button(" 4 ");
	Button b5 = new Button(" 5 ");
	Button b6 = new Button(" 6 ");
	Button b7 = new Button(" 7 ");
	Button b8 = new Button(" 8 ");
	Button b9 = new Button(" 9 ");
	Button deng = new Button(" = ");
	Button jia = new Button(" + ");
	Button jian = new Button(" - ");
	Button cheng = new Button(" * ");
	Button chu = new Button(" / ");
	Button clean = new Button(" C ");
	String s = "";
	double num1 = 0;
	double num2 = 0;
	String symbol = "";
	String check = "";

	public void init() {
		add(p1);
		add(p2);
		p1.add(t);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(chu);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(cheng);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(jian);
		p2.add(b0);
		p2.add(deng);
		p2.add(jia);
		p2.add(clean);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		deng.addActionListener(this);
		jia.addActionListener(this);
		jian.addActionListener(this);
		cheng.addActionListener(this);
		chu.addActionListener(this);
		clean.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b0) {
			if (check == "完成") {
				s = "";
				check = "";
			}
			s = s + "0";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));

		}
		if (e.getSource() == b1) {
			if (check == "完成") {
				s = "";
				check = "";
			}
			s = s + "1";
			num1 = Integer.parseInt(s);

			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b2) {
			if (check == "完成") {
				s = "";
				check = "";
			}
			s = s + "2";
			num1 = Integer.parseInt(s);

			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b3) {
			if (check == "完成") {
				s = "";
				check = "";
			}

			s = s + "3";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b4) {
			if (check == "完成") {
				s = "";
				check = "";
			}

			s = s + "4";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b5) {
			if (check == "完成") {
				s = "";
				check = "";
			}
			s = s + "5";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b6) {
			if (check == "完成") {
				s = "";
				check = "";
			}

			s = s + "6";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b7) {
			if (check == "完成") {
				s = "";
				check = "";
			}

			s = s + "7";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b8) {
			if (check == "完成") {
				s = "";
				check = "";
			}

			s = s + "8";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == b9) {
			if (check == "完成") {
				s = "";
				check = "";
			}

			s = s + "9";
			num1 = Integer.parseInt(s);
			t.setText(String.valueOf(s));
		}
		if (e.getSource() == jia) {

			num2 = num1;
			num1 = 0;
			s = "";
			symbol = "+";
			t.setText(s+"+");
		}
		if (e.getSource() == jian) {
			num2 = num1;
			num1 = 0;
			s = "";
			symbol = "-";
			t.setText("");
		}
		if (e.getSource() == cheng) {
			num2 = num1;
			num1 = 0;
			s = "";
			symbol = "*";
			t.setText("");
		}
		if (e.getSource() == chu) {
			num2 = num1;
			num1 = 0;
			s = "";
			symbol = "/";
			t.setText("");
		}
		if (e.getSource() == clean) {
			s = "";
			num2 = 0;
			t.setText("");
		}
		if (e.getSource() == deng) {
			if (symbol == "+") {
				num2 += num1;
				check = "完成";
				t.setText(String.valueOf(num2));
			}
			if (symbol == "-") {
				num2 -= num1;
				check = "完成";
				t.setText(String.valueOf(num2));
			}
			if (symbol == "*") {
				num2 *= num1;
				check = "完成";
				t.setText(String.valueOf(num2));
			}
			if (symbol == "/") {
				num2 /= num1;
				check = "完成";
				t.setText(String.valueOf(num2));
			}
		}
		System.out.println(s);

	}
}
