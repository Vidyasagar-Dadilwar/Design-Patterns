// File: /src/converters/ExcelToPdfConverter.java
package converters;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.FileInputStream;

public class ExcelToPdfConverter implements Converter {

    @Override
    public void convert(File inputFile, File outputFile) throws Exception {
        try (FileInputStream fis = new FileInputStream(inputFile);
                Workbook workbook = new XSSFWorkbook(fis);
                PDDocument pdfDoc = new PDDocument()) {

            Sheet sheet = workbook.getSheetAt(0);
            PDPage page = new PDPage();
            pdfDoc.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(pdfDoc, page)) {
                int yPosition = 750;
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        contentStream.beginText();
                        contentStream.setFont(PDType1Font.HELVETICA, 12);
                        contentStream.newLineAtOffset(50, yPosition);
                        contentStream.showText(cell.toString());
                        contentStream.endText();
                        yPosition -= 15;
                    }
                }
            }
            pdfDoc.save(outputFile);
        }
    }
}
