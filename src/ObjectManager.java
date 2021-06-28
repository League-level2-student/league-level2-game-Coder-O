import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	//public static final int ENEMY = 0;
	//public static final int ITEM = 1;
	
	public static Player player;
	static ArrayList<Entity> loadedEntities;
	static ArrayList<Entity> entitiesToAdd;
	//Staff staff = new Staff(player);
	
	ObjectManager() {
		loadedEntities = new ArrayList<Entity>();
		entitiesToAdd = new ArrayList<Entity>();
		player = new Player(400,400);
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
		
		for (Entity entity : entitiesToAdd) {
			entity.indexInArray = loadedEntities.size();
			loadedEntities.add(entity);
		}
		entitiesToAdd.clear();
		
	}
	
	
	
	void draw(Graphics g) {
		//staff.draw(g);
		player.draw(g);
		for (Entity entity : loadedEntities) {
			entity.draw(g);
		}
	}
	
}
