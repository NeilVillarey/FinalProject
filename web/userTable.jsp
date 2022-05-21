<%-- 
    Document   : displayresult
    Created on : Sep 15, 2016, 11:45:17 AM
    Author     : lawrence
--%>

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
        <p class="h1"><%
            out.println(getServletContext().getInitParameter("header"));
            %>
        <p><br>
        <p class="h1">Accounts</p>

        <div style="overflow-x:auto;">
            <table class="table">
                <thead>
                    <tr>
                    
                        <th scope="col">ID</th>
                        <th scope="col">Fullname</th>
                     <th scope="col">Username</th>
                        <th scope="col">Role</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ResultSet results = (ResultSet) request.getAttribute("results");
                        while (results.next()) {%>
                    <tr>
                        <td><%=results.getInt("id")%></td>
                        <td><%=results.getString("fullname")%></td>
                        <td><%=results.getString("username")%></td>
                         <td><%=results.getString("role")%></td>
                         
                        <td>
                            <form method="get" action="edit.jsp">
                                  <input type="hidden" name="id"  value="<%=results.getInt("id")%>">
                                <input type="hidden" name="fullname"  value="<%=results.getString("fullname")%>">
                          
                                <input type="hidden" name="username"  value="<%=results.getString("username")%>">
                                <input type="hidden" name="role"  value="<%=results.getString("role")%>">
                                <button type="submit" class="btn btn-outline-primary">Edit</button>
                            </form>
                        <td>
                            <form method="get" action="${pageContext.request.contextPath}/DeleteServlet">
                                <input type="hidden" name="id" value="<%=results.getInt("id")%>"> 
                                <button type="submit" class="btn btn-outline-danger">Delete</button>    
                            </form>

                        </td>
                        </td>

                    </tr>	
                    <%	}
                    %>


                </tbody>
            </table>
        </div>
        <br>
        <a href="add.jsp">Add Person</a>
        <p class="footer"><%
            out.println(getServletContext().getInitParameter("footer"));
            %></p>
    </body>
</html>
