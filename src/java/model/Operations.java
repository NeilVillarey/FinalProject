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

/**
 *
 * @author Lauren
 */
public class Operations {

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
            String query = "SELECT * FROM PRODUCTS";
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
                String query = "delete FROM PRODUCTS where id=?";
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

    public void addAcc(Connection conn, String nPRODUCT, String nId, String nUsername, int nPRICE) throws SQLException {
//        boolean add = false;
        System.out.println("Running add model");
        try {
            if (conn != null) {
                String PRODUCT = nPRODUCT;
                String id = nId;
                String username = nUsername;
                int PRICE = nPRICE;
                String query = "INSERT INTO PRODUCTS(PRODUCT,ID,USERNAME,PRICE) VALUES(?,?,?,?)";
                System.out.println("query made");
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, PRODUCT);
                ps.setString(2, id);
                ps.setString(3, username);
                ps.setInt(4, PRICE);
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

    public static void editAcc(Connection conn, String eId, String ePRICE) {
        System.out.println("running edit");
        try {
            if (conn != null) {
                String PRICE = ePRICE;
                String id = eId;
                String query = "update account_table set PRICE=? where id = ?";
                System.out.println("query made");
                PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                ps.setString(1, PRICE);
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
