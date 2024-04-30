package Proxy;

import java.util.List;
import java.util.ArrayList;

public class MainSongServer implements SongService {

    private ArrayList<Song> songs;


    private boolean isValidIndex(Integer index) {
        return index >= 0 && songs.size() > index;
    }


    public MainSongServer(){
        songs = new ArrayList<>();
    }


    public MainSongServer(List<Song> songs) {
        this.songs = new ArrayList<>();
        this.songs.addAll(songs);
    }


    public void addSong(Song song) {
        songs.add(song);
    }


    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        if(isValidIndex(songID)){
            return songs.get(songID);
        }

        return null;
    }


    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> output = new ArrayList<>();

        for(Song song : songs){
            if(song.getTitle().equals(title)) {
                output.add(song);
            }
        }

        return output;
    }


    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> output = new ArrayList<>();

        for(Song song : songs){
            if(song.getAlbum().equals(album)) {
                output.add(song);
            }
        }

        return output;
    }
}
