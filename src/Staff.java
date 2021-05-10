import java.awt.Color;
import java.awt.Graphics;

public class Staff extends Entity {
	Player player;
	Staff(Player player) {
		super(player.x+(player.width/2)-37, player.y+(player.height/2), 75, 5, 0,0,player.direction,null);
		this.player = player;
		// TODO Auto-generated constructor stub
	}
	@Override
	void update() {
		// TODO Auto-generated method stub
		x = player.x+(player.width/2)-37;
		y = player.y+(player.height/2);
		
		collisionBox.setBounds(x, y, width, height);
	}
	@Override
	void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		// TODO Auto-generated method stub
		super.draw(g);
	}
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		
	}

}
