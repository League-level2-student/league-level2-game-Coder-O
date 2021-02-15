import java.awt.Graphics;

public class ObjectManager {
	Player player = new Player(200,700);
	
	ObjectManager() {
		
	}
	
	void update() {
		player.update();
	}
	
	void draw(Graphics g) {
		player.draw(g);
	}
	
}
