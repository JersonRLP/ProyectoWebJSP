<%@ include file="MenuPrincipal.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario Registrar Usuario</title>
<!-- para bootstrap 5 -->
		<!-- css Datatable -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/buttons/2.4.2/css/buttons.bootstrap5.min.css" rel="stylesheet">
	
	
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/2.4.2/js/dataTables.buttons.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.html5.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.print.min.js"></script>
	<script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>

	<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.bootstrap5.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.colVis.min.js"></script>
		<!--ICONS DE BOOTSTRAP5 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	<script src="js/login.js"></script>
	

</head>
<body>
<section class="home">
    <div class="container">
        <div class="mt-5 row justify-content-center"> <!-- Agregamos la clase mt-4 para margen superior -->
            <div class="col-md-4">
                <h2 class="text-center">Registrar Usuario</h2>
                <form action="ControladorUsuario" method="post">
                 <div class="mb-3">
                        <label for="username" class="form-label">Codigo Empleado</label>
                    <select name="codigoemp" class="form-select" id="codigoemp" required>
    <option value="zz">Seleccione Empleado</option>
    <c:forEach var="emp" items="${ListadoEmpleados}">
        <option value='<c:out value="${emp.codigoemp}"></c:out>'>
            <c:out value="${emp.nomemp}"></c:out>
        </option>
    </c:forEach>
</select>


                    </div>
                    <div class= "mt-2" style="width :200px;">
     				 <input type="text" class="form-control" name ="idemp" readonly ">
    				  </div>
                    	<div class="mb-3">
                        <label for="username" class="form-label">Nombre de usuario</label>
                        <input type="text" class="form-control" name="usuario" placeholder="Ingrese su nombre de usuario">
                    </div>
                    <div class="mb-3">
                        <label for "password" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" name="password" placeholder="Ingrese su contraseña">
                    </div>
                    <div class="text-center	">
                    <button type="submit" class="btn btn-primary btn-block">Registrar Usuario</button>
                    <a href="ControladorEmpleado?accion=Listado" class="btn btn-info">Listado Empleados</a>
               		</div> 
                </form>
            </div>
        </div>
    </div>
    <br>
	<div class="container mt-3 div-buscar">

	<form class="form-inline">
        <label for="codigoEmpleado">Buscar Usuario:</label>
        <input type="text" class="form-control" name="txtbuscar" style="width: 200px;" />
        <input type="submit" name="accion" value="Buscar" class="btn btn-success" />
    </form>
	</div>
	<br>
    <div class="container">
	    <table id="table" class="table table-danger table-hover table-striped-columns table-sm">
		<!--   <tr>
  		<td colspan="1">Total de registros: ${listadoUsuario.size()}</td>
		</tr> -->
		<thead>
		<tr >
		<th scope="col">Codigo de Empleado</th>
		<th scope="col">Nombre de Usuario</th>
		<th scope="col" >Contraseña</th>
		<th scope="col" >MOSTRAR</th>
		<th scope="col" >Eliminar</th>
		<th scope="col" >Editar</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="usu" items="${listadoUsuario}">
		<tr>
		<td><c:out value="${usu.codigoemp}"></c:out></td>
		<td><c:out value="${usu.usuario}"></c:out></td>
		<td>
        <span class="password">*********</span>
        <span class="actual-password" style="display: none;"><c:out value="${usu.password}"></c:out></span>
        </td>
        <td>
        <button class="show-password-button btn btn-danger mostrar" >Mostrar</button>     
     	</td>
		<td><a href="ControladorUsuario?accion=Eliminar&codigoemp=${usu.codigoemp}" id="eliminar">
		<img src="imagenes/eliminar.png" width="30" height="30px">
		<input type="hidden" id="codigoemp" value="${emp.codigoemp}">
		</a>
		</td>
		<td>
		<a href="ControladorUsuario?accion=Modificar&codigoemp=${usu.codigoemp}">
		<img src="imagenes/actualizar.png" width="30" height="30px">
		</a>	
		</td>
	
		</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
	</section>
<script src="js/logindatatables.js"></script>
<script src="js/login2.js"></script>
</body>
</html>