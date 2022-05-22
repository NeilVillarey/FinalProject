/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.DBConnection;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.time.LocalTime;

/**
 *
 * @author njvil
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String userNameID = "";
    String passwordDB = "";
    String roleDB = "";


      response.setContentType("application/pdf");
      try
      {
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select username,role from users");
        Document document = new Document();
PdfWriter.getInstance(document, response.getOutputStream());
//PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\njvil\\Documents\\Netbeanss\\TestReport.pdf"));
document.open();
LocalTime myObj = LocalTime.now();

PdfPTable table = new PdfPTable(2);
 table.addCell(new PdfPCell(new Paragraph("role")));
 table.addCell(new PdfPCell(new Paragraph("username")));

          while(resultSet.next())
        {
            userNameID = resultSet.getString("role");
                        userNameDB = resultSet.getString("username");
        table.addCell(new PdfPCell (new Paragraph(resultSet.getString("role"))));
        table.addCell(new PdfPCell (new Paragraph(resultSet.getString("username"))));
        }
    {
    document.add(table);

 
 document.close();

      }} catch(Exception de){
          throw new IOException(de.getMessage());
      
      
      }
    }
    }
