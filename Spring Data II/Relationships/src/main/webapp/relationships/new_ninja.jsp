<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Ninja</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<div class="form-group row">
			<form:label path="dojo" class="col-sm-2 col-form-label">Dojo</form:label>
			<div class="col-sm-10">
				<form:errors path="dojo"/>
				<form:select path="dojo" class="form-control">
					<form:option value="-1" label="Choose dojo..."/>
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="firstName" class="col-sm-2 col-form-label">First Name:</form:label>
			<div class="col-sm-10">
				<form:errors path="firstName"/>
				<form:input path="firstName" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="lastName" class="col-sm-2 col-form-label">Last Name:</form:label>
			<div class="col-sm-10">
				<form:errors path="lastName"/>
				<form:input path="lastName" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="age" class="col-sm-2 col-form-label">Age:</form:label>
			<div class="col-sm-10">
				<form:errors path="age"/>
				<form:input path="age" class="form-control" type="number"/>
			</div>
		</div>
		<input type="submit" value="Create" class="btn btn-primary">
		</form:form>
	</div>
</body>
</html>