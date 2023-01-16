<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
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
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Listado de clientes</title>
		<link rel="stylesheet" href="../css/styles.css" />
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	</head>
	<body>
		<%@include file="../modules/header.jsp" %>
		<%@include file="../modules/menu.jsp" %>
		<div class="container">
			<div class="row">
				<div class="col-m-2 col-3">
					<!-- ACA VA EL MENU -->
					<ul>
						<li><a href="/bootcamp-jsp-html/user/add">Alta</a></li>
						<li><a href="/bootcamp-jsp-html/user/list">Listado</a></li>
					</ul>
				</div>
				<div class="col-m-10 col-9">
					<!-- ACA VA EL CONTENIDO -->
					<div class="row">
						<div class="col">
							<table class="table-responsive table-striped">
								<caption class="caption-top">Listado de clientes</caption>
								<thead>
								   <tr>
								     <th scope="col">T. Doc</th>
								     <th scope="col">Document</th>
								     <th scope="col">RazonSocial</th>
								     <th scope="col">Correo</th>
								     <th scope="col">FechaNacimiento</th>
								     <th scope="col">Telefono</th>
								     <th scope="col">E</th>
								     <th scope="col">D</th>
								   </tr>
								</thead>
								<tbody>
								<% 
								ServletContext cntx = request.getServletContext();
								ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) cntx.getAttribute("clientesDAOImpl");
								List<Clientes> clientes = clientesDAOImpl.getAll();
								for (Clientes c : clientes) {
									out.println("<tr>");
									out.println("<td>"+ c.getTipoDocumento() + "</td>");
									out.println("<td>"+ c.getDocumento() + "</td>");
									out.println("<td>"+ c.getRazonSocial() + "</td>");
									out.println("<td>"+ c.getCorreo() + "</td>");
									out.println("<td>"+ c.getFechaNacimiento() + "</ditdv>");
									out.println("<td>"+ c.getTelefono() + "</td>");
									out.println("<td><a href=\"/bootcamp-jsp-html/user/edit/" + c.getTipoDocumento() + "-" + c.getDocumento() + "\">Edit</a></td>");
									out.println("<td><a href=\"/bootcamp-jsp-html/user/delete/" + c.getTipoDocumento() + "-" + c.getDocumento() + "\">Delete</a></td>");
									out.println("</tr>");
								}
								%>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<nav aria-label="...">
							  <ul class="pagination  justify-content-center">
							    <li class="page-item disabled">
							      <a class="page-link">Previous</a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">1</a></li>
							    <li class="page-item active" aria-current="page">
							      <a class="page-link" href="#">2</a>
							    </li>
							    <li class="page-item"><a class="page-link" href="#">3</a></li>
							    <li class="page-item">
							      <a class="page-link" href="#">Next</a>
							    </li>
							  </ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../modules/footer.jsp" %>
	</body>
</html>
