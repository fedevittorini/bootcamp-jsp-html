<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.eduit.bootcamp.jdbc.entity.Clientes"%>
<%@page import="com.eduit.bootcamp.jdbc.ClientesDAOImpl" %>
<%@page import="java.util.List" %>
<%@page import="com.eduit.bootcamp.BootcampApp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Alta de clientes</title>
		<link rel="stylesheet" href="../css/styles.css" />
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	</head>
	<body>
		<%@include file="../modules/header.jsp" %>
		<%@include file="../modules/menu.jsp" %>
		<div class="container">
			<div class="m-2 pt-2">
			<form class="needs-validation" action="add" method="POST" novalidate>
				<div class="row">
					<div class="col-1">				
					  <label for="t-doc" class="col-form-label">T. Documento:</label>
					</div>
					<div class="col-2">
						<select class="form-select" id="t-doc" name="t-doc" >
							<option value="0" selected>-</option>
							<option value="DNI">DNI</option>
							<option value="CI">CI</option>
							<option value="LE">LE</option>
							<option value="PASAPORTE">PASAPORTE</option>
						</select>
					</div>
					<div class="col-3">				
					  <label for="doc" class="col-form-label">Documento:</label>
					</div>
					<div class="col-6">		
					  <input class="form-control" required type="number" id="doc" name="doc" placeholder="Ingrese su Nro de documento." />
					  <div class="valid-feedback">
					  El Doc esta bien!
				      </div>
					  <div class="invalid-feedback">
					  Por favor ingrese el numero de documento.
				      </div>
					</div>
				</div>
				<div class="row">
					<div class="col-4">	
					  <label for="r-social" class="col-form-label">Razon social:</label>
					</div>
					<div class="col-8">
					  <input class="form-control" required type="text" id="r-social" name="r-social" value="Doe" placeholder="ingrese aqui su razon social"/>
				  </div>
				</div>
				<div class="row">
					<div class="col-4">	
					  <label for="correo" class="col-form-label">Correo:</label>
					</div>
					<div class="col-8">
					  <input class="form-control" required type="email" id="correo" name="correo" placeholder="ingrese aqui su correo" />
				  </div>
				</div>
				<div class="row">
					<div class="col-4">	
					  <label for="f-nac" class="col-form-label">Fecha:</label>
					</div>
					<div class="col-8">
					  <input class="form-control" required type="date" id="f-nac" name="f-nac" />
				  </div>
				</div>
				<div class="row">
					<div class="col-4">
					  <label for="telefono" class="col-form-label">Telefono:</label>
					</div>
					<div class="col-8">
					  <input class="form-control" required type="text" id="telefono" name="telefono" placeholder="ingrese aqui su telefono" />
				  </div>
				</div>
				<div class="row">
					<div class="col-auto">	
					  <button class="form-control btn-primary" type="submit">Enviar</button>
				  </div>
				</div>
			</form>
			</div>
		</div>
		<%@include file="../modules/footer.jsp" %>
		<script type="text/javascript">
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(() => {
		  'use strict'

		  // Fetch all the forms we want to apply custom Bootstrap validation styles to
		  const forms = document.querySelectorAll('.needs-validation')

		  // Loop over them and prevent submission
		  Array.from(forms).forEach(form => {
		    form.addEventListener('submit', event => {
		      if (!form.checkValidity()) {
		        event.preventDefault()
		        event.stopPropagation()
		      }

		      form.classList.add('was-validated')
		    }, false)
		  })
		})()
		</script>
	</body>
</html>

