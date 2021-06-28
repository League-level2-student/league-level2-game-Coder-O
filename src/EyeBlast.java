import java.awt.Color;
import java.awt.Graphics;

public class EyeBlast extends Projectile {
	
	public static final int[] eyeBlastIntersects_Room = {roomObject.WALL, };
	public static final int[] eyeBlastIntersects_Entity = {PLAYER, };
	
	Eyeris source;
	
	EyeBlast(int x, int y, int direction, Eyeris source) {
		super(x, y, 15, 15, 15, direction, eyeBlastIntersects_Room, eyeBlastIntersects_Entity);
		this.source = source;
		// TODO Auto-generated constructor stub
	}
	@Override
	void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	
	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
		super.draw(g);
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		if (roomObject.objectType == roomObject.WALL) {
			takeDamage();
		}
	}
	
	@Override
	void intersectActions_Entity(Entity entity) {
		// TODO Auto-generated method stub
		if(entity.type==PLAYER) {
			entity.takeDamage();
			takeDamage();
		}
	}
	
	@Override
	void takeDamage() {
		// TODO Auto-generated method stub
		source.eyeBlastInPlay = false;
		super.takeDamage();
	}
	
}
