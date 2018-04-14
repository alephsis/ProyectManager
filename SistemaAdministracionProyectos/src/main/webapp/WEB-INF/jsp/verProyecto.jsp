<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />

	<title>Proyectos existentes</title>
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
               <c:forEach var="p" items="${proyectos}">
                    <tbody>
			<tr>
                        	<td></td>
                                <td></td>
                                <td>
                                    <div id="top">
                                        <div id="top2">
                                            <p class="titulos">Proyecto ${p.getId()}</p>
                                            <form>
                                                <ul>                                                                                                                
                                                    <li>Nombre: <input type="text" name="nombre" value ="${p.getNombre()}" readonly></li>                                                    
                                                    <li>Cliente: <input type="text" name="cliente"  value ="${p.getCliente()}" readonly></li>                                                    
                                                    <li>Fecha de Inicio:<input type="date" name="inicio" value ="${p.getFechaInicio()}" readonly></li>                                                    
                                                    <li>Fecha de FinalizaciÃ³n:<input type="date" name="fin" value ="${p.getFechaFin()}" readonly></li>                                                                                                                                                        
                                                </ul>   
                                                <br><textarea name="descripcion" rows="3" cols="20" readonly>"${p.getDescripcion()}" </textarea>
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
