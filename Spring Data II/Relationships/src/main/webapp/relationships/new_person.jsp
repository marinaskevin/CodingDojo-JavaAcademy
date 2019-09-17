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
	<h1>New Person</h1>
	<form:form action="/licenses" method="post" modelAttribute="person">
	<div class="form-group row">
		<form:label path="number">First Name</form:label>
		<div class="col-sm-10">
			<form:errors path="first_name"/>
			<form:input path="first_name"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="state">Last Name</form:label>
		<div class="col-sm-10">
			<form:errors path="last_name"/>
			<form:input path="last_name"/>
		</div>
	</div>
	</form:form>
</body>
</html>