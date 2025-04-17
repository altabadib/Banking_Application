<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Account Number Form</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }
      .form-container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
      }
      h1 {
        font-size: 24px;
        color: #333;
      }
      label {
        font-size: 16px;
        color: #555;
        margin-bottom: 8px;
        display: block;
      }
      input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 16px;
        box-sizing: border-box;
      }
      input[type="submit"] {
        background-color: #4caf50;
        color: white;
        border: none;
        padding: 12px 20px;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s ease;
      }
      input[type="submit"]:hover {
        background-color: #45a049;
      }
      .error {
        color: red;
        font-size: 14px;
        margin-top: 10px;
      }
    </style>
  </head>
  <body>
    <div class="form-container">
      <h1>Account Number</h1>
      <form action="adminbalance" method="POST" id="account-form">
        <label for="account-number">Enter your account number:</label>
        <input type="text" id="account-number" name="account-number" required />
        <input type="submit" value="Submit" />
      </form>
      <div class="error" id="error-message"></div>
    </div>

    <script>
      document.addEventListener("DOMContentLoaded", function () {
        const form = document.getElementById("account-form");
        const accountNumberInput = document.getElementById("account-number");
        const errorMessage = document.getElementById("error-message");

        function validateAccountNumber() {
          const regex = /^\d{9,18}$/;
          if (!regex.test(accountNumberInput.value)) {
            errorMessage.textContent =
              "Please enter a valid account number (9-18 digits).";
            accountNumberInput.style.border = "2px solid red";
            return false;
          } else {
            errorMessage.textContent = "";
            accountNumberInput.style.border = "1px solid #ddd";
            return true;
          }
        }

        accountNumberInput.addEventListener("input", validateAccountNumber);

        form.addEventListener("submit", function (event) {
          event.preventDefault(); // Prevent default form submission behavior
          if (validateAccountNumber()) {
            form.submit(); // Manually submit the form if validation passes
          }
        });
      });
    </script>
  </body>
</html>
