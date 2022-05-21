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
        </style>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <br>
        <p class="h1">Accounts</p>

        <div style="overflow-x:auto;">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Product</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                <tbody>

                    <% String userNameDB = "";
                       {%>
                    <%
                        ResultSet results = (ResultSet) request.getAttribute("results");
                         int sum = 0;
                        while (results.next()) {%>
                    <%          String user=(String)session.getAttribute("username");
                    userNameDB = results.getString("username");
                    request.setAttribute("testing", userNameDB);
                     if(userNameDB.equals(session.getAttribute("username")) ){
                          {%>
                    <tr>
                        <td><%=results.getString("product")%></td>
                        <td><%=results.getString("id")%></td>
                        <td><%=results.getInt("price")%></td>
                          <%sum +=results.getInt("price");%>     
                        <td><%	}
                    %>
                            <form method="get" action="edit.jsp">
                                <input type="hidden" name="product"  value="<%=results.getString("product")%>">
                                <input type="hidden" name="id"  value="<%=results.getString("id")%>">
                                <input type="hidden" name="username"  value=<%request.getAttribute("username");%>>
                                <input type="hidden" name="price"  value="<%=results.getInt("price")%>">
                                <button type="submit" class="btn btn-outline-primary">Edit</button>
                            </form>
                        <td>
                            <form method="get" action="${pageContext.request.contextPath}/DeleteServlet">
                                <input type="hidden" name="id" value="<%=results.getString("id")%>"> 
                                <button type="submit" class="btn btn-outline-danger">Delete</button>    
                            </form>

                        </td>
                        </td>

                    </tr>	
                    <%	}
                    %>
                    <%	}
                    %>
                    <td>Total price is :<%=sum%></td>
                    <%	}
                    %>
                </tbody>
            </table>
        </div>
              
        <br>
        <a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
        <a href="add.jsp">Add Person</a>

    </body>
</html>