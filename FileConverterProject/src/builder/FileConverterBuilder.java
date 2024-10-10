// File: /src/builder/FileConverterBuilder.java
package builder;

import converters.Converter;

import java.io.File;

public class FileConverterBuilder {
    private Converter converter;
    private File inputFile;
    private File outputFile;

    public FileConverterBuilder setConverter(Converter converter) {
        this.converter = converter;
        return this;
    }

    public FileConverterBuilder setInputFile(File inputFile) {
        this.inputFile = inputFile;
        return this;
    }

    public FileConverterBuilder setOutputFile(File outputFile) {
        this.outputFile = outputFile;
        return this;
    }

    public FileConverter build() {
        return new FileConverter(converter, inputFile, outputFile);
    }
}