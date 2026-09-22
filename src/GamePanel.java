import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private Image backgroundImage;
	
	public GamePanel(Player player) throws IOException {
		this.player = player;
		backgroundImage = ImageIO.read(new File("black.jpg"));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(player.getPlayerImage(), player.getX(), player.getY(), 50, 50, null);
	}
}
