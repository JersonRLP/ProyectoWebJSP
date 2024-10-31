// custom-functions.js
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

function ObtenerCodigoSelect() {
    var select = document.getElementsByName("codigoemp")[0];
    var hiddenInput = document.getElementsByName("nombre")[0];

    var selectedOption = select.options[select.selectedIndex];
    hiddenInput.value = selectedOption.value !== "zz" ? selectedOption.value : "";
}

// Asociar el evento "change" del select con la función de actualización
$(document).ready(function () {
    document.getElementsByName("codigoemp")[0].addEventListener("change", ObtenerCodigoSelect);
});
