<%-- 
    Document   : viewTable
    Created on : May 15, 2022, 10:19:25 AM
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.Operations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Table</title>
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

            .table{
                max-width: 1000px;
                width:100%;
            }
            img{

width:600px;

height:800px;

margin:0 auto;

vertical-align:middle;

border:2px solid green;

}

</style>
        </style>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body >
        <img src="images/GEMUGEMU.jpg" alt=""/>
        <%=session.getAttribute("tsum")%>
    </body>
</html>