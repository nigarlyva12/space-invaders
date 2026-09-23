
public abstract class Enemy {
	protected int x;
	protected int y;
	
	Enemy(int x, int y){
		this.x = x;
		this.setY(y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
