// Función para crear un asiento
function createSeat(row, seatNumber) {
    const seat = document.createElement("div");
    seat.classList.add("seat");
    seat.dataset.row = row;
    seat.dataset.seatNumber = seatNumber;

    const seatLetter = String.fromCharCode(65 + row); // Convertir el número de fila a letra (A, B, C, ...)
    seat.textContent = `${seatLetter}${seatNumber}`; // Sin espacio entre la letra y el número

    seat.addEventListener("click", () => toggleSeat(seat));

    return seat;
}

// Función para inicializar el cine
function initializeCinema() {
    const rows = 6; // Número de filas
    const seatsPerRow = 10; // Número de asientos por fila

    const cinemaContainer = document.getElementById("cinema-container");

    for (let i = 0; i < rows; i++) {
        const rowContainer = document.createElement("div");
        rowContainer.classList.add("row");

        for (let j = 1; j <= seatsPerRow; j++) {
            const seat = createSeat(i, j);
            rowContainer.appendChild(seat);
        }

        cinemaContainer.appendChild(rowContainer);
    }
}

const selectedSeats = [];

//Función para alternar el estado del asiento (seleccionado o no)
function toggleSeat(seat) {
 seat.classList.toggle("selected");

 const selectedSeatInfo = document.getElementById("selected-seat-info");
 const row = seat.dataset.row;
 const seatNumber = seat.dataset.seatNumber;
 const seatInfo = `${String.fromCharCode(65 + parseInt(row))} - ${seatNumber}`;

 if (seat.classList.contains("selected")) {
     selectedSeats.push(seatInfo);
 } else {
     const index = selectedSeats.indexOf(seatInfo);
     if (index !== -1) {
         selectedSeats.splice(index, 1);
     }
 }

 // Asignar el texto, cambiar el color y agregar un borde
 selectedSeatInfo.textContent = `Has seleccionado ${selectedSeats.length} asientos:\n${selectedSeats.join(", ")}`;
 selectedSeatInfo.style.color = "white";
 selectedSeatInfo.style.border = "2px solid red";  // Puedes ajustar el ancho y el color del borde según tus preferencias

 // Actualizar el valor del input cantentra con la cantidad de asientos seleccionados
 updateCantentraInput(selectedSeats.length);
}

//Función para mostrar los asientos reservados
function showReservedSeats() {
 const reservedSeats = selectedSeats.join(", ");
 document.getElementById("nroasientos").value = reservedSeats;
 alert(`Has seleccionado ${selectedSeats.length} asientos:\n${reservedSeats}`);
}

//Función para actualizar el valor del input cantentra
function updateCantentraInput(selectedSeatsCount) {
 document.getElementById("cantentra").value = selectedSeatsCount;
}

//Inicializar el cine cuando la página se carga
document.addEventListener("DOMContentLoaded", initializeCinema);

