package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.service.*;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		LoginService ls = new LoginServiceImpl();
		MyUser u = ls.loginAuth(uname,pass);

		if(u==null) {
			out.println("<h3>invalid credentials</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}else {
			out.println("<h3>Successful login</h3>");
			RequestDispatcher rd= req.getRequestDispatcher("product");
			rd.forward(req, res);
			
		}
	}
}
