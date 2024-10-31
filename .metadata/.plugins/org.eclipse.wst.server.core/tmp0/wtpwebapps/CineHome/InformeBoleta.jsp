<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Boleta de Compra de Entradas de CineHome</title>
<!-- para bootstrap 5 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
   
 <script src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
 
</head>
<body>

    <div id="boleta">
    <form  method="post" action="${pageContext.request.contextPath}/demo">
        <h1>Boleta de Compra de Entradas</h1>
        <p>Cine: Nombre del Cine</p>
        <p>Película: Nombre de la Película</p>
        <p>Fecha: 17 de Octubre de 2023</p>
        <p>Hora: 19:30</p>
        <p>Cantidad de Entradas: 2</p>
        <p>Precio Total: $20.00</p>
        <input type="text" name="productId" placeholder="Input product id">
         <input type="submit"	value="Generate">
         <br>
         <img src="${pageContext.request.contextPath}/ControladorGenerarQr?productId=${productId}" style="display: none;">
         <img src="${pageContext.request.contextPath}/barcode?productId=${productId}" width="400" height="200">
        </form>
        
       
        
    </div>

</body>
</html>