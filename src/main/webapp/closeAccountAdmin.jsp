<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Close Account</title>
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
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
      }
      h1 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
      }
      label {
        display: block;
        margin-bottom: 8px;
        color: #555;
        font-weight: bold;
      }
      input,
      textarea,
      button {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
      }
      button {
        background-color: #ff4d4d;
        color: white;
        border: none;
        cursor: pointer;
        font-weight: bold;
      }
      button:hover {
        background-color: #e60000;
      }
      .note {
        font-size: 12px;
        color: #888;
        text-align: center;
      }
    </style>
</head>
<body>
<div class="container">
      <h1>Close Account</h1>
      <form action="closeAccount" method="post">
        <label for="accountNumber">Account Number</label>
        <input
          type="text"
          id="accountNumber"
          name="accountNumber"
          placeholder="Enter your account number"
          required
        />

        <label for="reason">Reason for Closing</label>
        <textarea
          id="reason"
          name="reason"
          rows="4"
          placeholder="Please provide a reason"
          required
        ></textarea>

        <button type="submit">Close Account</button>
      </form>
      <p class="note">
        Note: Closing your account is permanent and cannot be undone.
      </p>
    </div>
</body>
</html>