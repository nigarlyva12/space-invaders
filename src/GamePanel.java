import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	
	public GamePanel(Player player) {
		this.player = player;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(player.getPlayerImage(), player.getX(), player.getY(), 50, 50, null);
	}
}
