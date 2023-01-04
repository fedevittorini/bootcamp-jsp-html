package com.eduit.bootcamp.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;
import com.eduit.bootcamp.jdbc.domain.Clientes;

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
		Clientes c = new Clientes("DNI", "77123456", "A", "tttttt", new Date(), "a");
		try {
			if (clientesDAOImpl.save(c) != null) {
				request.setAttribute("fullname", fname + " " + lname);
				request.setAttribute("r_status", "OK");
			} else {
				request.setAttribute("r_status", "ERROR");
				request.setAttribute("r_msg", "No se pudo grabar");
			}
		} catch (Exception e) {
			request.setAttribute("r_status", "ERROR");
			request.setAttribute("r_msg", e.getMessage());
		}
		request.getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);
    }
}
