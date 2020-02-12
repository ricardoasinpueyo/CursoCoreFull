<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenidos a nuestro alta de peliculas</h1>
	<h2 style="color:blue">${param.mensaje}</h2>
	<form action="doAltaPelicula">
	Titulo: <input type="text" name="titulo"/>
	<br/>
	Director: <input type="password" name="director"/>
	<br/>
	Genero: <input type="text" name="genero"/>
	<br/>
	Año: <input type="text" name="year"/>
	<br/>
	<input type="submit" value="Enviar"/>
	</form>
	<!-- como estamos en peliculas/alta 
		bajamos un nivel y ponemos inicio
		de tal manera que entreremos por el
		controlador "inicio" que esta
		en ControladorUsuario
	 -->
	<a href="../inicio">Ir a pagina de inicio</a>
</body>
</html>