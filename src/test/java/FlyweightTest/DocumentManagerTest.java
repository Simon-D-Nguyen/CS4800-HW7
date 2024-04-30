package FlyweightTest;

import org.junit.jupiter.api.*;
import Flyweight.DocumentManager;

import javax.swing.text.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DocumentManagerTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }



    @Test
    public void testCreateDocument(){
        //Given
        DocumentManager manager = new DocumentManager();

        //When
        manager.openDocument("test");
        File actual = new File("./test");

        //Then
        assertTrue(actual.exists());
    }


    @Test
    public void testAlreadyCreatedDocument(){
        //Given
        DocumentManager manager = new DocumentManager();
        DocumentManager copy = new DocumentManager();
        String expected = "Document already exists:" + System.lineSeparator();

        //When
        manager.openDocument("test1");
        out.reset();
        copy.openDocument("test1");
        String actual = out.toString();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testReadWithNoDocument() {
        //Given
        DocumentManager manager = new DocumentManager();
        String expected = "An error occured." + System.lineSeparator();

        //When
        manager.readDocument();
        String actual = out.toString();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testWriteWithNoDocument() {
        //Given
        DocumentManager manager = new DocumentManager();
        String expected = "An error occured." + System.lineSeparator();

        //When
        manager.writeToDocument('A', "Ariel", "Blue", 10);
        String actual = out.toString();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testReadNormalDoc() {
        //Given
        DocumentManager manager = new DocumentManager();
        String expected = "A => Font: Ar, Color: Blue, Size: 1 " +
                System.lineSeparator() +
                ">>> Plaintext:" +
                System.lineSeparator() +
                "A" +
                System.lineSeparator();
        String time = String.valueOf(System.currentTimeMillis());

        //When
        manager.openDocument(time);
        out.reset();
        manager.writeToDocument('A', "Ar", "Blue", 1);
        manager.readDocument();
        String actual = out.toString();

        //Then
        assertEquals(expected, actual);
    }
}
