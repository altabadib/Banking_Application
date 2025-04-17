<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="Customer.*" import="Admin.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Edit Balance</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
      }
      .welcome-message {
        font-size: 20px;
        font-weight: bold;
        margin-bottom: 20px;
        text-align: center;
        color: #333;
      }
      .form-container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 300px;
        text-align: center;
      }
      label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
      }
      input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
      }
      button {
        background-color: #4caf50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }
      button:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <% AdminBean ab = (AdminBean) session.getAttribute("bean"); CustomerBean
    bean = (CustomerBean) request.getAttribute("bean"); %>

    <div class="welcome-message">Welcome: <%= ab.getUsername() %></div>

    <div class="form-container">
      <form action="update" method="post">
        <label for="balance">Enter Balance to Update:</label>
        <input
          type="text"
          id="balance"
          name="balance"
          value="<%= bean.getBalance() %>"
          required
        />

        <button type="submit">Edit</button>
      </form>
    </div>
  </body>
</html>
