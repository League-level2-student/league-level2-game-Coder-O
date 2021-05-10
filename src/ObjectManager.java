import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Player player = new Player(400,400);
	static ArrayList<Projectile> playerProjectiles = new ArrayList<Projectile>();
	//Staff staff = new Staff(player);
	
	ObjectManager() {
		
	}
	
	void update() {
		player.update();
		//staff.update();
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
	
	void draw(Graphics g) {
		//staff.draw(g);
		player.draw(g);
		for (Projectile projectile : playerProjectiles) {
			projectile.draw(g);
		}
	}
	
}
