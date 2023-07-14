
package com.javaproject.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("name");
		String lname=request.getParameter("name2");
		String uname=request.getParameter("name3");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		String mobile=request.getParameter("contact");
		RequestDispatcher dispatcher =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/registration?useSSL=false","root","12345");
			PreparedStatement ps=con.prepareStatement("insert into employee(fname,lname,uname,password,email,mobile) values(?,?,?,?,?,?)");
			 ps.setString(1, fname);
			 ps.setString(2, lname);
			 ps.setString(3, uname);
			 ps.setString(4, password);
			 ps.setString(5,email);
			 ps.setString(6, mobile);
		
			 int rowcount =ps.executeUpdate();
			 dispatcher =request.getRequestDispatcher("registration.jsp");
			 if(rowcount >0) {
				 request.setAttribute("status", "success");
			 }else {
				 request.setAttribute("status", "failed");
			 }
			 dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
	}


	}

