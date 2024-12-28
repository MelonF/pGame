package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class sounds {
    Clip clip;
    URL[] soundURL = new URL[30];


    public sounds ()
    {
        soundURL[0] = getClass().getResource("/res/sprites/sound/themeK.wav");
        soundURL[1] = getClass().getResource("/res/sprites/sound/openGate_sound.wav");
        soundURL[2] = getClass().getResource("/res/sprites/sound/pickUp_sound.wav");

        ///res/sprites/tiles/sand_tile.png
    }
    public void setFile(int i)
    {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e)
        {

        }
    }
    public void play()
    {
        clip.start();

    }
    public void loop ()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
}
