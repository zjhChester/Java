package com.listenner;
import java.awt.*;

import javax.swing.JFrame;
public class GridLayoutTest {
public static void main(String[] args) {
	JFrame f = new JFrame("���ղ���ʵ��");

	f.setLayout(new GridLayout(2,3,5,5)); //���������2*3 ÿ����5�Ĳ���
	Button btn1 = new Button("��һ����ť");
	Button btn2 = new Button("�ڶ�����ť");
	Button btn3 = new Button("��������ť");
	Button btn4 = new Button("���ĸ���ť");
	Button btn5 = new Button("�������ť");
	f.add(btn1);
	f.add(btn2);
	f.add(btn3);
	f.add(btn4);
	f.add(btn5);
	f.setSize(500,500);
	f.pack();//������ʽ��ʾ����
	f.setVisible(true);
	f.setBackground(Color.darkGray);
	btn1.setBackground(Color.red);
	btn2.setBackground(Color.gray);
	btn3.setBackground(Color.green);
	btn4.setBackground(Color.black);
	btn5.setBackground(Color.blue);
}
}
