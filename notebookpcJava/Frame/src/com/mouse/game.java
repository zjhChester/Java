package com.mouse;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class game extends JFrame implements MouseListener ,ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new game();
	}

	JFrame jFrame = new JFrame("���");
	int x;
	int y;
	JLabel jLabel;
	JButton jButton;
	JButton yes;
	public game() {
		// TODO Auto-generated constructor stub
		jLabel = new JLabel("Ҫ��Ҫ���ҳԷ�");
		jButton = new JButton("��Ҫ");
		yes = new JButton(" Ҫ ");
		x = (int) (Math.random() * 400 + 1);
		y = (int) (Math.random() * 400 + 1);
		setLayout(null);
		jLabel.setBounds(0, 0, 500, 30);
		jButton.setBounds(x, y, 60, 40);
		yes.setBounds(50, 50, 60, 40);
		
		add(yes);
		add(jButton);
		add(jLabel);
		setSize(500, 500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jButton.addMouseListener(this);
		jButton.addActionListener(this);
		yes.addActionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		new game();
		System.out.println(x+"  "+y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		new game();
		System.out.println(x+"  "+y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//actionlistener
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jButton)
		{
			JOptionPane.showMessageDialog(null, "���ǵ�ѡ��", "���Ժ�����ʺ�", JOptionPane.PLAIN_MESSAGE);
			System.out.println("�㵽����");
			System.exit(1);
			
		}
		
			jLabel.setText("���ǵ�ѡ��!");
			jLabel.setFont(new Font("", Font.BOLD, 50));
			jLabel.setOpaque(true);
			jLabel.setForeground(Color.red);
		}
	}

