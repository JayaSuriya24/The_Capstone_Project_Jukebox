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

        String insertQuery = "INSERT INTO `jukebox`.`song` " + "( `name`, `genre`,`artist`) " + "VALUES (?, ?, ?);";

        //  create a statement object
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            //  set the values of the query parameters
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getGenre());
            preparedStatement.setString(3, song.getArtist());
            //  execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    //get All
    public List<Song> getAll(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`song`;";

        List<Song> songsList = new ArrayList<>();
        //  create a statement object
        try (Statement statement = connection.createStatement()) {

            // execute the query
            ResultSet songsResultSet = statement.executeQuery(readQuery);

            //  iterate over the result set and create a list of songs objects
            while (songsResultSet.next()) {
                //  fetch the values of the current row from the result set

                int songId = songsResultSet.getInt("id");
                String songName = songsResultSet.getString("name");
                String songGenre = songsResultSet.getString("genre");
                String artist = songsResultSet.getString("artist");
                String album = songsResultSet.getString("album");
                Song songList = new Song(songId, songName, songGenre, artist, album);
                songsList.add(songList);
            }
        }
        return songsList;
    }

    //get By ID method
    public Song getById(Connection connection, int id) throws SQLException {

        String searchQuery = "SELECT * FROM `jukebox`.`song` WHERE(`id` = ?);";
        Song song = new Song();
        //  create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {

            //  set the values of the query parameters
            preparedStatement.setInt(1, id);
            //  execute the query
            ResultSet songResultSet = preparedStatement.executeQuery();
            //  check if the result set is empty
            while (songResultSet.next()) {
                //  fetch the values of the current row from the result set
                int songId = songResultSet.getInt("id");
                String songName = songResultSet.getString("name");
                String songGenre = songResultSet.getString("genre");
                String artist = songResultSet.getString("artist");
                String album = songResultSet.getString("album");
                song = new Song(songId, songName, songGenre, artist, album);
            }
        }
        return song;
    }

    //
    public boolean updateName(Connection connection, int id, String name) throws SQLException {
        String updateQuery = "UPDATE `jukebox`.`song` SET `name` = ? WHERE (`id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    //delete By ID
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
