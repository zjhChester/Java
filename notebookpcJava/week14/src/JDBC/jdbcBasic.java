package JDBC;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class jdbcBasic extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public static void main(String[] args) {
		new jdbcBasic();
	}

	JFrame jFrame = new JFrame();//这是可以的
	//jFrame = new JFrame();  这是不行的 
	JButton select,insert,delete;
	JLabel l1,l2,l3;
	JTextField jtx1, jtx2, jtx3, jtx4;
	JPanel jPanel;
	ResultSet rs;
	String jdriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost/chester?useUnicode=true&characterEncoding=utf-8&useSSL=false&useSSL=false&serverTimezone=GMT";
	String username = "zjh";
	String psw = "abcd35873";
	Statement st;
	List list;
	Connection conn;
	public jdbcBasic() {
		// TODO Auto-generated constructor stub
		list= new List();
		
		jFrame = new JFrame("查询");
		select = new JButton("查询");
		insert  = new JButton("添加");
		delete  = new JButton("删除");
		jtx1 = new JTextField(20);
		jtx2 = new JTextField(20);
//		jtx3 = new JTextField(20);
//		jtx4 = new JTextField(20);
		l1 = new JLabel("学号");
		l2 = new JLabel("姓名");
		jPanel = new JPanel(new GridLayout(4, 1, 5, 5));
		jPanel.add(l1);
		jPanel.add(jtx1);
		jPanel.add(l2);
		jPanel.add(jtx2);
		jPanel.add(list);
	
		add(select);
		add(insert);
		add(delete);
		add(jPanel);
		setLayout(new GridLayout(2, 1));
		setSize(530, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		select.addActionListener(this);
		insert.addActionListener(this);
		delete.addActionListener(this);

		try {
			Class.forName(jdriver);
		} catch (java.lang.ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("forname:" + e.getMessage());
		}
		try {
			conn = DriverManager.getConnection(url, username, psw);
			st = conn.createStatement();
			System.out.println(conn.getMetaData().getTables(null, null, "", null));
		} catch (SQLException e1) {
			System.out.println("sql异常：" + e1.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i=0;
		int j =list.getSelectedIndex();
		if (e.getSource() == select) {
			String sqlselect = null;
			list.removeAll();
			try {
				if(jtx1.getText().equals(""))
				{
					sqlselect = "show tables from chester";
				}
				else {
				 sqlselect = "select * from st where sno = '"+jtx1.getText()+"'";
				
				} 
				//	String sqlselect = "select * from st";
				rs = st.executeQuery(sqlselect);
				 
				while (rs.next()) {
					
//					System.out.println(rs.getString("sno")+""+rs.getString("sname"));
					 
					System.out.println();
					list.add(rs.getString("Tables_in_chester"), i);
					i++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == insert)
		{
			String sqlinsert1 = "insert st values('"+jtx1.getText()+"','"+jtx2.getText()+"')";
			if(sqlinsert1 != null )
			{
				System.out.println(sqlinsert1);
				try {
					st.executeUpdate(sqlinsert1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			jtx1.setText("");
			jtx2.setText("");
		}
		if(e.getSource() == delete)
		{
			String sqldelete = "delete from st where sno = '"+jtx1.getText()+"'";
			System.out.println(sqldelete);
				
				String name = list.getItem(j);
				String sqldelete1 = "delete from st where sname = '"+name+"'";
				System.out.println(sqldelete1);
				list.remove(j);
				try {
					st.executeUpdate(sqldelete1);
//					st.executeUpdate(sqldelete);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	
	}

