<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Lookify!</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="sytlesheet" href="/css/styles.css" type="text/css">
</head>
<body>
	<div class="jumbotron container">
		<div class="d-flex flex-row justify-content-between">
			<span><a href="/songs/new">Add New</a></span>
			<span><a href="/search/topTen">Top Songs</a></span>
			<form action="/search" method="post" class="d-inline">
				<div class="form-group row">
					<input type="text" name="artist" class="form-control"/>
					<input type="submit" value="Search Artists" class="btn btn-primary">
				</div>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td>
						<form:form action="/songs/${song.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" class="btn btn-sm btn-danger" value="Delete">
						</form:form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>