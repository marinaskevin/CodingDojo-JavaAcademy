<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Add Song</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>
	<link rel="sytlesheet" href="/css/styles.css" type="text/css">
<body>
	<div class="jumbotron container">
		<div class="text-right">
			<span><a href="/dashboard">Dashboard</a></span>
		</div>
		<form:form action="/songs" method="post" modelAttribute="song">
			<div class="form-group row">
				<form:label path="title" class="col-form-label col-sm-2">Title</form:label>
				<div class="col-sm-10">
					<form:errors path="title"/>
					<form:input path="title"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="artist" class="col-form-label col-sm-2">Artist</form:label>
				<div class="col-sm-10">
					<form:errors path="artist"/>
					<form:input path="artist"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="rating" class="col-form-label col-sm-2">Rating (1-10)</form:label>
				<div class="col-sm-10">
					<form:errors path="rating"/>
					<form:input path="rating" type="number" min="1" max="10"/>
				</div>
			</div>
			<div class="text-right">
				<input type="submit" value="Add Song" class="btn btn-primary">
			</div>
		</form:form>
	</div>
</body>
</html>