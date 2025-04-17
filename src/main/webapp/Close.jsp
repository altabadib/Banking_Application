<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="Admin.*"
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Account Status</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }
      .container {
        text-align: center;
        background: #fff;
        padding: 20px 40px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      }
      h1 {
        color: #4caf50;
        margin-bottom: 20px;
      }
      p {
        font-size: 1.2em;
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
    <div class="container">
      <h1>Account Status</h1>
      <p>
        <% 
        AdminBean bean=(AdminBean)session.getAttribute("bean");
        String msg = (String) request.getAttribute("result"); out.println(msg
        != null ? msg : "No status available."); %>
      </p>
      <a href="index.jsp">Go to Home</a>
    </div>
  </body>
</html>
