<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title><c:out value="${event.name}"/></title>
</head>
<body>
	<div class="jumbotron container">
	<h1><c:out value="${event.name}"/></h1>
	<p>
		Host: <c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/><br>
		Date: <c:out value="${event.date}"/><br>
		Location: <c:out value="${event.location}"/><br>
		People who are attending this event: <c:out value="${event.attendees.size()}"/>
	</p>
	</div>
</body>
</html>