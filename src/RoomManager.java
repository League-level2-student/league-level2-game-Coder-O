import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RoomManager {
//Manages rooms, sets them up.
	Dungeon dungeon1;
	
	Dungeon loadedDungeon;
	Room loadedRoom;
	int currentFloorCordinate;
	int currentRowCordinate;
	int currentRoomCordinate;
	
	public static boolean mapForward = false;
	public static boolean mapBackward = false;
	public static boolean mapLeft = false;
	public static boolean mapRight = false;
	public static boolean mapUp = false;
	public static boolean mapDown = false;
	
	
	
	RoomManager() {
		createDungeons();
		loadedDungeon = dungeon1;
		loadedRoom = loadedDungeon.startingRoom;
		currentFloorCordinate = loadedDungeon.startingFloorCordinate;
		currentRowCordinate = loadedDungeon.startingRowCordinate;
		currentRoomCordinate = loadedDungeon.startingRoomCordinate;
	}
	
	void update() {
	 switchRoom(); 
	}
	
	
	void switchRoom() {
		if(mapForward) {
			
			if(currentRowCordinate>0 && loadedDungeon.dungeonMap[currentFloorCordinate][currentRowCordinate-1][currentRoomCordinate]!=null) {
				currentRowCordinate--;
			}
			/////////////
			//[ ][^][ ]//
			//[ ][|][ ]//
			//[ ][ ][ ]//
			/////////////
			
		} else if(mapBackward) {
			
			if(currentRowCordinate < loadedDungeon.maxRowCordinate && loadedDungeon.dungeonMap[currentFloorCordinate][currentRowCordinate+1][currentRoomCordinate]!=null) {
				currentRowCordinate++;
			}
			////////////////
			//[  ][  ][  ]//
			//[  ][||][  ]//
			//[  ][\/][  ]//
			////////////////
			
		} else if(mapLeft) {

			if(currentRoomCordinate>0 && loadedDungeon.dungeonMap[currentFloorCordinate][currentRowCordinate][currentRoomCordinate-1]!=null) {
				currentRoomCordinate--;
			}
			/////////////
			//[ ][ ][ ]//
			//[<][-][ ]//
			//[ ][ ][ ]//
			/////////////
			
		} else if(mapRight) {

			if(currentRoomCordinate<loadedDungeon.maxRoomCordinate && loadedDungeon.dungeonMap[currentFloorCordinate][currentRowCordinate][currentRoomCordinate+1]!=null) {
				currentRoomCordinate++;
			}
			/////////////
			//[ ][ ][ ]//
			//[ ][-][>]//
			//[ ][ ][ ]//
			/////////////
			
		} else if(mapUp) {

			if(currentFloorCordinate>0 && loadedDungeon.dungeonMap[currentFloorCordinate-1][currentRowCordinate][currentRoomCordinate]!=null) {
				currentFloorCordinate--;
			}
			/////////////
			//[ ][ ][ ]//
			//[ ][|][ ]// Up a floor
			//[ ][ ][ ]//
			/////////////
			
		} else if(mapDown) {

			if(currentRowCordinate<loadedDungeon.maxFloorCordinate && loadedDungeon.dungeonMap[currentFloorCordinate+1][currentRowCordinate][currentRoomCordinate]!=null) {
				currentRowCordinate++;
			}
			/////////////
			//[ ][ ][ ]//
			//[ ][|][ ]// Down a floor
			//[ ][ ][ ]//
			/////////////
				
		}
		mapForward = false;
		mapBackward = false;
		mapLeft = false;
		mapRight = false;
		mapUp = false;
		mapDown = false;
		
		loadedRoom = loadedDungeon.dungeonMap[currentFloorCordinate][currentRowCordinate][currentRoomCordinate];
	}
	
	
	void draw(Graphics g) {
		loadedRoom.draw(g);
	}
	
	
	
//–––––––––––––––––––––––––––––––––––––––––––––––––Dungeon Creation/Initialization–––––––––––––––––––––––––––––––––––––––––––––//
	
	
	void createDungeons() {
	//Constant space that initializes each dungeon's map and variables. Where the programmer manually inputs the layout of the dungeon and each room.
		
//––––––––––––––––––––––––––––Dungeon1–––––––––––––––//
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
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)}
		};
		//Main Room
		dungeon1.dungeonMap[1][1][1].roomMap = new roomObject[][] {
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(2),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)},
			{new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1),new Floor(1)}
		};
	//Initialize processes
		//sets starting room
		dungeon1.startingFloorCordinate = 1;
		dungeon1.startingRowCordinate = 2;
		dungeon1.startingRoomCordinate = 1;
		dungeon1.startingRoom = dungeon1.dungeonMap[dungeon1.startingFloorCordinate][dungeon1.startingRowCordinate][dungeon1.startingRoomCordinate];
		
		//sets max rooms
		dungeon1.maxFloorCordinate = 1; // 2 floors total
		dungeon1.maxRowCordinate = 2; // Each with 3 rows
		dungeon1.maxRoomCordinate = 3; // With 4 rooms each
		
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
		
	//––––––––––––––––––––––––––––Dungeon 2 would go here–––––––––––––––––––––––––//
		
	}
	
}

/*–––––––––––––––––––––––––––––––––––––––––––– Dungeon Classes ––––––––––––––––––––––––––––––––––––––––––––––––––*/

class Dungeon {
	Room startingRoom;
	Room[][][] dungeonMap;
	
	int startingFloorCordinate;
	int startingRowCordinate;
	int startingRoomCordinate;
	
	int maxFloorCordinate;
	int maxRowCordinate;
	int maxRoomCordinate;
	
	
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
	
	@Override
	void draw(Graphics g) {
		if(type == NORMAL) {
			g.setColor(Color.DARK_GRAY);
		} else {
			g.setColor(Color.GRAY);
		}
		g.fillRect(cornerX, cornerY, 100, 100);
	}

	
}

class Trap extends roomObject {
	public static final int PIT_TRAP = 1;
	
	Trap(int type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g) {
		if(type == PIT_TRAP) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.GRAY);
		}
		g.fillRect(cornerX, cornerY, 100, 100);
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