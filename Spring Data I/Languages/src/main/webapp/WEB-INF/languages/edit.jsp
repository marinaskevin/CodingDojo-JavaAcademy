<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Edit <c:out value="${language.name}"/></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
	<div class="jumbotron container">
		<p style="text-align: right"><a href="/languages/<c:out value="${language.id}"/>/delete" class="btn btn-danger">Delete</a>&emsp;<a href="/languages" class="btn btn-info">Dashboard</a></p>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
			<div class="form-group row">
				<form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
				<div class="col-sm-10">
					<form:errors path="name" class="danger"/>
					<form:input path="name" class="form-control" value="${language.name}"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="creator" class="col-sm-2 col-form-label">Creator</form:label>
				<div class="col-sm-10">
					<form:errors path="creator" class="danger"/>
					<form:input path="creator" class="form-control" value="${language.creator}"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="currentVersion" class="col-sm-2 col-form-label">Version </form:label>
				<div class="col-sm-10">
					<form:errors path="currentVersion" class="danger"/>
					<form:input path="currentVersion" class="form-control" value="${language.currentVersion}"/>
				</div>
			</div>
			<div>
				<input class="float-right btn btn-primary" type="submit" value="Submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>