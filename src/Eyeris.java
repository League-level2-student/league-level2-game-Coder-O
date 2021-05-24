import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Eyeris extends Enemy {
	//Eye-like turret Enemy. Stays in place, shoots lasers at player
	Eyeris(int x, int y, int width, int height, int speed, int type, int direction, int[] roomIntersects, int indexInArray) {
		super(x, y, width, height, speed, type, direction, roomIntersects, indexInArray);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		super.draw(g);
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub

	}

}
