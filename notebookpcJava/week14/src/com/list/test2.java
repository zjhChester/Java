package com.list;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class test2 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4942750899658080352L;
	JFrame jFrame;
	JLabel sno, sname, sdept, ssex;
	JTextField tsno, tsname;
	List tTotal;
	Choice choice;
	ButtonGroup bg;
	JRadioButton F, M;
	JCheckBox eat, surfing, sleep, study;
	JButton submit, delete;

	String str = "";

	public test2() {
		// TODO Auto-generated constructor stub
		sno = new JLabel("ѧ��");
		sname = new JLabel("����");
		sdept = new JLabel("רҵ");
		ssex = new JLabel("�Ա�");
		sno.setForeground(Color.WHITE);
		sname.setForeground(Color.WHITE);
		sdept.setForeground(Color.WHITE);
		ssex.setForeground(Color.WHITE);
		sno.setBounds(30, 100, 40, 30);
		sname.setBounds(30, 140, 40, 30);
		sdept.setBounds(30, 180, 40, 30);
		ssex.setBounds(30, 220, 40, 30);

		tsno = new JTextField(12);
		tsname = new JTextField(12);
		tTotal = new List();

		tsno.setBounds(80, 105, 80, 30);
		tsname.setBounds(80, 145, 80, 30);
		tTotal.setBounds(80, 350, 350, 100);

		choice = new Choice();
		choice.setBounds(80, 185, 130, 30);
		choice.addItem("�����רҵ");
		choice.addItem("�ƻ�רҵ");
		choice.addItem("����רҵ");
		choice.addItem("����רҵ");

		bg = new ButtonGroup();
		F = new JRadioButton("��");
		M = new JRadioButton("Ů");
		bg.add(F);
		bg.add(M);
		F.setBounds(80, 220, 40, 30);
		M.setBounds(80, 250, 40, 30);

		eat = new JCheckBox("�Է�");
		sleep = new JCheckBox("˯��");
		surfing = new JCheckBox("����");
		study = new JCheckBox("ѧϰ");
		eat.setBounds(260, 105, 80, 30);
		sleep.setBounds(260, 145, 80, 30);
		surfing.setBounds(360, 105, 80, 30);
		study.setBounds(360, 145, 80, 30);

		submit = new JButton("�ύ");
		delete = new JButton("ɾ��");
		submit.setBounds(260, 220, 80, 30);
		delete.setBounds(360, 220, 80, 30);

		jFrame = new JFrame();
		setLayout(null);
	
		 JLabel jb= new JLabel(new ImageIcon("../week14/image/login��¼.jpg"));
		 jb.setBounds(0, 0, 500,800);
		
		add(sno,JLayeredPane.MODAL_LAYER);
		add(sname,JLayeredPane.MODAL_LAYER);
		add(sdept,JLayeredPane.MODAL_LAYER);
		add(ssex,JLayeredPane.MODAL_LAYER);
		add(tsname,JLayeredPane.MODAL_LAYER);
		add(tsno,JLayeredPane.MODAL_LAYER);
		add(tTotal,JLayeredPane.MODAL_LAYER);
		add(choice,JLayeredPane.MODAL_LAYER);
		add(F,JLayeredPane.MODAL_LAYER);
		add(M,JLayeredPane.MODAL_LAYER);
		add(eat,JLayeredPane.MODAL_LAYER);
		add(sleep,JLayeredPane.MODAL_LAYER);
		add(surfing,JLayeredPane.MODAL_LAYER);
		add(study,JLayeredPane.MODAL_LAYER);
		add(submit,JLayeredPane.MODAL_LAYER);
		add(delete,JLayeredPane.MODAL_LAYER);
		add(jb);
		setTitle("�ʾ����");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		submit.addActionListener(this);
		delete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submit) {
			str = "";
			str += tsno.getText() + " - " + tsname.getText() + " - " + choice.getSelectedItem();

			if (F.isSelected())
				str += " - " + F.getText();
			if (M.isSelected())
				str += " - " + M.getText();
			if (eat.isSelected())
				str += " - " + eat.getText();
			if (sleep.isSelected())
				str += " - " + sleep.getText();
			if (surfing.isSelected())
				str += " - " + surfing.getText();
			if (study.isSelected())
				str += " - " + study.getText();

			try {
				Integer.parseInt(tsno.getText());
				if (!tsno.getText().equals("") && !tsname.getText().equals("")) {
					tTotal.add(str);
					tsno.setText("");
					tsname.setText("");
					bg.clearSelection();
					eat.setSelected(false);
					study.setSelected(false);
					surfing.setSelected(false);
					sleep.setSelected(false);
				} else
					JOptionPane.showMessageDialog(null, "����д�ؼ���Ϣ", "��Ӵ���", JOptionPane.WARNING_MESSAGE);

			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "���ѧ�ű�������", "��Ӵ���", JOptionPane.WARNING_MESSAGE);
			}

		}

		if (e.getSource() == delete) {
			if (tTotal.getSelectedIndex() != -1)
				tTotal.remove(tTotal.getSelectedIndex());
			else if (tTotal.getItemCount() == 0)
				JOptionPane.showMessageDialog(null, "��ǰ�б����κ�ѡ��", "��Ӵ���", JOptionPane.WARNING_MESSAGE);

			else {
				JOptionPane.showMessageDialog(null, "��ѡ��ɾ����", "��Ӵ���", JOptionPane.WARNING_MESSAGE);

			}
		}
	}

	public static void main(String[] args) {
		new test2();
	}
}
