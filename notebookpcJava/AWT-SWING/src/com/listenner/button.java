package com.listenner;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class button extends Applet implements ActionListener {

	Button btn1, btn2, btn3, btn4;
	TextField t = new TextField(20);
	int s = 0;
	int dx = 0;
	int dy = 0;

	int randnum1; // = new Random().nextInt(30)%30+1;
	int randnum2; // = new Random().nextInt(30)%30+1;

	button b;
	int result[] = new int[4];
	int i;

	public button() {

		int a[] = suiji();
		this.randnum1 = a[0];
		this.randnum2 = a[1];

	}

	public int[] suiji() {
		int a[] = new int[2];

		a[0] = (int) (Math.random() * 50 + 1);
		a[1] = (int) (Math.random() * 50 + 1);

		return a;
	}

	public void init() {
		setSize(800, 800);
		setLayout(null);
		b = new button();
		for (int j = 0; j < result.length; j++) {

			result[j] = (int) (Math.random() * 3000 + 1);
			// System.out.println(result[j]);
		}
		i = (int) (Math.random() * 4);
		result[i] = b.randnum1 * b.randnum2;
		btn1 = new Button("" + result[0]);
		btn2 = new Button("" + result[1]);
		btn3 = new Button("" + result[2]);
		btn4 = new Button("" + result[3]);
		System.out.println("下标" + (i + 1) + "\t" + result[i] + "\t" + b.randnum1 + " " + b.randnum2);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		Label l1 = new Label("A.");
		Label l2 = new Label("B.");
		Label l3 = new Label("C.");
		Label l4 = new Label("D.");
		Label title = new Label("请看题:\t" + b.randnum1 + " x " + b.randnum2 + "=( )");

		add(title);
		title.setBounds(dx, dy, 100, 30);
		add(l1);
		l1.setBounds(dx + 130, dy, 30, 30);
		add(btn1);
		btn1.setBounds(dx + 160, dy, 30, 30);
		add(l2);
		l2.setBounds(dx + 190, dy, 30, 30);
		add(btn2);
		btn2.setBounds(dx + 220, dy, 30, 30);
		add(l3);
		l3.setBounds(dx + 250, dy, 30, 30);
		add(btn3);
		btn3.setBounds(dx + 280, dy, 30, 30);
		add(l4);
		l4.setBounds(dx + 310, dy, 30, 30);
		add(btn4);
		btn4.setBounds(dx + 340, dy, 30, 30);
		dy = dy + 50;

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("" + result[i])) {
			s = 1;
			if (e.getSource() == btn1)
				btn1.setBackground(Color.GREEN);
			if (e.getSource() == btn2)
				btn2.setBackground(Color.GREEN);
			if (e.getSource() == btn3)
				btn3.setBackground(Color.GREEN);
			if (e.getSource() == btn4)
				btn4.setBackground(Color.GREEN);
		}
		if (!(e.getActionCommand().equals("" + result[i]))) {
			s += 2;

			if (e.getSource() == btn1)
				btn1.setBackground(Color.RED);
			if (e.getSource() == btn2)
				btn2.setBackground(Color.RED);
			if (e.getSource() == btn3)
				btn3.setBackground(Color.RED);
			if (e.getSource() == btn4)
				btn4.setBackground(Color.RED);
		}
		repaint();
	}

	public void paint(Graphics g) {
		g.drawString("张嘉豪的小游戏", 600, dy);
		if (s == 1) {
			g.setFont(new Font("隶书", Font.BOLD, 30));
			g.setColor(Color.green);

			g.drawString("恭喜你答对啦！", 400, dy);
			s = 0;
			init();
		}
		g.setFont(new Font("隶书", Font.BOLD, 30));
		g.setColor(Color.red);
		if (s == 2)
			g.drawString("怕是错了哦 检查一下？", 400, dy);
		if (s == 4)
			g.drawString("还选错？你是猪迈？", 400, dy);
		if (s >= 6)
			g.drawString("全选错 ？你真的是蠢得没得法", 400, dy);

	}
}
