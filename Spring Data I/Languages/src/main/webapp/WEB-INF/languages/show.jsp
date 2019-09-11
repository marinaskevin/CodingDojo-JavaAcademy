<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title><c:out value="${language.name}"/></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
	<div class="jumbotron container">
		<p style="text-align: right"><a href="/languages" class="btn btn-primary">Dashboard</a></p>
		<p><c:out value="${language.name}"/></p>
		<p><c:out value="${language.creator}"/></p>
		<p><c:out value="${language.currentVersion}"/></p>
		<a href="/languages/${language.id}/edit" class="btn btn-warning">Edit</a>
		<form:form action="/languages/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete" class="btn btn-danger">
		</form:form>
	</div>
</body>
</html>