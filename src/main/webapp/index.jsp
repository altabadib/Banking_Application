<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="Admin.*" import="BankApplication.*"
import="java.util.*"%>
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
    <% AdminBean ab=(AdminBean) session.getAttribute("bean"); 
    if(ab==null){
    request.setAttribute("msg", "User Log Out");
    request.getRequestDispatcher("msg.jsp").forward(request, response); } else{
    String msg=(String)request.getAttribute("msg"); } %>
    <header id="nav">
      <div class="banking">
        <h1>BANKING APPLICATION</h1>
      </div>
      <div id="navtag">
        <div class="navlinks">
          <a href="home.html">Home</a>
        </div>
        <div class="navlinks">
          <a href="aboutus.html">About Us</a>
        </div>
        <div class="navlinks">
          <a href="contact.html">Contact Us</a>
        </div>
      </div>
    </header>
    <main>
      <div id="main">
        <div id="option">
          <div class="btn">
            <form action="view" method="post">
              <button class="btntext" style="color: blue">View All</button>
            </form>
          </div>
          <div class="btn">
            <button class="btntext">
              <a href="adminbalance.jsp">Balance</a>
            </button>
          </div>
          <div class="btn">
            <button class="btntext">
              <a href="depositAmountAdmin.jsp">Deposit</a>
            </button>
          </div>
          <div class="btn">
            <button class="btntext">
              <a href="withdrawAmount.jsp">Withdraw</a>
            </button>
          </div>
          <div class="btn">
            <button class="btntext">
              <a href="transferAmountAdmin.jsp">Transfer</a>
            </button>
          </div>
          <div class="btn">
            <button class="btntext">
              <a href="closeAccountAdmin.jsp">Close Account</a>
            </button>
          </div>
           <div class="btn">
            <button class="btntext">
              <a href="logoutadmin.jsp">Log Out</a>
            </button>
          </div>
        </div>
      </div>
    </main>
  </body>
</html>
