<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Profile Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<h1><c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></h1>
	<table class="table">
		<tbody>
			<tr>
				<td>License Number</td>
				<td><c:out value="${license.number}"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><c:out value="${license.state}"/></td>
			</tr>
			<tr>
				<td>Expiration Date</td>
				<td><c:out value="${license.expiration_date}"/></td>
			</tr>
		</tbody>
	</table>
</body>
</html>