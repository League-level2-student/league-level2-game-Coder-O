

import java.awt.event.*;

import javax.swing.*;

public class ZeldaDungeon {
	//Creates main window, contains the main method
	
	JFrame gameFrame;
	GamePanel gamePanel;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	
	Action switchState_Action = new SwitchState_Action();
	Action playerUpStart_Action = new PlayerUpStart_Action();
	Action playerUpStop_Action = new PlayerUpStop_Action();
	Action playerDownStart_Action = new PlayerDownStart_Action();
	Action playerDownStop_Action = new PlayerDownStop_Action();
	Action playerLeftStart_Action = new PlayerLeftStart_Action();
	Action playerLeftStop_Action = new PlayerLeftStop_Action();
	Action playerRightStart_Action = new PlayerRightStart_Action();
	Action playerRightStop_Action = new PlayerRightStop_Action();
	
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
		//gameFrame.addKeyListener(gamePanel);
		
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "switchState");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "playerUpStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "playerUpStop");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "playerDownStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "playerDownStop");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "playerLeftStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "playerLeftStop");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "playerRightStart");
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "playerRightStop");
		
		gamePanel.getActionMap().put("switchState", switchState_Action);
		gamePanel.getActionMap().put("playerUpStart", playerUpStart_Action);
		gamePanel.getActionMap().put("playerUpStop", playerUpStop_Action);
		gamePanel.getActionMap().put("playerDownStart", playerDownStart_Action);
		gamePanel.getActionMap().put("playerDownStop", playerDownStop_Action);
		gamePanel.getActionMap().put("playerLeftStart", playerLeftStart_Action);
		gamePanel.getActionMap().put("playerLeftStop", playerLeftStop_Action);
		gamePanel.getActionMap().put("playerRightStart", playerRightStart_Action);
		gamePanel.getActionMap().put("playerRightStop", playerRightStop_Action);
		
	}
	
	public class SwitchState_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (gamePanel.currentState == gamePanel.END) {
				gamePanel.currentState = gamePanel.TITLE;
			} else {
				gamePanel.currentState++;
			}
			System.out.println("Switch state");
		}
		
	}
	
	public class PlayerUpStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveUp = true;
			System.out.println("Player up start");
		}
		
	}
	
	public class PlayerUpStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveUp = false;
			System.out.println("Player up stop");
		}
		
	}
	
	public class PlayerDownStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveDown = true;
			System.out.println("Player down start");
		}
		
	}
	
	public class PlayerDownStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveDown = false;
			System.out.println("Player down stop");
		}
		
	}
	
	public class PlayerLeftStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveLeft = true;
			System.out.println("Player left start");
		}
		
	}
	
	public class PlayerLeftStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveLeft = false;
			System.out.println("Player left stop");
		}
		
	}
	
	public class PlayerRightStart_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveRight = true;
			System.out.println("Player right start");
		}
		
	}
	
	public class PlayerRightStop_Action extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePanel.objectManager.player.moveRight = false;
			System.out.println("Player right stop");
		}
		
	}

}
