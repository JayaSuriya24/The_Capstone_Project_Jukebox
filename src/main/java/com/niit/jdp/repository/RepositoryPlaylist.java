package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RepositoryPlaylist {
    List<Playlist> getAll(Connection connection) throws SQLException;

    Playlist getById(Connection connection, int id) throws SQLException;

    //delete by id
    boolean deleteById(Connection connection, int id) throws SQLException;
}
