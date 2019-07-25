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
		
		GridBagLayout gridbag = new GridBagLayout();//实例化对象gridbag
		GridBagConstraints c = new GridBagConstraints();//实例化对象c
		setLayout(gridbag); // 设置布局为gridbag
		c.fill = GridBagConstraints.BOTH;//设置属性为fill
		c.weightx = 1.0;//放大容器，分配额外的水平空间比例
		addButton("按钮1", gridbag, c);
		addButton("按钮2", gridbag, c);
		addButton("按钮3", gridbag, c);
		
		c.gridwidth = GridBagConstraints.REMAINDER;//设置第四个按钮为第一行最后一个组件
		addButton("按钮4", gridbag, c);
		c.weightx = 0.0;
		addButton("按钮5", gridbag, c);
		c.gridwidth = GridBagConstraints.RELATIVE;//设置第六个按钮为第五个的下一个组件
		addButton("按钮6", gridbag, c);
		c.gridwidth = GridBagConstraints.REMAINDER;//设置第七个按钮为第三行最后一个组件
		addButton("按钮7", gridbag, c);
		c.gridheight = 2;c.gridwidth=1;//指定“按钮8”占有2行1列
		c.weighty = 1.0;
		addButton("按钮8", gridbag, c);
		c.gridheight = 1; // 指定按钮9占有一列
		
		c.gridwidth = GridBagConstraints.REMAINDER;//指定按钮9为当前行最后一个组件
		c.weighty = 0;
		addButton("按钮9", gridbag, c);
		addButton("按钮10", gridbag, c);

		
		
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
