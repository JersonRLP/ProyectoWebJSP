<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Importa el archivo CSS -->
    <link rel="stylesheet" href="Estilos/cinevista.css">
    <title>Selección de Asientos</title>

</head>
<body>

<div class="cinema-container" id="cinema-container">
    <!-- Filas y asientos se generarán dinámicamente aquí -->
</div>

<div id="selected-seat-info"></div>

<div>

    <button id="reserve-button" onclick="showReservedSeats()">Mostrar Asientos Reservados</button>
</div>


<script src="js/cine.js"></script>

</body>
</html>
