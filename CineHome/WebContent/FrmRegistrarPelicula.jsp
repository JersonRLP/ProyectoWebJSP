<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- para bootstrap 5 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>

</head>

<body>

<section class="home" id="content">


<div class="container col-md-4">
<form action="ControladorPelicula" method="post" enctype="multipart/form-data">
	<h1>Registrar Nueva Pelicula</h1>
	<hr>
<br>
	<div class="text-center mb-3">
	<label>Nombres:</label>
	<input type="text" name="nompelicula">
	</div> 	
	<div class="text-center mb-3">	
	<input type="file" name="fotopelicula" id="file">
	<div class="text-center	">
	<img src="http://localhost/files/imagenpeli.png" alt="avatar" id="img" width = "130px">
	</div>
	</div>
	<br>
	<div class="text-center">
	<input type="submit" name="action" value="Grabar">
	<input type="submit" name="action" value="Regresar">
	</div>	
	<br>
	<div class="text-center	">
	<a href="ControladorPelicula?action=Listar" class="btn btn-secondary">Regresar al listado Peliculas</a>
	</div>
</form>
</div>
</section>

<script src="js/previewimg.js"></script>
</body>
</html>