import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	static Map map = new Map();
	
	
	Tank tank1 = new Tank(ObjectManager.tank1x, ObjectManager.tank1y, 25, 25);
	Tank tank2 = new Tank(ObjectManager.tank2x, ObjectManager.tank2y, 25, 25);
	Font titleFont;
	Font titleFont2;
	Font scoreFont;
	public static BufferedImage tank1ImgR;
	public static BufferedImage tank1ImgL;
	public static BufferedImage tank1ImgU;
	public static BufferedImage tank1ImgD;

	public static BufferedImage tank2ImgR;
	public static BufferedImage tank2ImgL;
	public static BufferedImage tank2ImgU;
	public static BufferedImage tank2ImgD;


	final int MENU_STATE = 0;

	final int GAME_STATE = 1;
	
	final int END_STATE = 2;
	
	
	
	int currentState = MENU_STATE;
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		map.loadMap("Tanks/src/maze.txt");
		titleFont = new Font("Arial", Font.PLAIN, 100);
		titleFont2 = new Font("Arial", Font.PLAIN, 20);
		scoreFont = new Font("Arial", Font.PLAIN, 80);
		try {

			tank1ImgR = ImageIO.read(this.getClass().getResourceAsStream("/tank1r.png"));
			tank1ImgL = ImageIO.read(this.getClass().getResourceAsStream("/tank1l.png"));
			tank1ImgU = ImageIO.read(this.getClass().getResourceAsStream("/tank1u.png"));
			tank1ImgD = ImageIO.read(this.getClass().getResourceAsStream("/tank1d.png"));
			
			tank2ImgR = ImageIO.read(this.getClass().getResourceAsStream("/tank2r.png"));
			tank2ImgL = ImageIO.read(this.getClass().getResourceAsStream("/tank2l.png"));
			tank2ImgU = ImageIO.read(this.getClass().getResourceAsStream("/tank2u.png"));
			tank2ImgD = ImageIO.read(this.getClass().getResourceAsStream("/tank2d.png"));
			

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	ObjectManager object = new ObjectManager(tank1, tank2);

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);
			
		} else if (currentState == GAME_STATE) {

			drawGameState(g);
	}
		else if(currentState == END_STATE) {
			
			drawEndState(g);
		}
	}

	void DrawGame() {

	}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Tanks.width, Tanks.height);
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("Tanks", 750, 150);
	g.setFont(titleFont2);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to start", 800, 328);
	g.setFont(titleFont2);
	g.setColor(Color.WHITE);
	g.drawString("Press i for instructions", 800, 500);
}

	void drawGameState(Graphics g) {

		for (int i = 0; i < map.mColumns; i++) {
			for (int j = 0; j < map.mRows; j++) {
				if (map.array[i][j] == 'x') {
					g.setColor(Color.BLACK);
					g.fillRect(j * 25, i * 25, 25, 25);
				} else {
					g.setColor(Color.white);
					g.fillRect(j * 25, i * 25, 25, 25);

				}
			}
		}
		g.setFont(scoreFont);
		g.setColor(Color.GREEN);
		g.drawString(object.score1 + "", 100, 650);
		g.setFont(scoreFont);
		g.setColor(Color.CYAN);
		g.drawString(object.score2 + "", 1300, 650);
		object.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Tanks.width, Tanks.height);
		g.fillRect(0, 0, Tanks.width, Tanks.height);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Final score: " + object.score1 + "-" + object.score2, 600, 100);
		g.setFont(titleFont2);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to resart", 800, 500);
	}
	
	void startGame() {
		timer.start();
	}

	void updateGameState() {

		object.update();
		checkCollisions();
		if(object.score1==5 || object.score2==5) {
			currentState=END_STATE;
		}
	}

	void checkCollisions() {
		checkCollisions(tank1);
		checkCollisions(tank2);
	}
	
	void checkCollisions(Tank tank) {
		int x1 = tank.x;
		int x2 = tank.x + tank.width - 1;
		int y1 = tank.y;
		int y2 = tank.y + tank.height - 1;

		
		if (tank.left == true && !map.checkCollision((x1 - tank.speed) / 25, (y1) / 25)
				&& !map.checkCollision((x1 - tank.speed) / 25, (y2) / 25)) {
			tank.left();
		}
		if (tank.right == true && !map.checkCollision((x2 + tank.speed) / 25, (y1) / 25)
				&& !map.checkCollision((x2 + tank.speed) / 25, (y2) / 25)) {
			tank.right();
		}
		if (tank.up == true && !map.checkCollision((x1) / 25, (y1 - tank.speed) / 25)
				&& !map.checkCollision((x2) / 25, (y1 - tank.speed) / 25)) {
			tank.up();
		}
		if (tank.down == true && !map.checkCollision((x1) / 25, (y2 + tank.speed) / 25)
				&& !map.checkCollision((x2) / 25, (y2 + tank.speed) / 25)) {
			tank.down();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
	

		if (KeyEvent.VK_LEFT == e.getKeyCode()) {
			tank1.left = true;
			System.out.println("no");
		} else if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
			tank1.right = true;
		} else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
			tank1.down = true;
		} else if (KeyEvent.VK_UP == e.getKeyCode()) {
			tank1.up = true;
		}
		
		if (KeyEvent.VK_A == e.getKeyCode()) {
			tank2.left = true;
			System.out.println("no");
		} else if (KeyEvent.VK_D == e.getKeyCode()) {
			tank2.right = true;
		} else if (KeyEvent.VK_S == e.getKeyCode()) {
			tank2.down = true;
		} else if (KeyEvent.VK_W == e.getKeyCode()) {
			tank2.up = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (KeyEvent.VK_LEFT == e.getKeyCode()) {
			tank1.left = false;
			System.out.println("no");
		} else if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
			tank1.right = false;
		} else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
			tank1.down = false;
		} else if (KeyEvent.VK_UP == e.getKeyCode()) {
			tank1.up = false;
		}
		if (KeyEvent.VK_SPACE == e.getKeyCode()) {
			object.addProjectile(new Projectile(tank1.x, tank1.y, 10, 10, tank1.lastFaced), 1);
			System.out.println("e");
		}
		if (KeyEvent.VK_A == e.getKeyCode()) {
			tank2.left = false;
			System.out.println("no");
		} else if (KeyEvent.VK_D == e.getKeyCode()) {
			tank2.right = false;
		} else if (KeyEvent.VK_S == e.getKeyCode()) {
			tank2.down = false;
		} else if (KeyEvent.VK_W == e.getKeyCode()) {
			tank2.up = false;
		}
		if (KeyEvent.VK_Q == e.getKeyCode()) {
			object.addProjectile(new Projectile(tank2.x, tank2.y, 10, 10, tank2.lastFaced), 2);
			System.out.println("e");
		}
		if (KeyEvent.VK_ENTER == e.getKeyCode()) {
			object.score1=0;
			object.score2=0;
			currentState = GAME_STATE;
		}
		if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
			currentState = MENU_STATE;
		}
		if (KeyEvent.VK_I == e.getKeyCode() && currentState == MENU_STATE) {
			JOptionPane.showMessageDialog(null, "Tank 1: UP DOWN LEFT RIGHT to move Space To fire");
			JOptionPane.showMessageDialog(null, "Tank 2: W A S D to move Q to fire");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == GAME_STATE) {

			updateGameState();

		} 
		repaint();
	}
}