<%-- 
    Document   : adminpage
    Created on : Apr 21, 2022, 2:41:20 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .background{
        background-image: url("./images/bg.gif");
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
        <h1> <center>Hello Admin <%=request.getAttribute("username") %> !</center></h1>
<!--         <center><h1>   <img src="./images/admin.jpg" alt="guest" width="500" height="600"></h1></center>-->
  <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
    </body>
</html>

