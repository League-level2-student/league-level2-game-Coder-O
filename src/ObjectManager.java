import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	public static int ENEMY = 0;
	public static int ITEM = 1;
	
	Player player = new Player(400,400);
	static ArrayList<Entity> loadedEntities;
	//Staff staff = new Staff(player);
	
	ObjectManager() {
		loadedEntities = new ArrayList<Entity>();
	}
	
	void update() {
		player.update();
		//staff.update();
		ArrayList<Integer> indexsToRemove = new ArrayList<Integer>();
		for (Entity entity : loadedEntities) {
			entity.update();
			if(!entity.isActive) {
				indexsToRemove.add(entity.indexInArray);
			}
		}
		for (int index : indexsToRemove) {
			loadedEntities.remove(index);
		}
		indexsToRemove.clear();
		
		
	}
	
	
	
	void draw(Graphics g) {
		//staff.draw(g);
		player.draw(g);
		for (Entity entity : loadedEntities) {
			entity.draw(g);
		}
	}
	
}
