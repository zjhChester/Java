package com.hsy.serverlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class qwe
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ManageDB.ConnDB("jdbc:mysql://localhost/chester", "zjh","abcd35873");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sql="select * from user where username='"+username+"'";
		ManageDB.QueryDB(sql);
			try {
				if(ManageDB.rs.next()){
					if(password.equals(ManageDB.rs.getString(2))){
						request.getRequestDispatcher("main.jsp").forward(request, response);
						return;
					}else{
						request.getRequestDispatcher("error.jsp").forward(request, response);
						return;
					}
				}else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ManageDB.CloseDB();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
