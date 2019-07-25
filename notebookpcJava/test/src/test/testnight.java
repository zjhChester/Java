package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class testnight {
	public static void main(String[] args) throws Throwable {
		while(true)
		Server();
	}
	
	
	public static void Server() throws Throwable {
		ServerSocket ss  = new ServerSocket(8000);
		Socket s =  ss.accept();
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
