// File: /src/converters/PdfToExcelConverter.java
package converters;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class PdfToExcelConverter implements Converter {

    @Override
    public void convert(File inputFile, File outputFile) throws Exception {
        try (PDDocument pdfDoc = PDDocument.load(inputFile);
                Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("PDF Data");
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String[] lines = pdfStripper.getText(pdfDoc).split("\n");

            int rownum = 0;
            for (String line : lines) {
                Row row = sheet.createRow(rownum++);
                row.createCell(0).setCellValue(line);
            }

            try (FileOutputStream out = new FileOutputStream(outputFile)) {
                workbook.write(out);
            }
        }
    }
}
