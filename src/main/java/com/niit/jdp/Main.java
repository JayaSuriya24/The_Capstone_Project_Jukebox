package com.niit.jdp;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("----------------JukeBox Catalogue---------------");
            System.out.println("------------------------------------------------");
            System.out.println("Enter 1:- To View all playlist");
            System.out.println("Enter 2:- To Search full song details by playlist ID");
            System.out.println("Enter 3:- To Play song from the Playlist");
            System.out.println("Enter 4:- To Create playlist");
            System.out.println("Enter 5:- To Delete the playlist ");
            System.out.println("Enter 6:- Exit");
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.print("  => Enter your choice:- ");
            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();
            try {
                boolean connect = databaseService.connect();
                System.out.println(connect);
                databaseService.printConnectionStatus();
                Connection connection = databaseService.getConnection();
                SongRepository songRepository = new SongRepository();
                PlaylistRepository playlistRepository = new PlaylistRepository();
                MusicPlayerService musicPlayerService = new MusicPlayerService();

                switch (choice) {
                    case 1: {
                        System.out.println();
                        System.out.println("-----All the Playlist------");
                        System.out.println("---------------------------");
                        playlistRepository.getAll(connection);
                        break;
                    }
                    case 2: {

                        playlistRepository.getAll(connection);
                        System.out.println("-------------------------------------------------------");
                        System.out.println(" =>  Enter Song ID (To view full song details) :-");
                        int id = scanner.nextInt();
                        Song byId = songRepository.getById(connection, id);
                    }
                    case 3: {
                        System.out.println();
                        System.out.println("Viewing playlist to select ID");
                        System.out.println();
                        playlistRepository.getAll(connection);
                        musicPlayerService.play(connection, null);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter 1 to add song to your playlist : ");
                        int next = scanner.nextInt();
                        if (1 == next) {
                            System.out.println();
                            System.out.println(" =>Enter new Playlist Name : ");
                            String playlistName = scanner.next();
                            System.out.println("Your Playlist Name is created : " + playlistName);

                            System.out.println(" => Enter Song ID to add into the playlist :");
                            int songId = scanner.nextInt();
                            System.out.println(" => Enter Song Name to add into the playlist :- ");
                            String songName = scanner.next();
                            boolean playlist = playlistRepository.createPlaylist(connection, playlistName, songId, songName);
                            System.out.println(playlist);

                        }
                        break;
                    }
                    case 5: {
                        System.out.println();
                        System.out.println(" => Enter playlist ID to delete :- ");
                        int playlistId = scanner.nextInt();
                        playlistRepository.deleteById(connection, playlistId);
                    }
                    break;
                    case 6:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");

                }
            } catch (SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
                choice = 6;
            }
        } while (choice != 6);
    }


}
