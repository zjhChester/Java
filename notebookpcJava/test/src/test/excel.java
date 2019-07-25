package test;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class excel extends JFrame implements ActionListener{
	/**
	 * 
	 */
	public static void main(String[] args) {
		new excel();
	}
	private static final long serialVersionUID = 1L;
	JLabel no,name,sex,hobby,major;
	JButton delete,submit;
	JTextField jtf1,jtf2;
	JCheckBox jcb1,jcb2,jcb3,jcb4;
	JRadioButton jrb1,jrb2;
	List list;
	Choice choice;
	ButtonGroup b;
	String string;
	
	public excel(){
	no = new JLabel(" 学号 ");
	name = new JLabel(" 姓名 ");
	sex = new JLabel(" 性别 ");
	hobby = new JLabel(" 爱好 ");
	major = new JLabel(" 专业 ");
	jtf1 = new JTextField();
	jtf2 = new JTextField();
	delete = new JButton(" 删除 ");
	submit = new JButton(" 提交 ");
	jcb1 = new JCheckBox(" 吃饭 ");
	jcb2 = new JCheckBox(" 上网 ");
	jcb3 = new JCheckBox(" 睡觉 ");
	jcb4 = new JCheckBox(" 学习 ");
	jrb1= new JRadioButton(" 男 ");
	jrb2 = new JRadioButton(" 女 ");
	list = new List();
	choice = new Choice();
	b = new ButtonGroup();
	
	no.setBounds(35, 80, 40, 40);
	name.setBounds(35, 125, 40, 40);
	major.setBounds(35, 195, 40, 40);
	sex.setBounds(35, 245, 40, 40);
	hobby.setBounds(235, 100, 40, 40);
	jtf1.setBounds(85, 90, 110, 25);
	jtf2.setBounds(85, 140, 110, 25);
	jcb1.setBounds(300, 90, 78, 40);
	jcb2.setBounds(415, 90, 78, 40);
	jcb3.setBounds(300, 135, 78, 40);
	jcb4.setBounds(415, 135, 78, 40);
	jrb1.setBounds(85, 240, 95, 40);
	jrb2.setBounds(85, 270, 95, 40);
	list.setBounds(85, 315, 375, 110);
	delete.setBounds(375, 225, 80, 40);
	submit.setBounds(265, 225, 80, 40);
	choice.setBounds(85, 200, 120, 25);
	
	Container c = getContentPane();
	c.add(no);
	c.add(name);
	c.add(major);
	c.add(sex);
	c.add(hobby);
	c.add(jtf1);
	c.add(jtf2);
	c.add(jcb1);
	c.add(jcb2);
	c.add(jcb3);
	c.add(jcb4);
	c.add(jrb1);
	c.add(jrb2);
	c.add(list);
	c.add(delete);
	c.add(submit);
	c.add(choice);
	b.add(jrb1);
	b.add(jrb2);
	choice.addItem("计算机专业");
	choice.addItem("会计专业");
	choice.addItem("审计专业");
	choice.addItem("土木工程专业");
	choice.addItem("建筑专业");
	choice.addItem("市场营销专业");
	choice.addItem("旅游管理专业");
	choice.addItem("英语专业");
	choice.addItem("法语专业");
	choice.addItem("电子商务专业");
	choice.addItem("工程造价专业");
	setLayout(null);

	this.setSize(550,500);
	this.setVisible(true);
	this.setTitle("兴趣爱好调查");
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocation(800, 300);
	
	delete.addActionListener(this);
	submit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i = list.getSelectedIndex();
		if(e.getSource() == submit) {
			string = "";
			string += jtf1.getText()+"-"+jtf2.getText()+"-"+choice.getSelectedItem();
			if(jrb1.isSelected()) {
				string += "-"+jrb1.getText();
			}
			if(jrb2.isSelected()) {
				string += "-"+jrb2.getText();
			}
			if(jcb1.isSelected()) {
				string += "-"+jcb1.getText();
			}
			if(jcb2.isSelected()) {
				string += "-"+jcb2.getText();
			}
			if(jcb3.isSelected()) {
				string += "-"+jcb3.getText();
			}
			if(jcb4.isSelected()) {
				string += "-"+jcb4.getText();
			}
			try {
				Integer.parseInt(jtf1.getText());
				if(!no.getText().equals("") && !name.getText().equals(""))
				{
					list.add(string);
					jtf1.setText("");
					jtf2.setText("");
					jcb1.setSelected(false);
					jcb2.setSelected(false);
					jcb3.setSelected(false);
					jcb4.setSelected(false);
					b.clearSelection();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "请输入所有信息！", "出错!", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "请检查信息是否符合要求！", "出错！", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == delete) {
			if(i < 0) {
				JOptionPane.showMessageDialog(null, "当前没有信息可以删除！", "出错！", JOptionPane.WARNING_MESSAGE);
			}
			else if(i >= 0) {
				list.remove(i);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "你没有选择信息！", "出错!", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}