package test;

import java.io.*;


public class file {
public static void main(String[] args) {
	
	String path = "../test/src/test/test.txt";
//	String path = "../test/src/test/张嘉豪小组.xlsx";
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
	for(int i=0;i<s.length;i++)
	System.out.println("第"+i+"下标为：  "+s[i]);
}
}
