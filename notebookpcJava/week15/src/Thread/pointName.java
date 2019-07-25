package Thread;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class pointName extends JFrame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1261385005343977131L;
	JFrame jFrame;
	JTextField jtx1, jtx2;
	JButton btn1, btn2;
	JLabel jbLabel;

	public pointName() {
		// TODO Auto-generated constructor stub
		jFrame = new JFrame();
		jtx1 = new JTextField(10);
		jtx2 = new JTextField(10);
		// jtx1.setEnabled(false);
		// jtx2.setEnabled(false);
		btn1 = new JButton("抽              取");
		btn2 = new JButton("选定文件");
		jbLabel = new JLabel("抽取池");
		jFrame.setSize(600, 300);
		jFrame.setLayout(null);
		btn2.setBounds(20, 20, 120, 40);
		jtx1.setBounds(20, 70, 542, 100);
		jtx2.setBounds(20, 70, 542, 100);
		btn1.setBounds(60, 180, 470, 80);
		jFrame.add(btn2);
		jFrame.add(jbLabel);
		jFrame.add(jtx1);
		jFrame.add(jtx2);
		jtx2.setVisible(false);
		jFrame.setTitle("豪哥的点名器");
		jFrame.add(btn1);
		jbLabel.setFont(new Font("楷体", Font.BOLD, 40));
		jtx1.setFont(new Font("", Font.BOLD, 60));
		jtx1.setForeground(Color.BLUE);

		jtx2.setForeground(Color.BLUE);
		jtx2.setFont(new Font("", Font.BOLD, 60));

		// jtx2.setFont(new Font("", Font.BOLD, 45));
		btn1.setFont(new Font("", Font.BOLD, 40));
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.addActionListener(this);
		btn2.addActionListener(this);

	}

	static pointName f;
	static Thread t;

	public static void main(String[] args) {
		f = new pointName();
		t = new Thread(f);

	}

	int i = 0;
	int choose = 1;
	String path = "";

	@Override
	public void run() {

		while (true) {
			File f = new File(path);
			byte b[] = new byte[1024];
			int count = 0;
			InputStream in = null;
			try {
				in = new FileInputStream(f);
				count = in.read(b);
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String str = new String(b, 0, count);
			String s[] = str.split("    |   |  | |\n");

			i = (int) (Math.random() * (s.length - 1)+0);
			jtx1.setText("          " + s[i]);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "出错", "提示	", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btn1) {
			if (jtx1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请添加文件", "抽取失败", JOptionPane.ERROR_MESSAGE);
			} else {
				choose = 1;

				if (jtx1.isVisible()) {
					btn1.setText("抽              取");
					jtx1.setVisible(false);
					jtx2.setVisible(true);
					jtx2.setText(jtx1.getText());
					// jtx2.setText(" 抽取到： "+jtx1.getText());
					// JOptionPane.showMessageDialog(null, "抽取到：" + jtx1.getText() + " " +
					// "恭喜获得一次答题的机会", "提示",
					// JOptionPane.PLAIN_MESSAGE);
					//// }
				} else {
					btn1.setText("暂              停");
					jtx1.setVisible(true);
					jtx2.setVisible(false);
				}
			}
		}
		if (e.getSource() == btn2) {
			try {
				JFileChooser jc = new JFileChooser();
				jc.showDialog(null, null);
				File fi = jc.getSelectedFile();
				jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				String f = fi.getAbsolutePath();
				System.out.println(f);
				path = f;
				btn1.setText("暂              停");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "请添加文件正确的txt文件", "添加文件提示", JOptionPane.ERROR_MESSAGE);
			}

			t.start();
		}
	}
}
