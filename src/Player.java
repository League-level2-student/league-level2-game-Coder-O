import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends Entity {
	public static final int[] playerIntersects_Room = {roomObject.WALL, };
	static boolean fireballInPlay = false;
	
	
	Player(int x, int y) {
		super(x, y, 50, 50, 5, PLAYER, Entity.UP, playerIntersects_Room);  //Assuming player will always start out at the same size
		
		// TODO Auto-generated constructor stub
	}
	
	//Update method might need to be overridden
	@Override
	void update() {
		// TODO Auto-generated method stub
		super.update();
		
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		if (roomObject.objectType == roomObject.WALL && roomObject.subType != Wall.DOOR && roomObject.subType != Wall.STAIR) {
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
	
	@Override
	void up() {
		// TODO Auto-generated method stub
		super.up();
		if(this.y == 0 && this.moveUp) {
			RoomManager.mapForward = true;
			this.y = ZeldaDungeon.HEIGHT - 60;
		}
		
		
		
	}
	
	@Override
	void down() {
		// TODO Auto-generated method stub
		super.down();
		if(this.y == ZeldaDungeon.HEIGHT - height && this.moveDown) {
			RoomManager.mapBackward = true;
			this.y = 60;
		}
	}
	
	@Override
	void left() {
		// TODO Auto-generated method stub
		super.left();
	}
	
	@Override
	void right() {
		// TODO Auto-generated method stub
		super.right();
	}
	
	void fireBall() {
		if(!fireballInPlay) {
			ObjectManager.playerProjectiles.add(new FireBall(x,y,ObjectManager.playerProjectiles.size()+1,direction));
		}
	}
	
	@Override
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		super.draw(g);
		//System.out.println("Player Draw");
	}
	
}
