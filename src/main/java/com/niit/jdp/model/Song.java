/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.model;

public class Song {
    private int id;
    private String name;
    private String genre;

    public Song() {
    }

    public Song(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
}
