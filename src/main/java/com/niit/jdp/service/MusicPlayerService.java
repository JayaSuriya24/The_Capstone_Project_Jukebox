/*
 * Author Name: M Jaya Suriya
 * Date: 9/20/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayerService {
    public void play(String songPath) {
        //  a file object that contains our song
        File songFile = new File(songPath);
        try {
            //  an object of the AudioInputStream class
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            //  get a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();
            //  use the clip object to open the audio input stream
            clip.open(audioInputStream);
            //  set a loop for the sound file
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //  start the sound file
            clip.start();
            //  pause the current thread for the time the song is being played
            long songDurationInMilliseconds = clip.getMicrosecondLength() / 1000L;
            Thread.sleep(songDurationInMilliseconds);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("song thread was interrupted");
        }
    }
}
