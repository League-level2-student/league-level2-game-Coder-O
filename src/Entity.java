import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;
	boolean moveUp = false;
	boolean moveDown = false;
	boolean moveLeft = false;
	boolean moveRight = false;
	Rectangle collisionBox;
	
	Entity(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		collisionBox = new Rectangle(x, y, width, height);
		
		
	}
	
	//Again, UPDATE updates the CODE's version, DRAW updates the DISPLAY to match the code.
	void update() {
		up();
		down();
		left();
		right();
		
		collisionBox.setBounds(x, y, width, height);
		//System.out.println("Update");
		
	}
	
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
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
