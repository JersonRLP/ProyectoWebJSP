<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="Estilos/Estilos.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" ></script>

</head>
<body>
<div class="contenedor" >

<h2 class="color">Login</h2>

<table class="table">

<form action="ControladorLogueo" class="form-control" >
<tr><td><input class="control" type="text" name="usuario" class="form-control" placeholder="usuario"></td></tr>
<tr><td><input class="control" type="password" name="password" class="form-control" placeholder="password"></td></tr>
<tr><td><input  type="submit" value="Acceder" class="btn btn-primary"></td></tr>
</form>
</table>

</div>


</body>
</html>