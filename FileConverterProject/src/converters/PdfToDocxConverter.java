// File: /src/converters/PdfToDocxConverter.java
package converters;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileOutputStream;

public class PdfToDocxConverter implements Converter {

    @Override
    public void convert(File inputFile, File outputFile) throws Exception {
        try (PDDocument pdfDoc = PDDocument.load(inputFile);
                XWPFDocument docx = new XWPFDocument()) {

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(pdfDoc);

            XWPFParagraph paragraph = docx.createParagraph();
            paragraph.createRun().setText(text);

            try (FileOutputStream out = new FileOutputStream(outputFile)) {
                docx.write(out);
            }
        }
    }
}
