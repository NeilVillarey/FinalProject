<%-- 
    Document   : guestpage
    Created on : Apr 21, 2022, 2:41:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .background{
        background-image: url("./images/backg.gif");
       background-size: cover;

  height: 100vh;
 text-align: center; 
  background-position: center;
  background-repeat: no-repeat;
        
    }

</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="background">
    <center><h1>Welcome Guest <%=request.getAttribute("username") %> !</h1></center>
 <a href="<%=request.getContextPath()%>/ViewServlet">Cart</a>
      <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
    </body>
</html>