import java.awt.Graphics;

public class ObjectManager {
	Player player = new Player(400,400);
	//Staff staff = new Staff(player);
	
	ObjectManager() {
		
	}
	
	void update() {
		player.update();
		//staff.update();
	}
	
	void draw(Graphics g) {
		//staff.draw(g);
		player.draw(g);
	}
	
}
