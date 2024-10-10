// File: /src/converters/Converter.java
package converters;

import java.io.File;

public interface Converter {
    void convert(File inputFile, File outputFile) throws Exception;
}
