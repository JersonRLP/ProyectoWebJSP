<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cine Home</title>

<link rel="stylesheet" href="Estilos/EstilosMenu.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>

<body>

<nav class="sidebar close">

<header>

<div class="text logo">

<span class="name">MENU</span>


</div>
<i class="bx bx-menu toggle"></i>


</header>


<div class="menu-bar">

<div class="menu">
	
	<li class="search-box">
	<i class="bx bx-search icon"></i>
	<input type="text" placeholder="Buscar...">
	
	</li>
	
	<ul class="menu-links">
		<li class="nav">
		<a href="ControladorPelicula?action=ListadoPelicula">
			<i class="bx bx-home-alt icon"></i>
			<span class="text nav-text">Venta de Entrada</span>
		</a>
		</li>
		<li >
		<a href="ControladorPelicula?action=Listar" class="nav">
			<i class="bx bx-wallet icon"></i>
			<span class="text nav-text">Peliculas</span>
		</a>
		</li>
		<li>
		<a href="ControladorDetalleBoleta?accion=Listado">
			<i class="bx bx-wallet icon"></i>
			<span class="text nav-text">Reportes</span>
		</a>
		</li>
		<li class="nav">	
		
		<a href="#" id="mantenimiento-link" onclick="toggleSubMenu()">
			<i class="bx bx-wallet icon"></i>
			<span class="text nav-text">Mantenimiento</span>			
			<i class='bx bx-chevron-down arrow'></i>
		</a>
		
		
		<ul class="sub-menu" id="sub-menu">
		<li class="nav"><a href="ControladorEmpleado?accion=NuevoEmp" class="menu-link">
			<span class="text nav-text">Empleados</span>		
		</a>
		</li>
		<li class="nav"><a href="ControladorUsuario?accion=Listado" class="menu-link">
		<span class="text nav-text">Login</span>
		</a>
		</li>
		<li class="nav"><a href="FrmRegistrarPelicula.jsp"  class="menu-link">
		<span class="text nav-text">Peliculas</span>
		</a>
		</li>
		</ul >
		
		</li>
	</ul>
	
</div>

<div class="botton-content">
<li class="">
<a href="#"> 
	<i class="bx bx-log-out icon"></i>
	<span class="text nav-text">Salir</span>
</a>
</li>

<li class="mode">
	<div class="sun-moon">
	<i class="bx bx-moon icon"></i>
	<i class="bx bx-sun icon"></i>
	</div>
	<span class="mode-text text">Modo Oscuro</span>
	<div class="toggle-switch">
	<span class="switch"></span>
	</div>
</li>

</div>


</div>



</nav>

<script src="js/codigo.js"></script>


</body>

</html>



