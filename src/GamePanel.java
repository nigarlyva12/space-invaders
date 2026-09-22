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
	private Bullet bullet;
	private Image backgroundImage;
	
	public GamePanel(Player player, Bullet bullet) throws IOException {
		this.player = player;
		this.bullet = bullet;
		backgroundImage = ImageIO.read(new File("imgs/black.jpg"));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(player.getPlayerImage(), player.getX(), player.getY(), 50, 50, null);
		g.drawImage(bullet.getBulletImage(), bullet.getX(), bullet.getY(), 50, 50 , null);
	}
}
