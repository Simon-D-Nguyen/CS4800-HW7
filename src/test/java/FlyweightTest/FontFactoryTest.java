package FlyweightTest;

import Flyweight.Font;
import Flyweight.FontFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FontFactoryTest {

    @Test
    public void testGetFont() {
        //Given
        String expected = "Pop";
        FontFactory factory = new FontFactory();

        //When
        factory.getFont("Pop");
        Font returnFont = factory.getFont("Pop");
        String actual = returnFont.getName();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testUppercaseGetFont() {
        //Given
        String expected = "POP";
        FontFactory factory = new FontFactory();

        //When
        factory.getFont("Pop");
        Font returnFont = factory.getFont("Pop");
        String actual = returnFont.getName();

        //Then
        assertTrue(actual.equalsIgnoreCase(expected));
    }


    @Test
    public void testLowercaseGetFont() {
        //Given
        String expected = "pop";
        FontFactory factory = new FontFactory();

        //When
        factory.getFont("Pop");
        Font returnFont = factory.getFont("Pop");
        String actual = returnFont.getName();

        //Then
        assertTrue(actual.equalsIgnoreCase(expected));
    }


    @Test
    public void testMultipleSameFonts() {
        //Given
        FontFactory factory = new FontFactory();
        Font expected = factory.getFont("Pop");

        //When
        Font actual = factory.getFont("pop");

        //Then
        assertEquals(expected, actual);
    }

}
