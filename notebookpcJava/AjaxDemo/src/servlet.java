import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxDemo")
public class servlet extends HttpServlet {
	private Socket s;
	private BufferedReader br;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// ��ȡǰ�˴��������
		String p = req.getParameter("msg");
		System.out.println(req.getLocalAddr());
		 String reMsg = client();
		 System.out.println(reMsg);
		 //��ȡ���������������
		 PrintWriter pw = resp.getWriter();
		 //��������ǰ�˷�����Ϣ
		 pw.println("�������յ�������:\t"+reMsg);
	}

	public String client() throws IOException {
		s = new Socket("127.0.0.1", 9999);
		br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
		readMsg rm = new readMsg();
		rm.start();
		return rm.getMsg();
	}
	String msg= "";
	class readMsg extends Thread{
		String str;
		public void run() {
			while(true) {
				try {
					 str = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		private String getMsg() {
			return msg;
		}
		
	}
}
