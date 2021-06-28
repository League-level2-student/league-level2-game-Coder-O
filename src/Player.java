import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends Entity {
	public static final int[] playerIntersects_Room = {roomObject.WALL, roomObject.TRAP};
	public static final int[] playerIntersects_Entity = {ENEMY, PROJECTILE};
	
	static boolean fireballInPlay = false;
	static int health;
	static final int MAX_HEALTH = 3;
	static int invurnalbilityTimer;
	static final int MAX_INVURNALBILITY_TIME = 60;
	static final int MAX_REPRESS_MOVEMENT = 20; //The amount of invurnability time it takes to regain movment capabilities.
	
	Player(int x, int y) {
		super(x, y, 50, 50, 5, PLAYER, UP, playerIntersects_Room, playerIntersects_Entity);  //Assuming player will always start out at the same size
		health = MAX_HEALTH;
		invurnalbilityTimer = 0;
		// TODO Auto-generated constructor stub
	}
	
	//Update method might need to be overridden
	@Override
	void update() {
		// TODO Auto-generated method stub
		if(invurnalbilityTimer>0) {
			invurnalbilityTimer--;
		}
		super.update();
		
	}
	
	@Override
	void intersectActions_Room(roomObject roomObject) {
		// TODO Auto-generated method stub
		if ((roomObject.objectType == roomObject.WALL && !((roomObject.subType == Wall.DOOR && roomObject.subType_SpecificState==Wall.ON_OR_OPEN) || roomObject.subType == Wall.STAIR))|| roomObject.objectType == roomObject.TRAP) {
	//  If (It is a wall and is (not ((a door that is open) or a stair))
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
			
			if (roomObject.objectType == roomObject.TRAP) {
				takeDamage();
			}
		}
		
	}
	
	@Override
	void intersectActions_Entity(Entity entity) {
		// TODO Auto-generated method stub
		if(entity.type == ENEMY) {
			if(invurnalbilityTimer==0) {
				if (this.moveUp) {
					y+=4*speed;
				} 
				if (this.moveDown) {
					y-=4*speed;
				}
				if (this.moveLeft) {
					x+=4*speed;
				} 
				if (this.moveRight) {
					x-=4*speed;
				}
			} else {
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
			
			takeDamage();
		}
		
	}
	
	@Override
	void up() {
		// TODO Auto-generated method stub
		if(invurnalbilityTimer<MAX_INVURNALBILITY_TIME-MAX_REPRESS_MOVEMENT) {
		 super.up();
		}
		if(this.y == 0 && this.moveUp) {
			RoomManager.mapForward = true;
			this.y = ZeldaDungeon.HEIGHT - 60;
		}
		
		
		
	}
	
	@Override
	void down() {
		// TODO Auto-generated method stub
		if(invurnalbilityTimer<50) {
			super.down();
		}
		if(this.y == ZeldaDungeon.HEIGHT - height && this.moveDown) {
			RoomManager.mapBackward = true;
			this.y = 60;
		}
	}
	
	@Override
	void left() {
		// TODO Auto-generated method stub
		if(invurnalbilityTimer<50) {
			super.left();
		}
		if(this.x == 0 && this.moveLeft) {
			RoomManager.mapLeft = true;
			this.x = ZeldaDungeon.WIDTH - 60;
		}
	}
	
	@Override
	void right() {
		// TODO Auto-generated method stub
		if(invurnalbilityTimer<50) {
			super.right();
		}
		if(this.x == ZeldaDungeon.WIDTH - width && this.moveRight) {
			RoomManager.mapRight = true;
			this.x = 60;
		}
	}
	
	void fireBall() {
		if(!fireballInPlay) {
			ObjectManager.entitiesToAdd.add(new FireBall(x,y,direction));
			fireballInPlay=true;
		}
	}
	@Override
	void takeDamage() {
		// TODO Auto-generated method stub
		if (invurnalbilityTimer <=0) {
			health--;
			invurnalbilityTimer = MAX_INVURNALBILITY_TIME;
		}
	}
	
	@Override
	void draw(Graphics g) {
		if(invurnalbilityTimer>0) {
			g.setColor(new Color(4*invurnalbilityTimer, 0, 255));
		} else {
			g.setColor(Color.BLUE);
		}
		super.draw(g);
		//System.out.println("Player Draw");
	}

	
	
}
