import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	static Map map = new Map();
	Tank tank1 = new Tank(200, 250, 25, 25);
	Tank tank2 = new Tank(1000, 250, 25, 25);
	Font titleFont;
	Font titleFont2;
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;
	
	int currentState = MENU_STATE;
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		map.loadMap("src/maze.txt");
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titleFont2 = new Font("Arial", Font.PLAIN, 20);
	}

	ObjectManager object = new ObjectManager(tank1, tank2);

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);
	}
	}

	void DrawGame() {

	}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Tanks.width, Tanks.height);
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("Tanks", 20, 100);
	g.setFont(titleFont2);
	g.setColor(Color.WHITE);
	g.drawString("Press ENTER to start", 135, 328);
	g.setFont(titleFont2);
	g.setColor(Color.WHITE);
	g.drawString("Press SPACE for instructions", 100, 500);
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
		object.draw(g);
	}

	
	void startGame() {
		timer.start();
	}

	void updateGameState() {

		object.update();
		checkCollisions();
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

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {

			

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} 
		repaint();
	}
}