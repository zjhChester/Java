import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Server {
	private ServerSocket ss;
	private List<Socket> list;
	
	public Server() {
		try {
			ss = new ServerSocket(9999);
			list = new ArrayList<Socket>();
			System.out.println("Server is Running! port ="+ss.getLocalPort());
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void init() {
		while(true) {
			Socket s;
			try {
				s = ss.accept();
				System.out.println(s.getLocalSocketAddress()+"\t\tenter this chatRoom!");
				list.add(s);
				new send(s).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class send extends Thread {
		private Socket s;
		private BufferedReader br;

		public send(Socket s) {
			this.s = s;
			try {
				br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			while (true) {
				try {
					String str = br.readLine();
					if(str.indexOf("%EXIT%")==0)
					{
						s.close();
						sendMsg(s.getLocalSocketAddress()+"exit this ChatRoom");
					}
					sendMsg(str);
					
				} catch (IOException e) {
					e.printStackTrace();
					try {
						s.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		private void sendMsg(String msg) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			System.out.println(s.getLocalAddress()+"£º"+msg+"\t"+sdf.format(new Date()));
			try {
				for (Socket s : list) {
					PrintWriter  pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
					pw.println(msg+"\t\t"+sdf.format(new Date()));
					pw.flush();
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
