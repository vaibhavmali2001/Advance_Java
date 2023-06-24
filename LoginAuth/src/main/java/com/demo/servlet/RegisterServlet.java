package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int uid=Integer.parseInt (req.getParameter("id"));
		String name=req.getParameter("nm");
		String addr=req.getParameter("add");
		String pass=req.getParameter("pass");
		String gender=req.getParameter("gend");
		String [] skills =req.getParameterValues("1");
		String city=req.getParameter("city");
		String uname=req.getParameter("name");
		LoginService ls=new LoginServiceImpl();
	 RegisterUser ru =new RegisterUser(uid,name,addr,gender,skills,city,uname);  
	 MyUser mu=new MyUser(uname,pass,"user");
	
	 ls.registerUser(ru,mu);
	 
	 RequestDispatcher rd=  req.getRequestDispatcher("Login.html");
	 rd.forward(req, res);
	 
	
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doPost(req,res);
	}

}
