import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RoomManager {
//Manages rooms, sets them up.
	Dungeon dungeon1;
	
	Dungeon loadedDungeon;
	
	Room loadedRoom;
	
	
	
	
	
	RoomManager() {
		createDungeon();
		loadedDungeon = dungeon1;
		loadedRoom = loadedDungeon.startingRoom;
	}
	
	void draw(Graphics g) {
		loadedRoom.draw(g);
	}
	
	void createDungeon() {
	//Constant space that initializes the dungeon map. Where the programmer manually inputs the layout of the dungeon and each room.
		
		//Overall map of all rooms
		dungeon1 = new Dungeon(new Room[/*Floor*/][/*Row*/][/*Column*/] {
			{ //FLoor 2
				{    null   ,    null   ,    null   ,    null    },
				{    null   , new Room(), new Room(), new Room() },
				{    null   ,    null   ,    null   ,    null    }
			},
			{ //FLoor 1
				{    null   , new Room(),    null   ,    null    },
				{ new Room(), new Room(), new Room(), new Room() },
				{    null   , new Room(),    null   ,    null    }
			},
		});
		
	//Map of each room
		//Entrance room
		dungeon1.dungeonMap[1][2][1].roomMap = new roomObject[][] {
			{new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(2),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)}
		};
	//Initialize processes
		//sets starting room
		dungeon1.startingRoom = dungeon1.dungeonMap[1][2][1];
		
		//For every room in the dungeon...
		for (Room[][] floor : dungeon1.dungeonMap) {
			for (Room[] row : floor) {
				for (Room room : row) {
					//Initialize each of it's object's coordinates.
					if(room!= null&&room.roomMap!=null) {                //<––––––––––Delete room.roomMap!=null after all rooms have been formed!!!!!! It is unnecessary.
						int y = 0;
						for (roomObject[] roomRow : room.roomMap) {
							int x = 0;
							for (roomObject object : roomRow) {
								object.cornerY = y*100;
								object.cornerX = x*100;
								x++;
							}
							y++;
						}
					}
				}
			}
		}
	}
	
}

/*–––––––––––––––––––––––––––––––––––––––––––– Dungeon Classes ––––––––––––––––––––––––––––––––––––––––––––––––––*/

class Dungeon {
	Room startingRoom;
	Room[][][] dungeonMap;
	
	Dungeon(Room[][][] dungeonMap) {
		this.dungeonMap = dungeonMap;
	}
	
}

class Room {
	//Each room is a 8 by 8 grid off 100 pxl by 100 pxl squares. Each square can hold one object, such as a wall, a floor, a pit, etc.
	roomObject[][] roomMap;

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for (roomObject[] row : roomMap) {
			for (roomObject object : row) {
				object.draw(g);
			}
		}
	}
	
	
}


/*––––––––––––––––––––––––––––––––––––––––––– Room Object Classes ––––––––––––––––––––––––––––––––––––––––––––––––*/


class roomObject {
	//Base class of each item in a room's grid
	int type;
	int cornerX;
	int cornerY;
	Rectangle collisionBox;
	
	roomObject(int type) {
		this.type = type;
	}
	
	void draw(Graphics g) {
		
	}
}



class Wall extends roomObject {
	public static final int NORMAL = 1;
	public static final int DOOR = 2;
	public static final int TORCH = 3;
	
	Wall(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	
}

class Trap extends roomObject {
	public static final int PIT_TRAP = 1;
	
	Trap(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	
	
}
class Floor extends roomObject {
	public static final int NORMAL = 1;
	Object spawningObject;
	Floor(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	//If the floor spawns with an object on it (like an enemy), it will use this constructor
	Floor(int type, Object spawningObject) {
		super(type);
		this.spawningObject = spawningObject;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void draw(Graphics g) {
		if(type == NORMAL) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.GRAY);
		}
		g.fillRect(cornerX, cornerY, 100, 100);
	}
	
}