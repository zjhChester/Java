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
	JFrame = new JFrame("����ip");
	frash = new JButton("����");
	frash.setOpaque(false);
	frash.setBackground(new Color(2,2,2));
	JLabel lname,lip;
	tip = new JTextField();
	tname = new JTextField();
	lname = new JLabel("�������");
	lip = new JLabel("ip��ַ");
	String name = null;
	String ip = null;
	try        {            // ��ȡ�������      
		 name = InetAddress.getLocalHost().getHostName();            // ��ȡIP��ַ     
		ip = InetAddress.getLocalHost().getHostAddress();            
		System.out.println("���������"+name);        
		System.out.println("IP��ַ��"+ip);   
		
		}        catch (UnknownHostException e)        
		{   
			System.out.println("�쳣��" + e);     
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
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  //�õ�ϵͳ������  
	    String text = tip.getText();  
	    StringSelection selection = new StringSelection(text);  
	    clipboard.setContents(selection, null);  
	    JOptionPane.showMessageDialog(null, "�Ѹ���ip��ַ", "����ĵ�����Ϣ", JOptionPane.PLAIN_MESSAGE);
	}
}
}