package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		client1();
	}
	
	public static void client1() throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1",8000);
		BufferedReader br;
		PrintWriter pw;
		while (s!=null) {
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
			String str = "";
			while((str = br.readLine())!=null)
			{
				System.out.println(str);
			}
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			pw.println("服务器收到信息 ");
			pw.flush();
		}
	}
}
