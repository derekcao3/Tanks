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
	Map map = new Map();
	Tank tank = new Tank(100, 100, 25, 25);

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		map.loadMap("src/maze.txt");
	}

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
				}
				else {
					g.setColor(Color.white);
					g.fillRect(j * 25, i * 25, 25, 25);

				}
			}
		}
		tank.draw(g);

	}

	void startGame() {
		timer.start();
	}

	void updateGameState() {
		tank.update();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		if (KeyEvent.VK_LEFT == e.getKeyCode()) {
			tank.left = true;
			System.out.println("no");
		} else if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
			tank.right = true;
		} else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
			tank.down = true;
		} else if (KeyEvent.VK_UP == e.getKeyCode()) {
			tank.up = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (KeyEvent.VK_LEFT == e.getKeyCode()) {
			tank.left = false;
			System.out.println("no");
		} else if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
			tank.right = false;
		} else if (KeyEvent.VK_DOWN == e.getKeyCode()) {
			tank.down = false;
		} else if (KeyEvent.VK_UP == e.getKeyCode()) {
			tank.up = false;
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