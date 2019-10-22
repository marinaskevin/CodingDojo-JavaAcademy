<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class="row">
		<div class="col-6">
			<p>
				Host: ${event.host.firstName} ${event.host.lastName}<br>
				Date: <fmt:formatDate value="${event.date}" pattern="MMMM d, yyyy"/><br>
				Location: ${event.location}<br>
				People who are attending this event: ${event.attendees.size()}
			</p>
			<table class="table">
				<thead>
					<tr>
						<th class="col-6">Name</th>
						<th class="col-6">Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${event.attendees}" var="attendee">
					<tr>
						<td class="col-6">${attendee.firstName} ${attendee.lastName}</td>
						<td class="col-6">${attendee.location}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-6">
			<h2>Message Wall</h2>
			<div class="btn text-left overflow-auto">
			<c:forEach items="${event.comments}" var="comment">
				<p>${comment.user.firstName} says: ${comment.message}</p>
			</c:forEach>
			</div>
			<form:form action="/events/${event.id}/comments" method="post" modelAttribute="comment">
				<form:input path="message" class="form-control"/>
				<form:errors path="message"/>
				<div class="text-right">
					<input type="submit" value="Submit" class="btn btn-primary">
				</div>
			</form:form>
		</div>
	</div>
	Return to the <a href="/events">events dashboard</a>
	</div>
</body>
</html>