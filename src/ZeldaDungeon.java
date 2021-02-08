import javax.swing.*;

public class ZeldaDungeon {
	//Creates main window, contains the main method
	
	JFrame gameFrame;
	GamePanel gamePanel;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeldaDungeon zeldaDungeon = new ZeldaDungeon();
		zeldaDungeon.setup();
	}
	
	ZeldaDungeon() {
		gameFrame = new JFrame();
		gamePanel = new GamePanel();
	}
	
	void setup() {
		gameFrame.add(gamePanel);
		gameFrame.setSize(WIDTH, HEIGHT+20);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.addKeyListener(gamePanel);
	}

}
