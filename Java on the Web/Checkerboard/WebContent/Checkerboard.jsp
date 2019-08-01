<!-- Sample page: http://localhost:8080/Checkerboard/Checkerboard.jsp?width=10&height=10 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Checkerboard</title>
</head>
<body>
	<% String width = request.getParameter("width"); %>
	<% String height = request.getParameter("height"); %>
	<% width = width != null ? width : "1"; %>
	<% height = height != null ? height : "1"; %>
	<h1>Checkerboard: <%= width %>w X <%= height %>h</h1>
	<% for(int y = 0; y < Integer.parseInt(height); y++) { %>
	<div class="container">
		<% for(int x = 0; x < Integer.parseInt(width); x++) { %>
			<% int colorNum = (x+y)%2 == 0 ? 1 : 2; %>
			<span class="color<%= colorNum %>"></span>
		<% } %>
	</div>		
	<% } %>
</body>
</html>