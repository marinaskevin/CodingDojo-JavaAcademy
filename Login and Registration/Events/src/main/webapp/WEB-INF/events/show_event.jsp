<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${event.name}"/></title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
	<h1><c:out value="${event.name}"/></h1>
	<p>
		Host: <c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/><br>
		Date: <fmt:formatDate value="${event.date}" pattern="MMMM d, yyyy"/><br>
		Location: <c:out value="${event.location}"/><br>
		People who are attending this event: <c:out value="${event.attendees.size()}"/>
	</p>
	</div>
</body>
</html>