/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

//create class playlist
public class PlayList {
    private int playlistId;
    private String playlistName;
    private List<Song> song;

    public PlayList() {
    }

    public PlayList(int playlistId, String playlistName, List<Song> song) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.song = song;
    }

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

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayList playList = (PlayList) o;

        if (playlistId != playList.playlistId) return false;
        if (!Objects.equals(playlistName, playList.playlistName))
            return false;
        return Objects.equals(song, playList.song);
    }

    @Override
    public int hashCode() {
        int result = playlistId;
        result = 31 * result + (playlistName != null ? playlistName.hashCode() : 0);
        result = 31 * result + (song != null ? song.hashCode() : 0);
        return result;
    }
}
