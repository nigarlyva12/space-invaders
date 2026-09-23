import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SmallInvader extends Enemy {
	private Image smallInvaderImage;
	
	SmallInvader(int x, int y){
		super(x, y);
		try {
			smallInvaderImage = ImageIO.read(new File("imgs/small-invader.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isOutOfBound() {
		if(x>650) return true;
		return false;
	}
	public void moveRight() {
		x=x+15;
	}
	public void moveLeft() {
		x=x-15;
	}
	public Image getSmallInvaderImage() {
		return smallInvaderImage;
	}

	public void setSmallInvaderImage(Image smallInvaderImage) {
		this.smallInvaderImage = smallInvaderImage;
	}
	
	
}
