package oop.ue03;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


import java.io.IOException;

/**
 * class for reading messages for files
 */
public class FileReader {
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    private Charset encoding;

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    /*============================= LIFECYCLE ==================================*/

    public FileReader() {
        this.encoding = StandardCharsets.UTF_8;
    }

    /*============================= ACCESS =====================================*/

    public Charset getEncoding() { return this.encoding; }
    
    public FileReader setEncoding(Charset v) { this.encoding = v; return this; }

    /*============================= OPERATIONS =================================*/

    /**
     * read a mesage from a file specified by filepath
     * @param  filePath path to the file
     * @return content of the file as string
     * @throws IOException [description]
     */
    public String readMsgFromFile(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, encoding);
    }
}
