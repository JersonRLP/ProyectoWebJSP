<%@ include file="MenuPrincipal.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <!-- para bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<section class="home" id="content">
<div class="container col-md-4">
    <form action="ControladorPelicula" method="post" enctype="multipart/form-data">
        <h1>Actualizar Nueva Película</h1>
        <hr>
        <br>
        <div class="text-center mb-3">
            <label>Nombres:</label>
            <input type="text" value='<c:out value="${nompelicula}"></c:out>' name="nompelicula">
        </div>
        <div class="text-center mb-3">
            <label>Seleccionar un nueva imagen:</label>
            <input type="file" name="fotopelicula" id="file" style="Display :none;">
             <button id="customButton" class="btn btn-danger" type="button">Seleccionar</button>
        </div>
        <div id="selectedFileName"></div>
        
        <div class="text-center">
            <img src="${fotopelicula}" alt="imagen de la película" id="img" width="130px">
        </div>

        
        <div>
            <input type="hidden" value='<c:out value="${idpelicula}"></c:out>' name="idpelicula">
            <input type="hidden" value='<c:out value="${fotopelicula}"></c:out>' name="fotopelicula">
        </div>
        <br>
        <div class="text-center">
            <input type="submit" name="action" value="Actualizar" class="btn btn-primary">
        </div>
        <br>
        <div class="text-center">
            <a href="ControladorPelicula?action=Listar" class="btn btn-warning">Regresar al listado Películas</a>
        </div>
    </form>
</div>

</section>
<script>

    document.addEventListener("DOMContentLoaded", function () {
        const fileInput = document.getElementById("file");
        const img = document.getElementById("img");

        fileInput.addEventListener("change", function (e) {
            if (e.target.files[0]) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    img.src = e.target.result;
                }

                reader.readAsDataURL(e.target.files[0])
            } else {
                img.src = "http://localhost/files/${fotopelicula}"; // Puedes poner una imagen por defecto
                
            }
        });

        // Disparar el evento change para que la imagen se muestre al cargar la página
        fileInput.dispatchEvent(new Event("change"));
    });
</script>

<script>
    document.getElementById('customButton').addEventListener('click', function () {
        document.getElementById('file').click();
    });
</script>
</body>
</html>

