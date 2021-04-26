import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.ArrayList;

public class Entity {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	int type;
	
	public static final int PLAYER = 0;
	public static final int ENEMY = 1;
	
	boolean isActive = true;
	boolean moveUp = false;
	boolean moveDown = false;
	boolean moveLeft = false;
	boolean moveRight = false;
	Rectangle collisionBox;
	
	int[] roomIntersects;
	
	Entity(int x, int y, int width, int height, int speed, int type, int[] roomIntersects) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.type = type;
		this.roomIntersects = roomIntersects;
		collisionBox = new Rectangle(x, y, width, height);
		
		
	}
	
	//Again, UPDATE updates the CODE's version, DRAW updates the DISPLAY to match the code.
	void update() {
		up();
		down();
		left();
		right();
		
		collisionBox.setBounds(x, y, width, height);
		
		for (roomObject[] roomObjectRow : RoomManager.loadedRoom.roomMap) {
			for (roomObject roomObject : roomObjectRow) {
				for (int i = 0; i < roomIntersects.length; i++) {
					if(testIntersection(collisionBox, roomObject.collisionBox)&&roomIntersects[i]==roomObject.objectType) {
						intersectActions_Room(roomObject);
					}
				}
			}
		}
		//System.out.println("Update");
		
	}
	
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	//Called when the entity intersects with a room object. Determines what to do. Meant to be overridden.
	void intersectActions_Room(roomObject roomObject) {
		if (roomObject.objectType == roomObject.WALL) {
			if (this.moveUp) {
				y+=speed;
			} 
			if (this.moveDown) {
				y-=speed;
			}
			if (this.moveLeft) {
				x+=speed;
			} 
			if (this.moveRight) {
				x-=speed;
			}
		}
	}
	
	public static boolean testIntersection(Shape shapeA, Shape shapeB) {
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
		return !areaA.isEmpty();
	}
	
	//Controlled movement
	
	
	
	void up() {
		
		if (moveUp&&y>0) {  //possibly need to say this.moveUp(), same for rest of movement methods. <- Research suggests this is unlikely.
			y-=speed;
		}
		//collisionBox.y=y;
	}
	void down() {
		if (moveDown&&y<=ZeldaDungeon.HEIGHT-height-speed) {
	    	y+=speed;
	    }
		//collisionBox.y=y;
	}
	void left() {
		if (moveLeft&&x>0) {
	    	x-=speed;
	    }
		//collisionBox.x=x;
	}
	void right() {
		if (moveRight&&x<=ZeldaDungeon.WIDTH-width-speed) {
	    	x+=speed;
	    }
		//collisionBox.x=x;
	}
}
