<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1>Lista de peliculas actuales</h1>
		<table border=1>
			<tr>
				<th>id</th>
				<th>titulo</th>
				<th>director</th>
				<th>detalle</th>
				<th>detalle en pagina</th>
			</tr>
			 <c:forEach items="${listaPeliculas}" 
			 	var="pelicula">
             	<tr>
             		<td>${pelicula.id}</td>
                	<td>${pelicula.titulo}</td>
                	<td>${pelicula.director}</td>
                	<td><a href="detalle?id=${pelicula.id}">enlace</a></td>
                	<td><a href="listar?idPelicula=${pelicula.id}">enlace</a></td>
                </tr>
             </c:forEach>
		</table>
		
		<!-- hay que comprobar que nos venga la
		pelicula del controlador, en caso de que llegue
		tendremos que pintar los datos -->
		<c:if test="${not empty pelicula }">
			<hr/>
			<h1>Detalle de la pelicula</h1>
	
			<h3>${pelicula.id}</h3>
			<h3>${pelicula.titulo}</h3>
			<h3>${pelicula.genero}</h3>
			<h3>${pelicula.director}</h3>
			<h3>${pelicula.year}</h3>
		</c:if>
	</center>
</body>
</html>