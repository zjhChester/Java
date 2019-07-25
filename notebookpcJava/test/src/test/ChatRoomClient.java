package test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatRoomClient extends JFrame implements ActionListener{
	/**
	 * 
	 */
	public static void main(String[] args) {
		new ChatRoomClient();
	}
	private static final long serialVersionUID = 1L;
	JFrame jf;
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JLabel label;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String name ;
	public ChatRoomClient() {
		// TOD O Auto-generated constructor stub
		jf = new JFrame("聊天室客户端V1.0");
//		do {
//			String ip = JOptionPane.showInputDialog(jf,"请输入服务器地址：");
//			int port = Integer.parseInt(JOptionPane.showInputDialog(jf,"请输入端口号"));
//			try {
//				s= new Socket("127.0.0.1",8000);
//				pw = new PrintWriter(s.getOutputStream());
//				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				JOptionPane.showMessageDialog(jf, "连接失败请重新输入端口号");
//			}
//			
//		}while(s==null);
		try {
			s= new Socket("192.168.0.102",8000);
			pw = new PrintWriter(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jta = new JTextArea(20,40);
		jta.setFont(new Font("宋体", Font.BOLD, 24));
		jta.setEditable(true);
		jtf = new JTextField(28);
//		name = JOptionPane.showInputDialog(jf,"请输入您的名称");
		name = "张嘉豪的win7";
		jb = new JButton("发送");
		label = new JLabel(name+":");
		init();
		addEventHandler();
		new ReadMessageThread().start();
	}
	void init() {
		JScrollPane jsp = new JScrollPane(jta);
		jf.setLayout(new BorderLayout());
		jf.add(jsp,BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(jtf);
		panel.add(jb);
		jf.add(panel,BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	void showMe() {
		
	}
	
	void addEventHandler() {
	jb.addActionListener(this);	
	jtf.addActionListener(this);
	jf.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			int op = JOptionPane.showConfirmDialog(jf,"确定退出聊天室吗？");
			if(op==JOptionPane.YES_OPTION)
			{
				pw.println("%EXIT%:"+name);
				pw.flush();
//				try {
//					s.close();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				System.exit(0);
			}
		}
	});
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(jtf.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(jf, "不能发送空消息");
			return;
			}
		pw.println(name+":"+jtf.getText());
		pw.flush();
		jtf.setText("");
		new ReadMessageThread();
	}
	class ReadMessageThread extends Thread{
		String str="";
		
		public void run() {
			// TODO Auto-generated method stub
		while(true) {
			try {
				
				str = br.readLine();
				
				jta.append(str+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
}
