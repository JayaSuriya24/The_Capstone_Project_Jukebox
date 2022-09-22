/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int id;
    private String name;
    private String genre;
    private String artist;

    private String album;

    //constructors
    public Song() {
    }

    public Song(int id, String name, String genre, String artist, String album) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    //Equals and hash code method

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (id != song.id) return false;
        if (!Objects.equals(name, song.name)) return false;
        if (!Objects.equals(genre, song.genre)) return false;
        if (!Objects.equals(artist, song.artist)) return false;
        return Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (album != null ? album.hashCode() : 0);
        return result;
    }


    // To string method for playlist class
    @Override
    public String toString() {
        return "Song{" + "id=" + id + ", name='" + name + '\'' + ", genre='" + genre + '\'' + ", artist='" + artist + '\'' + ", album='" + album + '\'' + '}';
    }
}
