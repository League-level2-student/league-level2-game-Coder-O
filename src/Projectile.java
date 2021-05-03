import java.awt.Graphics;

public class Projectile extends Entity {
	
	
	
	Projectile(int x, int y, int width, int height, int speed, int[] roomObjectIntersects) {
		super(x, y, width, height, speed,0, roomObjectIntersects);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
	}
	
	@Override
	void update() {
		// TODO Auto-generated method stub
		super.update();
	}

	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		
	}

}
