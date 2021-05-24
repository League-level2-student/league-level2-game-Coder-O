import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Player player = new Player(400,400);
	static ArrayList<Projectile> playerProjectiles;
	static ArrayList<Enemy> enemiesInRoom;
	//Staff staff = new Staff(player);
	
	ObjectManager() {
		playerProjectiles = new ArrayList<Projectile>();
		enemiesInRoom = new ArrayList<Enemy>();
	}
	
	void update() {
		player.update();
		//staff.update();
		projectileManaging();
		
		
		
		
	}
	
	void projectileManaging() {
		ArrayList<Integer> indexsToRemove = new ArrayList<Integer>();
		for (Projectile projectile : playerProjectiles) {
			projectile.update();
			if(!projectile.isActive) {
				indexsToRemove.add(projectile.indexInArray);
			}
		}
		for (int index : indexsToRemove) {
			playerProjectiles.remove(index);
		}
		indexsToRemove.clear();
	}
	
	void enemyManaging() {
		ArrayList<Integer> indexsToRemove = new ArrayList<Integer>();
		for (Enemy enemy : enemiesInRoom) {
			enemy.update();
			if(!enemy.isActive) {
				indexsToRemove.add(enemy.indexInArray);
			}
		}
		for (int index : indexsToRemove) {
			enemiesInRoom.remove(index);
		}
		indexsToRemove.clear();
	}
	void draw(Graphics g) {
		//staff.draw(g);
		player.draw(g);
		for (Projectile projectile : playerProjectiles) {
			projectile.draw(g);
		}
	}
	
}
