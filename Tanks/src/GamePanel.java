import java.awt.Color;
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
	Tank tank2 = new Tank(500, 250, 25, 25);

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		map.loadMap("src/maze.txt");
	}

	ObjectManager object = new ObjectManager(tank1, tank2);

	@Override
	public void paintComponent(Graphics g) {
		drawGameState(g);
	}

	void DrawGame() {

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
		int x1 = tank1.x;
		int x2 = tank1.x + tank1.width - 1;
		int y1 = tank1.y;
		int y2 = tank1.y + tank1.height - 1;

		if (tank1.left == true && !map.checkCollision((x1 - tank1.speed) / 25, (y1) / 25)
				&& !map.checkCollision((x1 - tank1.speed) / 25, (y2) / 25)) {
			tank1.left();
		}
		if (tank1.right == true && !map.checkCollision((x2 + tank1.speed) / 25, (y1) / 25)
				&& !map.checkCollision((x2 + tank1.speed) / 25, (y2) / 25)) {
			tank1.right();
		}
		if (tank1.up == true && !map.checkCollision((x1) / 25, (y1 - tank1.speed) / 25)
				&& !map.checkCollision((x2) / 25, (y1 - tank1.speed) / 25)) {
			tank1.up();
		}
		if (tank1.down == true && !map.checkCollision((x1) / 25, (y2 + tank1.speed) / 25)
				&& !map.checkCollision((x2) / 25, (y2 + tank1.speed) / 25)) {
			tank1.down();
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
			object.addProjectile(new Projectile(tank1.x, tank1.y, 10, 10, tank1.lastFaced));
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
		updateGameState();
		repaint();
	}
}