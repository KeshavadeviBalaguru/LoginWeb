package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetContextPropertiesRule;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
	    // response.setContentType("text/html");
		response.setContentType("text/html");

		String un=request.getParameter("uname");
		String up=request.getParameter("upass");
		RequestDispatcher rs;
		if(un.equalsIgnoreCase("admin") && (up.equals("admin123")))
		{
			rs=request.getRequestDispatcher("ValidServlet");
			rs.forward(request, response);
		}
		else
		{
			out.println("Invalid UserName and Password Try Again!");
			rs=request.getRequestDispatcher("login.html");
			rs.include(request, response);
			
		}
	}

}
