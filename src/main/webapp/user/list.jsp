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
					<li class="small">T. Doc</li>
					<li class="mid">Documento</li>
					<li class="mid">RazonSocial</li>
					<li class="large">Correo</li>
					<li class="mid">FechaNacimiento</li>
					<li class="mid">Telefono</li>
				</ul>
				<% 
				ServletContext cntx = request.getServletContext();
				ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) cntx.getAttribute("clientesDAOImpl");
				List<Clientes> clientes = clientesDAOImpl.getAll();
				int i = 0;
				for (Clientes c : clientes) {
					String stl = ((i % 2) == 0)?"0":"1";
					out.println("<ul class=\"grid-content line-"+stl+"\">");
					out.println("<li class=\"small\">"+ c.getTipoDocumento() + "</li>");
					out.println("<li class=\"mid\">"+ c.getDocumento() + "</li>");
					out.println("<li class=\"mid\">"+ c.getRazonSocial() + "</li>");
					out.println("<li class=\"large\">"+ c.getCorreo() + "</li>");
					out.println("<li class=\"mid\">"+ c.getFechaNacimiento() + "</li>");
					out.println("<li class=\"mid\">"+ c.getTelefono() + "</li>");
					out.println("</ul>");
					i++;
				}
				%>
		</section>
		<footer>
		<p>pie de pagina</p>
		</footer>
	</body>
</html>
