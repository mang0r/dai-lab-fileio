// TODO change this to your own package instead of jehrensb ***
package ch.heig.dai.lab.fileio.mang0r;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FileReaderWriterTests {

    private final EncodingSelector selector = new EncodingSelector();
    private final FileReaderWriter readerWriter = new FileReaderWriter();


    @Test
    public void readTests () {
        File f = new File("src/test/java/ch/heig/dai/lab/fileio/mang0r/testwithcontent.txt");

        assertTrue(f.exists());

        assertEquals("hello  world\nhello  world\ntest is done", 
                     readerWriter.readFile(f, selector.getEncoding(f)));
    }

    @Test void writeTests () {
        File f = new File("src/test/java/ch/heig/dai/lab/fileio/mang0r/testwithcontent.txt");
        String testContent = "test content";

        String tmp = readerWriter.readFile(f, selector.getEncoding(f));

        readerWriter.writeFile(f, testContent, selector.getEncoding(f));
        assertEquals(testContent, readerWriter.readFile(f, selector.getEncoding(f)));

        readerWriter.writeFile(f, tmp, selector.getEncoding(f));
        assertEquals(tmp, readerWriter.readFile(f, selector.getEncoding(f)));
    }
}