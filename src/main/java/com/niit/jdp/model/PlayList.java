/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

import java.util.List;

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
}
