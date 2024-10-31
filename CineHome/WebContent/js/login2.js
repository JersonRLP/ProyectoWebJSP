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