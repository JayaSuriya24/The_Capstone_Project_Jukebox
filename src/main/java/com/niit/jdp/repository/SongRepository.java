/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    // add method
    public boolean add(Connection connection, Song song) throws SQLException {
        // write the query for selecting all  from the `song` table
        String insertQuery = "INSERT INTO `jukebox`.`song`(`name`,`artist_name`,`genre`,`song_path`) VALUES (?, ?, ?, ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            //set the values of the query parameters
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getArtistName());
            preparedStatement.setString(3, song.getGenre());
            preparedStatement.setString(4, song.getSongPath());
            // execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    //get all method
    public List<Song> getAll(Connection connection) throws SQLException {
        // write the query for selecting all  from the `song` table
        String readQuery = "SELECT * FROM `jukebox`.`song`;";
        List<Song> songsList = new ArrayList<>();
        //create a statement object
        try (Statement statement = connection.createStatement()) {
            ResultSet songsResultSet = statement.executeQuery(readQuery);
            while (songsResultSet.next()) {
                int songId = songsResultSet.getInt("song_id");
                String songName = songsResultSet.getString("song_name");
                String artistName = songsResultSet.getString("artist_name");
                String genre = songsResultSet.getString("genre");
                String songPath = songsResultSet.getString("Song path");
                //the values fetched from the result set
                Song songs = new Song(songId, songName, artistName, genre, songPath);
                songsList.add(songs);
            }
        }
        return songsList;
    }

    //get By Id
    public Song getById(Connection connection, int id) throws SQLException {
        // write the query for selecting all  from the `song` table
        String searchQuery = "SELECT * FROM `jukebox`.`song` WHERE(`id` = ?);";
        Song songs = new Song();

        //  create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet songsResultSet = preparedStatement.executeQuery();
            // check if the result set is empty
            while (songsResultSet.next()) {
                int songId = songsResultSet.getInt("song_id");
                String songName = songsResultSet.getString("song_name");
                String artistName = songsResultSet.getString("artist_name");
                String genre = songsResultSet.getString("genre");
                String songPath = songsResultSet.getString("Song path");
                //  the values fetched from the result set
                songs = new Song(songId, songName, artistName, genre, songPath);
            }
        }
        return songs;
    }

    public boolean deleteById(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM `jukebox`.`song` WHERE (`id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }
}
