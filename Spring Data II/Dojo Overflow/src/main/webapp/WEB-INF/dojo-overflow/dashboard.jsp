<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Questions Dashboard</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1>Questions Dashboard</h1>
		<table class="table">
			<thead>
				<tr>
					<td>Questions</td>
					<td>Tags</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
					<td>
					<c:forEach items="${question.tags}" var="tag" varStatus="status">
						<c:out value="${tag.subject}"/><c:if test="${status.count != question.tags.size()}">, </c:if>
					</c:forEach>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="text-right"><a href="/questions/new">New Question</a></div>
	</div>
</body>
</html>