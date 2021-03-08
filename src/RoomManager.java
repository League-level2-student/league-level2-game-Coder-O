import java.awt.Rectangle;

public class RoomManager {
//Manages rooms, sets them up.
	
	Dungeon dungeon1;
	
	Dungeon loadedDungeon;
	
	
	
	
	
	RoomManager() {
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
		loadedDungeon = dungeon1;
		dungeon1.dungeonMap[1][3][2].roomMap = new roomObject[][] {
			{/* 16 floors/walls/traps/etc.*/},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{},
			{}
		};
		
	}
	
	
}

class Dungeon {
	Room startingRoom;
	Room[][][] dungeonMap;
	
	Dungeon(Room[][][] dungeonMap) {
		this.dungeonMap = dungeonMap;
	}
	
}

class Room {
	//Each room is a 16 by 16 grid off 50 pxl by 50 pxl squares. Each square can hold one object, such as a wall, a floor, a pit, etc.
	roomObject[][] roomMap;
	
	
}


/*–––––––––––––––––––––––––––––––––––––––––––Room Object Stuff––––––––––––––––––––––––––––––––––––––––––––––––*/


class roomObject {
	//Base class of each item in a room's grid
	int type;
	int cornerX;
	int cornerY;
	Rectangle collisionBox;
	
	roomObject(int type) {
		this.type = type;
	}
	
	void draw() {
		
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
	
}