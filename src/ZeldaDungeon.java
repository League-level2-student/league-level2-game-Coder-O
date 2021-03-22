

import java.awt.event.*;

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
		
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "switchState");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "playerUpStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "playerUpStop");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "playerDownStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "playerDownStop");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "playerLeftStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "playerLeftStop");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "playerRightStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "playerRightStop");
		
		gamePanel.getActionMap();
		
	}
	
	public class SwitchState_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerUpStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerUpStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerDownStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerDownStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerLeftStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerLeftStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerRightStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class PlayerRightStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
