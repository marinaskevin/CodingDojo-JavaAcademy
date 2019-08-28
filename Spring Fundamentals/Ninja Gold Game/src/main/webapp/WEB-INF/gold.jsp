<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Your Gold: <span><c:out value="${gold}"/></span></h1>
	<div class="container">
		<form method="POST" action="/submit">
			<h1>Farm</h1>
			<h2>(earns 10-20 gold)</h2>
			<input type="hidden" name="place" value="farm">
			<button>Find Gold!</button>
		</form>
		<form method="POST" action="/submit">
			<h1>Cave</h1>
			<h2>(earns 5-10 gold)</h2>
			<input type="hidden" name="place" value="cave">
			<button>Find Gold!</button>
		</form>
		<form method="POST" action="/submit">
			<h1>House</h1>
			<h2>(earns 2-5 gold)</h2>
			<input type="hidden" name="place" value="house">
			<button>Find Gold!</button>
		</form>
		<form method="POST" action="/submit">
			<h1>Casino!</h1>
			<h2>(earns/takes 0 - 50 gold)</h2>
			<input type="hidden" name="place" value="casino">
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="container">
		<span class="messages" id="scrollbox">
			<c:choose>
				<c:when test="${messages.size() == 0}">
					<p>Welcome to Ninja Gold!</p>
				</c:when>
			</c:choose>
			<c:forEach var="message" items="${messages}">
				<c:choose>
					<c:when test="${message[1]>0}">
						<p class="earned">You entered a <c:out value="${message[0]}"/> and earned <c:out value="${message[1]}"/> gold. (<c:out value="${message[2]}"/>)</p>
					</c:when>
					<c:otherwise>
						<p class="lost">You entered a <c:out value="${message[0]}"/> and lost <c:out value="${message[1]*-1}"/> gold. (<c:out value="${message[2]}"/>)</p>				
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</span>
	</div>
	<script type="application/javascript" src="js/app.js"></script>

</body>
</html>