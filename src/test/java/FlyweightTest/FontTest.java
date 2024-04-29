package FlyweightTest;

import Flyweight.Font;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FontTest {

    @Test
    public void testConstructorAndGetName(){
        //Given
        Font testFont = new Font("Ariel");
        String expected = "Ariel";

        //When
        String actual = testFont.getName();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testEmptyString(){
        //Given
        Font testFont = new Font("");
        String expected = "";

        //When
        String actual = testFont.getName();

        //Then
        assertEquals(expected, actual);
    }

}
