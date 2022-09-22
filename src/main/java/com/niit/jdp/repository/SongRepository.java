/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
