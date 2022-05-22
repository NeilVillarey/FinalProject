package Reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.logging.*;

public class regPM {

    String username;
    String role;
    String payment_method;
    String plan;
    String amount;

    public void regPMReport(String name, String role, String payment_method, String plan, String amount, ResultSet result) {
        Document doc = new Document();
        try {
            this.username = name;
            this.role = role;
            this.payment_method = payment_method;
            this.plan = plan;
            this.amount = amount;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name")
                    + "\\Desktop\\" + username + "_" + dtf.format(now) + "Registrations.pdf"));
            
            PageEvent eve = new PageEvent();
            writer.setPageEvent(eve);

            Font header = new Font(Font.FontFamily.COURIER, 18, Font.BOLD, new BaseColor(0, 0, 0));

            doc.open();
            Paragraph par = new Paragraph();
            Paragraph heading = new Paragraph("Registrations on paid membership", header);

            par.add(dtf.format(now) + "\n");

            par.add("Hello there!\n");
            par.add("User: " + username + "\n");
            par.add("Role: " + this.role + "\n");

            PdfPTable table = new PdfPTable(2);
            table.addCell("Username");
            table.addCell("Role");
            table.addCell("Payment Method");
            table.addCell("Plan");
            table.addCell("Amount");

            while (result.next()) {
                table.addCell(result.getString("username")); //mangggaling sa db
                table.addCell(result.getString("role")); //mangggaling sa db
                table.addCell(result.getString("payment method"));
                table.addCell(result.getString("plan"));
                table.addCell(result.getString("amount"));
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

            PdfPCell cProd = new PdfPCell(new Phrase("EcoHero", fontTitle));

            cProd.setBorder(Rectangle.NO_BORDER);
            cProd.setPadding(10);

            tableHeader.addCell(cProd);

            try {
                doc.add(tableHeader);
            } catch (DocumentException ex) {
                Logger.getLogger(bestSeller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override //Footer
        public void onEndPage(PdfWriter writer, Document doc) {
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("page " + doc.getPageNumber()), 550, 30, 0);
        }

    }
}
