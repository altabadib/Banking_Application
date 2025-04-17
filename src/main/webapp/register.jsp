<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Registration Status</title>
<style>
body {
	background-color: #f0f8ff;
	font-family: Arial, sans-serif;
	color: #333;
	text-align: center;
	margin: 0;
	padding: 0;
}

h1 {
	margin-top: 20px;
	font-size: 2.5em;
	color: #4caf50;
}

a {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	text-decoration: none;
	color: white;
	background-color: #007bff;
	border-radius: 5px;
	font-size: 1.2em;
}

a:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>Registration Status</h1>
	<% String msg = (String) request.getAttribute("msg"); out.println("<p>" + msg + "</p>"); %>
	<a href="welcome.html">Go to Welcome Page</a>
</body>
</html>
