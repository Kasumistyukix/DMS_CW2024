package com.example.demo.utility;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;

public class sfxPlayer {
    public void sfxPlayer(String filePath) {
        try {
            URL soundUrl = getClass().getResource(filePath);
            if (soundUrl != null) {
                Media sound = new Media(soundUrl.toExternalForm());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.setOnEndOfMedia(mediaPlayer::dispose); // Release resources after playing
                mediaPlayer.play();
            } else {
                System.out.println("Audio file not found: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

