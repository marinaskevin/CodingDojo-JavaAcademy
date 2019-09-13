<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Search</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="sytlesheet" href="/css/styles.css" type="text/css">
</head>
<body>
	<div class="jumbotron">
		<div class="d-flex flex-row justify-content-between">
			<span>Top Ten Songs:</span>
			<span><a href="/dashboard">Dashboard</a></span>
		</div>
		<div>
			<span class="border-1 p3">
				<c:forEach items="${songs}" var="song">
					<p><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/></p>
				</c:forEach>
			</span>
		</div>
	</div>
</body>
</html>