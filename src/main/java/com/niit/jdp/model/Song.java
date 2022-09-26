/*
 * Author Name: M Jaya Suriya
 * Date: 9/26/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    //fields
    private int songId;
    private String songName;
    private String artistName;
    private String genre;
    private String duration;
    private String songPath;
    //no args constructor

    public Song() {
    }

    //parameterized constructor

    public Song(int songId, String songName, String artistName, String genre, String duration, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.duration = duration;
        this.songPath = songPath;
    }

    //getter and setter

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    //equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (songId != song.songId) return false;
        if (!Objects.equals(songName, song.songName)) return false;
        if (!Objects.equals(artistName, song.artistName)) return false;
        if (!Objects.equals(genre, song.genre)) return false;
        if (!Objects.equals(duration, song.duration)) return false;
        return Objects.equals(songPath, song.songPath);
    }

    @Override
    public int hashCode() {
        int result = songId;
        result = 31 * result + (songName != null ? songName.hashCode() : 0);
        result = 31 * result + (artistName != null ? artistName.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (songPath != null ? songPath.hashCode() : 0);
        return result;
    }

    //to string

    @Override
    public String toString() {
        return "Song{" + "songId=" + songId + ", songName='" + songName + '\'' + ", artistName='" + artistName + '\'' + ", genre='" + genre + '\'' + ", duration='" + duration + '\'' + ", songPath='" + songPath + '\'' + '}';
    }

}
