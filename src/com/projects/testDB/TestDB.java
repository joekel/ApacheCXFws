package com.projects.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Setup connection variable 
		String user = "springstudent";
		String pass = "springstudent";
		String localhost = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		// get connection to database
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Conection to the Database " +localhost);
			Class.forName(driver);
			Connection conex = DriverManager.getConnection(localhost, user, pass);
			out.println(" Succes !!! " );
			conex.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

}
