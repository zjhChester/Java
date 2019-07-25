package webDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AjaxDemo")
public class ServletDemo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Info i1 = new Info("ÕÅ¼ÎºÀ", "ÄÐ", "±à³Ì"); 
		Info i2 = new Info("¸¶ÄÐ", "ÄÐ", "æÎæ½");
		Info i3 = new Info("½¯Ä³", "ÄÐ", "´ò·É»ú");
		Info i4 = new Info("ÐÍP", "ÄÐ", "·£Õ¾");
		List<Info> list = new ArrayList<Info>();
		list.add(i1);
//		list.add(i2);
//		list.add(i3);
//		list.add(i4);
		PrintWriter pw = resp.getWriter();
		for (Info info : list) {
			pw.println("{\"name\":"+"\""+info.name+"\",\"sex\":\""+info.sex+"\",\"interesting\":\""+info.interesting+"\""+"}");
			pw.flush();
		}
		String parameter = req.getParameter("name");
		System.out.println(parameter);
	}
}
class Info{
	public String name;
	public String sex;
	public String interesting;
	public Info(String name, String sex, String interesting) {
		super();
		this.name = name;
		this.sex = sex;
		this.interesting = interesting;
	}
	@Override
	public String toString() {
		return "info [name=" + name + ", sex=" + sex + ", interesting=" + interesting + "]";
	}
	
}