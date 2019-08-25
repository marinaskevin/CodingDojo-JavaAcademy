<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dojo Survey Index</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<h1>Dojo Survey</h1>
		<form method="POST" action="/submit" class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-4 control-label" for="name">Your name:</label>
				<div class="col-sm-8">
					<input type="text" name="name" id="name" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="location">Dojo Location:</label>
				<div class="col-sm-8">
					<select name="location" id="location" class="form-control">
						<option selected disabled>Choose location...</option>
						<option value="Arlington">Arlington</option>
						<option value="Berkeley">Berkeley</option>
						<option value="Boise">Boise</option>
						<option value="Chicago">Chicago</option>
						<option value="Dallas">Dallas</option>
						<option value="Los Angeles">Los Angeles</option>
						<option value="Orange County">Orange County</option>
						<option value="Seattle">Seattle</option>
						<option value="Silicon Valley">Silicon Valley</option>
						<option value="Tulsa">Tulsa</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="language">Favorite language:</label>
				<div class="col-sm-8">
					<select name="language" id="language" class="form-control">
						<option selected disabled>Choose language...</option>
						<option value="Javascript">Javascript</option>
						<option value="Python">Python</option>
						<option value="C#.NET">C#.NET</option>
						<option value="MEAN">MEAN</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label" for="comment">Comment (optional):</label>
				<div class="col-sm-8">
					<textarea name="comment" id="comment" rows="5" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>