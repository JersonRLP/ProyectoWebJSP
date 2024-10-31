package Modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class PDFPrinter {
    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
            document.open();
            document.add(new Paragraph("Contenido de ejemplo para imprimir."));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
