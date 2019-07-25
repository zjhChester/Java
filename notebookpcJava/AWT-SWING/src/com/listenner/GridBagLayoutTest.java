package com.listenner;
import java.awt.*;

import javax.swing.JFrame;
public class GridBagLayoutTest {

	public static void main(String[] args) {
	}
}

@SuppressWarnings("serial")
class MyGridBagLayout extends JFrame{
	public MyGridBagLayout(String s) {
		super(s);
		setSize(200, 200);
		
		GridBagLayout gridbag = new GridBagLayout();//ʵ��������gridbag
		GridBagConstraints c = new GridBagConstraints();//ʵ��������c
		setLayout(gridbag); // ���ò���Ϊgridbag
		c.fill = GridBagConstraints.BOTH;//��������Ϊfill
		c.weightx = 1.0;//�Ŵ���������������ˮƽ�ռ����
		addButton("��ť1", gridbag, c);
		addButton("��ť2", gridbag, c);
		addButton("��ť3", gridbag, c);
		
		c.gridwidth = GridBagConstraints.REMAINDER;//���õ��ĸ���ťΪ��һ�����һ�����
		addButton("��ť4", gridbag, c);
		c.weightx = 0.0;
		addButton("��ť5", gridbag, c);
		c.gridwidth = GridBagConstraints.RELATIVE;//���õ�������ťΪ���������һ�����
		addButton("��ť6", gridbag, c);
		c.gridwidth = GridBagConstraints.REMAINDER;//���õ��߸���ťΪ���������һ�����
		addButton("��ť7", gridbag, c);
		c.gridheight = 2;c.gridwidth=1;//ָ������ť8��ռ��2��1��
		c.weighty = 1.0;
		addButton("��ť8", gridbag, c);
		c.gridheight = 1; // ָ����ť9ռ��һ��
		
		c.gridwidth = GridBagConstraints.REMAINDER;//ָ����ť9Ϊ��ǰ�����һ�����
		c.weighty = 0;
		addButton("��ť9", gridbag, c);
		addButton("��ť10", gridbag, c);

		
		
		setSize(300, 200);
		setVisible(true);
	}

void addButton(String label, GridBagLayout gridbag, GridBagConstraints c) {
	Button b = new Button(label);
	b.setBackground(Color.red);
	gridbag.setConstraints(b, c);
	add(b);
}
}
