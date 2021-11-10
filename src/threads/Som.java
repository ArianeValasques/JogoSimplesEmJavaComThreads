package threads;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Som {

	public Som() {
		PlayMusic();
	}
	
	public static void PlayMusic() {
		new Thread() {
			
			public void run() {
				try {
					FileInputStream in = new FileInputStream("Audio\\Street Fighter II.mp3");
					
					Player music = new Player(in);
					
					music.play();
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}
}
