package Proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ProxySongServer implements SongService {
    private Map<Integer, Song> songsByID;
    private Map<String, List<Song>> songsByTitle;
    private Map<String, List<Song>> songsByAlbum;
    private SongService realServer;


    public ProxySongServer(SongService realServer) {
        songsByID = new HashMap<>();
        songsByTitle = new HashMap<>();
        songsByAlbum = new HashMap<>();
        this.realServer = realServer;
    }


    @Override
    public Song searchById(Integer songID) {
        if(songsByID.containsKey(songID)) {
            return songsByID.get(songID);
        }

        Song output = realServer.searchById(songID);

        if (output == null){
            System.out.println("Song could not be found");
        }
        else {
            songsByID.put(songID, output);
        }

        return output;
    }


    @Override
    public List<Song> searchByTitle(String title) {
        if(songsByTitle.containsKey(title)) {
            return songsByTitle.get(title);
        }

        List<Song> output = realServer.searchByTitle(title);

        if(output.isEmpty()) {
            System.out.println("Songs titled \'" + title + "\' could not be found.");
            return null;
        }

        songsByTitle.put(title, output);
        return output;
    }


    @Override
    public List<Song> searchByAlbum(String album) {
        if(songsByAlbum.containsKey(album)) {
            return songsByAlbum.get(album);
        }

        List<Song> output = realServer.searchByAlbum(album);

        if(output.isEmpty()) {
            System.out.println("Songs of album \'" + album + "\' could not be found.");
            return null;
        }

        songsByAlbum.put(album, output);
        return output;
    }
}
