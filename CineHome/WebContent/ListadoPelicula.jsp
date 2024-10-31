<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Peliculas</title>
<!--js Datatable -->
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
	
	<!-- css Datatable -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
	<link href="https://cdn.datatables.net/buttons/2.4.2/css/buttons.bootstrap5.min.css" rel="stylesheet">
	
	<!--ICONS DE BOOTSTRAP5 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>





</head>

	
<style>
    .table th, .table td {
        text-align: center;
        vertical-align: middle;
    }

    .center-table {
        margin-left: auto;
        margin-right: auto;
    }
    /* Estilo para los botones de DataTables */
.dataTables_wrapper .dt-buttons {
    margin-left: 300px; /* Ajusta este valor según sea necesario */
}

/* Estilo para el cuadro de búsqueda de DataTables */
.dataTables_wrapper .dataTables_filter input {
    margin-right: 350px; /* Ajusta este valor según sea necesario */
}
img {
margin :auto;
cursor: pointer;
transition:1s;
}
 img:hover {
 transform: scale(1.1);
 transition:1s;
 }
 
 
</style>
<body>
 
  <section class="home">
	<div class="container">
	<h1 style=" margin-left:295px;">Listado de Películas</h1>
	
	
<!-- 	<form class="form-inline mb-3" style=" margin-left:285px;">
        <label for="codigoPelicula">Buscar Pelicula</label>
        <div style="Display:flex;">
        <input type="text" class="form-control" name="txtbuscar" style="width: 200px;" />
        <input type="submit" name="action" value="Buscar" class="btn btn-success" />
        </div>
       
    </form> 
     <span class="mt-5" style=" margin-left:285px;">Total de registros: ${ListadoPeliculas.size()}</span> -->
     
    
  

    <br>
	<table id="table" class="table table-warning table-hover table-striped-columns table-sm center-table" style="width:50%; margin-left:300px;" >
	 <thead>
	<tr class="table-dark">
	<th style="text-align: center;" >Codigo</th>
	<th  style="text-align: center;">Nombre Pelicula</th>
	<th >Portada</th>
	<th >Eliminar</th>
	<th >Editar</th>
	</tr>
	 </thead>
	   <tbody>
    <c:forEach var="peli" items="${ListadoPeliculas}">
  <tr>
    <td style="text-align: center;"><c:out value="${peli.idpelicula}"></c:out></td>
    <td  style="text-align: center;"><c:out value="${peli.nompelicula}"></c:out></td>
    <td><img src="http://localhost/files/${peli.fotopelicula}" width="150px" height="200px" onclick="openFulImg(this.src)" /></td>
    <td>
        <a href="ControladorPelicula?action=Eliminar&idpelicula=${peli.idpelicula}" id="eliminar">
            <img src="imagenes/eliminar.png" width="30px" height="30px">
            <input type="hidden" id="idpelicula" value="${peli.idpelicula}">
        </a>
    </td>
    <td>
        <a href="ControladorPelicula?action=Modificar&idpelicula=${peli.idpelicula}" id="modificar">
            <img src="imagenes/actualizar.png" width="50px" height="40px">
            <input type="hidden" id="idpelicula" value="${peli.idpelicula}">
        </a>
    </td>
</tr>

    </c:forEach>
      </tbody>
    </table>
  
    </div>
  </section>
  
  
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
            dom: 'Bfrtilp',
            
            responsive: "true",
            lengthMenu: [
                [5, 10,25, -1],
                [5, 10,25, 'All']
            ],
			buttons: [	

		
			  	
			{
			    extend: 'print',
			    text: 'Imprimir <i class="bi bi-printer"></i>',
			    titleAttr: 'Imprimir',
			    title: 'Listado de Peliculas', // Aquí puedes cambiar el título
			    className: 'btn btn-info',
			    
			    exportOptions: {
			        columns: ':visible',
			        format: {
			            body: function (inner, coldex, rowdex) {
			                if (inner.length <= 0) return inner;
			                var el = $.parseHTML(inner);
			                var result = '';
			                $.each(el, function (index, item) {
			                    if (item.nodeName == '#text') result = result + item.textContent;
			                    else if (item.nodeName == 'SUP') result = result + item.outerHTML;
			                    else if (item.nodeName == 'STRONG') result = result + item.outerHTML;
			                    else if (item.nodeName == 'IMG') result = result + item.outerHTML;
			                    else result = result + item.innerText;
			                });
			                return result;
			            }
			        }
			        
			    },
			    customize: function (win) {
	                $(win.document.body).find('table').addClass('display').css('font-size', '9px');
	                $(win.document.body).find('tr:nth-child(odd) td').each(function(index){
	                    $(this).css('background-color','#D0D0D0');
	                });
	                $(win.document.body).find('h1').css('text-align','center');
	            }
			    
			}

        
            ],
     
    } );
	
		
		
	</script>
	
	

	
</body>
</html>