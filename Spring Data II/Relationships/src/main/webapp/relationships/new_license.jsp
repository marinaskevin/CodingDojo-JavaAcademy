<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New License</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses" method="post" modelAttribute="license">
	<div class="form-group row">
		<form:label path="number">License Number</form:label>
		<div class="col-sm-10">
			<form:errors path="number"/>
			<form:input path="number"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="state">State</form:label>
		<div class="col-sm-10">
			<form:errors path="state"/>
			<form:input path="state"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="expiration_date">Expiration Date</form:label>
		<div class="col-sm-10">
			<form:errors path="expiration_date"/>
			<form:input path="expiration_date"/>
		</div>
	</div>
	</form:form>
</body>
</html>