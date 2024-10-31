<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Empleado</title>
 <!-- para bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="Estilos/registroemp.css">

</head>
<body>
<section class="home">
<di class="container">
<h1>Grabar Empleado</h1>
<form action="ControladorEmpleado" method="post">
<table align="center" style="text-align: center">
<tr>
<td><input type="text" name="codigoemp" id="codigoemp" class="form-control" value="${newcodigo}" readonly requerid></td>
</tr>
<tr>
<td><input type="text"  name="nomemp" class="form-control" placeholder="Nombre del empleado"></td>
</tr>
<tr>
    <td>
        <select name="distrito" class="form-control">
            <option value="">Selecciona un distrito</option>
            <option value="Surco">Surco</option>
            <option value="La Molina">La Molina</option>
            <option value="San Juan de Lurigancho">San Juan de Lurigancho</option>
             <option value="Independencia">Independencia</option>
         <option value="Comas">Comas</option>	
         <option value="El Agustino">El Agustino</option>	
         <option value="MiraFlores">MiraFlores</option>	
        </select>
    </td>
</tr>

<tr>
<td><input type="text" name="numero" class="form-control" placeholder ="Nro de Celular"></td>
</tr>
<tr>
<td><input type="text" name="correo" class="form-control" placeholder = "Correo"></td>
</tr>
<tr>
<td>
<select name="cargo" class="form-control">
            <option value="">Selecciona un Cargo</option>
            <option value="Cajero">Cajero</option>
            <option value="Administrador">Administrador</option>

</td>
</tr>
<div>
<tr style="Display:flex;justify-content: space-between;">
<td colspan="2" style="margin-left: 20px;">
<input type="submit" value="Enviar Datos" class="btn btn-primary input-margin"></td>
<td style="margin-right: 20px;">
<a href="ControladorEmpleado?accion=NuevoEmp" class="btn btn-success input-margin">Nuevo</a>
</td>

</tr>

<tr>
<td>
<a href="ControladorEmpleado?accion=Listado" class="btn btn-secondary a-margin">Regresar al listado Empleados</a>
</td>
</tr>

</table>
</form>
</di>
</section>
</body>
</html>

