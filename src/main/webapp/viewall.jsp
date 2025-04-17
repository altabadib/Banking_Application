<%@page import="oracle.net.aso.a"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="Customer.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Bank Customers</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        color: #333;
        margin-top: 20px;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    a {
        display: block;
        text-align: center;
        margin: 20px auto;
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<h1>List Of Bank Customers</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Account Number</th>
        <th>Balance</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%
    ArrayList<CustomerBean> listofcust = (ArrayList<CustomerBean>) request.getAttribute("listOfCustomer");
    if (listofcust != null) {
        for (CustomerBean bean : listofcust) {
    %>
    <tr>
        <td><%= bean.getName() %></td>
        <td><%= bean.getAccno() %></td>
        <td><%= bean.getBalance() %></td>
        <td><%= bean.getPassword() %></td>
        <td><a href="edit?accno= <%=bean.getAccno() %>" >Edit</a></td>
        <td><a href="delete?accno= <%=bean.getAccno()%>" >Delete</a></td>
        
    </tr>
    <% 
        }
    }
    %>
</table>
<a href="index.jsp">Go to Home</a>
</body>
</html>