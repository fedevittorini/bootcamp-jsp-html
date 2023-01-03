<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.eduit.bootcamp.jdbc.domain.Clientes"%>
<%@page import="com.eduit.bootcamp.jdbc.ClientesDAOImpl" %>
<%@page import="java.util.List" %>
<%@page import="com.eduit.bootcamp.BootcampApp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de usuarios</title>
</head>
<body>
<% 
out.println("Test");
ServletContext cntx = request.getServletContext();
ClientesDAOImpl clientesDAOImpl = (ClientesDAOImpl) cntx.getAttribute("clientesDAOImpl");
List<Clientes> clientes = clientesDAOImpl.getAll();
for (Clientes c : clientes) {
	out.println(c);
}
%>
</body>
</html>
</body>
</html>