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
		for (Projectile p : projectile1) {
			p.update();
		}
		for (Projectile p : projectile2) {
			p.update();
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		tank1.draw(g);
		tank2.draw(g);
		for (Projectile p : projectile1) {
			p.draw(g);
		}
		for (Projectile p : projectile2) {
			p.draw(g);
		}
	}

	ArrayList<Projectile> projectile1 = new ArrayList<Projectile>();
	ArrayList<Projectile> projectile2 = new ArrayList<Projectile>();

	void addProjectile(Projectile projectile, int tankNumber) {
		if(tankNumber==1) {
		projectile1.add(projectile);
		}
		if(tankNumber==2) {
		projectile2.add(projectile);
		}
	}

	void checkCollision() {
		for (Projectile b : projectile1) {

			if (b.collisionBox.intersects(tank2.collisionBox)) {
				tank2.isAlive = false;
				System.out.println("yes2");
				b.isAlive = false;

			}
		}
		for (Projectile b : projectile2) {

			if (b.collisionBox.intersects(tank1.collisionBox)) {
				tank1.isAlive = false;
				System.out.println("yes1");
				b.isAlive = false;

			}
		}
	}

	void purgeObjects() {

		for (int i = projectile1.size() - 1; i >= 0; i--) {
			if (!projectile1.get(i).isAlive) {
				projectile1.remove(i);
			}

		}
		for (int i = projectile2.size() - 1; i >= 0; i--) {
			if (!projectile2.get(i).isAlive) {
				projectile2.remove(i);
			}
		}
	}
}
