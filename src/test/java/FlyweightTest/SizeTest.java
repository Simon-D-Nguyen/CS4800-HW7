package FlyweightTest;

import Flyweight.Size;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeTest {

    @Test
    public void testConstructorAndGetNum(){
        //Given
        Size tester = new Size(10);
        int expected = 10;

        //When
        int actual = tester.getNum();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testToString(){
        //Given
        Size tester = new Size(10);
        String expected = "Size: 10";

        //When
        String actual = tester.toString();

        //Then
        assertEquals(expected, actual);
    }
}
