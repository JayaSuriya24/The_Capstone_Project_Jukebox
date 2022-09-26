/*
 * Author Name: M Jaya Suriya
 * Date: 9/26/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;

import java.sql.*;
import java.util.List;

public class PlaylistRepository implements RepositoryPlaylist {
    //create playlist
    public boolean createPlaylist(Connection connection, String playlistName, int songId, String songName) throws SQLException {

        // write the query for inserting a new playlist object into the `playlist` table

        String insertQuery = "INSERT INTO `jukebox`.`playlist` (playlist_name, song_id,song_name) VALUES (?,?,?);";
        // create a statement object
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, playlistName);
            preparedStatement.setInt(2, songId);
            preparedStatement.setString(3, songName);

            //  execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    //get all

    @Override
    public List<Playlist> getAll(Connection connection) throws SQLException {
        // write the query for inserting a new playlist object into the `playlist` table
        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(readQuery);
            while (resultSet.next()) {
                System.out.format("%s     %n%s     %n%s     %n%s%n", "Playlist ID :" + resultSet.getInt(1) + " ", "Playlist Name :" + resultSet.getString(2) + " ", "Song ID :" + resultSet.getInt(3) + " ", "Song Name :" + resultSet.getString(4));
                System.out.println();
            }
        }
        return List.of(new Playlist());
    }

    //get by id

    @Override
    public Playlist getById(Connection connection, int id) throws SQLException {
        // write the query for inserting a new playlist object into the `playlist` table
        String searchQuery = "SELECT * FROM `jukebox`.`playlist` WHERE(`playlist_id` = ?);";
        Playlist playlist = new Playlist();
        //  create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setInt(1, id);
            // execute the query
            ResultSet playlistResultSet = preparedStatement.executeQuery();
            while (playlistResultSet.next()) {
                //  fetch the values of the current row from the result set
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                int songNumber = playlistResultSet.getInt("song_id");
                String songName = playlistResultSet.getString("song_name");
                playlist = new Playlist(playlistId, playlistName, songNumber, songName);

            }
        }
        return playlist;
    }

    //delete by id
    @Override
    public boolean deleteById(Connection connection, int id) throws SQLException {
        // write the query for in deleting a  playlist object in the `playlist` table
        String deleteQuery = "DELETE FROM `jukebox`.`playlist` WHERE (`playlist_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }


}
