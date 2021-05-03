import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.ArrayList;

public abstract class Entity {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	int type;
	int direction;
	
	public static final int PLAYER = 0;
	public static final int ENEMY = 1;
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	
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
	abstract void intersectActions_Room(roomObject roomObject);
		
		
	
	
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
