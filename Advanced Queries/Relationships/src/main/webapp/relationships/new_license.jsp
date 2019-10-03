<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New License</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1>New License</h1>
		<form:form action="/licenses" method="post" modelAttribute="license">
		<div class="form-group row">
			<form:label path="person" class="col-sm-2 col-form-label">Person</form:label>
			<div class="col-sm-10">
				<form:errors path="person"/>
				<form:select path="person" class="form-control">
					<form:option value="-1" label="Choose person..."/>
					<c:forEach items="${persons}" var="person">
						<form:option value="${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="state" class="col-sm-2 col-form-label">State</form:label>
			<div class="col-sm-10">
				<form:errors path="state"/>
				<form:input path="state" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="expirationDate" class="col-sm-2 col-form-label">Expiration Date</form:label>
			<div class="col-sm-10">
				<form:errors path="expirationDate"/>
				<form:input path="expirationDate" class="form-control" type="date"/>
			</div>
		</div>
		<input type="submit" value="Create" class="btn btn-primary">
		</form:form>
	</div>
</body>
</html>