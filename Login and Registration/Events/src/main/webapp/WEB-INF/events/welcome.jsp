<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
	<table class="table">
		<tr>
			<td>
				<h1>Welcome</h1>
			</td>
		</tr>
		<tr>
			<td>
				<h2>Register</h2>
				<form:form action="/users" method="post" modelAttribute="user">
				<div class="form-group row">
					<form:label path="firstName" class="col-sm-4 col-form-label">First Name</form:label>
					<div class="col-sm-8">
						<form:input path="firstName" class="form-control"/>
						<small class="text-danger"><form:errors path="firstName"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="lastName" class="col-sm-4 col-form-label">Last Name</form:label>
					<div class="col-sm-8">
						<form:input path="lastName" class="form-control"/>
						<small class="text-danger"><form:errors path="lastName"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="email" class="col-sm-4 col-form-label">Email</form:label>
					<div class="col-sm-8">
						<form:input path="email" class="form-control"/>
						<small class="text-danger"><form:errors path="email"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="location" class="col-sm-4 col-form-label">Location</form:label>
					<div class="col-sm-8">
						<form:input path="location" class="form-control"/>
						<small class="text-danger"><form:errors path="location"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="state" class="col-sm-4 col-form-label">State</form:label>
					<div class="col-sm-8">
						<form:input path="state" class="form-control"/>
						<small class="text-danger"><form:errors path="state"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="password" class="col-sm-4 col-form-label">Password</form:label>
					<div class="col-sm-8">
						<form:input path="password" class="form-control" type="password"/>
						<small class="text-danger"><form:errors path="password"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="passwordConfirmation" class="col-sm-4 col-form-label">Confirm Password</form:label>
					<div class="col-sm-8">
						<form:input path="passwordConfirmation" class="form-control" type="password"/>
						<small class="text-danger"><form:errors path="passwordConfirmation"/></small>
					</div>
				</div>
				<input type="submit" value="Register" class="btn btn-primary">
				</form:form>
			</td>
			<td>
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="user">
				<div class="form-group row">
					<form:label path="email" class="col-sm-4 col-form-label">Email</form:label>
					<div class="col-sm-8">
						<form:input path="email" class="form-control"/>
						<small class="text-danger"><form:errors path="email"/></small>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="password" class="col-sm-4 col-form-label">Password</form:label>
					<div class="col-sm-8">
						<form:input path="password" class="form-control" type="password"/>
						<small class="text-danger"><form:errors path="password"/></small>
					</div>
				</div>
				<input type="submit" value="Login" class="btn btn-primary">
				</form:form>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>