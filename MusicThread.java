import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicThread extends Thread{
	static String musicPath = "musicSound.wav"; 
    
    public MusicThread() {}

    // run method read the audio File as an InputStream, create a Clip object to control the music flow
    // start the clip with the music and keep it in a loop until main Thread finish
	@Override
	public void run() {
		try {
            File musicFile = new File(musicPath);
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(musicFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(musicStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException err) {
        	err.printStackTrace();
        }
	}
}
