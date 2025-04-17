<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="Admin.*"
	%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Transaction Successful</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	text-align: center;
	background: #ffffff;
	padding: 20px 40px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.container h1 {
	color: #4caf50;
	margin-bottom: 20px;
}

.container p {
	font-size: 18px;
	color: #333;
}

.button {
	margin-top: 20px;
}

.button a {
	text-decoration: none;
	color: white;
	background-color: #4caf50;
	padding: 10px 20px;
	border-radius: 5px;
	font-size: 16px;
}

.button a:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Transaction Status</h1>
		<p>
			<% 
			AdminBean bean=(AdminBean)session.getAttribute("bean");
			String msg = (String) request.getAttribute("transfer"); 
        if (msg !=null) { out.println(msg); } 
        else { out.println("Amount Not deposited successfully!"); } %>
		</p>
		<div class="button">
			<a href="index.jsp">Go to Home</a>
		</div>
	</div>
</body>
</html>
