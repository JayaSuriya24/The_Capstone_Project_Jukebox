/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

//create the class song
public class Song {
    private int id;
    private String name;
    private String artistName;
    private String genre;
    private String songPath;

    //no arguments constructor
    public Song() {
    }

    //parameterized constructor
    public Song(int id, String name, String artistName, String genre, String songPath) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.genre = genre;
        this.songPath = songPath;
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        if (id != song.id) return false;
        if (!Objects.equals(name, song.name)) return false;
        if (!Objects.equals(artistName, song.artistName)) return false;
        if (!Objects.equals(genre, song.genre)) return false;
        return Objects.equals(songPath, song.songPath);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (artistName != null ? artistName.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (songPath != null ? songPath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Song{" + "Id=" + id + ", Name='" + name + '\'' + ", artistName='" + artistName + '\'' + ", genre='" + genre + '\'' + ", songPath='" + songPath + '\'' + '}';
    }
}
