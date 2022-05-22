package Reports;

import com.itextpdf.text.pdf.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.*;

public class StamperReader {

    //Variables
    String username = "";
    String role = "";
    String reportType = "";

    public void StamperReader() {
    }

    public void Stamper(String name, String role, String reportType) {

        this.username = name;
        this.role = role;
        this.reportType = reportType;

        //Debugging
        System.out.println("Stamper.java");
        System.out.println("Username: " + this.username);
        System.out.println("Role: " + this.role + "\n");
        System.out.println("Report Type: " + this.reportType);

        //Date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try {

            //PDFReader
            System.out.println("Reader: " + "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\"
                    + username + "" + dtf.format(now) + "" + reportType + ".pdf");
            PdfReader reader = new PdfReader("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\"
                    + username + "" + dtf.format(now) + "" + reportType + ".pdf");

            //PDFStamper
            System.out.println(
                    "IsTampered: " + reader.isTampered());
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\"
                    + username + "" + dtf.format(now) + "" + reportType + "_Tampered.pdf"));

            System.out.println(
                    "IsTampered: " + reader.isTampered());
            Map<String, String> info = reader.getInfo();

            info.put("Author", role + "_" + username);
            info.put("Title", "All Users" + "" + role + "" + username);
            info.put("Subject", "Display all users");
            stamper.setMoreInfo(info);

        } catch (Exception ex) {
            Logger.getLogger(StamperReader.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

}
