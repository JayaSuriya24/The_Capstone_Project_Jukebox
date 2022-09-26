/*
 * Author Name: M Jaya Suriya
 * Date: 9/26/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SongRepository {

    //get all
    public List<Song> getAll(Connection connection) throws SQLException {
        // write the query for inserting a new song object into the `song` table
        String readQuery = "SELECT * FROM `jukebox`.`song`;";
        List<Song> songsList = new ArrayList<>();
        //  create a statement object
        try (Statement statement = connection.createStatement()) {
            // execute the query
            ResultSet songsResultSet = statement.executeQuery(readQuery);
            //  iterate over the result set and create a list of song objects
            while (songsResultSet.next()) {
                int songId = songsResultSet.getInt("song_id");
                String songName = songsResultSet.getString("song_name");
                String artistName = songsResultSet.getString("artist_name");
                String genre = songsResultSet.getString("genre");
                String duration = songsResultSet.getString("duration");
                String songPath = songsResultSet.getString("Song path");
                System.out.format("%s     %n%s     %n%s     %n%s%n", "Song ID :" + songsResultSet.getInt(1) + " ", "Song Name :" + songsResultSet.getString(2) + " ", "Artist Name :" + songsResultSet.getString(3) + " ", "Genre :" + songsResultSet.getString(4));
                System.out.println();
                //  create a song object using the values fetched from the result set
                Song songs = new Song(songId, songName, artistName, genre, duration, songPath);
                songsList.add(songs);
            }
        }
        return songsList;
    }

    //get by id

    public Song getById(Connection connection, int id) throws SQLException {
        //  write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT * FROM `jukebox`.`song` WHERE(`song_id` = ?);";
        Song songs = new Song();
        //  create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            //  set the values of the query parameters
            preparedStatement.setInt(1, id);
            //  execute the query
            ResultSet songsResultSet = preparedStatement.executeQuery();
            while (songsResultSet.next()) {
                //  fetch the values of the current row from the result set
                int songId = songsResultSet.getInt("song_id");
                String songName = songsResultSet.getString("song_name");
                String artistName = songsResultSet.getString("artist_name");
                String genre = songsResultSet.getString("genre");
                String duration = songsResultSet.getString("duration");
                String songPath = songsResultSet.getString("Song path");
                songs = new Song(songId, songName, artistName, genre, duration, songPath);

            }
        }
        return songs;
    }

    //delete by id

    public boolean deleteById(Connection connection, int id) throws SQLException {
        // write the query for in deleting a  song object in the `song` table
        String deleteQuery = "DELETE FROM `jukebox`.`song` WHERE (`song_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }


}
