package com.eduit.bootcamp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;

public class UserAddServlet extends HttpServlet {
	
	public UserAddServlet( ) {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) request.getServletContext().getAttribute("clientesDAOImpl");
		request.setAttribute("fullname", fname + " " + lname);
		request.setAttribute("r_status", "OK");
		request.getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);
    }
}
