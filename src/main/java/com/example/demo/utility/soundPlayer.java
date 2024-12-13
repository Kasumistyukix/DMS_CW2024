package com.example.demo.utility;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import java.net.URL;

/**
 * The {@code soundPlayer} class provides functionality for playing sound effects (SFX) in the game.
 * This class can be used to load and play audio files specified by their file paths.
 *
 * <p><b>Note:</b> This implementation currently has its functionality commented out to prevent build errors, and relies on
 * JavaFX's {@code Media} and {@code MediaPlayer} dependency classes to play audio. Issues with this implementation
 * was failure to recognise {@code Media} and {@code MediaPlayer} from JavaFX and Maven.</p>
 */


public class soundPlayer {
    /**
     * Plays a sound effect from the specified file path.
     *
     * @param filePath the relative file path of the sound effect to be played.
     *                 The file should be accessible in the application's resources.
     */
    public void playSFX(String filePath) {
//        try {
//            URL soundUrl = getClass().getResource(filePath);
//            if (soundUrl != null) {
//                Media sound = new Media(soundUrl.toExternalForm());
//                MediaPlayer mediaPlayer = new MediaPlayer(sound);
//                mediaPlayer.setOnEndOfMedia(mediaPlayer::dispose); // Release resources after playing
//                mediaPlayer.play();
//            } else {
//                System.out.println("Audio file not found: " + filePath);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

