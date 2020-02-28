import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Tank tank1;
	Tank tank2;
	static int tank1x = 200;
	static int tank1y = 250;
	static int tank2x = 1000;
	static int tank2y = 250;
	int score1 =0;
	int score2 =0;

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
		
		tank1.draw1(g);
		tank2.draw2(g);
		for (Projectile p : projectile1) {
			p.draw1(g);
		}
		for (Projectile p : projectile2) {
			p.draw2(g);
		}
	}

	ArrayList<Projectile> projectile1 = new ArrayList<Projectile>();
	ArrayList<Projectile> projectile2 = new ArrayList<Projectile>();

	void addProjectile(Projectile projectile, int tankNumber) {
		if (tankNumber == 1) {
			projectile1.add(projectile);
		}
		if (tankNumber == 2) {
			projectile2.add(projectile);
		}
	}

	void checkCollision() {
		for (Projectile b : projectile1) {

			if (b.collisionBox.intersects(tank2.collisionBox)) {
				tank2.isAlive = false;
				System.out.println("yes2");
				b.isAlive = false;
				purgeProjectiles();
			}
		}
		for (Projectile b : projectile2) {

			if (b.collisionBox.intersects(tank1.collisionBox)) {
				tank1.isAlive = false;
				System.out.println("yes1");
				b.isAlive = false;
				purgeProjectiles();
			}
		}
	}

	void purgeProjectiles() {
		for (Projectile b : projectile1) {
				b.isAlive = false;

		}
		for (Projectile b : projectile2) {
			b.isAlive = false;

	}
	}
	void purgeObjects() {

		for (int i = projectile1.size() - 1; i >= 0; i--) {
			if (!projectile1.get(i).isAlive) {
				projectile1.remove(i);
			}

		}

		if (tank1.isAlive == false) {
			tank1.x = tank1x;
			tank1.y = tank1y;
			tank2.x = tank2x;
			tank2.y = tank2y;
			score2++;
			tank1.isAlive = true;
		}

		if (tank2.isAlive == false) {
			tank1.x = tank1x;
			tank1.y = tank1y;
			tank2.x = tank2x;
			tank2.y = tank2y;
			score1++;
			tank2.isAlive = true;
		}
		
		for (int i = projectile2.size() - 1; i >= 0; i--) {
			if (!projectile2.get(i).isAlive) {
				projectile2.remove(i);
			}
		}
	}
}
