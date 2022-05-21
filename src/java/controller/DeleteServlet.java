/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Operations;


public class DeleteServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

//        try {
//            Class.forName(config.getInitParameter("jdbcClassName"));
//            //System.out.println("jdbcClassName: " + config.getInitParameter("jdbcClassName"));
//            String username = config.getInitParameter("dbUserName");
//            String password = config.getInitParameter("dbPassword");
//
//            StringBuffer url = new StringBuffer(config.getInitParameter("jdbcDriverURL"))
//                    .append("://")
//                    .append(config.getInitParameter("dbHostName"))
//                    .append(":")
//                    .append(config.getInitParameter("dbPort"))
//                    .append("/")
//                    .append(config.getInitParameter("databaseName"));
//            conn = DriverManager.getConnection(url.toString(), username, password);
//        } catch (SQLException sqle) {
//            System.out.println("SQLException error occured - "
//                    + sqle.getMessage());
//        } catch (ClassNotFoundException nfe) {
//            System.out.println("ClassNotFoundException error occured - "
//                    + nfe.getMessage());
//        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection conn = (Connection) session.getAttribute("conn");
        String id = request.getParameter("id");
        try {

            if (conn != null) {

                Operations delete = new Operations();
                delete.deleteAcc(conn, id);
                request.getRequestDispatcher("ViewServlet").forward(request, response);
            } else {
                System.out.println("Connection null");
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Error");
            response.sendRedirect("sqlerror.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
