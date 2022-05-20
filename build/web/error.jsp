

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Connection Error Page</title>
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
        </style>
    </head>
    <body>
        <p class="h1"><%
            out.println(getServletContext().getInitParameter("header"));
            %>
        <p><br>
        <p class="h1">Null connection</p>
        <p class="footer"><%
            out.println(getServletContext().getInitParameter("footer"));
            %></p>
    </body>
</html>
