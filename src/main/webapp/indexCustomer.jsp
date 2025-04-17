<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, Customer.*" %>
<%
  CustomerBean ab = (CustomerBean) session.getAttribute("bean");
  if (ab == null) {
    request.setAttribute("msg", "User Log Out");
    request.getRequestDispatcher("cmsg.jsp").forward(request, response);
    return;
  }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>INTERNATIONAL BANK</title>
  <link rel="stylesheet" href="style.css" />
  <script>
    window.onload = function () {
      const params = new URLSearchParams(window.location.search);
      if (params.get("login") === "success") {
        alert("Login Successful!");
        const newURL = window.location.origin + window.location.pathname;
        history.replaceState(null, "", newURL);
      }
    };
  </script>
</head>
<body>
  <header id="nav">
    <div class="banking">
      <h1>BANKING APPLICATION</h1>
    </div>
    <div id="navtag">
      <div class="navlinks"><a href="home.html">Home</a></div>
      <div class="navlinks"><a href="aboutus.html">About Us</a></div>
      <div class="navlinks"><a href="contact.html">Contact Us</a></div>
    </div>
  </header>

  <main>
    <div id="main">
      <div id="option">
        <div class="btn">
        <input type="hidden">
          <button class="btntext">
            <a href="customerBalance?accno=<%= ab.getAccno() %>">Balance</a>
          </button>
        </div>
        <div class="btn">
          <button class="btntext">
            <a href="customerDepositAmount.jsp?accno=<%= ab.getAccno() %>">Deposit</a>
          </button>
        </div>
        <div class="btn">
          <button class="btntext">
            <a href="customerWithdrawAmount.jsp?accno=<%= ab.getAccno()%>">Withdraw</a>
          </button>
        </div>
        <div class="btn">
          <button class="btntext">
            <a href="customerTransferAmount.jsp?accno=<%= ab.getAccno() %>">Transfer</a>
          </button>
        </div>
        <div class="btn">
          <button class="btntext">
            <a href="customerLogout">Log Out</a>
          </button>
        </div>
      </div>
    </div>
  </main>
</body>
</html>

