import java.awt.Color;
import java.awt.Graphics;

public class Tank extends GameObject{
	int speed;
	int lastFaced=0;
	//0 right 1 down 2 left 3 up
Tank(int x, int y, int width, int height) {
	super(x,y,width,height);
	speed = 5;
}

boolean left = false;
boolean right = false;
boolean down = false;
boolean up = false;

void left() {
	if (left) {
		x = x - speed;
		lastFaced =2;
	}
}

void right() {
	if (right) {
		x = x + speed;
		lastFaced = 0;
	}
}

void down() {
	if (down ) {
		y = y + speed;
		lastFaced = 1;
	}
}

void up() {
	if (up) {
		y = y - speed;
		lastFaced = 3;
	}
	
}


void draw1(Graphics g) {
	
	  g.drawImage(GamePanel.tank1ImgR, x, y, width, height, null);

	  if(lastFaced==2) {
		  g.drawImage(GamePanel.tank1ImgL, x, y, width, height, null);
}
	  else if(lastFaced==0) {
		  g.drawImage(GamePanel.tank1ImgR, x, y, width, height, null);
}
	  else if(lastFaced==3) {
		  g.drawImage(GamePanel.tank1ImgU, x, y, width, height, null);
}
	  else if(lastFaced==1) {
		  g.drawImage(GamePanel.tank1ImgD, x, y, width, height, null);
}

}

void draw2(Graphics g) {
	  
	  g.drawImage(GamePanel.tank2ImgL, x, y, width, height, null);
	  
	  if(lastFaced==2) {
		  g.drawImage(GamePanel.tank2ImgL, x, y, width, height, null);
}
	  else if(lastFaced==0) {
		  g.drawImage(GamePanel.tank2ImgR, x, y, width, height, null);
}
	  else if(lastFaced==3) {
		  g.drawImage(GamePanel.tank2ImgU, x, y, width, height, null);
}
	  else if(lastFaced==1) {
		  g.drawImage(GamePanel.tank2ImgD, x, y, width, height, null);
}

}
}
