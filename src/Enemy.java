import java.awt.Graphics;

public abstract class Enemy extends Entity {
	public static final int EYERIS = 1;
	
	Enemy(int x, int y, int width, int height, int speed, int direction, int[] roomIntersects, int[] entityIntersects, int indexInArray) {
		super(x, y, width, height, speed, ENEMY, direction, roomIntersects, entityIntersects, indexInArray);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.fillOval(x, y, width, height);
	}
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub

	}
	@Override
	void takeDamage() {
		// TODO Auto-generated method stub
		this.isActive = false;
	}

}
