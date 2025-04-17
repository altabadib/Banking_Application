<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="Customer.*" import="Admin.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Update Customer Details</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f9f9f9;
      }
      h1 {
        color: #333;
      }
      table {
        width: 50%;
        border-collapse: collapse;
        margin: 20px 0;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      }
      th,
      td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
      }
      th {
        background-color: #f4f4f4;
        color: #333;
      }
      tr:nth-child(even) {
        background-color: #f9f9f9;
      }
    </style>
  </head>
  <body>
    <% AdminBean bean = (AdminBean)session.getAttribute("bean"); 
    CustomerBean cb= (CustomerBean)request.getAttribute("customerBean"); out.println("<h1>Welcome: " + bean.getUsername() + "</h1>");
    %>

    <h2>Customer Details</h2>
    <table>
      <tr>
        <th>Field</th>
        <th>Value</th>
      </tr>
      <tr>
        <td>Customer Name</td>
        <td><%= cb.getName() %></td>
      </tr>
      <tr>
        <td>Account Number</td>
        <td><%= cb.getAccno() %></td>
      </tr>
      <tr>
        <td>Balance</td>
        <td><%= cb.getBalance() %></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><%= cb.getPassword() %></td>
      </tr>
    </table>

    <form action="deleteCustomer" method="post">
      <input type="hidden" name="customerId" value="<%= cb %>" />
      <button type="submit">Confirm Delete</button>
    </form>
  </body>
</html>
