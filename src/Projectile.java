import java.awt.Graphics;

public abstract class Projectile extends Entity {
	
	
	
	Projectile(int x, int y, int width, int height, int speed, int direction, int indexInArray, int[] roomObjectIntersects, int[] entityIntersects) {
		super(x, y, width, height, speed, PROJECTILE, direction, roomObjectIntersects, entityIntersects, indexInArray);
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
	void takeDamage() {
		// TODO Auto-generated method stub
		this.isActive = false;
	}

}
