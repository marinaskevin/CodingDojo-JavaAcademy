<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Secret Code</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<h1 class="error"><c:out value="${error}"/></h1>
		<form class="container" method="POST" action="/submit">
			<h1>What is the code?</h1>
			<input type="text" name="code">
			<button>Try Code</button>
		</form>
	</div>
</body>
</html>