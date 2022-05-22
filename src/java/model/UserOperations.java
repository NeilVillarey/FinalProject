/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserOperations {

    Connection conn;

    public Connection establishConn(String className, String username, String password, String url,
            String hostname, String dbport, String dbname) {
        try {
            Class.forName(className);
            StringBuffer dburl = new StringBuffer(url)
                    .append("://")
                    .append(hostname)
                    .append(":")
                    .append(dbport)
                    .append("/")
                    .append(dbname);
            conn = DriverManager.getConnection(dburl.toString(), username, password);
        } catch (SQLException sqle) {
            System.out.println("SQLException error occured - "
                    + sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException nfe) {
            System.out.println("ClassNotFoundException error occured - "
                    + nfe.getMessage());
        }
        return conn;

    }

    public static ResultSet viewTable(Connection conn) {

        try {
            String query = "SELECT * FROM USERS";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet records = ps.executeQuery();
            return records;
        } catch (SQLException sqle) {
            System.out.println("SQLException error occured - "
                    + sqle.getMessage());
        }

        return null;
    }

    public static void deleteAcc(Connection conn, String sId) throws SQLException {
        try {
            if (conn != null) {
                String id = sId;
                String query = "delete FROM USERS where id=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, id);
                ps.executeUpdate();
            } else {
                System.out.println("Connection is null");
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Error");
        }
    }

    public void addAcc(Connection conn, int nid, String nusername, String nfullname, String npassword, String nrole) throws SQLException {
//        boolean add = false;
        System.out.println("Running add model");
        try {
            if (conn != null) {
                String fullname = nfullname;
                int id = nid;
                String username = nusername;
                String password = npassword;
                String role = nrole;
                String query = "INSERT INTO USERS(ID,FULLNAME,USERNAME,PASSWORD,ROLE) VALUES(?,?,?,?,?)";
                System.out.println("query made");
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, fullname);
                ps.setString(3, username);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.executeUpdate();
//                add = ps.executeUpdate() >= 1;
            } else {
                System.out.println("Conn is null");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("SQL Error");
        }
//        return add;
    }

    public static void editAcc(Connection conn, String eId, String erole) {
        System.out.println("running edit");
        try {
            if (conn != null) {
                String role = erole;
                String id = eId;
                String query = "update USERS set ROLE=? where ID = ?";
                System.out.println("query made");
                PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                ps.setString(1, role);
                ps.setString(2, id);
                ps.executeUpdate();
            } else {
                System.out.println("Conn is null");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("SQL Error");
        }
    }

//    public static double getTotalCartPrice(Connection conn, String susername) throws SQLException {
//        double sum = 0;
//        try {
//            if (conn != null) {
//
//                String username = susername;
//                String query = "select PRICE from products where username=?";
//                PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//                ps = conn.prepareStatement(query);
//                 ps.setString(1, username);
//                ps.executeUpdate();
//              
//                 ResultSet rs = ps.executeQuery();
//        
//                while (rs.next()) {
//                    sum += rs.getDouble("PRICE");
//   
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//        System.out.println(sum);
//        return sum;
//       
//    }
}
