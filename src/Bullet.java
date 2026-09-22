import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet {
	private int x;
	private int y;
	private Direction direction;
	private Image bulletImage;
	private final int steps = 5;
	
	Bullet(int x, int y, Direction direction) throws IOException{
		this.x = x;
		this.y = y;
		this.direction = direction;
		
		if(direction == Direction.UP) {
			bulletImage = ImageIO.read(new File("imgs/player-shot.png"));
		}else if(direction == Direction.DOWN) {
			bulletImage = ImageIO.read(new File("imgs/enemy-shot"));
		}
	}
	
	public void move() {
		if(direction == Direction.UP) {
			y = y - steps;
		}
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Image getBulletImage() {
		return bulletImage;
	}

	public void setBulletImage(Image bulletImage) {
		this.bulletImage = bulletImage;
	}
	
	
}
