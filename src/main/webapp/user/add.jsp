<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Agregar usuario</title>
	</head>
	<body>
	<% 
	if (request.getAttribute("r_status") != null) { 
	  	if ((String) request.getAttribute("r_status") == "OK") {
			out.println("<h1>INSERTED</h1>");
	  	}
	  	if ((String) request.getAttribute("r_status") == "ERROR") {
			out.println("<h1>"+(String) request.getAttribute("r_msg")+"</h1>");
	  	}
	}
	%>
		<h2>Agregar usuario</h2>
		<form action="add" method="POST">
		  <label for="fname">Nombre:</label><br>
		  <input type="text" id="fname" name="fname" value="John"><br>
		  <label for="lname">Apellido:</label><br>
		  <input type="text" id="lname" name="lname" value="Doe"><br><br>
		  <input type="submit" value="Submit">
		</form> 
	</body>
</html>
