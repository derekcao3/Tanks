import java.awt.Graphics;

public class ObjectManager {
Tank tank;

ObjectManager(Tank tank) {
	this.tank = tank;
}

void update() {
	tank.update();
}
void draw(Graphics g) {
	tank.draw(g);
}
}
