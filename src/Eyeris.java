import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Eyeris extends Enemy {
	//Eye-like turret Enemy. Stays in place, shoots lasers at player
	public static final int[] eyerisIntersects_Room = {}; //An Eyeris will never move, so it has no room intersects.
	public static final int[] eyerisIntersects_Entity = {};
	
	public boolean eyeBlastInPlay = false;
	
	Eyeris(int x, int y) {
		super(x, y, Room.roomObjectSize, Room.roomObjectSize, 0, UP, eyerisIntersects_Room, eyerisIntersects_Entity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void update() {
		// TODO Auto-generated method stub
		if(y >= ObjectManager.player.y && y <= ObjectManager.player.y+ObjectManager.player.height) { 
			if(x < ObjectManager.player.x) { //Player is right of Eyeris
				eyeBlast(RIGHT);
			} else {  //Player is left of Eyeris (can't be on eyeris);
				eyeBlast(LEFT);
			}
		} else if (x >= ObjectManager.player.x && x <= ObjectManager.player.x+ObjectManager.player.width) {
			if(y < ObjectManager.player.y) { //Player is bellow Eyeris
				eyeBlast(DOWN);
			} else {  //Player is above Eyeris (can't be on Eyeris);
				eyeBlast(UP);
			}
		}
		
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
	
	void eyeBlast(int direction) {
		if(!eyeBlastInPlay) {
			ObjectManager.entitiesToAdd.add(new EyeBlast(x, y, direction, this));
			eyeBlastInPlay = true;
		}
	}

}
