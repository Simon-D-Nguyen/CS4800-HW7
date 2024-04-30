package FlyweightTest;

import Flyweight.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ColorTest {

    @Test
    public void testConstructorAndGetName(){
        //Given
        Color tester = new Color("Red");
        String expected = "Red";

        //When
        String actual = tester.getName();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testEmptyString(){
        //Given
        Color tester = new Color("");
        String expected = "";

        //When
        String actual = tester.getName();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testToString(){
        //Given
        Color tester = new Color("H");
        String expected = "Color: H";

        //When
        String actual = tester.toString();

        //Then
        assertEquals(expected, actual);
    }

}
