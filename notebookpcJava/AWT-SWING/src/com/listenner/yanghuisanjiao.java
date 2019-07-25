package com.listenner;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.applet.*;

@SuppressWarnings("serial")
public class yanghuisanjiao extends Applet implements ActionListener{
 Label l = new Label("请输入要显示的行数(1-20)：");
 TextField t = new TextField(5);
 Button b = new Button("确定");
 int n = 0;
 int [][]nums;
 public void init() {
	 setSize(800,600);
	 add(l);
	 add(b);
	 add(t);
	 t.addActionListener(this);
	 b.addActionListener(this);
 }
 Frame f = new Frame();
	
 public void paint(Graphics g) {
	 g.drawString("张嘉豪的杨辉三角", 10, 10);
	String s = "";
	for(int i=0;i<n;i++) {
		for(int j=0;j<=i;j++) {
			s = String.valueOf(nums[i][j]);
			g.setColor(Color.BLUE);
			
			g.setFont(new Font("隶书", Font.BOLD,13));
			g.drawString(s, 400-20*(i+1)+40*j, 50+15*i);
		}
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	n = Integer.parseInt(t.getText());
	nums = new int[n][];
	if(e.getActionCommand().equals("确定"))
	{
		repaint();
	}
	for(int i=0;i<n;i++) nums[i] = new int[i+1];
	nums[0][0]=1;
	for(int j=1;j<n;j++) {
		nums[j][0] = 1; //每组数组第一个元素为1
		nums[j][j] = 1;//每组元素最后一个元素为1
		for(int k =1;k<j;k++)nums[j][k]=nums[j-1][k-1]+nums[j-1][k];//计算杨辉三角
	}
	
}


}
