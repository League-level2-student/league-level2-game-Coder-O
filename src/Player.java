import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {
	
	Player(int x, int y) {
		super(x, y, 50, 50);  //Assuming player will always start out at the same size
		// TODO Auto-generated constructor stub
	}
	
	//Update method might need to be overridden
	
	@Override
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		super.draw(g);
	}
	
}
