<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Question</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1>New Question</h1>
		<form action="/questions" method="post">
		<div class="form-group row">
			<label for="question" class="col-sm-2 col-form-label">Question:</label>
			<div class="col-sm-10">
				<textarea id="question" name="question" class="form-control" rows="4"></textarea>
			</div>
		</div>
		<div class="form-group row">
			<label for="tags" class="col-sm-2 col-form-label">Tags:</label>
			<div class="col-sm-10">
				<input id="tags" name="tags" class="form-control" placeholder="Enter in tags seperated by commas....">
			</div>
		</div>
		<input type="submit" value="Create" class="btn btn-primary">
		</form>
	</div>
</body>
</html>