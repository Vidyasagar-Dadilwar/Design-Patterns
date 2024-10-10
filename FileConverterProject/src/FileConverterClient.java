
// File: /src/FileConverterClient.java
import builder.FileConverter;
import builder.FileConverterBuilder;
import converters.DocxToPdfConverter;
import converters.ExcelToPdfConverter;
import converters.PdfToDocxConverter;
import converters.PdfToExcelConverter;

import java.io.File;

public class FileConverterClient {
    public static void main(String[] args) {
        try {
            // DOCX to PDF
            FileConverter docxToPdfConverter = new FileConverterBuilder()
                    .setConverter(new DocxToPdfConverter())
                    .setInputFile(new File("input.docx"))
                    .setOutputFile(new File("output.pdf"))
                    .build();
            docxToPdfConverter.convert();

            // PDF to DOCX
            FileConverter pdfToDocxConverter = new FileConverterBuilder()
                    .setConverter(new PdfToDocxConverter())
                    .setInputFile(new File("input.pdf"))
                    .setOutputFile(new File("output.docx"))
                    .build();
            pdfToDocxConverter.convert();

            // Excel to PDF
            FileConverter excelToPdfConverter = new FileConverterBuilder()
                    .setConverter(new ExcelToPdfConverter())
                    .setInputFile(new File("input.xlsx"))
                    .setOutputFile(new File("output.pdf"))
                    .build();
            excelToPdfConverter.convert();

            // PDF to Excel
            FileConverter pdfToExcelConverter = new FileConverterBuilder()
                    .setConverter(new PdfToExcelConverter())
                    .setInputFile(new File("input.pdf"))
                    .setOutputFile(new File("output.xlsx"))
                    .build();
            pdfToExcelConverter.convert();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
