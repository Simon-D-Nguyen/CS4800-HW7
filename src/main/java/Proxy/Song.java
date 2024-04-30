package Proxy;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;
    private Integer id;

    public Song(String title,
                String artist,
                String album,
                int duration,
                int id) {

        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public String getArtist() {
        return artist;
    }


    public String getAlbum() {
        return album;
    }


    public int getDuration() {
        return duration;
    }


    public Integer getId() {
        return id;
    }
}
