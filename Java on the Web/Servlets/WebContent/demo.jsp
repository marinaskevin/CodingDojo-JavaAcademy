<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
</head>
<body>
	<!-- this is a declaration tag for methods -->
	<%! 
    public int add(int a, int b) {
        return a + b;
    }
    %>

	<!-- this is a tag for any java code -->
	<% 
    int i = 2;
    int j = 4;
    %>
	<!-- shortcut to output whatever returns from our method call %> -->
	<h3><%= add(i, j) %></h3>
	<!-- forloops work as well! -->
	<% for(int index = 0; index < 5; index++) { %>
	<h1><%= index %></h1>
	<% } %>
	<!-- here we have to import the Date class. You will put the import in the first line of the jsp tag. Use the import attribute -->
	<p>
		The time is:
		<%= new Date() %></p>
		
    <!-- getting the value for the name parameter -->
    <% String req = request.getParameter("name"); %>
    <% req = req != null ? req : "Your name goes here!"; %>
    <!-- displaying the value -->
    <h1><%= req %></h1>
</body>
</html>