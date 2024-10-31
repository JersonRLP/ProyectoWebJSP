<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- para bootstrap 5 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    <style>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh; /* Esto centra verticalmente en la ventana del navegador */
  }

  form {
    text-align: center;
  }
   .input-margin {
    margin-top: 10px; /* Aplica margen superior a los elementos input */
  }

  .a-margin {
    margin-top: 10px; /* Aplica margen superior a la etiqueta <a> */
  }

  
</style>
</head>
<body>
<section class="home">
<div class="container">
<h1>Actualizar Usuario</h1>
			
			<form action="ControladorUsuario" method="post">
			<table class="table table-dark">
			<tr>
			<td><input type="text" value='<c:out value="${usuario}"></c:out>' name="usuario" class="form-control" placeholder="Nombre del Usuario"></td>
			</tr>
			<tr>
			<td><input type="text" value='<c:out value="${password}"></c:out>' name="password" class="form-control" placeholder="Contraseña"></td>
			</tr>
			<tr>
			<tr>
			<td><input type = "hidden" value='<c:out value="${codigoemp}"></c:out>' name="codigoemp"></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="Actualizar Usuario" class="btn btn-primary input-margin"></td>
			</tr>
			<tr>
			<td>
			<a href="ControladorUsuario?accion=Listado" class="btn btn-secondary a-margin">Regresar al listado Usuario</a>
			</td>
			</tr>
			
			</table>
			</form>
			</div>
			</section>
</body>
</html>