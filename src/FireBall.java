import java.awt.Color;
import java.awt.Graphics;

public class FireBall extends Projectile {
	
	public static final int[] fireBallIntersects_Room = {roomObject.WALL, };
	public static final int[] fireBallIntersects_Entity = {ENEMY, };
	
	
	
	FireBall(int x, int y, int direction, int indexInArray) {
		super(x, y, 15, 15, 15, direction, indexInArray,fireBallIntersects_Room, fireBallIntersects_Entity);
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
		g.setColor(Color.RED);
		super.draw(g);
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		if (roomObject.objectType == roomObject.WALL) {
			takeDamage();
			if(roomObject.subType==Wall.TORCH && roomObject.subType_SpecificState != Wall.ON_OR_OPEN) {
				roomObject.subType_SpecificState = Wall.ON_OR_OPEN;
			}
		}
	}
	
	@Override
	void intersectActions_Entity(Entity entity) {
		// TODO Auto-generated method stub
		if(entity.type==ENEMY) {
			entity.takeDamage();
			takeDamage();
		}
	}
	
	@Override
	void takeDamage() {
		// TODO Auto-generated method stub
		Player.fireballInPlay = false;
		super.takeDamage();
	}
	
}
