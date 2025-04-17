<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Deposit Amount</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #6a11cb, #2575fc);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        color: #fff;
      }
      .container {
        background: #ffffff;
        padding: 20px 30px;
        border-radius: 12px;
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 400px;
        color: #333;
        text-align: center;
      }
      h1 {
        color: #4caf50;
        margin-bottom: 20px;
      }
      label {
        display: block;
        margin-bottom: 8px;
        color: #555;
      }
      input[type="text"],
      input[type="number"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 16px;
      }
      button {
        width: 100%;
        padding: 12px;
        background-color: #4caf50;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }
      button:hover {
        background-color: #45a049;
      }
      .success-message {
        margin-top: 20px;
        padding: 15px;
        background: #e8f5e9;
        color: #2e7d32;
        border: 1px solid #c8e6c9;
        border-radius: 6px;
        display: <%= request.getParameter("status") != null && request.getParameter("status").equals("success") ? "block" : "none" %>;
      }
    </style>
  </head>
  <body>
  
  <%
  Long accNo=Long.parseLong(request.getParameter("accno"));
  %>
    <div class="container">
      <h1>Deposit Amount</h1>

      <form action="customerDepositAmount" method="POST" id="depositForm">
        <label for="accountNumber">Account Number</label>
        <input
          type="text"
          id="accountNumber"
          name="accountNumber"
          value="<%=accNo %>"
          readonly
        />
        <label for="amount">Amount</label>
        <input
          type="number"
          id="amount"
          name="amount"
          placeholder="Enter amount to deposit"
          required
        />

        <button type="submit" value="submit">Deposit</button>
      </form>

      <div class="success-message" id="successMessage">
        <h2>Deposit Successful!</h2>
        <p id="accountInfo">
          <% if(request.getParameter("acc") != null)
          { 
        	  out.print("Account Number:" + request.getParameter("acc")); 
          } %>
        </p>
        <p id="amountInfo">
          <% if(request.getParameter("amt") != null){
        	  out.print("Amount: $" + request.getParameter("amt")); 
        	  } %>
        </p>
      </div>
    </div>
  </body>
</html>