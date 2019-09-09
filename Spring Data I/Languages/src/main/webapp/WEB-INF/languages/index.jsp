<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Languages</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
			<tr>
				<td><c:out value="${language.name}"/></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.currentVersion}"/></td>
				<td><a href="/languages/<c:out value="${language.id}"/>/edit">Edit</a>
					<a href="/languages/<c:out value="${language.id}"/>/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>