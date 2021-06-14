import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Eyeris extends Enemy {
	//Eye-like turret Enemy. Stays in place, shoots lasers at player
	public static final int[] eyerisIntersects_Room = {}; //An Eyeris will never move, so it has no room intersects.
	public static final int[] eyerisIntersects_Entity = {};
	
	Eyeris(int x, int y, int indexInArray) {
		super(x, y, Room.roomObjectSize, Room.roomObjectSize, 0, UP, eyerisIntersects_Room, eyerisIntersects_Entity, indexInArray);
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
		g.setColor(Color.WHITE);
		super.draw(g);
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub

	}

	@Override
	void intersectActions_Entity(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
