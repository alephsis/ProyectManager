<%-- 
    Document   : verUsuario
    Created on : 9/04/2018, 04:51:56 AM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />

	<title>Usuarios existentes</title>
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
    <div class="table-container">
	<table class="table table-filter">
               <c:forEach var="p" items="${usuarios}">
                    <tbody>
			<tr>
                        	<td></td>
                                <td></td>
                                <td>
                                    <div id="top">
                                        <div id="top2">
                                            <p class="titulos">Usuario ${usuario.getID()}</p>
                                            <form>
                                                <ul>                                                                                                                
                                                    <li>Nombre: <input type="text" name="nombre" value ="${p.getNombre()}" readonly></li>                                                    
                                                    <li>Rol: <input type="text" name="cliente"  value ="${p.getRol()}" readonly></li>                                                                                                                                                       
                                                </ul>
                                            </form>
                                        </div>
                                    </div>
                                </td>
                        </tr>						
                    </tbody>
                </c:forEach>
        </table>
    </div>
</div>

</body>
</html>