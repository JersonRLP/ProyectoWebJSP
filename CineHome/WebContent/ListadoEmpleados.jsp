<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--js Datatable -->
<!--ICONS DE BOOTSTRAP5 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

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
	
	
<!-- para insertar alertas con diseño -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    
    <script>
 
 $(document).ready(function(){
	 //cuando hacemos el evento click....
	 $("tr #eliminar").click(function(y){
		 y.preventDefault();
		//evita el reinicio de la pagina
		var cod=$(this).parent().find("#codigoemp").val();
		//aplicamos modelo de alerta...
		Swal.fire({

			 title: 'Eliminar Registro',

			 text: "¿Usted Desea Eliminar el Registro?",

			 icon: 'warning',

			 showCancelButton: true,

			 confirmButtonColor: '#3085d6',

			 cancelButtonColor: '#d33',

			 confirmButtonText: 'SI,ELIMINAR REGISTRO!',

			 cancelButtonText:'¿Desea Cancelar?'

			}).then((result) => {

			 if (result.isConfirmed) {//aplicamos la condicion

			  //invocamos a la funcion...

			  eliminarproducto(cod);

			  //reiniciamos el navegador...

			  setTimeout(function(){

			  	parent.location="ControladorEmpleado?accion=Listado"

			  },2000)

			 } //fin de la condicion...
	 	})
	 
	 })
	 
	 //creamos una funcion que permita capturar el codigo 
	 function eliminarproducto(cod){
		 //recibimos el codigo
		 var codigo=cod;
		 //almacenamos la url en una variable..
		 var url="ControladorEmpleado?accion=Eliminar&codigoemp="+codigo;
		 //aplicamos AJAX..
		 $.ajax({
			 url:url,
			 async:true,
			 success:function(r){
				 //vemos la respuesta...
				 console.log(r);
			 }
			 
		 })//fin de ajax
		 
	 }//fin de la funcion eliminar
 })
 </script>    
</head>

<body>


 <section class="home" id="content">
 <h1 align="center">Listado de Empleados</h1>
	<div class="container mt-3 div-buscar">


	<a id="nuevoEmpleado" href="ControladorEmpleado?accion=NuevoEmp" class="btn btn-warning">Nuevo Empleado</a>
	<a href="ControladorUsuario?accion=Listado" class="btn btn-dark">Crear Login Empleado</a>
    <form class="form mt-3"  style="Display:flex;">
        <label for="codigoEmpleado">Buscar Empleado </label>
        <input type="text" class="form-control" name="txtbuscar" style="width: 200px;" />
        <input type="submit" name="accion" value="Buscar" class="btn btn-outline-success" />
    </form>
 </div>



<br>
<div class="container">

<table id="table" class="table table-info table-hover table-striped-columns table-sm">
<!--  <tr>
<td colspan="1">Total de registros: ${listadoEmpleado.size()}</td>
</tr>-->
<thead class="table-dark">
<tr>
<th>Codigo de Empleado</th>
<th>Nombre</th>
<th>Distrito</th>
<th>Celular</th>
<th>Correo</th>
<th>Cargo</th>
<th>Elminar</th>
<th>Editar</th>
</tr>
</thead>
<tbody>
<c:forEach var="emp" items="${listadoEmpleado}">
<tr>
<td><c:out value="${emp.codigoemp}"></c:out></td>
<td><c:out value="${emp.nomemp}"></c:out></td>
<td><c:out value="${emp.distrito}"></c:out></td>
<td><c:out value="${emp.numero}"></c:out></td>
<td><c:out value="${emp.correo}"></c:out></td>
<td><c:out value="${emp.cargo}"></c:out> </td>

<td>
<a href="ControladorEmpleado?accion=Eliminar&codigoemp=${emp.codigoemp}" id="eliminar">
<img src="imagenes/eliminar.png" width="30" height="30px">
<input type="hidden" id="codigoemp" value="${emp.codigoemp}">
</a>
</td>

<td>
<a href="ControladorEmpleado?accion=Modificar&codigoemp=${emp.codigoemp}">
<img src="imagenes/actualizar.png" width="30" height="30px">
</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</section>
</body>
		
	<script>
		new DataTable('#table', {
			    language: {
                "lengthMenu": "Mostrar _MENU_ registros",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando...",
            },
            searching: false,	
 			dom: 'Bfrtilp',
            
            responsive: "true",
            lengthMenu: [
                [5, 10,25, -1],
                [5, 10,25, 'All']
            ],
			
			
			buttons: [	

			

			
			 
			 
				{
				extend:    'excelHtml5',
				text:      '<i class="bi bi-file-earmark-excel"></i> ',
				titleAttr: 'Exportar a Excel',
				className: 'btn btn-success'
			},
			  {
				extend:    'pdfHtml5',
				text:      '<i class="bi bi-filetype-pdf"></i>',
				titleAttr: 'Exportar a PDF',
				className: 'btn btn-danger'
			},
			  	
			  {
                extend: 'print',
                text:      '<i class="bi bi-printer"></i>',
                titleAttr: 'Imprimir',
                className: 'btn btn-info',
                exportOptions: {
                    columns: ':visible'
                }
             },
                
            ],
        
    } );
	
	</script>
	
</html>