package application;
import javafx.scene.image.ImageView;

public class DragonThread extends Thread {
	public void run() {
		int posx = 100;
		int posy = 100;
		Main interfaz = new Main();
		try {
			while (true) {
				Thread.sleep(50);
				interfaz.automove(400, 400);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
