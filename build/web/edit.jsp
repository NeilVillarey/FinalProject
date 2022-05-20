<%-- 
    Document   : edit
    Created on : May 15, 2022, 10:20:34 AM
    Author     : user
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit</title>
        <style>
            body{
                height: 100vh;
                margin: 0;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
                padding-left: 16px;
            }

            .footer{
                margin-top: auto;
            }
            
            .mb-3{
                max-width: 1000px;
                width:100%;
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
        <p class="h1"><%
            out.println(getServletContext().getInitParameter("header"));
            %>
        <p><br>
        <p class="h1">Edit</p>
        <form method="get" action="EditServlet">
            <div class="mb-3">
                <label for="website" class="form-label">Website</label>
                <input type="text" name="website" class="form-control" id="website"  value="<%=request.getParameter("website")%>"readonly>
            </div>
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" name="id" class="form-control" id="id"  value="<%=request.getParameter("id")%>"readonly>
            </div>
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" name="username" class="form-control" id="username"  value="<%=request.getParameter("username")%>"readonly>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="text" name="password" class="form-control" id="password" required>
            </div>

            <button type="submit" class="btn btn-outline-secondary">Save</button>
            <br>

        </form>
        <br>
        <a href="ViewServlet">Go back</a>
        <p class="footer"><%
            out.println(getServletContext().getInitParameter("footer"));
            %></p>
    </body>
</html>
