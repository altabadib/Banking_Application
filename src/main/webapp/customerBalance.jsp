<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Customer.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Balance</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        h1 {
            font-size: 48px;
            font-weight: 700;
            color: #4CAF50;
            margin: 0;
        }

        .balance-wrapper {
            margin-top: 20px;
        }

        .balance {
            font-size: 36px;
            font-weight: 500;
            color: #333;
            background: #f4f4f4;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .balance span {
            font-size: 24px;
            font-weight: 700;
            color: #4CAF50;
        }

        .footer {
            margin-top: 20px;
            font-size: 14px;
            color: #777;
        }

        .footer a {
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Your Balance</h1>
        <div class="balance-wrapper">
        <%
       CustomerBean ab=(CustomerBean) session.getAttribute("bean");
      double balance = (double)request.getAttribute("balance");
        %>
            <div class="balance">
             Account Holder Name:<span><% out.println(ab.getName()); %></span><br>
              Balance $<span><% out.println(balance); %></span>
            </div>
        </div>
        <div class="footer">
            <p><a href="indexCustomer.jsp">Go To Home</a></p>
        </div>
    </div>

</body>
</html>
