package FlyweightTest;

import Flyweight.Color;
import Flyweight.ColorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColorFactoryTest {

    @Test
    public void testGetColor() {
        //Given
        String expected = "Red";
        ColorFactory factory = new ColorFactory();

        //When
        factory.getColor("Red");
        Color returnColor = factory.getColor("Red");
        String actual = returnColor.getName();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testUppercaseGetColor() {
        //Given
        String expected = "RED";
        ColorFactory factory = new ColorFactory();

        //When
        factory.getColor("Red");
        Color returnColor = factory.getColor("Red");
        String actual = returnColor.getName();

        //Then
        assertTrue(actual.equalsIgnoreCase(expected));
    }


    @Test
    public void testLowercaseGetColor() {
        //Given
        String expected = "red";
        ColorFactory factory = new ColorFactory();

        //When
        factory.getColor("Red");
        Color returnColor = factory.getColor("Red");
        String actual = returnColor.getName();

        //Then
        assertTrue(actual.equalsIgnoreCase(expected));
    }


    @Test
    public void testMultipleSameColors() {
        //Given
        ColorFactory factory = new ColorFactory();
        Color expected = factory.getColor("RED");

        //When
        Color actual = factory.getColor("red");

        //Then
        assertEquals(expected, actual);
    }
}
