import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private List<Bullet> bullets;
	private List<SmallInvader> smallInvaders;
	private Image backgroundImage;
	
	public GamePanel(Player player, List<Bullet> bullets, List<SmallInvader> smallInvaders) throws IOException {
		this.player = player;
		this.bullets = bullets;
		this.smallInvaders = smallInvaders;
		backgroundImage = ImageIO.read(new File("imgs/black.jpg"));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(player.getPlayerImage(), player.getX(), player.getY(), 50, 50, null);
		for (Bullet b : bullets) {
		    g.drawImage(b.getBulletImage(), b.getX(), b.getY(), 20, 20, null);
		}
		for (SmallInvader si : smallInvaders) {
		    g.drawImage(si.getSmallInvaderImage(), si.getX(), si.getY(), 50, 50, null);
		}
	}
}
