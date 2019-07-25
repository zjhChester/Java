package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class KeyDemo
{
    //�����ͼ������������������
    private Frame f;
    private Button bt; 
    private TextField tf,tf2;
    
    //����
    KeyDemo()//���췽��
    {
        madeFrame();
    }
    
    public void madeFrame()
    {
        f = new Frame("My Frame");
        
        //��Frame���л������á�
        f.setBounds(300,100,600,500);//�Կ�ܵ�λ�úʹ�С��������
        f.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));//��Ʋ���
        
        bt = new Button("My Button");
        tf = new TextField(20);
        tf2 = new TextField(20);
        //�������ӵ�Frame��
        f.add(tf);
        f.add(tf2);
        f.add(bt);
        
        //����һ�´����ϵ��¼�
        myEvent();
        
        //��ʾ����
        f.setVisible(true);
    }
    
    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter()//���ڼ���
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("����ִ�йرգ�");
                System.exit(0);
            }
        });
        tf.addKeyListener(new KeyAdapter()//���̼�����ť
        {
            public void keyPressed(KeyEvent e)
            {
//                if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
//                   System.exit(0);
//                //��ϼ�
//                else if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER)
//                   System.exit(0);
//                else System.out.println(e.getKeyChar()+"..."+KeyEvent.getKeyText(e.getKeyCode()));
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            	
     
            	System.out.println("������"+e.getKeyCode());
            	JOptionPane.showMessageDialog(null, "���ڵڶ����ı�����������", "", JOptionPane.WARNING_MESSAGE);
            
            }
           
            
            }
        });
        tf2.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
            	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                	
            	     
                	System.out.println("������"+e.getKeyCode());
                	JOptionPane.showMessageDialog(null, "��ɵ�¼", "", JOptionPane.WARNING_MESSAGE);
                
                }
            }
       });
    }
    
    public static void main(String[] agrs)
    {
        new KeyDemo();
    }
}