import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
Tank tank1;
Tank tank2;

ObjectManager(Tank tank1, Tank tank2) {
	this.tank1 = tank1;
	this.tank2 = tank2;

}


void update() {
	tank1.update();
	tank2.update();
	for (Projectile p : projectiles) {
		p.update();
	}
	purgeObjects();
}
void draw(Graphics g) {
	tank1.draw(g);
	tank2.draw(g);
	for (Projectile p : projectiles) {
		p.draw(g);
	}
}

ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
}
void purgeObjects() {

		
	
	for (int i = projectiles.size() - 1; i >= 0; i--) {
		if (!projectiles.get(i).isAlive) {
			projectiles.remove(i);
		}
	}
}
}
