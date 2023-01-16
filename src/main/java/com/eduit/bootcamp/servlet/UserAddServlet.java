package com.eduit.bootcamp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;
import com.eduit.bootcamp.jdbc.domain.Clientes;

public class UserAddServlet extends HttpServlet {
	
	private final SimpleDateFormat formater =  new SimpleDateFormat("yyyy-mm-dd");
	
	public UserAddServlet( ) {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/user/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tdoc = request.getParameter("t-doc");
		String doc = request.getParameter("doc");
		String correo = request.getParameter("correo");
		String fnac = request.getParameter("f-nac");
		String tel = request.getParameter("telefono");
		String rsocial = request.getParameter("r-social");
		Date fechaNac = null;
		try {
			fechaNac = this.formater.parse(fnac);
		} catch (ParseException e) {
			request.setAttribute("r_status", "ERROR");
			request.setAttribute("r_msg", e.getMessage());
			request.getServletContext().getRequestDispatcher("/user/list.jsp").forward(request, response);
			return;
		}
		
		ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) request.getServletContext().getAttribute("clientesDAOImpl");
		Clientes c = new Clientes(tdoc, doc, rsocial, correo, fechaNac, tel);
		try {
			if (clientesDAOImpl.save(c) != null) {
				request.setAttribute("r_status", "OK");
			} else {
				request.setAttribute("r_status", "ERROR");
				request.setAttribute("r_msg", "No se pudo grabar");
			}
		} catch (Exception e) {
			request.setAttribute("r_status", "ERROR");
			request.setAttribute("r_msg", e.getMessage());
		}
		request.getServletContext().getRequestDispatcher("/user/list.jsp").forward(request, response);
    }
}
