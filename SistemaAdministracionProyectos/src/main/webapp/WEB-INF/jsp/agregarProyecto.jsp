<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />

	<title>Agregar Proyecto</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

<header class="header">
<nav class="menu">

	<ul>
	<li>Cerrar Sesion</li>
	</ul></nav>
		
	</header><!-- .header-->

<div class="wrapper">

	
	<div id="top">
    	<div id="top2">
        <p class="titulos">Agregar Proyecto</p>
        <form action="/SistemaAdministracionProyectos/home/agregarProyectoBoton">
        <ul>
        <li>Nombre: <input type="text" name="nombre"></li>
        <li>Cliente: <input type="text" name="cliente"></li>
        <li>Fecha de Inicio:<input type="date" name="inicio"></li>
        <li>Fecha de Finalización:<input type="date" name="fin"></li>
        
        
        </ul>
        
        <br><textarea name="descripcion" rows="3" cols="40">Descripción del proyecto</textarea>
        
        <input type="submit" value="Agregar">
        </form>

        </div>

</div><!-- .wrapper -->
</div>
<footer class="footer">
	Relizado por <b>Chabelo Software </b>
</footer><!-- .footer -->

</body>
</html>
