<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.web.models.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Person page</title>
</head>
<body>
	<% Person person = (Person) request.getAttribute("person"); %>
	<h1><%= person.greeting() %></h1>
</body>
</html>