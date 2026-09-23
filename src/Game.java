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
	private Player player;
	private JFrame frame;
	private GamePanel panel;
	private List<Bullet> bullets;
	private List<SmallInvader> smallInvaders = new ArrayList<>();
	private int x=400;
	private int y=300;
	public Game() throws IOException {
		bullets = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			smallInvaders.add(new SmallInvader(x, y));
			x=x-50;
		}
		 
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
		Timer bulletTimer = new Timer(16, e -> {
		    for (Bullet b : bullets) b.move();
		    panel.repaint();
		});

		Timer invaderTimer = new Timer(500, e -> {
		    for (SmallInvader si : smallInvaders) {
		    	if(si.isOutOfBound()) break;
		    	si.moveRight();
		    }
		    for(int i=smallInvaders.size()-1; i>=0; i--) {
		    	smallInvaders.get(i).moveLeft();
		    }
		    panel.repaint();
		});

		bulletTimer.start();
		invaderTimer.start();
		
		frame.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.moveLeft();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
					player.moveRight();
				else if(e.getKeyCode() == KeyEvent.VK_SPACE)
					try {
						bullets.add(new Bullet(player.getX() + 15, player.getY(), Direction.UP));
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
