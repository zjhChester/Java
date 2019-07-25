package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class game extends JFrame implements ActionListener{

	public static void main(String[] args) {
		new game();
	}
	
	JFrame jFrame = new JFrame("game");
	JButton jButton;
	JLabel jLabel = new JLabel("*");
	
	int x,y;
	
	public game() {
		
		x=300;y=5;
		init();
	}
	void init() {
		
		jFrame.setLayout(null);
		jFrame.setSize(500, 500);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jButton = new JButton("¿ªÊ¼");
		jButton.setBounds(20,20,60,30);
		jFrame.add(jButton);
		jLabel.setForeground(Color.red);
		jLabel.setFont(new Font("", Font.BOLD, 25));
		jLabel.setBounds(x,y,20,20);
		jFrame.add(jLabel);
		jButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButton)
		{
			
			
			init();
		}
	}

}
