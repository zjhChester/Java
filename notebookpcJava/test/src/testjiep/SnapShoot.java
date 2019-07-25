package testjiep;

import java.awt.AWTException;  
import java.awt.Container;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.GroupLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
  
/** 
 * ��Ļ��ͼС���� 
 * @author pengranxiang 
 * 
 */  
public class SnapShoot extends JFrame {  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
    private JButton snapButton;  
    private JLabel imageLabel;  
      
    public SnapShoot() {  
        initUI();  
        initLayout();  
        createAction();  
          
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setSize(600, 400);  
        this.setTitle("��ͼС����");  
        this.setLocationRelativeTo(null);   //����  
        this.setVisible(true);  
    }  
      
    private void initUI() {  
        snapButton = new JButton("��ʼ��ͼ�����Ҽ��˳���");  
        imageLabel = new JLabel();  
    }  
      
    private void initLayout() {  
        JPanel pane = new JPanel();  
        pane.add(imageLabel);  
        JScrollPane imgScrollPane = new JScrollPane(pane);  
          
        Container container = this.getContentPane();  
        GroupLayout layout = new GroupLayout(container);  
        container.setLayout(layout);  
          
        layout.setAutoCreateContainerGaps(true);  
        layout.setAutoCreateGaps(true);  
          
        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup();  
        hGroup  
            .addComponent(snapButton)  
            .addComponent(imgScrollPane);  
        layout.setHorizontalGroup(hGroup);  
          
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();  
        vGroup  
            .addComponent(snapButton)  
            .addComponent(imgScrollPane);  
        layout.setVerticalGroup(vGroup);  
    }   
      
    private void createAction() {  
        snapButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                try {  
                    //����ģ����Ļ������ʾ��ͼ��Ŀ���������  
                    new ScreenWindow(imageLabel);  
                } catch (AWTException e1) {  
                    e1.printStackTrace();  
                } catch (InterruptedException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        });  
    }  
  
    public static void main(String[] args) {  
        new SnapShoot();  
    }  
}  
