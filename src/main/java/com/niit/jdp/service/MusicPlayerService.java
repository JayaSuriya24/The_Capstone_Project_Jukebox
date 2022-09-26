/*
 * Author Name: M Jaya Suriya
 * Date: 9/26/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MusicPlayerService {
    public void play(Connection connection, String songPath) throws SQLException {

        int songID;
        try (Statement statement = connection.createStatement()) {
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println(" => Enter Song ID (To play your song) :- ");
            songID = input.nextInt();
            statement.executeQuery("SELECT * FROM `playlist` WHERE song_id = '" + songID + "'");
        }
        if (songID == 1) {
            songPath = "src/main/resources/songs/akon.wav";
        } else if (songID == 2) {
            songPath = "src/main/resources/songs/Fast and Furious.wav";
        } else if (songID == 3) {
            songPath = "src/main/resources/songs/Fast and Furious.wav";
        } else if (songID == 4) {
            songPath = "src/main/resources/songs/Jack Sparrow.wav";
        } else if (songID == 5) {
            songPath = "src/main/resources/songs/smack that.wav";
        }
        File songFile = new File(songPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Scanner sc = new Scanner(System.in);
            int input;
            int temp = 0;
            long clippo = 0;

            while (temp == 0) {
                System.out.println("\nEnter your Choice\n------- ---- -------\n1.Pause\n2.Resume\n3.Restart\n4.Stop and Exit");
                input = sc.nextInt();
                switch (input) {
                    case 1: {
                        clippo = clip.getMicrosecondPosition();
                        clip.stop();
                        System.out.println();
                        System.out.println("Song Paused");
                        break;
                    }
                    case 2: {
                        clip.setMicrosecondPosition(clippo);
                        clip.start();
                        System.out.println();
                        System.out.println("Song Resumed");

                        break;
                    }
                    case 3: {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        System.out.println();
                        System.out.println("Song Restarted");

                        break;
                    }

                    case 4: {
                        clip.stop();
                        System.out.println("Stop and Exit");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice!!");
                        break;
                    }
                }
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
            exception.printStackTrace();
        }
    }

}
