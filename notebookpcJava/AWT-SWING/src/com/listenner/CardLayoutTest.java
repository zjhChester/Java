package com.listenner;

import java.awt.*;
import java.awt.event.*;

public class CardLayoutTest implements ActionListener {
	Frame f;
	CardLayout card;

	public CardLayoutTest() {
		// TODO Auto-generated constructor stub
		
		setLayout(null);
		f = new Frame("按钮点击监听器实例");
		Button btn1 = new Button("第一张卡片");
		Button btn2 = new Button("第二张卡片");
		Button btn3 = new Button("第三张卡片");
		Button btn4 = new Button("第四张卡片");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn1.setBackground(Color.red);
		btn2.setBackground(Color.GREEN);
		btn3.setBackground(Color.blue);
		btn4.setBackground(Color.yellow);
		btn1.setSize(10, 10);
		card = new CardLayout(10, 10);// 卡片间距
		f.setLayout(card);
		f.add(btn1, "C1");
		f.add(btn2, "C2");
		f.add(btn3, "C3");
		f.add(btn4, "C4");
		f.setBounds(300, 300, 500, 500);
		f.setVisible(true);
		WindowListener mw = new MywinListener();
		f.addWindowListener(mw );
		
	}

	private void setLayout(Object object) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new CardLayoutTest(); // 实例化对象
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		card.next(f);
	}
}
class MywinListener extends WindowAdapter{

	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}
}