<%-- 
    Document   : buscaUsuario
    Created on : 9/04/2018, 04:51:56 AM
    Author     : daniel
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />

	<title>Usuario Encontrado</title>
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
                   accesskey=""href = "/SistemaAdministracionProyectos/home/salir">Cerrar sesion
                </a>
            </li>
	</ul></nav>
		
	</header><!-- .header-->

<div class="wrapper">

	
	<div id="top">
    	<div id="top2">
        <p class="titulos">Usuario ${u.getId()}</p>
        <form action="/SistemaAdministracionProyectos/home/agregarUsuarioBoton">
            <ul>
                <li>Nombre: <input type="text" name="nombre" value="${u.getNombre()}" readonly></li>
                <li>Cliente: <input type="text" name="cliente" value="${u.getRol()}" readonly></li>
            </ul>
        </form>

        </div>

</div><!-- .wrapper -->
</div>
<footer class="footer">
	Relizado por <b>Chabelo Software </b>
</footer><!-- .footer -->

</body>
</html>

