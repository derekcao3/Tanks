import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Map map = new Map();

	GamePanel()  {
		map.loadMap("src/maze.txt");
		for (int i = 0; i < map.mColumns; i++) {
			for (int j = 0; j < map.mRows; j++) {
				System.out.print(map.array[i][j]);
				
			}
			System.out.print("\n");
		}
	}

	public void paintComponent() {
		
	}

	void DrawGame() {

	}

	void drawGameState(Graphics g) {

	}
}