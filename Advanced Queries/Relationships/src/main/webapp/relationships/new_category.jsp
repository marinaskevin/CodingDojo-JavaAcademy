<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Category</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1>New Category</h1>
		<form:form action="/categories" method="post" modelAttribute="category">
		<div class="form-group row">
			<form:label path="name" class="col-sm-2 col-form-label">Name: </form:label>
			<div class="col-sm-10">
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
		</div>
		<input type="submit" value="Create" class="btn btn-primary">
		</form:form>
	</div>
</body>
</html>