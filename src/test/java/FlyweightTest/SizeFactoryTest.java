package FlyweightTest;

import Flyweight.Size;
import Flyweight.SizeFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SizeFactoryTest {


    @Test
    public void testGetSize() {
        //Given
        int expected = 10;
        SizeFactory factory = new SizeFactory();

        //When
        factory.getSize(10);
        Size tester = factory.getSize(10);
        int actual = tester.getNum();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testFromFirstCopyGetSize() {
        //Given
        int expected = 10;
        SizeFactory factory = new SizeFactory();

        //When
        Size tester = factory.getSize(10);
        int actual = tester.getNum();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testMultipleSameSizes() {
        //Given
        SizeFactory factory = new SizeFactory();
        Size expected = factory.getSize(10);

        //When
        Size actual = factory.getSize(10);

        //Then
        assertEquals(expected, actual);
    }
}
