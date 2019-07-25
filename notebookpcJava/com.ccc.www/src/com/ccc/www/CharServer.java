package com.ccc.www;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatServer extends JFrame implements ActionListener{

	
	private JTextField inputMsgBox;
	private JTextArea displayArea;
	private JButton sendMsg;
	private ObjectInputStream inputS;
	private ObjectOutputStream outputS;
	private ServerSocket server;
	private Socket socket;
	public ChatServer(){
		super("聊天服务器端");
	Container container= getContentPane();
	inputMsgBox = new JTextField("",18);
	inputMsgBox.setEnabled(false);
	inputMsgBox.addActionListener(this);
	sendMsg = new JButton("发送");
	sendMsg.addActionListener(this);
	JPanel p = new JPanel(new FlowLayout());
	p.add(inputMsgBox);
	p.add(sendMsg);
	container.add(p, BorderLayout,SOUTH);
	displayArea = new JTextArea();
	Object dispalyArea;
	container.add(newJScrollPane(dispalyArea),BorderLayout,CENRER);
	this.setSize(280,320);
	this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event){
		sendMsg(inputMsgBox.getText().trim());
		inputMsgBox.setText("");
	}
	public void connect(){
		try{
			server = new ServerSocket(5000);
			setupConnection();
			communication();
		}catch(IEOxception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeConnection();
			}catch (IEOxception e){
				e.printStackTrace();
			}
		}
	}
	private void setupConnection() throws IOException{
		displayArea.setText("\n等待连接······");
		socket = server.accept();
		displayArea.append("\n与"+socket.getInetAddress().getHostName()+"客户建立连接");		
	}
	private void communication() throws IOException{
		outputS= new ObjectOutputStream(socket.getOutputStream());
		outputS.flush();
		inputS= new ObjectInputStream(socket.getInputStream());
		String s= "\n与服务器端连接成功";
		outputS.writeObject(s);
		outputS.flush();
		inputMsgBox.setEnabled(true);
		do{
			try{
				s=(String)inputS.readObject();
				displayArea.append("连接关闭");
			}
		}
	}
}
