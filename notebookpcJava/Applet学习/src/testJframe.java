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
        //��ʼ��һ��jframe
        JFrame frame = new JFrame("�żκ��ĵ�һ��Jframe����");

        //��ʼ��һ����������
        JTextArea textarea = new JTextArea("�Ҿ�����ôţƤ���˶�");
        
        //��ʼ��һ���˵���
        JMenuBar menuBar = new JMenuBar();

        //��ʼ���˵�
        JMenu menu1 = new JMenu("�ļ�");
        JMenu menu2 = new JMenu("�༭");
        JMenu menu3 = new JMenu("��Դ");
        JMenu menu4 = new JMenu("��һ������ܻ���");

        //��ʼ��һ��panel
        JPanel panel = new JPanel();

        //��ʼ��һ������
        Container container = frame.getContentPane();

        //��ʼ��һ����ť
        JButton startAutoGen = new JButton("����һ����ť"); 

        //���ò���
        container.setLayout(new FlowLayout());

        //�Ѱ�ť��ӵ�pannel
        panel.add(textarea);
     
        panel.add(startAutoGen);

        //�Ѳ˵���ӵ��˵���
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        //���ò˵���
        frame.setJMenuBar(menuBar);

        //���ùرշ�ʽ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //��panel��ӵ�����
        container.add(panel);

        //���ô�С
        frame.setSize(600,500);

        //����λ��
        frame.setLocation(100, 100);

        //���ÿɼ���
        frame.setVisible(true);
    }
}