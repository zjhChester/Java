import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket s;
	BufferedReader	br ;

	PrintWriter pw;
	Client(String str) throws  IOException{
		s = new Socket("127.0.0.1", 9999);
		while(s!=null) {
			br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
			pw.println(str);
			pw.flush();
		}
		new ReadMsg().start();
	}
	class ReadMsg extends Thread{
		public void run() {
			while(true){
				try {
					String str = br.readLine();
					System.out.println(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			new Client(new Scanner(System.in).nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
