<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Person</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1>New Person</h1>
		<form:form action="/persons" method="post" modelAttribute="person">
		<div class="form-group row">
			<form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
			<div class="col-sm-10">
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
			<div class="col-sm-10">
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</div>
		</div>
		<input type="submit" value="Create" class="btn btn-primary">
		</form:form>
	</div>
</body>
</html>