<%@page import="Conectar.Cinehome.ConectarBD"%>
<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consulta detalle boleta</title>
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


<script type="text/javascript">
    function consultar() {
        // Obtener los datos del formulario
        var formData = $("#consultaForm").serialize();

        // Realizar la solicitud AJAX
        $.ajax({
            type: "POST",
            url: "ControladorDetalleBoleta",
            data: formData,
            success: function (response) {
                // Actualizar la sección de resultados con la respuesta del servidor
                $("#resultadoConsulta").html(response);
            }
        });
    }
</script>

</head>
<body>
 <section class="home" id="content">
 <div class="container">
 
  	  <div class="form-group col-md-6 mt-4">
       <form id="consultaForm" action="ControladorDetalleBoleta" method="post">
    	<div class="form-group col-md-6 mt-4">
        	<select name="codigoemp" class="form-select">
            <option value="zz">Seleccione Empleado</option>
           <c:forEach var="cod" items="${listadoEmpleado}">
            <option value='<c:out value="${cod.codigoemp}"></c:out>'>
            <c:out value="${cod.nomemp}"></c:out></option>
            </c:forEach> 
            
        	</select>
        	<div style="Display:flex;" class="mt-2 mb-2">
        	<input type="text" name="nombre" class="form-control" readonly>
        	<button class="btn btn-primary" type="submit">Consultar</button>
        
        	</div>
        
        	
       
     	 

    	</div>
		</form>
		
        </div> 
 

 <table id="table" class="table table-warning">
<thead>
 <tr>
  <th>Codigo Boleta</th>
  <th>Entradas Vendidas</th>
  <th>Precio Total</th>
 </tr>
 </thead>
 <tbody>
  		<c:forEach var="dtbol" items="${listadoDetalleBoleta}">
 <tr>
 		<td ><c:out value="${dtbol.codboleta}"></c:out></td>
        <td><c:out value="${dtbol.cantentra}"></c:out></td>
        <td><c:out value="${dtbol.preciotot}"></c:out></td>
	</tr>	
	</c:forEach>
 </tbody>
 </table>

 
 
 </section>

</body>
<script>
  function ObtenerCodigoSelect() {
    var select = document.getElementsByName("codigoemp")[0];
    var hiddenInput = document.getElementsByName("nombre")[0];

    var selectedOption = select.options[select.selectedIndex];
    if (selectedOption.value !== "zz") {
      hiddenInput.value = selectedOption.value; // Cambiado a selectedOption.value
    } else {
      hiddenInput.value = "";
    }
  }

  // Asociar el evento "change" del select con la función de actualización
  document.getElementsByName("codigoemp")[0].addEventListener("change", ObtenerCodigoSelect);
</script>
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
            responsive: "true",
            dom: 'Bfrtilp',
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