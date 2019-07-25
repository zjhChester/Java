package com.listenner;
import java.awt.*;

import javax.swing.JFrame;
public class GridLayoutTest {
public static void main(String[] args) {
	JFrame f = new JFrame("紧凑布局实例");

	f.setLayout(new GridLayout(2,3,5,5)); //给窗口添加2*3 每组间隔5的布局
	Button btn1 = new Button("第一个按钮");
	Button btn2 = new Button("第二个按钮");
	Button btn3 = new Button("第三个按钮");
	Button btn4 = new Button("第四个按钮");
	Button btn5 = new Button("第五个按钮");
	f.add(btn1);
	f.add(btn2);
	f.add(btn3);
	f.add(btn4);
	f.add(btn5);
	f.setSize(500,500);
	f.pack();//紧凑形式显示窗口
	f.setVisible(true);
	f.setBackground(Color.darkGray);
	btn1.setBackground(Color.red);
	btn2.setBackground(Color.gray);
	btn3.setBackground(Color.green);
	btn4.setBackground(Color.black);
	btn5.setBackground(Color.blue);
}
}
