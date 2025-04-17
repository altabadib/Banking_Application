<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Update Status</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        color: #333;
        text-align: center;
        padding: 20px;
      }
      h1 {
        color: #4caf50;
      }
      .message {
        margin: 20px auto;
        padding: 15px;
        border: 1px solid #ddd;
        border-radius: 5px;
        background-color: #fff;
        display: inline-block;
      }
      a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #fff;
        background-color: #4caf50;
        padding: 10px 20px;
        border-radius: 5px;
        transition: background-color 0.3s;
      }
      a:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <h1>Update Status</h1>
    <div class="message">
      <% String msg = (String) request.getAttribute("msg"); out.println(msg); %>
    </div>
    <a href="index.jsp">Go to Home</a>
  </body>
</html>
