<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Languages</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
	<div class="jumbotron container">
		<h1>Languages</h1>
		<table class="container table-striped">
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
					<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
					<td><c:out value="${language.creator}"/></td>
					<td><c:out value="${language.currentVersion}"/></td>
					<td><a href="/languages/${language.id}/edit" class="btn btn-warning btn-sm">Edit</a>&emsp;
						<form:form action="/languages/${language.id}" method="post" class="d-inline">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete" class="btn btn-danger btn-sm">
						</form:form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="jumbotron container">
		<form:form action="/languages" method="post" modelAttribute="language">
			<div class="form-group row">
				<form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
				<div class="col-sm-10">
					<form:errors path="name" class="danger"/>
					<form:input path="name" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="creator" class="col-sm-2 col-form-label">Creator</form:label>
				<div class="col-sm-10">
					<form:errors path="creator" class="danger"/>
					<form:input path="creator" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="currentVersion" class="col-sm-2 col-form-label">Version </form:label>
				<div class="col-sm-10">
					<form:errors path="currentVersion" class="danger"/>
					<form:input path="currentVersion" class="form-control"/>
				</div>
			</div>
			<div>
				<input class="float-right btn btn-primary" type="submit" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>