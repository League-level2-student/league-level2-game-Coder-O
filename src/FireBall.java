import java.awt.Color;
import java.awt.Graphics;

public class FireBall extends Projectile {
	
	public static final int[] fireBallIntersects_Room = {roomObject.WALL, };
	
	
	
	FireBall(int x, int y, int direction, int indexInArray) {
		super(x, y, 5, 5, 15, direction, indexInArray,fireBallIntersects_Room);
		// TODO Auto-generated constructor stub
	}
	@Override
	void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	
	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		super.draw(g);
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		if (roomObject.objectType == roomObject.WALL) {
			explode();
		}
	}
	
	void explode() {
		System.out.println(x+" "+y+" "+direction);
		isActive=false;
	}
}
