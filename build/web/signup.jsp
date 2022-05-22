

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .background{
        background-image: url("./images/bga.jpg");
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
        <title>Sign Up Page</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <script>
            function validate()
            {
                var fullname = document.form.fullname.value;
                var email = document.form.email.value;
                var username = document.form.username.value;
                var password = document.form.password.value;
                var conpassword = document.form.conpassword.value;

                if (fullname == null || fullname == "")
                {
                    alert("Full Name can't be blank");
                    return false;
                } else if (email == null || email == "")
                {
                    alert("Email can't be blank");
                    return false;
                } else if (username == null || username == "")
                {
                    alert("Username can't be blank");
                    return false;
                } else if (password.length < 6)
                {
                    alert("Password must be at least 6 characters long.");
                    return false;
                } else if (password != conpassword)
                {
                    alert("Confirm Password should match with the Password");
                    return false;
                }
            }
        </script> 
    </head>
    <body class="background">
    <center><h2>Sign Up now to Order! </h2></center>
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">

                        <div class="card-body p-5">
                            <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
                                <table align="center">
                                    <tr>
                                        <td>Full Name</td>
                                        <td><input type="text" name="fullname" /></td>
                                    </tr>

                                    <tr>
                                        <td>Username</td>
                                        <td><input type="text" name="username" /></td>
                                    </tr>
                                    <tr>
                                        <td>Password</td>
                                        <td><input type="password" name="password" /></td>
                                    </tr>
                                    <tr>
                                        <td>Confirm Password</td>
                                        <td><input type="password" name="conpassword" /></td>
                                    </tr>
                                    <tr>
                                        <td>Role</td>
                                        <td>

                                           <input type="text" name="role" value="GUEST" readonly/>
 
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> <img src="stickyImg" /></td>

                                    </tr>
                                    <tr>
                                        <td> Enter Captcha:</td>
                                        <td><input name="answer" required/></td>
                                    </tr>

                                    <tr>
                                            <td><%=(request.getAttribute("errMessage") == null) ? ""
                 : request.getAttribute("errMessage")%></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="Register"></input><input
                                                type="reset" value="Reset"></input></td>
                                    </tr>
                                       <tr>
                                    
                                        <td>

                                            <p>Already have an account?? </p>
                                            <a href="login.jsp" >Log-In</a>
 
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
