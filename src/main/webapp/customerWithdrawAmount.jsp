<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Amount</title>
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
      .withdraw-container {
        background: #ffffff;
        padding: 20px 30px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
      }
      .withdraw-container h1 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
      }
      .form-group {
        margin-bottom: 15px;
      }
      .form-group label {
        display: block;
        margin-bottom: 5px;
        color: #555;
      }
      .form-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
      }
      .form-group input:focus {
        border-color: #007bff;
        outline: none;
      }
      .btn {
        display: block;
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
      }
      .btn:hover {
        background-color: #0056b3;
      }
    </style>
</head>
<body>
<%
Long accNo=Long.parseLong(request.getParameter("accno"));
%>
    <div class="withdraw-container">
      <h1>Withdraw Amount</h1>
      <form action="customerWithdrawAmount" method="POST">
        <div class="form-group">
      <input type="text" name="accNo" readonly placeholder="<%= accNo %>" value="<%= accNo %>">
          <label for="amount">Amount</label>
          <input
            type="number"
            id="amount"
            name="amount"
            placeholder="Enter amount to withdraw"
            required
          />
        </div>
        <button type="submit" class="btn">Withdraw</button>
      </form>
    </div>

</body>
</html>