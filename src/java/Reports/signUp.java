package Reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.logging.*;

public class signUp {

    String username;
    String role;
    Document doc = new Document();

    public void signUpReport(String name, String role, ResultSet result) {
        try {
            this.username = name;
            this.role = role;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name")
                    + "\\Desktop\\" + username + "_" + dtf.format(now) + "Sign Up.pdf"));
            
            PageEvent eve = new PageEvent();
            writer.setPageEvent(eve);

            Font header = new Font(Font.FontFamily.COURIER, 18, Font.BOLD, new BaseColor(0, 0, 0));

            doc.open();
            Paragraph par = new Paragraph();
            Paragraph heading = new Paragraph("Customers that only signed up", header);

            par.add(dtf.format(now) + "\n");

            par.add("Hello there!\n");
            par.add("User: " + username + "\n");
            par.add("Role: " + this.role + "\n");

            PdfPTable table = new PdfPTable(2);
            table.addCell("Username");
            table.addCell("Role");

            while (result.next()) {
                table.addCell(result.getString("username")); //mangggaling sa db
                table.addCell(result.getString("role")); //mangggaling sa db
            }

            //Add to doc
            doc.add(par);
            doc.add(table);
            doc.close();

            System.out.println("Report Successful");

        } catch (Exception e) {
            Logger.getLogger(allUsers.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();

        }
    }
    
    public class PageEvent extends PdfPageEventHelper {

    @Override //Header
    public void onStartPage(PdfWriter writer, Document doc) {
        PdfPTable tableHeader = new PdfPTable(1);
        Font fontTitle = new Font(Font.FontFamily.COURIER, 18, Font.BOLD, new BaseColor(0, 0, 0));

        PdfPCell cApp = new PdfPCell(new Phrase("EcoHero", fontTitle));

        cApp.setBorder(Rectangle.NO_BORDER);
        cApp.setPadding(10);

        tableHeader.addCell(cApp);

        try {
            doc.add(tableHeader);
        } catch (DocumentException ex) {
            Logger.getLogger(ds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //Footer
    public void onEndPage(PdfWriter writer, Document doc) {
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("page " + doc.getPageNumber()), 550, 30, 0);
    }

}
}