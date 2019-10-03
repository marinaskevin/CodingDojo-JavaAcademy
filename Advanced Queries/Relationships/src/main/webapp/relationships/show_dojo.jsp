<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dojo Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		<table class="table">
			<thead>
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Age</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dojo.ninjas}" var="ninja">
				<tr>
					<td><c:out value="${ninja.firstName}"/></td>
					<td><c:out value="${ninja.lastName}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>