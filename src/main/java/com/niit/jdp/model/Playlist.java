/*
 * Author Name: M Jaya Suriya
 * Date: 9/26/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Playlist {
    //fields
    private int playlistId;
    private String playlistName;
    private int songId;
    private String songName;
    //no args constructor

    public Playlist() {
    }

    //parameterized constructor

    public Playlist(int playlistId, String playlistName, int songId, String songName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songId = songId;
        this.songName = songName;
    }

    //getter and setter

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

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

    //equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (playlistId != playlist.playlistId) return false;
        if (songId != playlist.songId) return false;
        if (!Objects.equals(playlistName, playlist.playlistName)) return false;
        return Objects.equals(songName, playlist.songName);
    }

    @Override
    public int hashCode() {
        int result = playlistId;
        result = 31 * result + (playlistName != null ? playlistName.hashCode() : 0);
        result = 31 * result + songId;
        result = 31 * result + (songName != null ? songName.hashCode() : 0);
        return result;
    }

    //to string

    @Override
    public String toString() {
        return "Playlist{" + "playlistId=" + playlistId + ", playlistName='" + playlistName + '\'' + ", songId=" + songId + ", songName='" + songName + '\'' + '}';
    }

}
