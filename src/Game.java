import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game {
	private Player player;
	private JFrame frame;

	public Game() {
		player = new Player();
		frame = new JFrame("Space Invaders");
		try {
			frame.setIconImage(ImageIO.read(new File("plane.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setSize(640, 480);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
