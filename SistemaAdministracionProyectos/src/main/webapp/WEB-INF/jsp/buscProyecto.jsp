<%-- 
    Document   : buscProyecto
    Created on : 9/04/2018, 02:42:48 AM
    Author     : ahernandez
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />

	<title>Proyecto Encontrado</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<header class="header">
<nav class="menu">

	<ul>
	<li>
            <a class="nav-link" 
               href = "/SistemaAdministracionProyectos/home/salir">Cerrar sesion
            </a>
        </li>
	</ul></nav>
		
	</header><!-- .header-->

<div class="wrapper">

	
	<div id="top">
    	<div id="top2">
        <p class="titulos">Proyecto ${p.getId()}</p>
        <form action="/SistemaAdministracionProyectos/home/agregarProyectoBoton">
        <ul>
            <li>Nombre: <input type="text" name="nombre" value="${p.getNombre()}" readonly></li>
        <li>Cliente: <input type="text" name="cliente" value="${p.getNombre()}" readonly></li>
        <li>Fecha de Inicio:<input type="date" name="inicio" value="${p.getNombre()}" readonly></li>
        <li>Fecha de Finalización:<input type="date" name="fin" value="${p.getNombre()}" readonly></li>
        
        
        </ul>
        
        <br><textarea name="descripcion" rows="3" cols="40">${p.getNombre()}</textarea>
        
        </form>

        </div>

</div><!-- .wrapper -->
</div>
<footer class="footer">
	Relizado por <b>Chabelo Software </b>
</footer><!-- .footer -->

</body>
</html>

