package com.listenner;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.applet.*;

@SuppressWarnings("serial")
public class yanghuisanjiao extends Applet implements ActionListener{
 Label l = new Label("������Ҫ��ʾ������(1-20)��");
 TextField t = new TextField(5);
 Button b = new Button("ȷ��");
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
	 g.drawString("�żκ����������", 10, 10);
	String s = "";
	for(int i=0;i<n;i++) {
		for(int j=0;j<=i;j++) {
			s = String.valueOf(nums[i][j]);
			g.setColor(Color.BLUE);
			
			g.setFont(new Font("����", Font.BOLD,13));
			g.drawString(s, 400-20*(i+1)+40*j, 50+15*i);
		}
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	n = Integer.parseInt(t.getText());
	nums = new int[n][];
	if(e.getActionCommand().equals("ȷ��"))
	{
		repaint();
	}
	for(int i=0;i<n;i++) nums[i] = new int[i+1];
	nums[0][0]=1;
	for(int j=1;j<n;j++) {
		nums[j][0] = 1; //ÿ�������һ��Ԫ��Ϊ1
		nums[j][j] = 1;//ÿ��Ԫ�����һ��Ԫ��Ϊ1
		for(int k =1;k<j;k++)nums[j][k]=nums[j-1][k-1]+nums[j-1][k];//�����������
	}
	
}


}
