import java.awt.Graphics;

public abstract class Enemy extends Entity {
	public static final int EYERIS = 1;
	int indexInArray;
	
	Enemy(int x, int y, int width, int height, int speed, int direction, int[] roomIntersects, int indexInArray) {
		super(x, y, width, height, speed, ENEMY, direction, roomIntersects);
		// TODO Auto-generated constructor stub
		this.indexInArray = indexInArray;
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

}
