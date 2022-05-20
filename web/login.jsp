<%-- 
    Document   : login
    Created on : Apr 7, 2022, 2:52:37 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .background{
        background-image: url("./images/aes.jpg");
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
        <title>Login Page</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body class="background">
        <h1>LOGIN</h1>
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">

                        <div class="card-body p-5">
        <form action = "login" method="post">
            Enter username: <input type="text" name="username" required> <br>
            Enter Password: <input type="password" name="password" required> <br>
            <img src="stickyImg" /><br>
            Enter Captcha: <br> <input name="answer" required/> <br> 
            <input type ="submit" value="Login">
        </form>
     <h3> no account? click here to <a href = signup.jsp>Sign up</a> </h3>
         </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

        
    </body>
</html>
