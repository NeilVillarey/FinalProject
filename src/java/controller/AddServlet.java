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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Operations;

/**
 *
 * @author Lauren
 */
public class AddServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        Connection conn = (Connection) session.getAttribute("conn");
        String website = request.getParameter("website");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
//        Operations addi = new Operations();
//        boolean add = addi.addAcc(conn, website, id, username, password);
//        
//        if(add){
//            response.sendRedirect(request.getContextPath() + "ViewServlet");
//        }else{
//            response.sendRedirect(request.getContextPath() + "/sqlerror.jsp");
//        }
        System.out.println("running addservlet");
        try {
            System.out.println("trying conn addservlet");
            if (conn != null) {
                System.out.println("trying conn addservlet");
                Operations add = new Operations();
                add.addAcc(conn, website, id, username, password);
                request.getRequestDispatcher("RedirectServlet").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
