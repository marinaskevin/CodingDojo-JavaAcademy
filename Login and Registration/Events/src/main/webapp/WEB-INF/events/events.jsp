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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<div class="row" style="padding: 10px">
			<div class="sm-col-6"><h1>Welcome, <c:out value="${user.firstName} ${user.lastName}"/></h1></div>
			<div class="sm-col-6 text-right"><a href="/logout" class="btn btn-primary">Logout</a></div>
		</div>
		<h3>Here are some of the events in your state:</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${eventsInState}" var="event">
				<tr>
					<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
					<td><fmt:formatDate value="${event.date}" pattern="MMMM d, yyyy"/></td>
					<td><c:out value="${event.location}"/></td>
					<td><c:out value="${event.host.firstName} ${event.host.lastName}"/></td>
					<td>
						<form action="/events/${event.id}" method="post" style="padding: 0px">
						<button type="button" id="join" class="btn-link <c:if test="${event.attendees.contains(user)}">hidden</c:if>">Join</button>
						<span id="joining" class="<c:if test="${!event.attendees.contains(user)}">hidden</c:if>">Joining <a class="btn-link" href="/events/${event.id}/unjoin"><button type="button" class="btn-link">Cancel</button></a></span>
						<c:if test="${event.host.equals(user)}"><a href="/events/${event.id}/edit">Edit</a>
							<input type="hidden" name="_method" value="delete">
							<button type="submit" class="btn-link">Delete</button>
						</c:if>
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h3>Here are some of the events in other states:</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${eventsNotInState}" var="event">
				<tr>
					<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
					<td><fmt:formatDate value="${event.date}" pattern="MMMM d, yyyy"/></td>
					<td><c:out value="${event.location}"/></td>
					<td><c:out value="${event.state}"/></td>
					<td><c:out value="${event.host.firstName} ${event.host.lastName}"/></td>
					<td>
						<form action="/events/${event.id}" method="post">
						<button type="button" id="join" class="btn-link <c:if test="${event.attendees.contains(user)}">hidden</c:if>">Join</button>
						<span id="joining" class="<c:if test="${!event.attendees.contains(user)}">hidden</c:if>">Joining <a class="btn-link" href="/events/${event.id}/unjoin"><button type="button" class="btn-link">Cancel</button></a></span>
						<c:if test="${event.host.equals(user)}"><a href="/events/${event.id}/edit">Edit</a>
							<input type="hidden" name="_method" value="delete">
							<button type="submit" class="btn-link">Delete</button>
						</c:if>
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h2>Create an Event</h2>
		<form:form action="/events" method="post" modelAttribute="event">
			<div class="form-group row">
				<form:label path="name" class="col-sm-2 form-label">Name</form:label>
				<div class="col-sm-10">
					<form:input path="name" class="form-control"/>
					<form:errors path="name"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="date" class="col-sm-2 form-label">Date</form:label>
				<div class="col-sm-10">
					<form:input path="date" class="form-control" type="date"/>
					<form:errors path="date"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="location" class="col-sm-2 form-label">Location</form:label>
				<div class="col-sm-8">
					<form:input path="location" class="form-control"/>
					<form:errors path="location"/>
				</div>
				<div class="col-sm-2">
					<form:input path="state" class="form-control"/>
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