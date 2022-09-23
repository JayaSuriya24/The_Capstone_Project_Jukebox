/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;


import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListRepository implements RepositoryPlaylist {
    @Override
    public boolean add(Connection connection, PlayList playList) throws SQLException {
        // write the query for inserting a new playlist object into the `playlist` table

        String insertQuery = "INSERT INTO `jukebox`.`playlist`" + "(`playlist_name`,`song_ids`)" + " VALUES (?,?);";
        //create a statement object
        int numberOfRowsAffected;
        //set values of the query parameter
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, playList.getPlaylistName());
            preparedStatement.setString(2, String.valueOf(playList.getSong()));

            //set values of the query parameter
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;

    }

    @Override
    public List<PlayList> getAll(Connection connection) throws SQLException {
        //write the query for selecting all the playlist objects from the `PLAYLIST` table
        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";
        List<Song> songList = new SongRepository().getAll(connection);
        List<PlayList> playlistList = new ArrayList<>();
        List<Song> songList1 = new ArrayList<>();
        //create a statement object
        try (Statement statement = connection.createStatement()) {
            //execute the query
            ResultSet playlistResultSet = statement.executeQuery(readQuery);
            //iterate over the result set and create a list of salesperson objects
            while (playlistResultSet.next()) {
                //fetch the values of the current row from the result set
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                int songIds = playlistResultSet.getInt("song_ids");
                Song idOfSong = songList.get(songIds - 1);
                songList1.add(idOfSong);
                PlayList playList = new PlayList(playlistId, playlistName, songList1);
                playlistList.add(playList);
            }
        }
        return playlistList;
    }

    @Override
    public PlayList getById(Connection connection, int id) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`playlist` WHERE(`playlist_id` = ?);";
        List<Song> songList = new SongRepository().getAll(connection);
        List<Song> songs = new ArrayList<>();
        PlayList playlist = new PlayList();
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet playlistResultSet = preparedStatement.executeQuery();
            //check if the result set is empty
            while (playlistResultSet.next()) {
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                int songNumber = playlistResultSet.getInt("songs");
                Song songId = songList.get(songNumber - 1);
                songs.add(songId);
                //the values fetched from the result set
                playlist = new PlayList(playlistId, playlistName, songs);
            }
        }
        return playlist;
    }


}