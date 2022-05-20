/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 import model.DBConnection;

 
public class LoginJdbc {
 
public String authenticateUser(LoginUser loginUser)
{
    String username = loginUser.getUsername();
    String password = loginUser.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String usernameDB = "";
    String passwordDB = "";
    String roleDB = "";
    
    try
    {
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select username,password,role from users");
 
        while(resultSet.next())
        {
            usernameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            roleDB = resultSet.getString("role");
           
            if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("ADMIN"))
            return "Admin_Role";
           
            else if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("GUEST"))
            return "Guest_Role";
            
            else if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("MEMBER"))
            return "Member_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}

}