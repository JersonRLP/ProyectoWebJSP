<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Selección de Asientos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
             background-image: url('imagenes/fondocine.jpg');
            margin: 0;
            padding: 20px;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            height: 100vh;
        }

        .cinema-container {
            display: flex;
            flex-direction: column;
            gap: 20px;
            max-width: 600px;
        }

        .row {
            display: flex;
            gap: 10px;
        }

        .seat {
            width: 40px;
            height: 40px;
            background-color: #bdc3c7;
            cursor: pointer;
            border-radius: 5px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 14px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .seat.selected {
            background-color: #3498db;
        }

        #selected-seat-info {
            margin-top: 20px;
        }

        #reserve-button {
            margin-top: 20px;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
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