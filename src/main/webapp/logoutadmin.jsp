<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Admin.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

AdminBean ab=(AdminBean)session.getAttribute("bean");
out.println("You Are Going To LogOut"+ab.getUsername());
%>
<form action="logout">
<button>Login Out</button>
</form>
</body>
</html>