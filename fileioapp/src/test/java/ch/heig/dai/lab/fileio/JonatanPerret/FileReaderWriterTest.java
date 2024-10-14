// TODO change this to your own package instead of jehrensb ***
package ch.heig.dai.lab.fileio.JonatanPerret;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FileReaderWriterTest {

    private final FileReaderWriter readerWriter = new FileReaderWriter();

    // before each 
    public void init(){
        try{
            // write a test file
            File file = new File("file1.txt");
            file.createNewFile();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write("Hello, World!\n".getBytes());
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // after each

    @Test
    public void readFileTest() {
        File file = new File("file1.txt");
        String content = readerWriter.readFile(file, StandardCharsets.US_ASCII);
        assertEquals("Hello, World!\n", content);
    }
}