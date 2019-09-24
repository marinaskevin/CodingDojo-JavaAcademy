<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Category Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron container">
		<h1><c:out value="${category.name}"/></h1>
		<table class="table">
			<tbody>
				<tr>
					<td>
						<h2>Products:</h2>
						<ul>
						<c:forEach items="${category.products}" var="product">
							<li><c:out value="${product.name}"/></li>
						</c:forEach>
						</ul>
					</td>
					<td>
						<form action="/categories/${category.id}/edit" method="post">
							<div class="form-group row">
								<input type="hidden" name="_method" value="put">
								<label class="col-sm-2" for="product">Add Product: </label>
								<div class="col-sm-10">
									<select name="product">
										<option value="-1">Choose a product....</option>
									<c:forEach items="${products}" var="product">
										<option value="${product.id}"><c:out value="${product.name}"/></option>
									</c:forEach>
									</select>
									<input type="submit" value="Add"/>
								</div>
							</div>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>