package com.example.AAAAAAAAAA;

public class Song extends MusicItem {
    private String artist;
    private int duration;
    private String genre;

    public Song() {
        super("");
    }

    public Song(String title, String artist, int duration, String genre) {
        super(title);
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String getInfo() { return title + " - " + artist; }
}
