package xx;


import java.awt.Color;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

import javax.swing.*;

public class jdbc extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new jdbc();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7076791407991396775L;

	JFrame jf = new JFrame();
	JLabel lname, lage, lsex, wordsfuture, hopecity;
	JTextField name, age, city;
	JTextArea words;
	JRadioButton female, male;
	ButtonGroup sexgroup = new ButtonGroup();
	JLabel aftergraduate, workfx, salary, influencework, workquestion;
	JCheckBox check11, check12, check13, check14, check15;// ��ҵ��İ���
	JCheckBox check21, check22, check23, check24, check25, check26, check27;// ��ҵ�����ѡ��ҵ����
	JCheckBox check31, check32, check33, check34, check35, check36, check37;// ��н
	JCheckBox check41, check42, check43, check44, check45, check46, check47;// Ӱ���ҵ������
	JCheckBox check51, check52, check53, check54, check55, check56, check57;// ��ְ��Ϊ���ŵ�����
	JButton add, delete, select;
	List list = new List();
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	// ��д���ݿ���Ϣ
	String mysqldatabase = "jdbc"; // ��д�޸ĵ����ݿ���
	String url = "jdbc:mysql://localhost/" + mysqldatabase
			+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false&useSSL=false&serverTimezone=GMT";
	String mysqlusername = "zjh"; // ��д���ݿ��û���     	��д���Լ������ݿ��˺�����
	String mysqlpsw = "abcd35873"; // ��д���ݿ�����

	public jdbc() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, mysqlusername, mysqlpsw);
			st = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		jfInit();
	}

	void jfInit() {
		check11 = new JCheckBox("��ҵ");
		check12 = new JCheckBox("������ҵ");
		check13 = new JCheckBox("����");
		check14 = new JCheckBox("����");
		check15 = new JCheckBox("�ݲ���ҵ");
		check21 = new JCheckBox("��������");
		check22 = new JCheckBox("������ҵ");
		check23 = new JCheckBox("������ҵ");
		check24 = new JCheckBox(" ������ҵ");
		check25 = new JCheckBox("��Ӫ��ҵ");
		check26 = new JCheckBox("ѧУ�������о���");
		check27 = new JCheckBox("����");
		check31 = new JCheckBox("2000Ԫ������");
		check32 = new JCheckBox("2001-3000Ԫ");
		check33 = new JCheckBox("3001-5000Ԫ");
		check34 = new JCheckBox("5001-8000Ԫ");
		check35 = new JCheckBox("8001-12000Ԫ");
		check36 = new JCheckBox("12001-20000Ԫ");
		check37 = new JCheckBox("20000Ԫ����");
		check41 = new JCheckBox("רҵ֪ʶ");
		check42 = new JCheckBox("ʵ���͹�������");
		check43 = new JCheckBox("����ϵ");
		check44 = new JCheckBox("��ͨ�������");
		check45 = new JCheckBox("�������");
		check46 = new JCheckBox("ѧ������");
		check47 = new JCheckBox("����");
		check51 = new JCheckBox("רҵ���Կ�");
		check52 = new JCheckBox("��ҵ��Ϣ����");
		check53 = new JCheckBox("��ҵ��������");
		check54 = new JCheckBox("ȱ��ʵ���͹�������");
		check55 = new JCheckBox("ȱ������ϵ");
		check56 = new JCheckBox("����ƽ�����继���Ա�����");
		check57 = new JCheckBox("����");
		female = new JRadioButton("Ů");
		male = new JRadioButton("��");
		sexgroup.add(female);
		sexgroup.add(male);
		name = new JTextField();
		age = new JTextField();
		words = new JTextArea();
		city = new JTextField();
		lname = new JLabel("����");
		lage = new JLabel("����");
		lsex = new JLabel("�Ա�");
		wordsfuture = new JLabel("���δ���Լ�˵�Ļ�");
		hopecity = new JLabel("��ϣ�����ĸ����о�ҵ��");
		aftergraduate = new JLabel("�������������������ҵ���ȥ���ţ�");
		workfx = new JLabel("����ѡ�ľ�ҵ�����ǣ�");
		salary = new JLabel("����������н�ǣ�");
		influencework = new JLabel("����ΪӰ���ҵ����������Щ��");
		workquestion = new JLabel("����Ϊ��ְ������������ǣ�");
		select = new JButton("��ѯ");
		add = new JButton("����");
		delete = new JButton("ɾ��");

		lname.setBounds(10, 10, 50, 50);
		name.setBounds(50, 20, 100, 30);
		lsex.setBounds(10, 50, 50, 50);
		female.setBounds(50, 50, 50, 50);
		male.setBounds(100, 50, 50, 50);
		lage.setBounds(10, 90, 50, 50);
		age.setBounds(50, 100, 100, 30);
		aftergraduate.setBounds(300, 0, 300, 50);
		check11.setBounds(300, 40, 300, 40);
		check12.setBounds(300, 70, 300, 40);
		check13.setBounds(300, 100, 300, 40);
		check14.setBounds(300, 130, 300, 40);
		check15.setBounds(300, 160, 300, 40);
		workfx.setBounds(700, 0, 300, 50);
		check21.setBounds(700, 40, 300, 40);
		check22.setBounds(700, 70, 300, 40);
		check23.setBounds(700, 100, 300, 40);
		check24.setBounds(700, 130, 300, 40);
		check25.setBounds(700, 160, 300, 40);
		check26.setBounds(700, 190, 300, 40);
		check27.setBounds(700, 220, 300, 40);
		salary.setBounds(300, 250, 300, 50);
		check31.setBounds(300, 290, 300, 40);
		check32.setBounds(300, 320, 300, 40);
		check33.setBounds(300, 350, 300, 40);
		check34.setBounds(300, 380, 300, 40);
		check35.setBounds(300, 410, 300, 40);
		check36.setBounds(300, 440, 300, 40);
		check37.setBounds(300, 470, 300, 40);
		influencework.setBounds(700, 250, 300, 50);
		check41.setBounds(700, 290, 300, 40);
		check42.setBounds(700, 320, 300, 40);
		check43.setBounds(700, 350, 300, 40);
		check44.setBounds(700, 380, 300, 40);
		check45.setBounds(700, 410, 300, 40);
		check46.setBounds(700, 440, 300, 40);
		check47.setBounds(700, 470, 300, 40);
		workquestion.setBounds(300, 500, 300, 50);
		check51.setBounds(300, 540, 300, 40);
		check52.setBounds(300, 570, 300, 40);
		check53.setBounds(300, 600, 300, 40);
		check54.setBounds(300, 630, 300, 40);
		check55.setBounds(300, 660, 300, 40);
		check56.setBounds(300, 690, 300, 40);
		check57.setBounds(300, 720, 300, 40);
		wordsfuture.setBounds(10, 500, 300, 50);
		words.setBounds(10, 550, 180, 200);
		hopecity.setBounds(10, 250, 300, 50);
		city.setBounds(10, 300, 150, 50);
		select.setBounds(600, 520, 70, 30);
		add.setBounds(680, 520, 70, 30);

		delete.setBounds(760, 520, 70, 30);
		list.setBounds(600, 560, 350, 200);

		jf.add(lname);
		jf.add(lsex);
		jf.add(lage);
		jf.add(wordsfuture);
		jf.add(hopecity);
		jf.add(aftergraduate);
		jf.add(influencework);
		jf.add(workfx);
		jf.add(workquestion);
		jf.add(salary);
		jf.add(name);
		jf.add(female);
		jf.add(male);
		jf.add(age);
		jf.add(words);
		jf.add(city);
		jf.add(select);
		jf.add(delete);
		jf.add(add);
		jf.add(list);
		jf.add(check11);
		jf.add(check12);
		jf.add(check13);
		jf.add(check14);
		jf.add(check15);
		jf.add(check21);
		jf.add(check22);
		jf.add(check23);
		jf.add(check24);
		jf.add(check25);
		jf.add(check26);
		jf.add(check27);
		jf.add(check31);
		jf.add(check32);
		jf.add(check33);
		jf.add(check34);
		jf.add(check35);
		jf.add(check36);
		jf.add(check37);
		jf.add(check41);
		jf.add(check42);
		jf.add(check43);
		jf.add(check44);
		jf.add(check45);
		jf.add(check46);
		jf.add(check47);
		jf.add(check51);
		jf.add(check52);
		jf.add(check53);
		jf.add(check54);
		jf.add(check55);
		jf.add(check56);
		jf.add(check57);
		words.setOpaque(true);
		words.setBackground(Color.LIGHT_GRAY);
		jf.setTitle("��ѧ����ҵ��������ʾ�");
		jf.setLayout(null);
		jf.setSize(1000, 800);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		select.addActionListener(this);
		add.addActionListener(this);

		delete.addActionListener(this);
	}

	void add() {
		list.removeAll();
		if (name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "δ��������!");
			name.requestFocus();

		} else if (female.isSelected() == false && male.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "��ѡ���Ա�", "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			female.requestFocus();
		} else if (city.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "����д��ҵ��ϣ��ȥ�ĳ���", "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			city.requestFocus();
		} else if (words.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "����д��δ�����Լ�˵�Ļ�", "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			words.requestFocus();
		} else if (check11.isSelected() == false && check12.isSelected() == false && check13.isSelected() == false
				&& check14.isSelected() == false && check15.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "����д�������������������ҵ���ȥ���ţ�", "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			check11.requestFocus();
		} else if (check21.isSelected() == false && check22.isSelected() == false && check23.isSelected() == false
				&& check24.isSelected() == false && check25.isSelected() == false && check26.isSelected() == false
				&& check27.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "����д" + workfx.getText(), "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			check21.requestFocus();
		} else if (check31.isSelected() == false && check32.isSelected() == false && check33.isSelected() == false
				&& check34.isSelected() == false && check35.isSelected() == false && check36.isSelected() == false
				&& check37.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "����д" + salary.getText(), "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			check31.requestFocus();
		} else if (check41.isSelected() == false && check42.isSelected() == false && check43.isSelected() == false
				&& check44.isSelected() == false && check45.isSelected() == false && check46.isSelected() == false
				&& check47.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "����д" + influencework.getText(), "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			check41.requestFocus();
		} else if (check51.isSelected() == false && check52.isSelected() == false && check53.isSelected() == false
				&& check54.isSelected() == false && check55.isSelected() == false && check56.isSelected() == false
				&& check57.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "����д" + workquestion.getText(), "��Ϣ������", JOptionPane.WARNING_MESSAGE);
			check51.requestFocus();
		} else {
			String sql = "insert info values('" + name.getText() + "','";
			String sex = "";
			String c1 = "";
			String c2 = "";
			String c3 = "";
			String c4 = "";
			String c5 = "";
			if (female.isSelected())
				sex = female.getText();
			if (male.isSelected())
				sex = male.getText();
			sql += sex + "','" + city.getText() + "','" + words.getText() + "','" + age.getText() + "','";
			if (check11.isSelected())
				c1 += check11.getText();
			if (check12.isSelected())
				c1 += check12.getText();
			if (check13.isSelected())
				c1 += check13.getText();
			if (check14.isSelected())
				c1 += check14.getText();
			if (check15.isSelected())
				c1 += check15.getText();
			sql += c1 + "','";
			if (check21.isSelected())
				c2 += check21.getText();
			if (check22.isSelected())
				c2 += check22.getText();
			if (check23.isSelected())
				c2 += check23.getText();
			if (check24.isSelected())
				c2 += check24.getText();
			if (check25.isSelected())
				c2 += check25.getText();
			if (check26.isSelected())
				c2 += check26.getText();
			if (check27.isSelected())
				c2 += check27.getText();
			sql += c2 + "','";
			if (check31.isSelected())
				c3 += check31.getText();
			if (check32.isSelected())
				c3 += check32.getText();
			if (check33.isSelected())
				c3 += check33.getText();
			if (check34.isSelected())
				c3 += check34.getText();
			if (check35.isSelected())
				c3 += check35.getText();
			if (check36.isSelected())
				c3 += check36.getText();
			if (check37.isSelected())
				c3 += check37.getText();
			sql += c3 + "','";
			if (check41.isSelected())
				c4 += check41.getText();
			if (check42.isSelected())
				c4 += check42.getText();
			if (check43.isSelected())
				c4 += check43.getText();
			if (check44.isSelected())
				c4 += check44.getText();
			if (check45.isSelected())
				c4 += check45.getText();
			if (check46.isSelected())
				c4 += check46.getText();
			if (check47.isSelected())
				c4 += check47.getText();
			sql += c4 + "','";
			if (check51.isSelected())
				c5 += check51.getText();
			if (check52.isSelected())
				c5 += check52.getText();
			if (check53.isSelected())
				c5 += check53.getText();
			if (check54.isSelected())
				c5 += check54.getText();
			if (check55.isSelected())
				c5 += check55.getText();
			if (check56.isSelected())
				c5 += check56.getText();
			if (check57.isSelected())
				c5 += check57.getText();
			sql += c5 + "');";
			System.out.println(sql);
			try {
				st.execute(sql);

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "�������Ѵ���" + e1.fillInStackTrace());
				e1.getMessage();
			}
			String select = "select name,sex from info";
			String all = "";
			try {
				rs = st.executeQuery(select);

				while (rs.next()) {
					all += rs.getString("name") + "����" + rs.getString("sex") + "��";

				}

				String[] fg = all.split("��");
				for (int i = 0; i < fg.length; i++) {
					list.add(fg[i]);
					name.setText("");
					female.setSelected(false);
					male.setSelected(false);
					age.setText("");
					words.setText("");
					city.setText("");
					check11.setSelected(false);
					check12.setSelected(false);
					check13.setSelected(false);
					check14.setSelected(false);
					check15.setSelected(false);
					check21.setSelected(false);
					check22.setSelected(false);
					check23.setSelected(false);
					check24.setSelected(false);
					check25.setSelected(false);
					check26.setSelected(false);
					check27.setSelected(false);
					check31.setSelected(false);
					check32.setSelected(false);
					check33.setSelected(false);
					check34.setSelected(false);
					check35.setSelected(false);
					check36.setSelected(false);
					check37.setSelected(false);
					check41.setSelected(false);
					check42.setSelected(false);
					check43.setSelected(false);
					check44.setSelected(false);
					check45.setSelected(false);
					check46.setSelected(false);
					check47.setSelected(false);
					check51.setSelected(false);
					check52.setSelected(false);
					check53.setSelected(false);
					check54.setSelected(false);
					check55.setSelected(false);
					check56.setSelected(false);
					check57.setSelected(false);
				}

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "��Ӻ����");
			}
		}
	}

	void select() {

		String select = "select name,sex from info";
		String all = "";
		try {
			rs = st.executeQuery(select);

			while (rs.next()) {
				all += rs.getString("name") + "����" + rs.getString("sex") + "��";
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "��ѯ����");
		}
		if (list.getSelectedIndex() == -1) {
			list.removeAll();
			String[] fg = all.split("��");
			for (int i = 0; i < fg.length; i++) {
				list.add(fg[i]);
			}
		}
		if (list.getSelectedIndex() != -1) {

			try {

				String[] fg1 = all.split("�����У�|����Ů��");

				rs = st.executeQuery("select * from info where name = '" + fg1[list.getSelectedIndex()] + "'");
				String tk = "";
				JFrame tkFrame = new JFrame("������Ϣ");
				List tkList = new List();
				while (rs.next()) {
					tk += rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-" + rs.getString(4) + "-"
							+ rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7) + "-" + rs.getString(8)
							+ "-" + rs.getString(9) + "-" + rs.getString(10);
				}
				String[] tk1 = tk.split("-");
				System.out.println(tk);
				for (int i = 0; i < tk1.length; i++) {
					tkList.add(tk1[i]);
				}
				tkFrame.setLayout(null);
				tkFrame.setSize(300, 300);
				tkList.setBounds(1, 1, 300, 300);
				tkFrame.add(tkList);
				tkFrame.setLocationRelativeTo(null);
				tkFrame.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
		}
		jf.requestFocus();
	}

	void delete() {

		String all = list.getSelectedItem();
		System.out.println(all);
		String[] fg1 = all.split("������|����Ů");
		//

		try {
			System.out.println("delete from info where name = '" + fg1[list.getSelectedIndex()] + "'");
			st.execute("delete from info where name = '" + fg1[list.getSelectedIndex()] + "'");
			list.remove(list.getSelectedIndex());

		} catch (SQLException e1) {

			e1.getMessage();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			add();
		}
		if (e.getSource() == select) {
			select();
		}
		if (e.getSource() == delete) {
			delete();
		}
	}

}
