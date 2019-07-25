package test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

import java.net.*;
import javax.swing.*;


public class ip extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static void main(String[] args)  
{    
	new ip();
	}
JFrame JFrame ;
JButton frash;
JTextField tip,tname;
@SuppressWarnings("static-access")
public ip() {
	// TODO Auto-generated constructor stub
	JFrame = new JFrame("本机ip");
	frash = new JButton("复制");
	frash.setOpaque(false);
	frash.setBackground(new Color(2,2,2));
	JLabel lname,lip;
	tip = new JTextField();
	tname = new JTextField();
	lname = new JLabel("计算机名");
	lip = new JLabel("ip地址");
	String name = null;
	String ip = null;
	try        {            // 获取计算机名      
		 name = InetAddress.getLocalHost().getHostName();            // 获取IP地址     
		ip = InetAddress.getLocalHost().getHostAddress();            
		System.out.println("计算机名："+name);        
		System.out.println("IP地址："+ip);   
		
		}        catch (UnknownHostException e)        
		{   
			System.out.println("异常：" + e);     
			e.printStackTrace();      
		} 
	tname.setText(name);
	tip.setText(ip);
	setLayout(new FlowLayout());
	add(lname);
	add(tname);
	add(lip);
	add(tip);
	add(frash);
	setVisible(true);
	setSize(400,200);
	setLocation(500, 200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frash.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == frash)
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  //得到系统剪贴板  
	    String text = tip.getText();  
	    StringSelection selection = new StringSelection(text);  
	    clipboard.setContents(selection, null);  
	    JOptionPane.showMessageDialog(null, "已复制ip地址", "豪哥的弹框信息", JOptionPane.PLAIN_MESSAGE);
	}
}
}