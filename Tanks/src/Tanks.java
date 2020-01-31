import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class Tanks {
	JFrame frame;
	static final int width = 1700;
	static final int height = 700;
	GamePanel gamePanel;
public static void main(String[] args)  {
	Tanks tank = new Tanks();
	tank.setup();
}
Tanks() {
	frame = new JFrame();
	gamePanel = new GamePanel();
}

void setup() {
	frame.add(gamePanel);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(width, height);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
	frame.setVisible(true);
	gamePanel.startGame();
	frame.addKeyListener(gamePanel);
	frame.pack();
}
}
