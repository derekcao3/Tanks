import java.awt.Color;
import java.awt.Graphics;

public class Tank extends GameObject{
	int speed;
	
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
	}
}

void right() {
	if (right) {
		x = x + speed;
	}
}

void down() {
	if (down ) {
		y = y + speed;
	}
}

void up() {
	if (up) {
		y = y - speed;
	}
	
}
void draw(Graphics g) {
	  g.setColor(Color.GREEN);
	  g.fillRect(x, y, width, height);

}
}
