<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.eduit.bootcamp.jdbc.domain.Clientes"%>
<%@page import="com.eduit.bootcamp.jdbc.ClientesDAOImpl" %>
<%@page import="java.util.List" %>
<%@page import="com.eduit.bootcamp.BootcampApp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Listado de usuarios</title>
		<link rel="stylesheet" href="../css/styles.css" />
	</head>
	<body>
		<header>
			<h1>Este es el encabezado de mi pagina</h1>
		</header>
		<nav>
			<ul>
				<li><a href="/bootcamp-jsp-html/user/list">listado usuarios</a></li>
				<li><a href="/bootcamp-jsp-html/user/add">agregar usuario</a></li>
			</ul>
		</nav>
		<section id="list-grid" class="grid">
				<ul class="grid-head">
					<li><div class="small">T. Doc</div></li>
					<li><div class="mid">Documento</div></li>
					<li><div class="mid">RazonSocial</div></li>
					<li><div class="large">Correo</div></li>
					<li><div class="mid">FechaNacimiento</div></li>
					<li><div class="mid">Telefono</div></li>
				</ul>
				<% 
				ServletContext cntx = request.getServletContext();
				ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) cntx.getAttribute("clientesDAOImpl");
				List<Clientes> clientes = clientesDAOImpl.getAll();
				int i = 0;
				for (Clientes c : clientes) {
					String stl = ((i % 2) == 0)?"0":"1";
					out.println("<ul class=\"grid-content line-"+stl+"\">");
					out.println("<li><div class=\"small\">"+ c.getTipoDocumento() + "</div></li>");
					out.println("<li><div class=\"mid\">"+ c.getDocumento() + "</div></li>");
					out.println("<li><div class=\"mid\">"+ c.getRazonSocial() + "</div></li>");
					out.println("<li><div class=\"large\">"+ c.getCorreo() + "</div></li>");
					out.println("<li><div class=\"mid\">"+ c.getFechaNacimiento() + "</div></li>");
					out.println("<li><div class=\"mid\">"+ c.getTelefono() + "</div></li>");
					out.println("</ul>");
					i++;
				}
				%>
		</section>
		<footer>
			<div class="marca">Mi brand de marca</div>
			<p>copy 2023</p>
			<a href="#">Contacto</a>
		</footer>
	</body>
</html>
