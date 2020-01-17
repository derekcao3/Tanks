import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GamePanel {
	
	
void DrawGame() {
	
	char[][] arr = { {'x', 'x', 'x', 'x'}, 
					{'x', ' ', ' ', ' '},
					{'x', 'x', 'x', 'x'}};
	
	String maze =
			"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxx                           xxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxx                           xxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxx                           xxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxxxxxxxxxxx           xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxxxxxxxxxxx	        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxxxxxxxxxxx           xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"xxxxxxxxxxxxxxxxxxxx           xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
			"x         x                                                   x\n" +
			"x         x                                                   x\n" +
			"x         x         xxxxxxxxxxxxx                        x    x\n" +
			"x         x         xxxxxxxxxxxxx                        x    x\n" +
			"x         x                                              x    x\n" +
			"x         x                                              x    x\n" +
			"x         x                                              x    x\n" +
			"x                                                        x    x\n" +
			"x                                                        x    x\n" +
			"x         xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx              x\n" +
			"x                                                             x\n" +
			"x                                                             x\n" +
			"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n";
	int row =0;
	int column =0;
	for(int pos=0; pos<maze.length(); pos++) {
		char ch = maze.charAt(pos);
		
		column++;
		if(ch == '\n') {
			row++;
			column=0;
		}
		else {
			if(ch == 'x') {
				
				//draw wall at column, row
			}
		}
	}
}
 void drawGameState(Graphics g) {

	 
}
}