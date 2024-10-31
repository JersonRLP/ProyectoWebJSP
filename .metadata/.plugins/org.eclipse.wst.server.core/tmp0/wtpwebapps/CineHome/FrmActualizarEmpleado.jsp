<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Empleado</title>

 <!-- para bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="Estilos/updempleado.css">

</head>

<body>
<section class="home" id="content">
<div class="container">
<h1>Actualizar Empleado</h1>
<form action="ControladorEmpleado" method="post">
<table align="center" style="text-align: center">
<tr>
<td><input type="text" value='<c:out value="${nomemp}"></c:out>' name="nomemp" class="form-control" placeholder="Nombre del empleado"></td>
</tr>
<tr>
<td><input type="text" value='<c:out value="${distrito}"></c:out>' name="distrito" class="form-control" placeholder="Distrito"></td>
</tr>

<tr>
<td><input type="text" value='<c:out value="${numero}"></c:out>' name="numero" class="form-control" placeholder ="Nro de Celular"></td>
</tr>
<tr>
<td><input type="text" value='<c:out value="${correo}"></c:out>' name="correo" class="form-control" placeholder = "Correo"></td>
</tr>
<tr>
<td><input type="text" value='<c:out value="${cargo}"></c:out>' name="cargo"  class="form-control" placeholder="Cargo"></td>
</tr>
<tr>
<td><input type = "hidden" value='<c:out value="${codigoemp}"></c:out>' name="codigoemp"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Actualizar Empleado" class="btn btn-primary input-margin"></td>
</tr>
<tr>
<td>
<a href="ControladorEmpleado?accion=Listado" class="btn btn-secondary a-margin">Regresar al listado Empleados</a>
</td>
</tr>

</table>
</form>
</div>
</section>

</body>
</html>