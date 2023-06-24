package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConvertServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Doll=request.getParameter("doll");
		String Inr=request.getParameter("inr");
		out.println("<form action=\"convert\">");
		if(Doll.equals("")) {
			int result=Integer.parseInt(Inr)/82;
		    out.println("Dollar:<input type=\"text\" name=\"doll\" value='"+result+"' id=\"i1\">");	
			out.println("Inr:<input type=\"text\" name=\"inr\"  value='"+Inr+"'id=\"i2\">");
		}else 
		{
			int result=Integer.parseInt(Doll)*82;
		    out.println("Dollar:<input type=\"text\" name=\"doll\" value='"+Doll+"' id=\"i1\">");	
			out.println("Inr:<input type=\"text\" name=\"inr\"  value='"+result+"'id=\"i2\">");

		}
		out.print("  <input type=\"submit\" name=\"btn\" value=\"convert\"></input> ");
		out.println("</form>");
				
	}

}
