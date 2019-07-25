package test;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JButton jb = new JButton("Ñ¡Ôñ");
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jc = new JFileChooser();
				jc.showDialog(null, null);
				File fi = jc.getSelectedFile();
				jc.setFileSelectionMode(JFileChooser.FILES_ONLY );
				String f = fi.getAbsolutePath();
				System.out.println("save: " + f);
				try {
					FileWriter out = new FileWriter(f);
					out.write("successful!!!");
					out.close();
				} catch (Exception ee) {
				}

			}
		});
		jf.add(jb);
		jf.setSize(500, 100);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}