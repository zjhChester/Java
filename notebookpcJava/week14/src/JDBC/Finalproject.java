package JDBC;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Finalproject extends JFrame implements ActionListener, Runnable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Finalproject f = new Finalproject();
		Thread t = new Thread(f);
		t.start();

	}

	JFrame jfselect, jflogin, jfmysql, jinputsql;
	List list1, list2, list3, list4, list5, list6, list7, listinputrs;
	JLabel bg, labelmysql, labellogin, labelselect, time;
	JLabel l1, l2, l3, l4, l5, l6, l7, luser, lpsw, ldb, ltb, muser, mpsw, inputsqllabel, serverName;
	JLabel col1, col2, col3, col4, col5, col6, col7, colt1, colt2, colt3, colt4, colt5, colt6, colt7;
	JButton select, insert, delete, update, login, exit, mexit, relogin, loginmysql, inputenter, inputexit, setF, setP;
	JTextField jtx1, jtx2, jtx3, jtx4, jtx5, jtx6, jtx7, Tuser, mysqluser, inputsqltext, TserverName;
	JPasswordField Tpsw, mysqlpsw;
	Choice database, table;
	String userType = "";
	Choice ctype;

	// 数据库连接变量
	String jdriver = "com.mysql.cj.jdbc.Driver";
	String Database = "";
	String Table = "";
	String server = "";
	String url = "jdbc:mysql://" + server + "/" + Database
			+ "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	String username = "";
	String psw = "";
	Statement st;
	ResultSet rs, rs1;
	Connection conn;

	// 设置主键图形界面组件
	JFrame jprimary;
	JLabel LPname, Lcol;
	JPanel paimaryJpanel;
	JTextField Pname;
	JCheckBox Pcol1, Pcol2, Pcol3, Pcol4, Pcol5, Pcol6, Pcol7;
	JButton Penter;

	// 设置外键图形界面组件
	JFrame jfkey;
	JLabel fl1_ftx1, fl2_table_col, fl3_referDatabase, fl4_referTable, fl5_refercol, fl6_whiledelete, fl7_whileupdate;
	JTextField ftx1;
	Choice table_col, referDatabase, referTable, refercol, whiledelete, whileupdate;
	JButton fkenter, fkexit;
	JPanel fkjp1, fkjp2;

	// 注册
	JFrame fregister, fyz;
	Choice rqx;
	JTextField rusername, tyz, showyz;
	JPasswordField rpsw, rRpsw;
	JLabel lregister, lyz, lrusername, lrpsw, lrRpsw, lqx;
	JButton register, renter, rexit, send, yzenter;

	void register() {
		fregister = new JFrame();

		lrusername = new JLabel("注册账号：");
		lrpsw = new JLabel("密码：");
		lrRpsw = new JLabel("确认密码：");
		lqx = new JLabel("注册权限：");
		lyz = new JLabel("验证码：");
		rusername = new JTextField();
		rpsw = new JPasswordField();
		rRpsw = new JPasswordField();
		tyz = new JTextField();
		rqx = new Choice();
		rqx.add("administrator");
		rqx.add("customer");
		renter = new JButton("确认注册");
		rexit = new JButton("返回主界面");
		send = new JButton("发送验证码");
		fregister.setLayout(null);
		fregister.setSize(420, 380);
		fregister.setLocationRelativeTo(null);
		fregister.setResizable(false);
		fregister.setVisible(false);
		fregister.setTitle("注册");
		fregister.add(lrusername);
		fregister.add(lrpsw);
		fregister.add(lrRpsw);
		fregister.add(lyz);
		fregister.add(rusername);
		fregister.add(rpsw);
		fregister.add(rRpsw);
		fregister.add(tyz);
		fregister.add(renter);
		fregister.add(rexit);
		fregister.add(send);
		fregister.add(rqx);
		fregister.add(lqx);
		lrusername.setBounds(20, 10, 100, 50);
		lrpsw.setBounds(20, 60, 100, 50);
		lrRpsw.setBounds(20, 110, 100, 50);
		lqx.setBounds(20, 160, 100, 50);
		lyz.setBounds(20, 210, 100, 50);
		rusername.setBounds(120, 15, 200, 35);
		rpsw.setBounds(120, 65, 200, 35);
		rRpsw.setBounds(120, 115, 200, 35);
		rqx.setBounds(120, 170, 200, 35);
		tyz.setBounds(120, 215, 90, 35);
		send.setBounds(210, 215, 100, 35);
		renter.setBounds(60, 280, 100, 50);
		rexit.setBounds(240, 280, 100, 50);

		fyz = new JFrame();
		showyz = new JTextField();
		showyz.setEnabled(false);
		yzenter = new JButton("确定");
		fyz.setLayout(null);
		fyz.setSize(300, 200);
		fyz.add(showyz);
		fyz.add(yzenter);
		showyz.setBounds(40, 20, 200, 80);
		yzenter.setBounds(110, 120, 60, 30);
		fyz.setTitle("验证码消息");
		fyz.setResizable(false);
		fyz.setLocationRelativeTo(null);
		fyz.setVisible(false);
	}

	public Finalproject() {
		// TODO Auto-generated constructor stub

		mysqlConfiguration();

		mysqluser.requestFocus();
		register();
		setP.addActionListener(this);
		setF.addActionListener(this);
		Penter.addActionListener(this);
		fkenter.addActionListener(this);
		fkexit.addActionListener(this);
		loginmysql.addActionListener(this);
		insert.addActionListener(this);
		delete.addActionListener(this);
		select.addActionListener(this);
		update.addActionListener(this);
		login.addActionListener(this);
		exit.addActionListener(this);
		mexit.addActionListener(this);
		relogin.addActionListener(this);
		register.addActionListener(this);

		referDatabase.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				referTable.removeAll();
				refercol.removeAll();
				try {

					rs = st.executeQuery("show tables from " + referDatabase.getSelectedItem());
					while (rs.next()) {
						referTable.addItem(rs.getString("Tables_in_" + referDatabase.getSelectedItem()));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "出错" + e1.fillInStackTrace(), "更新参照表失败",
							JOptionPane.ERROR_MESSAGE);
				}
				refercol.removeAll();
				try {
					rs = st.executeQuery(
							"desc " + referDatabase.getSelectedItem() + "." + referTable.getSelectedItem());
					while (rs.next()) {
						refercol.add(rs.getString("Field"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "出错" + e1.fillInStackTrace(), "更新参照列失败",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		database.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				table.removeAll();
				try {

					rs = st.executeQuery("show tables from " + database.getSelectedItem());

					Database = (String) database.getSelectedItem();

					while (rs.next()) {
						table.addItem(rs.getString("Tables_in_" + database.getSelectedItem()));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Table = (String) table.getSelectedItem();
				jfselect.requestFocus();

			}
		});
		referTable.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				refercol.removeAll();
				try {
					rs = st.executeQuery(
							"desc " + referDatabase.getSelectedItem() + "." + referTable.getSelectedItem());
					while (rs.next()) {
						refercol.add(rs.getString("Field"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "出错" + e1.fillInStackTrace(), "更新参照列失败",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		table.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				Table = (String) table.getSelectedItem();
			}
		});

		inputexit.addActionListener(this);
		inputenter.addActionListener(this);

		mysqluser.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (mysqluser.getText().equals(""))

						JOptionPane.showMessageDialog(null, "请输入数据库账号信息！", "数据库登录异常", JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "请输入数据库密码！", "数据库登录异常", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		mysqlpsw.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (mysqlpsw.getText().equals(""))

						JOptionPane.showMessageDialog(null, "请输入数据库密码！", "数据库登录异常", JOptionPane.WARNING_MESSAGE);
					else
						loginmysql();

				}
			}
		});
		Tuser.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (Tuser.getText().equals(""))

						JOptionPane.showMessageDialog(null, "请输入账号信息！", "登录异常", JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "请输入密码！", "登录异常", JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		Tpsw.addActionListener(this);
		Tpsw.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (Tpsw.getText().equals(""))

						JOptionPane.showMessageDialog(null, "请输入密码！", "登录异常", JOptionPane.WARNING_MESSAGE);
					else
						login();

				}
			}
		});
		jfselect.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F6) {
					jinputsql.setVisible(true);

				}
			}
		});
		inputsqltext.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					inputenter();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					inputexit();
				}
			}
		});

		jfmysql.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					exit();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jflogin.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					exit();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		jfselect.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					exit();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	void setprimaryKey() {
		jprimary = new JFrame();
		Pname = new JTextField(15);
		Pcol1 = new JCheckBox();
		Pcol2 = new JCheckBox();
		Pcol3 = new JCheckBox();
		Pcol4 = new JCheckBox();
		Pcol5 = new JCheckBox();
		Pcol6 = new JCheckBox();
		Pcol7 = new JCheckBox();
		ctype = new Choice();

		ctype.add("       primary key     ");
		ctype.add("       unique          ");
		Penter = new JButton("确定");
		LPname = new JLabel("约束名       ");
		Lcol = new JLabel("选择要设置约束的列");
		jprimary.setLayout(new FlowLayout());
		paimaryJpanel = new JPanel();
		paimaryJpanel.setLayout(new GridLayout(8, 1));
		JLabel ltype = new JLabel("设置约束类型");
		jprimary.add(ltype);
		jprimary.add(ctype);
		jprimary.add(LPname);
		jprimary.add(Pname);
		paimaryJpanel.add(Lcol);
		jprimary.add(paimaryJpanel);
		jprimary.add(Penter);
		jprimary.setSize(250, 400);
		jprimary.setLocationRelativeTo(null);
		jprimary.setVisible(false);
		jprimary.setResizable(false);

	}

	void setforeginerKey() {
		jfkey = new JFrame();
		fl1_ftx1 = new JLabel("外键名");
		fl2_table_col = new JLabel("字段");
		fl3_referDatabase = new JLabel("参考数据库");
		fl4_referTable = new JLabel("参考表");
		fl5_refercol = new JLabel("参考字段");
		fl6_whiledelete = new JLabel("删除时");
		fl7_whileupdate = new JLabel("更新时");

		ftx1 = new JTextField();
		table_col = new Choice();
		referDatabase = new Choice();
		referTable = new Choice();
		refercol = new Choice();
		whiledelete = new Choice();
		whileupdate = new Choice();

		fkenter = new JButton("确定");
		fkexit = new JButton("返回");
		fkjp1 = new JPanel(new GridLayout(2, 7));
		fkjp2 = new JPanel(new FlowLayout());
		jfkey.setLayout(new GridLayout(2, 1));
		fkjp1.add(fl1_ftx1);
		fkjp1.add(fl2_table_col);
		fkjp1.add(fl3_referDatabase);
		fkjp1.add(fl4_referTable);
		fkjp1.add(fl5_refercol);
		fkjp1.add(fl6_whiledelete);
		fkjp1.add(fl7_whileupdate);

		fkjp1.add(ftx1);
		fkjp1.add(table_col);
		fkjp1.add(referDatabase);
		fkjp1.add(referTable);
		fkjp1.add(refercol);
		fkjp1.add(whiledelete);
		fkjp1.add(whileupdate);

		fkjp2.add(fkenter);
		fkjp2.add(fkexit);

		jfkey.add(fkjp1);
		jfkey.add(fkjp2);

		jfkey.setSize(700, 200);
		jfkey.setLocationRelativeTo(null);
		jfkey.setTitle("设置外键");
		jfkey.setResizable(false);
		jfkey.setVisible(false);

	}

	void mysqlConfiguration() {
		jfmysql = new JFrame();
		jfmysql.setLayout(null);
		bg = new JLabel(new ImageIcon("../week14/image/mysql登录.jpg"));
		bg.setBounds(0, 0, 400, 300);
		loginmysql = new JButton(" 登   录  ");
		mexit = new JButton(" 退  出  ");
		serverName = new JLabel(" 数据库服务器名 ");
		TserverName = new JTextField();
		mysqluser = new JTextField();
		mysqlpsw = new JPasswordField();
		labelmysql = new JLabel("数据库登录");
		labelmysql.setFont(new Font("楷体", Font.BOLD, 25));
		labelmysql.setForeground(Color.white);
		labelmysql.setBounds(250, 5, 200, 35);
		muser = new JLabel("账  号");
		mpsw = new JLabel("密  码");
		mysqluser.setBounds(110, 80, 200, 35);
		mysqluser.setFont(new Font("", Font.PLAIN, 25));
		mysqlpsw.setBounds(110, 130, 200, 35);
		muser.setBounds(20, 85, 100, 20);
		mpsw.setBounds(20, 135, 100, 20);
		loginmysql.setBounds(70, 200, 100, 35);
		mexit.setBounds(220, 200, 100, 35);
		jfmysql.add(muser);
		jfmysql.add(mpsw);
		jfmysql.add(mysqluser);
		jfmysql.add(mysqlpsw);
		jfmysql.add(loginmysql);
		jfmysql.add(mexit);
		jfmysql.add(serverName);
		jfmysql.add(TserverName);
		jfmysql.add(labelmysql);
		jfmysql.add(bg);

		jfmysql.setTitle("豪哥的期末项目mysql连接程序");
		jfmysql.setSize(400, 300);
		jfmysql.setLocationRelativeTo(null);
		jfmysql.setVisible(true);
		jfmysql.setResizable(false);

		serverName.setBounds(10, 15, 100, 30);
		serverName.setForeground(Color.WHITE);
		TserverName.setBounds(110, 10, 100, 35);
		TserverName.setText("localhost");
		jfmysql.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfmysql.setBackground(Color.black);
		// Container container = jfmysql.getContentPane();
		// container.setBackground(Color.black);
		mysqlpsw.setBorder(null);
		mysqluser.setBorder(null);
		muser.setForeground(Color.white);
		mpsw.setForeground(Color.white);
		mpsw.setFont(new Font("楷体", Font.BOLD, 20));
		muser.setFont(new Font("楷体", Font.BOLD, 20));
		loginmysql.setBackground(Color.black);
		loginmysql.setForeground(Color.WHITE);
		mexit.setBackground(Color.black);
		mexit.setForeground(Color.red);
		jfloginConfiguration();

	}

	void jfloginConfiguration() {
		jflogin = new JFrame();
		jflogin.setLayout(null);
		bg = new JLabel(new ImageIcon("../week14/image/login登录.jpg"));
		bg.setSize(400, 300);
		labellogin = new JLabel("用户登录");
		labellogin.setFont(new Font("楷体", Font.BOLD, 25));
		labellogin.setForeground(Color.white);
		labellogin.setBounds(280, 5, 200, 35);
		luser = new JLabel("账   号");
		lpsw = new JLabel("密   码");
		Tuser = new JTextField(20);
		Tpsw = new JPasswordField(20);
		login = new JButton(" 登   录  ");
		register = new JButton("注册");
		exit = new JButton(" 退  出  ");
		jflogin.add(luser);
		jflogin.add(Tuser);
		jflogin.add(lpsw);
		jflogin.add(Tpsw);
		jflogin.add(login);
		jflogin.add(register);
		jflogin.add(exit);
		jflogin.add(labellogin);
		jflogin.add(bg);
		luser.setBounds(20, 85, 100, 20);
		lpsw.setBounds(20, 135, 100, 20);
		login.setBounds(70, 200, 80, 35);
		register.setBounds(180, 200, 80, 35);
		exit.setBounds(290, 200, 80, 35);
		jflogin.setTitle("豪哥的期末项目登录程序");
		jflogin.setSize(400, 300);

		jflogin.setLocationRelativeTo(null);
		jflogin.setVisible(false);
		jflogin.setResizable(false);
		jflogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tuser.setBounds(110, 80, 200, 35);
		Tpsw.setBounds(110, 130, 200, 35);
		luser.setForeground(Color.white);
		lpsw.setForeground(Color.white);
		lpsw.setFont(new Font("楷体", Font.BOLD, 20));
		luser.setFont(new Font("楷体", Font.BOLD, 20));
		Tuser.setFont(new Font("", Font.PLAIN, 20));
		jfselectConfiguration();

	}

	void jfinputConfiguration() {
		jinputsql = new JFrame();
		inputsqllabel = new JLabel("请输入sql语句：");
		inputsqltext = new JTextField(50);
		jinputsql.setLayout(null);
		inputenter = new JButton("确 定");
		inputexit = new JButton("取 消");
		listinputrs = new List();
		listinputrs.setBounds(20, 100, 450, 500);
		inputsqllabel.setBounds(20, 10, 100, 50);
		inputsqltext.setBounds(20, 50, 450, 30);
		inputenter.setBounds(100, 120, 100, 35);
		inputexit.setBounds(300, 120, 100, 35);
		jinputsql.setTitle("豪哥的命令提示界面");
		jinputsql.add(inputsqllabel);
		jinputsql.add(inputsqltext);
		jinputsql.add(inputenter);
		jinputsql.add(inputexit);
		jinputsql.add(listinputrs);
		jinputsql.setSize(500, 200);
		jinputsql.setLocationRelativeTo(null);
		jinputsql.setVisible(false);
		jinputsql.setResizable(false);
		listinputrs.setVisible(false);
		jinputsql.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		inputsqltext.setFont(new Font("", Font.PLAIN, 15));
		Container input = jinputsql.getContentPane();
		input.setBackground(Color.black);
		inputenter.setBackground(Color.GREEN);
		inputexit.setBackground(Color.red);
		inputsqllabel.setForeground(Color.white);

	}

	void jfselectConfiguration() {
		jfselect = new JFrame();
		database = new Choice();
		table = new Choice();

		jfselect.setLayout(null);
		String imgurl = "";
		System.out.println(userType);
		time = new JLabel("");
		time.setBounds(780, 0, 200, 25);
		time.setForeground(Color.red);

		imgurl = "../week14/image/main界面.jpg";
		bg = new JLabel(new ImageIcon(imgurl));
		bg.setSize(1000, 600);
		labelselect = new JLabel();
		labelselect.setFont(new Font("楷体", Font.BOLD, 20));
		labelselect.setForeground(Color.black);
		labelselect.setBounds(420, 5, 500, 35);
		list1 = new List();
		list2 = new List();
		list3 = new List();
		list4 = new List();
		list5 = new List();
		list6 = new List();
		list7 = new List();
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel();
		col1 = new JLabel();
		col2 = new JLabel();
		col3 = new JLabel();
		col4 = new JLabel();
		col5 = new JLabel();
		col6 = new JLabel();
		col7 = new JLabel();
		colt1 = new JLabel();
		colt2 = new JLabel();
		colt3 = new JLabel();
		colt4 = new JLabel();
		colt5 = new JLabel();
		colt6 = new JLabel();
		colt7 = new JLabel();
		jtx1 = new JTextField(20);
		jtx2 = new JTextField(20);
		jtx3 = new JTextField(20);
		jtx4 = new JTextField(20);
		jtx5 = new JTextField(20);
		jtx6 = new JTextField(20);
		jtx7 = new JTextField(20);
		select = new JButton("查询");
		insert = new JButton("插入");
		delete = new JButton("删除");
		update = new JButton("更新");
		setP = new JButton("设置约束");
		select.setOpaque(false);
		select.setBackground(new Color(2, 2, 2));
		select.setForeground(Color.WHITE);
		insert.setOpaque(false);
		insert.setBackground(new Color(2, 2, 2));
		insert.setForeground(Color.WHITE);
		select.setOpaque(false);
		delete.setBackground(new Color(2, 2, 2));
		delete.setForeground(Color.WHITE);
		delete.setOpaque(false);
		update.setBackground(new Color(2, 2, 2));
		update.setOpaque(false);
		update.setForeground(Color.WHITE);

		setP.setBounds(900, 50, 100, 25);
		setF = new JButton("设置外键");
		setF.setBounds(900, 75, 100, 25);
		relogin = new JButton("切换账号");
		ldb = new JLabel("数据库:");
		ltb = new JLabel(" 表名 :");
		ldb.setBounds(55, 10, 50, 20);
		database.setBounds(110, 10, 120, 20);
		ltb.setBounds(260, 10, 40, 20);
		table.setBounds(300, 10, 120, 20);
		insert.setBounds(50, 400, 70, 35);
		delete.setBounds(150, 400, 70, 35);
		update.setBounds(250, 400, 70, 35);
		select.setBounds(350, 400, 70, 35);
		col1.setBounds(10, 53, 120, 20);
		colt1.setBounds(10, 65, 120, 20);
		col2.setBounds(130, 53, 120, 20);
		colt2.setBounds(130, 65, 120, 20);
		col3.setBounds(250, 53, 120, 20);
		colt3.setBounds(250, 65, 120, 20);
		col4.setBounds(370, 53, 120, 20);
		colt4.setBounds(370, 65, 120, 20);
		col5.setBounds(490, 53, 120, 20);
		colt5.setBounds(490, 65, 120, 20);
		col6.setBounds(610, 53, 120, 20);
		colt6.setBounds(610, 65, 120, 20);
		col7.setBounds(730, 53, 120, 20);
		colt7.setBounds(730, 65, 120, 20);
		list1.setBounds(10, 80, 120, 300);
		list2.setBounds(130, 80, 120, 300);
		list3.setBounds(250, 80, 120, 300);
		list4.setBounds(370, 80, 120, 300);
		list5.setBounds(490, 80, 120, 300);
		list6.setBounds(610, 80, 120, 300);
		list7.setBounds(730, 80, 120, 300);
		list1.setFont(new Font("楷体", Font.BOLD, 13));
		list2.setFont(new Font("楷体", Font.BOLD, 13));
		list3.setFont(new Font("楷体", Font.BOLD, 13));
		list4.setFont(new Font("楷体", Font.BOLD, 13));
		list5.setFont(new Font("楷体", Font.BOLD, 13));
		list6.setFont(new Font("楷体", Font.BOLD, 13));
		list7.setFont(new Font("楷体", Font.BOLD, 13));
		list1.setVisible(false);
		list2.setVisible(false);
		list3.setVisible(false);
		list4.setVisible(false);
		list5.setVisible(false);
		list6.setVisible(false);
		list7.setVisible(false);
		jtx1.setBounds(60, 460, 80, 30);
		jtx4.setBounds(60, 490, 80, 30);
		jtx6.setBounds(60, 520, 80, 30);
		jtx2.setBounds(202, 460, 80, 30);
		jtx5.setBounds(202, 490, 80, 30);
		jtx7.setBounds(202, 520, 80, 30);
		jtx3.setBounds(347, 460, 80, 30);
		l1.setBounds(5, 470, 60, 15);
		l4.setBounds(5, 500, 60, 15);
		l6.setBounds(5, 530, 60, 15);
		l2.setBounds(150, 470, 60, 15);
		l5.setBounds(150, 500, 60, 15);
		l7.setBounds(150, 530, 60, 15);
		l3.setBounds(295, 470, 60, 15);
		relogin.setBounds(900, 0, 100, 25);
		relogin.setBackground(Color.black);
		relogin.setForeground(Color.WHITE);
		jfselect.add(ldb);
		jfselect.add(database);
		jfselect.add(ltb);
		jfselect.add(table);
		jfselect.add(relogin);
		jfselect.add(setP);
		jfselect.add(setF);
		jfselect.add(list1);
		jfselect.add(list2);
		jfselect.add(list3);
		jfselect.add(list4);
		jfselect.add(list5);
		jfselect.add(list6);
		jfselect.add(list7);
		jfselect.add(l1);
		jfselect.add(l2);
		jfselect.add(l3);
		jfselect.add(l4);
		jfselect.add(l5);
		jfselect.add(l6);
		jfselect.add(l7);
		jfselect.add(col1);
		jfselect.add(col2);
		jfselect.add(col3);
		jfselect.add(col4);
		jfselect.add(col5);
		jfselect.add(col6);
		jfselect.add(col7);
		jfselect.add(colt1);
		jfselect.add(colt2);
		jfselect.add(colt3);
		jfselect.add(colt4);
		jfselect.add(colt5);
		jfselect.add(colt6);
		jfselect.add(colt7);
		jfselect.add(jtx1);
		jfselect.add(jtx2);
		jfselect.add(jtx3);
		jfselect.add(jtx4);
		jfselect.add(jtx5);
		jfselect.add(jtx6);
		jfselect.add(jtx7);
		jfselect.add(insert);
		jfselect.add(delete);
		jfselect.add(select);
		jfselect.add(update);
		jfselect.add(labelselect);
		jfselect.add(time);
		jfselect.add(bg);
		jfselect.setTitle("查询");
		jfselect.setSize(1000, 600);
		jfselect.setLocationRelativeTo(null);
		jfselect.setVisible(false);
		jfselect.setResizable(false);
		jfselect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtx1.setVisible(false);
		jtx2.setVisible(false);
		jtx3.setVisible(false);
		jtx4.setVisible(false);
		jtx5.setVisible(false);
		jtx6.setVisible(false);
		jtx7.setVisible(false);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		jfinputConfiguration();
		setprimaryKey();
		setforeginerKey();
	}

	void login() {

		String qx = "";
		@SuppressWarnings("deprecation")
		String sqluser = "select * from chester.user where username = '" + Tuser.getText() + "' and psw = '"
				+ Tpsw.getText() + "'";
		System.out.println(qx);
		try {
			rs = st.executeQuery(sqluser);
			while (rs.next()) {
				qx = rs.getString("qx");

			}
			if (qx.equals("administrator")) {

				jfselect.setVisible(true);
				jfselect.requestFocus();
				jflogin.setVisible(false);
				labelselect.setText("用户名：" + Tuser.getText() + "   当前用户类型：管理员");
				list1.removeAll();
				list2.removeAll();
				jfselect.setTitle("管理员界面" + "              当前管理员账号：  " + Tuser.getText());
				select.setEnabled(true);
				update.setEnabled(true);
				insert.setEnabled(true);
				delete.setEnabled(true);
				list1.setBackground(Color.black);
				list1.setForeground(Color.white);
				list2.setBackground(Color.black);
				list2.setForeground(Color.white);
				list3.setBackground(Color.black);
				list3.setForeground(Color.white);
				list4.setBackground(Color.black);
				list4.setForeground(Color.white);
				list5.setBackground(Color.black);
				list5.setForeground(Color.white);
				list6.setBackground(Color.black);
				list6.setForeground(Color.white);
				list7.setBackground(Color.black);
				list7.setForeground(Color.white);

			} else if (qx.equals("customer")) {

				list1.removeAll();
				list2.removeAll();
				jfselect.setVisible(true);
				jfselect.requestFocus();
				jflogin.setVisible(false);
				labelselect.setText("用户名：" + Tuser.getText() + "当前用户类型：普通用户");
				jfselect.setTitle("普通用户界面" + "              当前用户账号：  " + Tuser.getText());
				select.setEnabled(true);
				update.setEnabled(false);
				insert.setEnabled(false);
				delete.setEnabled(false);
				list1.setBackground(Color.white);
				list1.setForeground(Color.black);
				list2.setBackground(Color.white);
				list2.setForeground(Color.black);
				list3.setBackground(Color.white);
				list3.setForeground(Color.black);
				list4.setBackground(Color.white);
				list4.setForeground(Color.black);
				list5.setBackground(Color.white);
				list5.setForeground(Color.black);
				list6.setBackground(Color.white);
				list6.setForeground(Color.black);
				list7.setBackground(Color.white);
				list7.setForeground(Color.black);

			} else {
				Tpsw.setText("");
				JOptionPane.showMessageDialog(null, "账号或密码错误", "登录异常	", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "" + e1.fillInStackTrace(), "登录异常", JOptionPane.WARNING_MESSAGE);
		}

	}

	void exit() throws SQLException {
		JOptionPane.showMessageDialog(null, "感谢使用再见！", "来自豪哥的简讯", JOptionPane.INFORMATION_MESSAGE);
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
		if (rs != null)
			rs.close();
		System.exit(1);
	}

	@SuppressWarnings("deprecation")
	void loginmysql() {

		int ch = 0;
		server = TserverName.getText();
		username = mysqluser.getText();
		psw = mysqlpsw.getText();
		try {
			Class.forName(jdriver);
		} catch (java.lang.ClassNotFoundException e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "" + e1.fillInStackTrace(), "登录异常", JOptionPane.WARNING_MESSAGE);
		}
		try {
			conn = DriverManager.getConnection(url, username, psw);
			st = conn.createStatement();

			selectionDb();
			database.select(0);

		} catch (SQLException e1) {
			ch++;
			JOptionPane.showMessageDialog(null, "数据库连接失败", "mysql连接信息", JOptionPane.WARNING_MESSAGE);
			System.out.println("sql异常：" + e1.getMessage());
			mysqlpsw.setText("");

		}
		if (ch == 0) {
			JOptionPane.showMessageDialog(null, "数据库连接成功   数据库用户： " + mysqluser.getText() + "  欢迎您！", "mysql连接信息",
					JOptionPane.PLAIN_MESSAGE);
			jfmysql.setVisible(false);
			jflogin.setVisible(true);

		}
	}

	void selectionDb() {

		try {

			rs = st.executeQuery("show databases");
			while (rs.next()) {
				database.addItem(rs.getString("Database"));
			}
			table.removeAll();
			try {

				rs = st.executeQuery("show tables from " + database.getSelectedItem());

				Database = (String) database.getSelectedItem();

				while (rs.next()) {
					table.addItem(rs.getString("Tables_in_" + database.getSelectedItem()));

				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Table = (String) table.getSelectedItem();

		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "" + e3.fillInStackTrace(), "数据库更新异常！", JOptionPane.WARNING_MESSAGE);
		}

		jfselect.requestFocus();
	}

	void sqlselect() {
		list1.removeAll();
		list2.removeAll();
		list3.removeAll();
		list4.removeAll();
		list5.removeAll();
		list6.removeAll();
		list7.removeAll();
		list1.setVisible(false);

		list2.setVisible(false);

		list3.setVisible(false);

		list4.setVisible(false);

		list5.setVisible(false);

		list6.setVisible(false);

		list7.setVisible(false);
		jtx1.setVisible(false);
		jtx2.setVisible(false);
		jtx3.setVisible(false);
		jtx4.setVisible(false);
		jtx5.setVisible(false);
		jtx6.setVisible(false);
		jtx7.setVisible(false);
		col1.setText("");
		colt1.setText("");
		col2.setText("");
		colt2.setText("");
		col3.setText("");
		colt3.setText("");
		col4.setText("");
		colt4.setText("");
		col5.setText("");
		colt5.setText("");
		col6.setText("");
		colt6.setText("");
		col7.setText("");
		colt7.setText("");

		colname = new String[7];
		coltype = new String[7];

		int i = 0;
		int col_i = 0;
		String sqlselect = null;

		list1.removeAll();
		list2.removeAll();
		try {

			sqlselect = "select * from  " + Database + "." + Table;

			rs1 = st.executeQuery("desc " + Database + "." + Table);
			while (rs1.next()) {

				colname[col_i] = rs1.getString("Field");
				coltype[col_i] = rs1.getString("Type");
				if (col_i < colname.length - 1)
					col_i++;
			}
			if (!jtx1.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[0] + " = '" + jtx1.getText()
						+ "'";
				jtx1.setText("");
			}
			if (!jtx2.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[1] + " = '" + jtx2.getText()
						+ "'";
				jtx2.setText("");
			}
			if (!jtx3.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[2] + " = '" + jtx3.getText()
						+ "'";
				jtx3.setText("");
			}
			if (!jtx4.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[3] + " = '" + jtx4.getText()
						+ "'";
				jtx4.setText("");
			}
			if (!jtx5.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[4] + " = '" + jtx5.getText()
						+ "'";
				jtx5.setText("");
			}
			if (!jtx6.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[5] + " = '" + jtx6.getText()
						+ "'";
				jtx6.setText("");
			}
			if (!jtx7.getText().equals("")) {

				sqlselect = "select * from " + Database + "." + Table + " where " + colname[6] + " = '" + jtx7.getText()
						+ "'";
				jtx7.setText("");
			}
			col1.setText(colname[0]);
			colt1.setText(coltype[0]);
			col2.setText(colname[1]);
			colt2.setText(coltype[1]);
			col3.setText(colname[2]);
			colt3.setText(coltype[2]);
			col4.setText(colname[3]);
			colt4.setText(coltype[3]);
			col5.setText(colname[4]);
			colt5.setText(coltype[4]);
			col6.setText(colname[5]);
			colt6.setText(coltype[5]);
			col7.setText(colname[6]);
			colt7.setText(coltype[6]);
			l1.setText(colname[0]);
			l2.setText(colname[1]);
			l3.setText(colname[2]);
			l4.setText(colname[3]);
			l5.setText(colname[4]);
			l6.setText(colname[5]);
			l7.setText(colname[6]);
			rs = st.executeQuery(sqlselect);
			while (rs.next()) {
				if (colname[0] != null) {
					jtx1.setVisible(true);
					list1.setVisible(true);
					list1.add(rs.getString(colname[0]), i);
					if (colname[1] != null) {
						jtx2.setVisible(true);
						list2.setVisible(true);
						list2.add(rs.getString(colname[1]), i);
						if (colname[2] != null) {
							jtx3.setVisible(true);
							list3.setVisible(true);
							list3.add(rs.getString(colname[2]), i);
							if (colname[3] != null) {
								jtx4.setVisible(true);
								list4.setVisible(true);
								list4.add(rs.getString(colname[3]), i);
								if (colname[4] != null) {
									jtx5.setVisible(true);
									list5.setVisible(true);
									list5.add(rs.getString(colname[4]), i);
									if (colname[5] != null) {
										jtx6.setVisible(true);
										list6.setVisible(true);
										list6.add(rs.getString(colname[5]), i);
										if (colname[6] != null) {
											jtx7.setVisible(true);
											list7.setVisible(true);
											list7.add(rs.getString(colname[6]), i);
										}
									}
								}
							}
						}
					}
				}

				i++;
			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "查询失败！" + e1.fillInStackTrace(), "查询错误", JOptionPane.WARNING_MESSAGE);
			// TODO Auto-generated catch block

		}
	}

	void sqlinsert() {
		String sqlinsert = null;
		String sqlinsertbefore = null;
		String sqlinsertafter = null;
		int checkinsert = 0;
		int checklist = 0;
		sqlinsertbefore = "insert " + Database + "." + Table + "(";
		sqlinsertafter = "values(";
		if (colname[0] != null) {
			sqlinsertbefore += colname[0];
			sqlinsertafter += "'" + jtx1.getText();
			checkinsert = 1;
			if (colname[1] != null) {
				sqlinsertbefore += "," + colname[1];
				sqlinsertafter += "','" + jtx2.getText();
				checkinsert = 2;
				if (colname[2] != null) {
					sqlinsertbefore += "," + colname[2];
					sqlinsertafter += "','" + jtx3.getText();
					checkinsert = 3;
					if (colname[3] != null) {
						sqlinsertbefore += "," + colname[3];
						sqlinsertafter += "','" + jtx4.getText();
						checkinsert = 4;
						if (colname[4] != null) {
							sqlinsertbefore += "," + colname[4];
							sqlinsertafter += "','" + jtx5.getText();
							checkinsert = 5;
							if (colname[5] != null) {
								sqlinsertbefore += "," + colname[5];
								sqlinsertafter += "','" + jtx6.getText();
								checkinsert = 6;
								if (colname[6] != null) {
									sqlinsertbefore += "," + colname[6];
									sqlinsertafter += "','" + jtx7.getText();
									checkinsert = 7;

								}
							}
						}
					}
				}
			}

		}
		if (jtx1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "至少添加一条属性", "出错！", JOptionPane.WARNING_MESSAGE);
		} else {
			sqlinsertbefore += ")";
			sqlinsertafter += "')";
			checklist = 1;
		}
		try {

			sqlinsert = sqlinsertbefore + sqlinsertafter;
			System.out.println(sqlinsert);
			st.executeUpdate(sqlinsert);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "插入失败！" + e1.fillInStackTrace(), "插入错误", JOptionPane.WARNING_MESSAGE);
			// TODO Auto-generated catch block
		}
		if (checkinsert != 0) {
			if (checklist == 1)
				list1.add(jtx1.getText());
			if (checkinsert >= 2) {
				if (checklist == 1)
					list2.add(jtx2.getText());
				if (checkinsert >= 3) {
					if (checklist == 1)
						list3.add(jtx3.getText());
					if (checkinsert >= 4) {
						if (checklist == 1)
							list4.add(jtx4.getText());
						if (checkinsert >= 5) {
							if (checklist == 1)
								list5.add(jtx5.getText());
							if (checkinsert >= 6) {
								if (checklist == 1)
									list6.add(jtx6.getText());
								if (checkinsert >= 7) {
									if (checklist == 1)
										list7.add(jtx7.getText());
								}
							}
						}
					}
				}
			}
		}

		jtx1.setText("");
		jtx2.setText("");
		jtx3.setText("");
		jtx4.setText("");
		jtx5.setText("");
		jtx6.setText("");
		jtx7.setText("");
	}

	void sqlupdate() {
		int checkupdate = 0;
		String sql = "";
		int col = 0;
		int index = -1;
		String colValues = "";
		index = list1.getSelectedIndex();
		try {
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "请选择第一列主码字段作为更新条件", "来自更新的错误", JOptionPane.WARNING_MESSAGE);
			}
			if (list7.getSelectedIndex() != -1) {
				col = 6;
				colValues = jtx7.getText();
				checkupdate = 7;
			} else {
				if (list6.getSelectedIndex() != -1) {
					col = 5;
					colValues = jtx6.getText();
					checkupdate = 6;
				} else {
					if (list5.getSelectedIndex() != -1) {
						col = 4;
						colValues = jtx5.getText();
						checkupdate = 5;
					} else {
						if (list4.getSelectedIndex() != -1) {
							col = 3;
							colValues = jtx4.getText();
							checkupdate = 4;
						} else {
							if (list3.getSelectedIndex() != -1) {
								col = 2;
								colValues = jtx3.getText();
								checkupdate = 3;
							} else {
								if (list2.getSelectedIndex() != -1) {
									col = 1;
									colValues = jtx2.getText();
									checkupdate = 2;
								} else {
									if (list1.getSelectedIndex() != -1) {
										col = 0;
										colValues = jtx1.getText();
										checkupdate = 1;
									} else {
										JOptionPane.showMessageDialog(null, "请选择第一列主码字段作为更新条件", "来自更新的错误",
												JOptionPane.WARNING_MESSAGE);
									}
								}
							}
						}
					}
				}
			}

			sql = "update " + Database + "." + Table + " set " + colname[col] + "= '" + colValues + "'  where "
					+ colname[0] + " = '" + list1.getItem(index) + "'";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "更新失败！" + e1.fillInStackTrace(), "更新错误", JOptionPane.WARNING_MESSAGE);

		}
		int i = list1.getSelectedIndex();
		if (checkupdate == 1) {

			list1.remove(list1.getSelectedIndex());
			list1.add(jtx1.getText(), i);
			jtx1.setText("");
		}
		if (checkupdate == 2) {

			list2.remove(list1.getSelectedIndex());
			list2.add(jtx2.getText(), list1.getSelectedIndex());
			jtx2.setText("");
		}
		if (checkupdate == 3) {
			list3.remove(list1.getSelectedIndex());
			list3.add(jtx3.getText(), list1.getSelectedIndex());
			jtx3.setText("");
		}
		if (checkupdate == 4) {
			list4.remove(list1.getSelectedIndex());
			list4.add(jtx4.getText(), list1.getSelectedIndex());
			jtx4.setText("");
		}
		if (checkupdate == 5) {
			list5.remove(list1.getSelectedIndex());
			list5.add(jtx5.getText(), list1.getSelectedIndex());
			jtx5.setText("");
		}
		if (checkupdate == 6) {
			list6.remove(list1.getSelectedIndex());
			list6.add(jtx6.getText(), list1.getSelectedIndex());
			jtx6.setText("");
		}
		if (checkupdate == 7) {
			list7.remove(list1.getSelectedIndex());
			list7.add(jtx7.getText(), list1.getSelectedIndex());
			jtx7.setText("");
		}

	}

	void sqldelete() {

		String sqldelete = "";
		try {
			if (list1.getSelectedIndex() != -1) {
				sqldelete = "delete from " + Database + "." + Table + " where " + colname[0] + "='"
						+ list1.getSelectedItem() + "'";
				st.executeUpdate(sqldelete);
				if (list7.isVisible())
					list7.remove(list1.getSelectedIndex());
				if (list6.isVisible())
					list6.remove(list1.getSelectedIndex());
				if (list5.isVisible())
					list5.remove(list1.getSelectedIndex());
				if (list4.isVisible())
					list4.remove(list1.getSelectedIndex());
				if (list3.isVisible())
					list3.remove(list1.getSelectedIndex());
				if (list2.isVisible())
					list2.remove(list1.getSelectedIndex());
				if (list1.isVisible())
					list1.remove(list1.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(null, "请选主码字段作为删除条件", "删除异常！", JOptionPane.WARNING_MESSAGE);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "" + e.fillInStackTrace(), "删除异常！", JOptionPane.WARNING_MESSAGE);
		}

	}

	void relogin() {
		jfselect.setVisible(false);
		jflogin.setVisible(true);
		Tpsw.setText("");
		Tuser.setText("");
		list1.setVisible(false);
		jtx1.setVisible(false);
		list2.setVisible(false);
		jtx2.setVisible(false);
		list3.setVisible(false);
		jtx3.setVisible(false);
		list4.setVisible(false);
		jtx4.setVisible(false);
		list5.setVisible(false);
		jtx5.setVisible(false);
		list6.setVisible(false);
		jtx6.setVisible(false);
		list7.setVisible(false);
		jtx7.setVisible(false);
		col1.setText("");
		col2.setText("");
		col3.setText("");
		col4.setText("");
		col5.setText("");
		col6.setText("");
		col7.setText("");
		colt1.setText("");
		colt2.setText("");
		colt3.setText("");
		colt4.setText("");
		colt5.setText("");
		colt6.setText("");
		colt7.setText("");
		l1.setText("");
		l2.setText("");
		l3.setText("");
		l4.setText("");
		l5.setText("");
		l6.setText("");
		l7.setText("");
		Tuser.requestFocus();
	}

	void inputenter() {
		int check = 0;
		String sql = "";

		try {
			sql = inputsqltext.getText();
			database.removeAll();
			st.execute(sql);

			// rs = st.getResultSet();
			// while (rs.next()) {
			// jinputsql.setSize(500, 700);
			// inputenter.setBounds(100, 500, 100, 35);
			// inputexit.setBounds(300, 500, 100, 35);
			// listinputrs.setVisible(true);
			// listinputrs.add(rs.getString(1));
			// listinputrs.add(rs.getString(2));
			// listinputrs.add(rs.getString(3));
			// listinputrs.add(rs.getString(4));
			//
			//
			// }
		} catch (SQLException e1) {

			check = 1;
			JOptionPane.showMessageDialog(null, "sql语句出错", "来自命令提示界面", JOptionPane.WARNING_MESSAGE);
		}
		if (check != 1) {
			JOptionPane.showMessageDialog(null, "sql语句执行成功", "来自命令提示界面", JOptionPane.PLAIN_MESSAGE);
			inputexit();
		}
		selectionDb();
	}

	void inputexit() {
		inputsqltext.setText("");
		jinputsql.setVisible(false);
	}

	void setp() {
		Pcol1.setVisible(false);
		Pcol2.setVisible(false);
		Pcol3.setVisible(false);
		Pcol4.setVisible(false);
		Pcol5.setVisible(false);
		Pcol6.setVisible(false);
		Pcol7.setVisible(false);

		try {
			if (colname[0] != null) {
				paimaryJpanel.add(Pcol1);
				Pcol1.setVisible(true);
				Pcol1.setText(colname[0]);
				if (colname[1] != null) {
					paimaryJpanel.add(Pcol2);
					Pcol2.setVisible(true);
					Pcol2.setText(colname[1]);
					if (colname[2] != null) {
						paimaryJpanel.add(Pcol3);
						Pcol3.setVisible(true);
						Pcol3.setText(colname[2]);
						if (colname[3] != null) {
							paimaryJpanel.add(Pcol4);
							Pcol4.setVisible(true);
							Pcol4.setText(colname[3]);
							if (colname[4] != null) {
								paimaryJpanel.add(Pcol5);
								Pcol5.setVisible(true);
								Pcol5.setText(colname[4]);
								if (colname[5] != null) {
									paimaryJpanel.add(Pcol6);
									Pcol6.setVisible(true);
									Pcol6.setText(colname[5]);
									if (colname[6] != null) {
										paimaryJpanel.add(Pcol7);
										Pcol7.setVisible(true);
										Pcol7.setText(colname[6]);
									}
								}
							}
						}
					}
				}
			}
			jprimary.setVisible(true);

		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "请先查询表信息", "来自设置主键错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	void setF() {

		try {
			if (colname[0] != null) {
				table_col.addItem(colname[0]);
				if (colname[1] != null) {
					table_col.addItem(colname[1]);
					if (colname[2] != null) {
						table_col.addItem(colname[2]);
						if (colname[3] != null) {
							table_col.addItem(colname[3]);
							if (colname[4] != null) {
								table_col.addItem(colname[4]);
								if (colname[5] != null) {
									table_col.addItem(colname[5]);
									if (colname[6] != null) {
										table_col.addItem(colname[6]);
									}
								}
							}
						}
					}
				}
			}
			jfkey.setVisible(true);
			referDatabase.removeAll();
			referTable.removeAll();
			refercol.removeAll();
			rs = st.executeQuery("show databases");
			while (rs.next()) {
				referDatabase.add(rs.getString("Database"));
			}

			rs = st.executeQuery("show tables from " + referDatabase.getSelectedItem());
			while (rs.next()) {
				referTable.add(rs.getString("Tables_in_" + referDatabase.getSelectedItem()));
			}
			rs = st.executeQuery("desc " + referDatabase.getSelectedItem() + "." + referTable.getSelectedItem());
			while (rs.next()) {
				refercol.add(rs.getString("Field"));
			}
			whiledelete.add("RESTRICT");
			whiledelete.add("NO ACTION");
			whiledelete.add("CASCADE");
			whiledelete.add("SET NULL");
			whileupdate.add("RESTRICT");
			whileupdate.add("NO ACTION");
			whileupdate.add("CASCADE");
			whileupdate.add("SET NULL");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "请先查询表信息", "设置外键提示", JOptionPane.ERROR_MESSAGE);
		}

	}

	void penter() {

		if (Pname.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请设置约束名", "来自设置约束错误", JOptionPane.ERROR_MESSAGE);
		} else {
			String sql = "";
			String selectcol = "";
			if (Pcol1.isSelected()) {
				selectcol += Pcol1.getText();
			}
			if (Pcol2.isSelected()) {
				if (Pcol1.isSelected()) {
					selectcol += ",";
				}
				selectcol += Pcol2.getText();
			}
			if (Pcol3.isSelected()) {
				if (Pcol1.isSelected() || Pcol2.isSelected()) {
					selectcol += ",";
				}

				selectcol += Pcol3.getText();
			}
			if (Pcol4.isSelected()) {
				if (Pcol1.isSelected() || Pcol2.isSelected() || Pcol3.isSelected()) {
					selectcol += ",";
				}
				selectcol += Pcol4.getText();
			}
			if (Pcol5.isSelected()) {
				if (Pcol1.isSelected() || Pcol2.isSelected() || Pcol3.isSelected() || Pcol4.isSelected()) {
					selectcol += ",";
				}
				selectcol += Pcol5.getText();
			}
			if (Pcol6.isSelected()) {
				if (Pcol1.isSelected() || Pcol2.isSelected() || Pcol3.isSelected() || Pcol4.isSelected()
						|| Pcol5.isSelected()) {
					selectcol += ",";
				}
				selectcol += Pcol6.getText();
			}
			if (Pcol7.isSelected()) {
				if (Pcol1.isSelected() || Pcol2.isSelected() || Pcol3.isSelected() || Pcol4.isSelected()
						|| Pcol5.isSelected() || Pcol5.isSelected()) {
					selectcol += ",";
				}
				selectcol += Pcol7.getText();
			}
			if (ctype.getSelectedItem() == "       primary key     ") {
				sql = "alter table " + Database + "." + Table + " add constraint " + Pname.getText() + " primary key("
						+ selectcol + ")";
			}
			if (ctype.getSelectedItem() == "       unique          ") {
				sql = "alter table " + Database + "." + Table + " add constraint " + Pname.getText() + " unique("
						+ selectcol + ")";
			}
			try {
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "设置成功", "", JOptionPane.PLAIN_MESSAGE);
				Pcol1.setSelected(false);
				Pcol2.setSelected(false);
				Pcol3.setSelected(false);
				Pcol4.setSelected(false);
				Pcol5.setSelected(false);
				Pcol6.setSelected(false);
				Pcol7.setSelected(false);
				Pname.setText("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "" + e1.fillInStackTrace(), "语句错误", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	void fkenter() {
		if (ftx1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "外键名为空！", "设置外键错误提示", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				st.execute("ALTER TABLE " + Database + "." + Table + " " + "ADD CONSTRAINT " + ftx1.getText()
						+ " FOREIGN KEY (" + table_col.getSelectedItem() + ") " + "REFERENCES "
						+ referDatabase.getSelectedItem() + "." + referTable.getSelectedItem() + " ("
						+ refercol.getSelectedItem() + ") " + "ON DELETE " + whiledelete.getSelectedItem()
						+ " ON UPDATE " + whileupdate.getSelectedItem() + "");

				JOptionPane.showMessageDialog(null, "设置外键成功", "设置外键提示", JOptionPane.PLAIN_MESSAGE);
				ftx1.setText("");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "设置外键失败" + e2.fillInStackTrace(), "设置外键错误提示",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	void fkexit() {
		ftx1.setText("");
		jfkey.setVisible(false);
		referDatabase.removeAll();
		referTable.removeAll();
		refercol.removeAll();
	}

	@SuppressWarnings("deprecation")
	void renter() {
		send.setText("发送验证码");
		send.setSize(100, 35);
		send.setForeground(Color.black);
		if (rusername.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "注册账号为空", "注册信息", JOptionPane.WARNING_MESSAGE);
			rusername.requestFocus();
		} else if (rusername.getText().length() < 4) {
			JOptionPane.showMessageDialog(null, "账号至少多余三个字符", "注册信息", JOptionPane.WARNING_MESSAGE);
			rusername.requestFocus();
		} else if (rpsw.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "密码为空", "注册信息", JOptionPane.WARNING_MESSAGE);
			rpsw.requestFocus();
		} else if (rpsw.getText().length() < 5) {
			JOptionPane.showMessageDialog(null, "密码至少多余四个字符", "注册信息", JOptionPane.WARNING_MESSAGE);
			rpsw.requestFocus();
		} else if (!rpsw.getText().equals(rRpsw.getText())) {
			JOptionPane.showMessageDialog(null, "两次输入密码不一致", "注册信息", JOptionPane.WARNING_MESSAGE);
			rRpsw.setText("");
			rRpsw.requestFocus();
		} else if (tyz.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "请输入验证码", "注册信息", JOptionPane.WARNING_MESSAGE);
			tyz.requestFocus();
		} else if (!tyz.getText().equals(showyz.getText())) {
			JOptionPane.showMessageDialog(null, "输入验证码有误请重新输入！", "注册信息", JOptionPane.WARNING_MESSAGE);
			tyz.setText("");
			tyz.requestFocus();
		} else {
			String sql = "insert into chester.user values('" + rusername.getText() + "','" + rpsw.getText() + "','"
					+ rqx.getSelectedItem() + "')";
			try {
				st.execute(sql);
				JOptionPane.showMessageDialog(null, "注册成功", "注册信息", JOptionPane.PLAIN_MESSAGE);
				fregister.setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "注册失败,用户名已存在" + e1.fillInStackTrace(), "注册信息",
						JOptionPane.ERROR_MESSAGE);
				showyz.setText("" + (int) (Math.random() * 9 + 1) + "" + (char) (int) (Math.random() * 26 + 97) + ""
						+ (char) (int) (Math.random() * 26 + 65) + "" + (int) (Math.random() * 9 + 1)
						+ (int) (Math.random() * 9 + 1));
				send.setText("验证码变更重新发送");
				send.setSize(180, 35);
				send.setForeground(Color.RED);
				rRpsw.setText("");
				tyz.setText("");
				rusername.requestFocus();
			}
		}
	}

	String[] colname = null;
	String[] coltype = null;

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getSource() == loginmysql) {
				loginmysql();
			}
			if (e.getSource() == mexit) {
				exit();
			}
			if (e.getSource() == exit) {
				exit();
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "" + e1.fillInStackTrace(), "删除异常！", JOptionPane.WARNING_MESSAGE);
		}

		if (e.getSource() == login) {
			login();
		}

		if (e.getSource() == relogin) {
			relogin();
		}
		if (e.getSource() == select) {
			sqlselect();
			jfselect.requestFocus();
		}
		if (e.getSource() == insert) {
			sqlinsert();
			jfselect.requestFocus();
		}
		if (e.getSource() == delete) {
			jfselect.requestFocus();
			sqldelete();
		}
		if (e.getSource() == update) {
			jfselect.requestFocus();
			sqlupdate();
		}
		if (e.getSource() == inputenter) {
			inputenter();
		}
		if (e.getSource() == inputexit) {
			inputexit();
		}
		if (e.getSource() == setP) {
			jfselect.requestFocus();
			setp();
		}
		if (e.getSource() == Penter) {
			penter();
		}
		if (e.getSource() == setF) {
			jfselect.requestFocus();
			setF();
		}
		if (e.getSource() == fkenter) {

			fkenter();
		}
		if (e.getSource() == fkexit) {
			fkexit();
		}
		if (e.getSource() == register) {
			register();
			fregister.setVisible(true);
			rusername.setText("");
			tyz.setText("");
			showyz.setText("");
			rpsw.setText("");
			rRpsw.setText("");
			renter.addActionListener(this);
			rexit.addActionListener(this);
			send.addActionListener(this);
			yzenter.addActionListener(this);
		}
		if (e.getSource() == send) {
			fyz.setVisible(true);
			showyz.setText("");
			showyz.setText("" + (int) (Math.random() * 9 + 1) + "" + (char) (int) (Math.random() * 26 + 97) + ""
					+ (char) (int) (Math.random() * 26 + 65) + "" + (int) (Math.random() * 9 + 1)
					+ (int) (Math.random() * 9 + 1));
			showyz.setFont(new Font("", Font.BOLD, 48));
			fyz.requestFocus();
			fyz.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						fyz.setVisible(false);
						tyz.requestFocus();
					}
				}
			});
		}
		if (e.getSource() == yzenter) {
			fyz.setVisible(false);
			tyz.requestFocus();
		}
		if (e.getSource() == renter) {
			renter();
		}
		if (e.getSource() == rexit) {
			fregister.setVisible(false);
		}

	}

	@Override
	public void run() {
		while (true) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			new Date();
			time.setText(df.format(new Date()));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.getMessage();

			}
		}
	}

}
