package week7_mon_TestDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IODemo {
	public static void main(String[] args) throws IOException {
		
		File file = new File("IODemo.txt");
		if(!file.exists())
			file.createNewFile();
		
		FileInputStream fos = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fos, "utf8"));
		String str = "";
		int len;
//		byte b []= new byte[2];
		while((len=br.read())!=-1)
		{
			str+=(char)len;
		}
		System.out.println(str);

		File file1 = new File("CopyDemo.txt");
		if(!file1.exists())
			file1.createNewFile();
		PrintWriter pW = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file1),"utf8"));
		pW.print(str);
		pW.flush();
		pW.close();
		br.close();
		fos.close();
	}
}
