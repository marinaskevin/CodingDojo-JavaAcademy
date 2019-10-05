<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Ninjas</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<table class="table">
		    <thead>
		        <th>Dojo Name</th>
		        <th>Ninja First Name</th>
		        <th>Ninja Last Name</th>
		    </thead>
		    <tbody>
		        <c:forEach var="row" items="${ninjas}">                
		        <tr>
		            <td>${row[0].name}</td>
		            <td>${row[1].firstName}</td>
		            <td>${row[1].lastName}</td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>