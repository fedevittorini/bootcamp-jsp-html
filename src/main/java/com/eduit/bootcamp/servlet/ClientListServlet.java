package com.eduit.bootcamp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduit.bootcamp.jdbc.ClientesDAOImpl;
import com.eduit.bootcamp.jdbc.entity.Clientes;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("application/json".equals(request.getHeader("Accept"))) {
			ServletContext cntx = request.getServletContext();
			ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) cntx.getAttribute(ClientesDAOImpl.CTX_NAME);
			try {
				List<Clientes> clientes = clientesDAOImpl.getAll();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				out.print("{\"data\":"+mapper.writeValueAsString(clientes)+"}");
				out.flush();
			} catch (Exception e) {
				
			}
		} else {
			request.getServletContext().getRequestDispatcher("/client/list.jsp").forward(request, response);
		}
		
	}
}
