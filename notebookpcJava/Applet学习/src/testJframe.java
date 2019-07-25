import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class testJframe {
    public static void main(String[] args) {
        //初始化一个jframe
        JFrame frame = new JFrame("张嘉豪的第一个Jframe程序");

        //初始化一个文字区域
        JTextArea textarea = new JTextArea("我就是这么牛皮的人儿");
        
        //初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        //初始化菜单
        JMenu menu1 = new JMenu("文件");
        JMenu menu2 = new JMenu("编辑");
        JMenu menu3 = new JMenu("资源");
        JMenu menu4 = new JMenu("点一下你可能会死");

        //初始化一个panel
        JPanel panel = new JPanel();

        //初始化一个容器
        Container container = frame.getContentPane();

        //初始化一个按钮
        JButton startAutoGen = new JButton("这是一个按钮"); 

        //设置布局
        container.setLayout(new FlowLayout());

        //把按钮添加到pannel
        panel.add(textarea);
     
        panel.add(startAutoGen);

        //把菜单添加到菜单栏
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        //设置菜单栏
        frame.setJMenuBar(menuBar);

        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //把panel添加到容器
        container.add(panel);

        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(100, 100);

        //设置可见性
        frame.setVisible(true);
    }
}