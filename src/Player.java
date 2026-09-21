import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private Image playerImage;
	private int x;
	private int y;
	private final int step = 10;
	
	public Player() {
		this.x = 300;
		this.y = 380;
		try {
			playerImage = ImageIO.read(new File("player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void moveLeft() {
		x=x-step;
	}
	
	public void moveRight() {
		x=x+step;
	}
	
	public Image getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(Image playerImage) {
		this.playerImage = playerImage;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
