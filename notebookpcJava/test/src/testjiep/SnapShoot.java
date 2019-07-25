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
 * 屏幕截图小程序 
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
        this.setTitle("截图小工具");  
        this.setLocationRelativeTo(null);   //居中  
        this.setVisible(true);  
    }  
      
    private void initUI() {  
        snapButton = new JButton("开始截图（点右键退出）");  
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
                    //开启模拟屏幕，将显示截图的目标组件传入  
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
