
public abstract class Enemy extends Entity {
	
	int indexInArray;
	
	Enemy(int x, int y, int width, int height, int speed, int type, int direction, int[] roomIntersects, int indexInArray) {
		super(x, y, width, height, speed, type, direction, roomIntersects);
		// TODO Auto-generated constructor stub
		this.indexInArray = indexInArray;
	}

	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub

	}

}
