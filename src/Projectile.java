import java.awt.Graphics;

public abstract class Projectile extends Entity {
	
	int indexInArray;
	
	
	Projectile(int x, int y, int width, int height, int speed, int direction, int indexInArray, int[] roomObjectIntersects) {
		super(x, y, width, height, speed,0, direction, roomObjectIntersects);
		this.indexInArray = indexInArray;
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	void update() {
		// TODO Auto-generated method stub
		moveUp = false;
		moveDown = false;
		moveLeft = false;
		moveRight = false;
		if (direction == UP) {
			moveUp = true;
		}
		if (direction == DOWN) {
			moveDown = true;
		}
		if (direction == LEFT) {
			moveLeft = true;
		}
		if (direction == RIGHT) {
			moveRight = true;
		}
		super.update();
	}

	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		
	}
	

}
