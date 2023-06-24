package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConvertServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String doll=req.getParameter("doll");
		String inr=req.getParameter("inr");
	
		if(doll.equals(""))
		{
			int result=(Integer.parseInt(inr)/82);
			out.println("<h1>Dollar:"+result+"</h1>");
		}
		else
		{
			int result=Integer.parseInt(doll)*82;
			System.out.println(result);
			out.println("<h1>Inr:"+result+"</h1>");
		}
	}
}
