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
import com.eduit.bootcamp.jdbc.UsuariosDAOImpl;
import com.eduit.bootcamp.jdbc.entity.Clientes;
import com.eduit.bootcamp.jdbc.entity.Usuarios;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getContentType() == "application/json") {
			ServletContext cntx = request.getServletContext();
			UsuariosDAOImpl usuariosDAOImpl = (UsuariosDAOImpl) cntx.getAttribute(UsuariosDAOImpl.CTX_NAME);
			try {
				List<Usuarios> usuarios = usuariosDAOImpl.getAll();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				ObjectMapper mapper = new ObjectMapper();
				out.print("{\"data\":"+mapper.writeValueAsString(usuarios)+"}");
				out.flush();
			} catch (Exception e) {
				
			}
		} else {
			request.getServletContext().getRequestDispatcher("/user/list.jsp").forward(request, response);
		}
		
	}
}
