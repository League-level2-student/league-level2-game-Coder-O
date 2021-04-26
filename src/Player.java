import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends Entity {
	public static final int[] playerIntersects_Room = {roomObject.WALL, };
	
	Player(int x, int y) {
		super(x, y, 50, 50, 5, PLAYER, playerIntersects_Room);  //Assuming player will always start out at the same size
		
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
		if(this.y == 750 && this.moveDown) {
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
	
	@Override
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		super.draw(g);
		//System.out.println("Player Draw");
	}
	
}
