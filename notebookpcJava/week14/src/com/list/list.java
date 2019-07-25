package com.list;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class list extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
	new list();
	}
	JFrame jf ;
	List list;
	JButton up,down,add,delete,select;
	JTextField jtx1,jtx2;
	JLabel jLabel1,jLabel2;
	
	public list() {
		jf = new JFrame("list");
		list = new List();
		up = new JButton(" 向上 ");
		down = new JButton(" 向下 ");
		add = new JButton(" 添加 ");
		delete = new JButton(" 删除 ");
		select = new JButton(" 查询 ");
		jtx1 = new JTextField(20);
		jtx2 = new JTextField(20);
		jLabel1 = new JLabel("书名");
		jLabel2 = new JLabel("排行");
		setLayout(null);
		list.setBounds(10,80,200,300);
		up.setBounds(250, 80, 70, 35);
		down.setBounds(250, 160, 70, 35);
		add.setBounds(250, 240, 70, 35);
		delete.setBounds(250, 320, 70, 35);
		select.setBounds(250, 400, 70, 35);
		jtx1.setBounds(380,200,140,35);
		jtx2.setBounds(380,280,140,35);
		jLabel1.setBounds(350, 200, 50, 20);
		jLabel2.setBounds(350, 280, 50, 20);
		add(list);
		add(up);
		add(down);
		add(add);
		add(delete);
		add(select);
		add(jtx1);
		add(jtx2);
		add(jLabel1);
		add(jLabel2);
		setTitle("豪哥的list");
		list.add("百年孤儿");
		list.add("JAVA");
		list.add("C++");
		list.add("Python");
		list.add("PHP");
		setSize(700,500);
		setLocation(700,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		up.addActionListener(this);
		down.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);
		select.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i =  list.getSelectedIndex();
		String name = list.getSelectedItem();
		
		if(e.getSource() == up)
		{
			if(i==0)
				
			{
				JOptionPane.showMessageDialog(null, "已经是第一名啦", "出错！", JOptionPane.WARNING_MESSAGE);
			}
			else {
				list.remove(i);
				list.add(name,i-1);
				list.select(i-1);
			}
			jtx1.setText("");
			jtx2.setText("");
		}
		if(e.getSource() == down)
		{
			
			if(i==list.getItemCount()-1)
			{
				JOptionPane.showMessageDialog(null, "已经是最后一名啦", "出错！", JOptionPane.WARNING_MESSAGE);
			}
			else {
				list.remove(i);
				list.add(name,i+1);
				list.select(i+1);
				
			}
			jtx1.setText("");
			jtx2.setText("");
		}
		if(e.getSource() == add)
		{
			if(jtx1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "插入为空", "出错！", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				if(jtx2.getText().equals(""))
				{
				list.add(jtx1.getText());
				}
				else {
					list.add(jtx1.getText(),Integer.parseInt(jtx2.getText())-1);
				}
				jtx1.setText("");
				jtx2.setText("");
			}
		}
		if(e.getSource() == delete)
		{
			list.remove(i);
			jtx1.setText("");
			jtx2.setText("");
		}
		if(e.getSource() == select)
		{
			jtx1.setText("《"+name+"》");
			jtx2.setText("第  "+(i+1)+"  名");
		}
	}
	
}
