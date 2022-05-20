

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


  <style>
body {
    color: #404E67;
    background: #F5F7FA;
    font-family: 'Open Sans', sans-serif;
    margin:10px;
}
.table-wrapper {
    width: 700px;
    margin: 30px auto;
    background: #fff;
    padding: 20px;	
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {
    padding-bottom: 10px;
    margin: 0 0 10px;
}
.table-title h2 {
    margin: 6px 0 0;
    font-size: 22px;
}
.table-title .add-new {
    float: right;
    height: 30px;
    font-weight: bold;
    font-size: 12px;
    text-shadow: none;
    min-width: 100px;
    border-radius: 50px;
    line-height: 13px;
}
.table-title .add-new i {
    margin-right: 4px;
}
table.table {
    table-layout: fixed;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}
table.table th:last-child {
    width: 100px;
}
table.table td a {
    cursor: pointer;
    display: inline-block;
    margin: 0 5px;
    min-width: 24px;
}    
table.table td a.add {
    color: #27C46B;
}
table.table td a.edit {
    color: #FFC107;
}
table.table td a.delete {
    color: #E34724;
}
table.table td i {
    font-size: 19px;
}
table.table td a.add i {
    font-size: 24px;
    margin-right: -1px;
    position: relative;
    top: 3px;
}    
table.table .form-control {
    height: 32px;
    line-height: 32px;
    box-shadow: none;
    border-radius: 2px;
}
table.table .form-control.error {
    border-color: #f50000;
}
table.table td .add {
    display: none;
}
</style>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <jsp:include page="/MainJdbc"/>
        <title>Records Page</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
 
    <body>
 <div class="container-lg">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    
                    <div class="col-sm-4">
                        <input type="button" value="Add Order" class="btn btn-outline-success" onclick="window.location='orderform.jsp'" >
                    </div>
                </div>
            </div>	
        
        <table class="table table-striped table-dark">
            <tr>
                
                <th>Orders</th>
                <th>Add-on</th>
                <th>Additional Instructions</th>
                <th>Amount</th>
                <th>Edit</th>
                <th>Delete</th>
                <tbody>
            </tr>

            <%
                ResultSet results = (ResultSet) request.getAttribute("results");
                while (results.next()) {%>
            <tr>
                
                <td><%=results.getString("orders")%></td>
                <td><%=results.getString("addon")%></td>
                <td><%=results.getString("additional")%></td>
                <td><%=results.getString("amount")%></td>
                
                
                
                    <form method="get" action="updateform.jsp">
                        <input type="hidden" name="id" value="<%=results.getString("id")%>" />
                        <td><input type="submit" value="Edit"></td>
                    </form>
            
            
            <form method="get" action="${pageContext.request.contextPath}/DeleteController">
                                <input type="hidden" name="id" value="<%=results.getString("id")%>"> 
                                <button type="submit" class="btn btn-outline-danger">Delete</button>    
                            </form>
<!--                    <form method="get" action="DeleteController">
                        <input type="hidden" name="id" value="<%=results.getString("id")%>" />
                        <td><input type="submit" value="Delete"></td>
                    </form>-->
         
            </tr>	
             </tbody>
            <%	}
            %>

        </table>
        </div>
    </div>
</div>  
    </body>
   
</html>
