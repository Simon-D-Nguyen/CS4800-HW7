package ProxyTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import Proxy.Song;
import Proxy.MainSongServer;

import java.util.ArrayList;
import java.util.List;


public class MainSongServerTest {

    @Test
    public void testOverloadedConstructor() {
        //Given
        Song expected = new Song(null, null, null, 0);
        List<Song> list = new ArrayList<>();
        list.add(expected);
        MainSongServer server = new MainSongServer(list);

        //When
        server.addSong(expected);
        Song actual = server.searchById(0);

        //Then
        assertSame(expected, actual);
    }


    @Test
    public void testSearchById() {
        //Given
        Song expected = new Song(null, null, null, 0);
        MainSongServer server = new MainSongServer();

        //When
        server.addSong(expected);
        Song actual = server.searchById(0);

        //Then
        assertSame(expected, actual);
    }


    @Test
    public void testFailedSearchById() {
        //Given
        Song newSong = new Song(null, null, null, 0);
        MainSongServer server = new MainSongServer();
        Song expected = null;

        //When
        server.addSong(newSong);
        Song actual = server.searchById(1);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSearchByTitle() {
        //Given
        Song tester = new Song("tester", null, null, 0);
        Song dummy = new Song("dummy", null, null, 0);
        MainSongServer server = new MainSongServer();
        List<Song> expected = new ArrayList<>();
        expected.add(tester);

        //When
        server.addSong(tester);
        server.addSong(dummy);
        List<Song> actual = server.searchByTitle("tester");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testMultipleSearchByTitle() {
        //Given
        Song tester = new Song("tester", null, null, 0);
        Song tester1 = new Song("tester", null, null, 0);
        MainSongServer server = new MainSongServer();
        List<Song> expected = new ArrayList<>();
        expected.add(tester);
        expected.add(tester1);

        //When
        server.addSong(tester);
        server.addSong(tester1);
        List<Song> actual = server.searchByTitle("tester");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testFailedSearchByTitle() {
        //Given
        Song tester = new Song("tester", null, null, 0);
        MainSongServer server = new MainSongServer();
        List<Song> expected = new ArrayList<>();


        //When
        server.addSong(tester);
        List<Song> actual = server.searchByTitle("none");

        //Then
        assertEquals(expected, actual);
    }



    @Test
    public void testSearchByAlbum() {
        //Given
        Song tester = new Song("tester", null, "tester", 0);
        Song tester1 = new Song("tester", null, "2", 0);
        MainSongServer server = new MainSongServer();
        List<Song> expected = new ArrayList<>();
        expected.add(tester);

        //When
        server.addSong(tester);
        server.addSong(tester1);
        List<Song> actual = server.searchByAlbum("tester");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSearchMultipleByAlbum() {
        //Given
        Song tester = new Song("tester", null, "tester", 0);
        Song tester1 = new Song("tester", null, "tester", 0);
        MainSongServer server = new MainSongServer();
        List<Song> expected = new ArrayList<>();
        expected.add(tester);
        expected.add(tester1);

        //When
        server.addSong(tester);
        server.addSong(tester1);
        List<Song> actual = server.searchByAlbum("tester");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testFailedSearchByAlbum() {
        //Given
        Song tester = new Song("tester", null, "tester", 0);
        Song tester1 = new Song("tester", null, "2", 0);
        MainSongServer server = new MainSongServer();
        List<Song> expected = new ArrayList<>();

        //When
        server.addSong(tester);
        server.addSong(tester1);
        List<Song> actual = server.searchByAlbum("None");

        //Then
        assertEquals(expected, actual);
    }
}
