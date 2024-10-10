// File: /src/builder/FileConverter.java
package builder;

import converters.Converter;

import java.io.File;

public class FileConverter {
    private Converter converter;
    private File inputFile;
    private File outputFile;

    public FileConverter(Converter converter, File inputFile, File outputFile) {
        this.converter = converter;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void convert() throws Exception {
        converter.convert(inputFile, outputFile);
    }
}
