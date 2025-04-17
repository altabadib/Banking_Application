<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Customer.*"
    %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Deposit Successful</title>
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
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        max-width: 400px;
        width: 100%;
      }
      h1 {
        color: #4caf50;
        font-size: 24px;
        margin-bottom: 20px;
      }
      p {
        color: #555555;
        font-size: 16px;
        margin-bottom: 30px;
      }
      a {
        text-decoration: none;
        color: #ffffff;
        background-color: #4caf50;
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 14px;
        transition: background-color 0.3s ease;
        display: inline-block;
      }
      a:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Transaction Status</h1>
      <p>
        <% 
       CustomerBean bean=(CustomerBean) session.getAttribute("bean");
        out.println("Welcome"+bean.getName()+"<br>");
        String msg = (String) request.getAttribute("result"); 
          out.println(msg);  
         %>
      </p>
      <a href="indexCustomer.jsp">Go Back to Home</a>
    </div>
  </body>
</html>