package Reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.logging.*;

public class bestSeller {

    Document doc = new Document();

    public void bestSellerReport(ResultSet product) {
        try {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name")
                    + "\\Desktop\\" + "_" + dtf.format(now) + "Best Selling Product.pdf"));
            
            PageEvent eve = new PageEvent();
            writer.setPageEvent(eve);

            Font header = new Font(Font.FontFamily.COURIER, 18, Font.BOLD, new BaseColor(0, 0, 0));

            doc.open();
            Paragraph par = new Paragraph();
            Paragraph heading = new Paragraph("Best Selling Product", header);

            par.add(dtf.format(now) + "\n");

            par.add("Hello there!\n");

            PdfPTable table = new PdfPTable(2);
            table.addCell("Product");
            table.addCell("Quantity");

            while (product.next()) {
                table.addCell(product.getString("product")); //mangggaling sa db
                table.addCell(product.getString("quantity")); //mangggaling sa db
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

//product ng result set dapat best seller na agad and connected sia sa query ng servlet
