<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Events</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<fmt:formatDate value="${event.date}"  
	                type="date" 
	                pattern="yyyy-MM-dd"
	                var="eventDate" />

	<div class="jumbotron container">
		<h1><c:out value="${event.name}"/></h1>
		<h3>Edit Event</h3>
		<form:form action="/events/${event.id}" method="post" modelAttribute="event">
			<input type="hidden" name="_method" value="put">
			<div class="form-group row">
				<form:label path="name" class="col-sm-2 form-label">Name</form:label>
				<div class="col-sm-10">
					<form:input path="name" class="form-control" value="${event.name}"/>
					<form:errors path="name"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="date" class="col-sm-2 form-label">Date</form:label>
				<div class="col-sm-10">
					<form:input path="date" class="form-control" type="date" value="${eventDate}"/>
					<form:errors path="date"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="location" class="col-sm-2 form-label">Location</form:label>
				<div class="col-sm-8">
					<form:input path="location" class="form-control" value="${event.location}"/>
					<form:errors path="location"/>
				</div>
				<div class="col-sm-2">
					<form:input path="state" class="form-control" value="${event.state}"/>
					<form:label path="state" class="d-none"/>
					<form:errors path="state"/>
				</div>
			</div>
			<div class="row text-right" style="padding: 10px">
				<input type="submit" value="Submit" class="btn btn-primary"/>
			</div>
		</form:form>
	</div>
</body>
</html>