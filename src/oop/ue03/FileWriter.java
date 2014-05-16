package oop.ue03;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


import java.io.IOException;

/**
 * class for reading messages for files
 */
public class FileWriter {
    
    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    /*============================= LIFECYCLE ==================================*/

    public FileWriter() { }

    /*============================= OPERATIONS =================================*/

    /**
     * read a mesage from a file specified by filepath
     * @param  filePath path to the file
     * @param msg the message
     * @throws IOException [description]
     */
    public void writeMsgToFile(String filePath, String msg) throws IOException {
        Files.write(Paths.get(filePath), msg.getBytes());
    }
}
