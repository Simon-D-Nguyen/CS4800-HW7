package ProxyTest;

import Proxy.ProxySongServer;
import Proxy.SongService;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import Proxy.Song;
import Proxy.MainSongServer;

import java.util.ArrayList;
import java.util.List;


public class ProxySongServerTest {

    @Test
    public void testSearchById(){
        //Given
        Song expected = new Song("test", null, null, 0);
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(null, null, null, 0));
        songList.add(expected);
        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);

        //When
        Song actual = proxy.searchById(1);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testFailedSearchById(){
        //Given
        Song expected = null;
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(null, null, null, 0));
        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);

        //When
        Song actual = proxy.searchById(3);

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSearchByTitle(){
        //Given
        Song test = new Song("test", null, null, 0);
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("", null, null, 0));
        songList.add(test);
        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);
        List<Song> expected = new ArrayList<>();
        expected.add(test);

        //When
        List<Song> actual = proxy.searchByTitle("test");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testMultipleSearchByTitle(){
        //Given
        Song test = new Song("test", null, null, 0);
        Song test1 = new Song("test", null, null, 0);
        List<Song> expected = new ArrayList<>();
        expected.add(test);
        expected.add(test1);
        SongService realServer = new MainSongServer(expected);
        SongService proxy = new ProxySongServer(realServer);

        //When
        List<Song> actual = proxy.searchByTitle("test");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testFailedSearchByTitle(){
        //Given
        Song test = new Song("", null, null, 0);
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("", null, null, 0));
        songList.add(test);
        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);
        List<Song> expected = null;

        //When
        List<Song> actual = proxy.searchByTitle("test");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testSearchByAlbum(){
        //Given
        Song test = new Song("", null, "test", 0);
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("", null, "", 0));
        songList.add(test);
        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);
        List<Song> expected = new ArrayList<>();
        expected.add(test);

        //When
        List<Song> actual = proxy.searchByAlbum("test");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testMultipleSearchByAlbum(){
        //Given
        Song test = new Song(null, null, "test", 0);
        Song test1 = new Song(null, null, "test", 0);
        List<Song> expected = new ArrayList<>();
        expected.add(test);
        expected.add(test1);
        SongService realServer = new MainSongServer(expected);
        SongService proxy = new ProxySongServer(realServer);

        //When
        List<Song> actual = proxy.searchByAlbum("test");

        //Then
        assertEquals(expected, actual);
    }


    @Test
    public void testFailedSearchByAlbum(){
        //Given
        Song test = new Song("", null, "", 0);
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("", null, "", 0));
        songList.add(test);
        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);
        List<Song> expected = null;

        //When
        List<Song> actual = proxy.searchByAlbum("test");

        //Then
        assertEquals(expected, actual);
    }
}
