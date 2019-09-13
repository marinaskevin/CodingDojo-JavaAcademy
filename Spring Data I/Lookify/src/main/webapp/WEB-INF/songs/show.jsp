<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Details</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>
	<link rel="sytlesheet" href="/css/styles.css" type="text/css">
<body>
	<div class="jumbotron container">
		<div class="text-right">
			<span><a href="/dashboard">Dashboard</a></span>
		</div>
		<div class="row">
			<div class="col-sm-2">Title</div>
			<div class="col-sm-10">
				<c:out value="${song.title}"/>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">Artist</div>
			<div class="col-sm-10">
				<c:out value="${song.artist}"/>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">Rating (1-10)</div>
			<div class="col-sm-10">
				<c:out value="${song.rating}"/>
			</div>
		</div>
		<form:form action="/songs/${song.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" class="btn btn-sm btn-danger" value="Delete">
		</form:form>
	</div>
</body>
</html>