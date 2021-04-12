import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {
	
	Player(int x, int y) {
		super(x, y, 50, 50, 5);  //Assuming player will always start out at the same size
		
		// TODO Auto-generated constructor stub
	}
	
	//Update method might need to be overridden
	
	
	@Override
	void up() {
		// TODO Auto-generated method stub
		super.up();
		if(this.y == 0 && this.moveUp) {
			RoomManager.mapForward = true;
			this.y = ZeldaDungeon.HEIGHT - 10;
		}
		
		
		
	}
	
	@Override
	void down() {
		// TODO Auto-generated method stub
		super.down();
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
