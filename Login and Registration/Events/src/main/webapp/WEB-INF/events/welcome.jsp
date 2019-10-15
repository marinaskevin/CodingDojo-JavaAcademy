<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
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
					<form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
					<div class="col-sm-10">
						<form:errors path="firstName"/>
						<form:input path="firstName" class="form-control"/>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
					<div class="col-sm-10">
						<form:errors path="lastName"/>
						<form:input path="lastName" class="form-control"/>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
					<div class="col-sm-10">
						<form:errors path="email"/>
						<form:input path="email" class="form-control"/>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="location" class="col-sm-2 col-form-label">Location</form:label>
					<div class="col-sm-10">
						<form:errors path="location"/>
						<form:input path="location" class="form-control"/>
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
					<form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
					<div class="col-sm-10">
						<form:errors path="password"/>
						<form:input path="password" class="form-control" type="password"/>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="passwordConfirmation" class="col-sm-2 col-form-label">Confirm Password</form:label>
					<div class="col-sm-10">
						<form:errors path="passwordConfirmation"/>
						<form:input path="passwordConfirmation" class="form-control" type="password"/>
					</div>
				</div>
				<input type="submit" value="Register" class="btn btn-primary">
				</form:form>
			</td>
			<td>
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="user">
				<div class="form-group row">
					<form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
					<div class="col-sm-10">
						<form:errors path="email"/>
						<form:input path="email" class="form-control"/>
					</div>
				</div>
				<div class="form-group row">
					<form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
					<div class="col-sm-10">
						<form:errors path="password"/>
						<form:input path="password" class="form-control" type="password"/>
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