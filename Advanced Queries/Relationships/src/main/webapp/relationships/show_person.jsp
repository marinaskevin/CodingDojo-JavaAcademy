<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Profile Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
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
					<td><fmt:formatDate pattern="MM/dd/YYYY" value="${license.expirationDate}"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>