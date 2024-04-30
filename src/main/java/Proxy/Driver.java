package Proxy;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Proxy Test ===");

        List<Song> songList = new ArrayList<>();
        songList.add(new Song("First", "Number", "#", 1));
        songList.add(new Song("HW7", "Professors", "HW", 10));
        songList.add(new Song("HW6", "Professors", "HW", 2));
        songList.add(new Song("First", "Fraction", "/", 3));
        songList.add(new Song("Spudsy", "Roots", "Potato", 8));
        songList.add(new Song("Granola", "Oats", "Grainy", 4));
        songList.add(new Song("Potash", "Roots", "Potato", 1));

        SongService realServer = new MainSongServer(songList);
        SongService proxy = new ProxySongServer(realServer);


        System.out.println();
        System.out.println("---> Printing out song ID 0:...");
        Song firstSong = proxy.searchById(0);
        System.out.println(firstSong);


        System.out.println();
        System.out.println("---> Printing out the HW album:...");
        List<Song> albumHW = proxy.searchByAlbum("HW");
        if(albumHW != null) {
            for (Song song : albumHW) {
                System.out.println(song);
            }
        }

        System.out.println();
        System.out.println("---> Printing out the HW album again to test speed:...");
        List<Song> albumHWRepeat = proxy.searchByAlbum("HW");
        if(albumHWRepeat != null) {
            for (Song song : albumHWRepeat) {
                System.out.println(song);
            }
        }


        System.out.println();
        System.out.println("---> Printing out the songs titled \'First\':...");
        List<Song> titleFirst = proxy.searchByTitle("First");
        if(titleFirst != null) {
            for (Song song : titleFirst) {
                System.out.println(song);
            }
        }


        System.out.println();
        System.out.println("---> " +
                "Printing out the songs titled \'First\' " +
                "again to test speed:...");
        List<Song> titleFirst1 = proxy.searchByTitle("First");
        if(titleFirst1 != null) {
            for (Song song : titleFirst1) {
                System.out.println(song);
            }
        }


        System.out.println();
        System.out.println("---> Looking for songs with ids that don't exist...");
        Song imaginarySong = proxy.searchById(10);
        if(imaginarySong != null) {
            System.out.println(imaginarySong);
        }


        System.out.println();
        System.out.println("---> Looking for songs by titles that don't exist:...");
        List<Song> imaginaryTitle = proxy.searchByTitle("imaginary");
        if(imaginaryTitle != null) {
            for (Song song : imaginaryTitle) {
                System.out.println(song);
            }
        }


        System.out.println();
        System.out.println("---> Looking for songs by albums that don't exist:...");
        List<Song> imaginaryAlbum = proxy.searchByAlbum("imaginary");
        if(imaginaryAlbum != null) {
            for (Song song : imaginaryAlbum) {
                System.out.println(song);
            }
        }

    }
}