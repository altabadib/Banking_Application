<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Customer.*"
    %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Withdrawal Status</title>
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
        background: #ffffff;
        padding: 20px 30px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        text-align: center;
        max-width: 400px;
        width: 100%;
      }
      .container h1 {
        color: #4caf50;
        font-size: 24px;
        margin-bottom: 10px;
      }
      .container p {
        font-size: 16px;
        color: #333;
        margin-bottom: 20px;
      }
      .btn {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        color: #fff;
        background-color: #4caf50;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        cursor: pointer;
      }
      .btn:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Transaction Status...</h1>
      <p>
        <% 
       CustomerBean bean=(CustomerBean) session.getAttribute("bean");
        out.println("Welcome"+bean.getName()+"<br>");
        String result = (String) request.getAttribute("msg");
        out.println(result); 
        %>
      </p>
      <a href="indexCustomer.jsp" class="btn">Go to Home</a>
    </div>
  </body>
</html>