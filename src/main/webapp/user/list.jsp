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
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="container">
			<header>
				<h1>Este es el encabezado de mi pagina</h1>
			</header>
		</div>
		<div class="container">
			<nav class="mt-5 navbar navbar-dark navbar-expand-lg"> 
				<div class="container-fluid"> 
					<a class="fw-bold navbar-brand text-primary" href="#">Titulo de la app</a> 
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation"> 
						<span class="navbar-toggler-icon"></span> 
					</button>
					<div class="collapse navbar-collapse" id="navbarNavDropdown"> 
						<ul class="navbar-nav">
							<li class="nav-item"><a class="active nav-link" href="/bootcamp-jsp-html/user/list">Usuarios</a></li>
							<li class="nav-item"><a class="active nav-link" href="/bootcamp-jsp-html/category/list">Categorias</a></li>
							<li class="dropdown nav-item"><a class="dropdown-toggle nav-link" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">Desplegable</a> 
								<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink"> 
									<li><a class="dropdown-item" href="#">Item 1</a></li> 
									<li><a class="dropdown-item" href="#">Item 2</a></li> 
								</ul>
							</li>
						</ul>
					</div> 
				</div> 
			</nav>
		</div>
		<div class="container">
			<div class="row">
				 <div class="col-1">T. Doc</div>
				 <div class="col-1">Documento</div>
				 <div class="col-2">RazonSocial</div>
				 <div class="col-4">Correo</div>
				 <div class="col-2">FechaNacimiento</div>
				 <div class="col-2">Telefono</div>
			</div>
					<% 
					ServletContext cntx = request.getServletContext();
					ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) cntx.getAttribute("clientesDAOImpl");
					List<Clientes> clientes = clientesDAOImpl.getAll();
					int i = 0;
					for (Clientes c : clientes) {
						String stl = ((i % 2) == 0)?"0":"1";
						out.println("<div class=\"row\">");
						out.println("<div class=\"col-1\">"+ c.getTipoDocumento() + "</div>");
						out.println("<div class=\"col-1\">"+ c.getDocumento() + "</div>");
						out.println("<div class=\"col-2\">"+ c.getRazonSocial() + "</div>");
						out.println("<div class=\"col-4\">"+ c.getCorreo() + "</div>");
						out.println("<div class=\"col-2\">"+ c.getFechaNacimiento() + "</div>");
						out.println("<div class=\"col-2\">"+ c.getTelefono() + "</div>");
						out.println("</div>");
						i++;
					}
					%>
		</div>
		<div class="container">
			<footer>
				<div class="marca">Mi brand de marca</div>
				<p>copy 2023</p>
				<a href="#">Contacto</a>
			</footer>
		</div>
	</body>
</html>
