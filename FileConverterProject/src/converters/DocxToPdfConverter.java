// File: /src/converters/DocxToPdfConverter.java
package converters;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class DocxToPdfConverter implements Converter {

    @Override
    public void convert(File inputFile, File outputFile) throws Exception {
        try (XWPFDocument docx = new XWPFDocument(new FileInputStream(inputFile));
                PDDocument pdfDoc = new PDDocument()) {

            PDPage page = new PDPage();
            pdfDoc.addPage(page);

            try (Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile))) {
                docx.getParagraphs().forEach(p -> {
                    try {
                        writer.write(p.getText() + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            pdfDoc.save(outputFile);
        }
    }
}
