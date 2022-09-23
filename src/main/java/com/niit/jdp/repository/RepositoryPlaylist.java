package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RepositoryPlaylist {
    boolean add(Connection connection, PlayList playList) throws SQLException;

    List<PlayList> getAll(Connection connection) throws SQLException;

    PlayList getById(Connection connection, int id) throws SQLException;
}
