<%-- 
    Document   : agregarUsuario
    Created on : Apr 8, 2018, 4:19:34 PM
    Author     : manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/> ">
    </head>
    <body>
        <header class="header">
            <nav class="menu">

                <ul>
	
                </ul>
            </nav>
		
	</header><!-- .header-->

        <div class="wrapper">
            <div id="top">
                <div id="top2">
                    <p class="titulos">Registro</p>
                    <form action="agregarUsuario" method="post" onsubmit="return validar(this)">
                        <ul>
                            <li>Nombre: <input type="text" name="nombre" 
                                               required
                                               oninvalid="this.setCustomValidity('Llena este campo')" 
                                               oninput="setCustomValidity('')"></li>
                            <li>Contraseña:<input type="text" name="password"
                                                  required
                                                  oninvalid="this.setCustomValidity('Llena este campo')" 
                                                  oninput="setCustomValidity('')"
                                                  ></li>
                            <li>Rol: <input type="radio" name="rol" value="usuario" checked> Usuario <input type="radio" name="rol" value="analista"> Analista <input type="radio" name="rol" value="admin"> Administrador</li>

                        </ul>
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
