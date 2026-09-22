import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Game {
	private Timer timer;
	private Player player;
	private JFrame frame;
	private GamePanel panel;
	private List<Bullet> bullets;
	private List<SmallInvader> smallInvaders;
	
	public Game() throws IOException {
		bullets = new ArrayList<>();
		player = new Player();
		panel = new GamePanel(player, bullets, smallInvaders);
		frame = new JFrame("Space Invaders");
		try {
			frame.setIconImage(ImageIO.read(new File("imgs/logo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.add(panel);
		frame.setSize(720, 560);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void start() {
		timer = new Timer(50, e -> {
		    for (Bullet b : bullets) {
		        b.move();
		    }
		    panel.repaint();
		});
		timer.start();
		frame.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.moveLeft();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
					player.moveRight();
				else if(e.getKeyCode() == KeyEvent.VK_SPACE)
					try {
						bullets.add(new Bullet(player.getX() +15, player.getY(), Direction.UP));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
	}
}
