package com.example.songr.SongDTO;

public class SongDTO {
    private String title;
    private String album;
    private int length;
    private int trackNumber;

    public SongDTO() {
    }

    public SongDTO(String title, String album, int length, int trackNumber) {
        this.title = title;
        this.album = album;
        this.length = length;
        this.trackNumber = trackNumber;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
