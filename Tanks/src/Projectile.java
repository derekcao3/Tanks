import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
int speed = 10;
boolean left = false;
boolean right = false;
boolean down = false;
boolean up = false;

	Projectile(int x, int y, int width, int height, int lastFaced) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		switch(lastFaced){
		case 0: right = true;
		System.out.println("right");
				break;
		case 1: down = true;
		System.out.println("down");
				break;
		case 2: left = true;
		System.out.println("left");
				break;
		case 3: up = true;
		System.out.println("up");
				break;
		default: right = true;
		System.out.println(lastFaced);
		}
	}
	void update() {
		super.update();
		CheckCollision();

	}
	void draw1(Graphics g) {
		g.setColor(Color.red);
	
		 g.fillRect(x+10, y+10, width, height);
		
		}
	void draw2(Graphics g) {
		g.setColor(Color.magenta);
	
		 g.fillRect(x+10, y+10, width, height);
		
		}


	void left() {
		
			x = x - speed;
		
	}

	void right() {
		
			x = x + speed;
		
	}

	void down() {
	
		y = y + speed;

	}

	void up() {
		
			y = y - speed;
		
		
	}
	
	
	void CheckCollision(){
		int x1 = this.x;
		int x2 = this.x+this.width-1;
		int y1= this.y;
		int y2 = this.y+this.height-1;
	if(this.left==true && !GamePanel.map.checkCollision((x1-this.speed)/25,(y1)/25) && !GamePanel.map.checkCollision((x1-this.speed)/25,(y2)/25)) {
		this.left();
	}
	else if(this.right==true && !GamePanel.map.checkCollision((x2+this.speed)/25,(y1)/25) &&  !GamePanel.map.checkCollision((x2+this.speed)/25,(y2)/25)) {
		this.right();
	}
	else if(this.up==true && !GamePanel.map.checkCollision((x1)/25,(y1-this.speed)/25) &&  !GamePanel.map.checkCollision((x2)/25,(y1-this.speed)/25)) {
		this.up();
	}
	else if(this.down==true && !GamePanel.map.checkCollision((x1)/25,(y2+this.speed)/25) && !GamePanel.map.checkCollision((x2)/25,(y2+this.speed)/25) ) {
		this.down();
	}
	else {
		isAlive = false;
	}
	}
}
