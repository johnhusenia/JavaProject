import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music extends Thread{
	static String musicPath = "musicSound.wav"; 
    
    public Music() {}

	@Override
	public void run() {
		try {
            File musicFile = new File(musicPath);
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(musicFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(musicStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
	}
}
