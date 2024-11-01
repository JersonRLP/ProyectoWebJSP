<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
    
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link rel="stylesheet" href="Estilos/registrarboleta.css">
	

</head>

<body >
<section class="home" id="content">
  <div class="container" style ="width:43%; ">
    <h1 class="text-center mt-4">Formulario de Venta de Entradas</h1>
    <form action="ControladorBoleta" method="post" style="margin-left:100px;">
      <div class="row">
        <div class="form-group col-md-6" >
         <label for="codboleta">Código de Boleta:</label>
			<input type="text" class="form-control" id="codboleta" name="codboleta" value="${nuevoCodigoBoleta}" readonly required style="width:400px; margin-left:30px;">

        </div>

        <div class="form-group col-md-6">
          <label for="cliente">Cliente:</label>
          <input type="text" class="form-control" id="cliente" name="cliente" required	style="width:400px; margin-left:30px;">
        </div>
      </div>

      <div class="row">
        <div class="form-group col-md-6">
          <label for="cantentra">Cantidad de Entradas:</label>
          <input type="number" class="form-control" id="cantentra" name="cantentra" readonly required style="width:400px; margin-left:30px;">
        </div>

        <div class="form-group col-md-6 mt-4">
        
          <select name="idpelicula" class="form-select bg-warning" style="width:400px; margin-left:30px;">
			<option value="zz">Seleccione Pelicula</option>
			<c:forEach var="peli" items="${ListadoPeliculas}">
			<option value='<c:out value="${peli.idpelicula}"></c:out>'>
			<c:out value="${peli.nompelicula}"></c:out></option>
			</c:forEach>
			
			</select>
			<input type="hidden" name="nombrePelicula" value="">
			
        </div>  
      </div>

      <div class="row">
        <div class="form-group col-md-6">
          <label for="nroasientos">Número de Asientos:</label>
          <div class="text-center" style="width: 450px;"><button type="button" class="btn btn-primary btnModal mb-2"   >Reservar Asientol</button></div>
          <input type="text" class="form-control" id="nroasientos" name="nroasientos" readonly required style="width:400px; margin-left:30px;">
        </div>
		
        <div class="form-group col-md-6">
          <label for="preciotot">Precio Total:</label>
          <input type="number" class="form-control" id="preciotot" name="preciotot" required style="width:400px; margin-left:30px;">
        </div>
      </div>

      <div class="form-group col-md-6">
        <label for="codigoemp">Código de Empleado:</label>
       
         <select name="codigoemp" class="form-select bg-warning" id="codigoemp" required style="width:400px; margin-left:30px;">
			<option value="zz">Seleccione Empleado</option>
			<c:forEach var="emp" items="${ListadoEmpleados}">
			<option value='<c:out value="${emp.codigoemp}"></c:out>'>
			<c:out value="${emp.nomemp}"></c:out></option>
			</c:forEach>
			
			</select>
      </div>
      <div class= "mt-2" style="width :200px;">
      <input type="text" class="form-control" name ="idemp" readonly style="width:400px; margin-left:30px;">
      </div>
	<div class="text-center	">
	
      <button type="submit" class="btn btn-primary mt-3">Agregar Transacción</button>
      <a href="ControladorPelicula?action=ListadoPelicula" class="btn btn-danger mt-3">Nuevo</a>
      
    
    </div>
    
<div class="modal fade" id="eliminarModal" tabindex="-1" aria-labelledby="eliminarModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content custom-modal" >
            <div class="modal-header" >
                <link rel="stylesheet" href="Estilos/cine.css">
                <script src="js/cine.js"></script>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="cinema-container" id="cinema-container" >
                <!-- Filas y asientos se generarán dinámicamente aquí -->
            </div>

            <div id="selected-seat-info" class="custom-seat-info"></div>

            <div>
                <button id="reserve-button" onclick="showReservedSeats()" class="custom-reserve-button">Mostrar Asientos Reservados</button>
            </div>
        </div>
    </div>
</div>
<style>
.custom-modal {
    background-image: url('imagenes/fondocine.jpg');
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    height: 100vh;
}

.custom-seat-info {
    margin-top: 20px;
    color: white;
}

.custom-reserve-button {
    margin-top: 20px;
    padding: 10px;
    font-size: 16px;
    cursor: pointer;
}
.seat {
    width: 40px; /* Ajusta el ancho según sea necesario */
    height: 40px; /* Ajusta la altura según sea necesario */
    background-color: #bdc3c7;
    cursor: pointer;
    border-radius: 5px;
    margin: 5px; /* Agregamos un pequeño margen entre los asientos para mejorar la apariencia */
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 12px; /* Ajusta el tamaño de la letra según sea necesario */
    font-weight: bold;
    transition: background-color 0.3s ease;
}

.row {
    display: flex;
    gap: 5px; /* Reducimos el espacio entre los asientos para mejorar la apariencia */
}

</style>


    <script>
		$(document).ready(function(){
			$('.btnModal').on('click',function(){
				$('#eliminarModal').modal('show');
			
				//console.log(data);
		
			})
		});
		
		
		
		
	</script>
    
    
¡
<script>
  function ObtenerCodigoSelect() {
    var select = document.getElementsByName("codigoemp")[0];
    var hiddenInput = document.getElementsByName("idemp")[0];

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
    
function actualizarNombrePelicula() {
  var select = document.getElementsByName("idpelicula")[0];
  var hiddenInput = document.getElementsByName("nombrePelicula")[0];
  
  var selectedOption = select.options[select.selectedIndex];
  if (selectedOption.value !== "zz") {
    hiddenInput.value = selectedOption.innerText;
  } else {
    hiddenInput.value = "";
  }
}

// Asociar el evento "change" del select con la función de actualización
document.getElementsByName("idpelicula")[0].addEventListener("change", actualizarNombrePelicula);
</script>
    
    </form>
  </div>
  </section>
</body>
</html>