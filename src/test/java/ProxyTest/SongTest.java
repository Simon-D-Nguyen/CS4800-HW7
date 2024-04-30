package ProxyTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Proxy.Song;

public class SongTest {

    @Test
    public void testGetTitle(){
        //Given
        String expected = "No";

        //When
        Song tester = new Song("No", null, null, 0, 0);
        String actual = tester.getTitle();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetArtist(){
        //Given
        String expected = "Baylor";

        //When
        Song tester = new Song("No", "Baylor", null, 0, 0);
        String actual = tester.getArtist();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetAlbum(){
        //Given
        String expected = "ScotchTape Terrors";

        //When
        Song tester = new Song("No", null, "ScotchTape Terrors", 0, 0);
        String actual = tester.getAlbum();

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testGetDuration(){
        //Given
        int expected = 0;

        //When
        Song tester = new Song("No", null, "Terrors", 0, 0);
        int actual = tester.getDuration();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void testGetId(){
        //Given
        int expected = 0;

        //When
        Song tester = new Song("No", null, "ScotchTape Terrors", 0, 0);
        int actual = tester.getId();

        //Then
        assertEquals(expected, actual);
    }
}
