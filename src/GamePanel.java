import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int TITLE = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = TITLE;
	boolean pause = false;
	
	ObjectManager objectManager = new ObjectManager();
	RoomManager roomManager = new RoomManager();
	
	Timer frameDraw;
	
	Font titleFont = new Font("Zapfino", Font.PLAIN, 48);
	Font headerFont = new Font("Apple Chancery", Font.PLAIN, 35);
	
	
	GamePanel() {
		
		
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	
	//Update methods update the CODE's version of the game.
	void updateTitleState() {
		
	}
	void updateGameState() {
		objectManager.update();
	}
	
	void updatePauseSubstate() {
		
	}
	
	void updateEndState() {
		
	}
	
	//Draw methods update the USER'S DISPLAY's version of the game
	void drawTitleState(Graphics g) {
		g.setColor(new Color(0,200,100));
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
		
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("Zelda Dungeon", 169, 175);
		
		g.setColor(Color.BLACK);
		g.setFont(headerFont);
		
		g.drawString(">Press ENTER to start<", 210, 450);
		
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
		
		roomManager.draw(g);
		objectManager.draw(g);
	}
	void drawPauseSubstate(Graphics g) {
		g.setColor(new Color(100,100,100,100));
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.setFont(headerFont);
		g.drawString("Pause", 100, 175);
	}

	void drawEndState(Graphics g) {
		g.setColor(new Color(60,0,60));
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
		
		g.setColor(new Color(130,0,130));
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 175);
		
		g.setColor(new Color(135,0,135));
		g.setFont(headerFont);
		g.drawString(">Press ENTER to return to the tittle screen<", 60, 450);
	}
	
	@Override
	public void paintComponent(Graphics g){
		//Called 60 times per second by actionPerformed. Paints and Repaints each state, this is what updates the user's display.
		if(currentState == TITLE){
		    drawTitleState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		    if (pause) {
		    	drawPauseSubstate(g);
		    }
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
//–––––––––––––––––––––––––––––––––––––––Controls/Listeners––––––––––––––––––––––––––––––––––––––––––––//
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key pressed");
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			//Switches the state in all states
			System.out.println("Enter");
			if (currentState == END) {
				currentState = TITLE;
			} else {
				currentState++;
			}
		} else if (currentState == GAME) {
			//Controls in GAME state
			
			//Pause
			if (e.getKeyCode() == KeyEvent.VK_E) {
				pause = !pause;
			}
			
			//Player movement
			else if(e.getKeyCode() == KeyEvent.VK_W) {
				objectManager.player.moveUp = true;
			} else if(e.getKeyCode() == KeyEvent.VK_A) {
				objectManager.player.moveLeft = true;
			} else if(e.getKeyCode() == KeyEvent.VK_S) {
				objectManager.player.moveDown = true;
			} else if(e.getKeyCode() == KeyEvent.VK_D) {
				objectManager.player.moveRight = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key released");
		if (currentState == GAME) {
			//More controls in GAME state, specifically ending repeated actions/pressed states originating in keyPressed()
			
			//Ending player movement
			if(e.getKeyCode() == KeyEvent.VK_W) {
				objectManager.player.moveUp = false;
			} else if(e.getKeyCode() == KeyEvent.VK_A) {
				objectManager.player.moveLeft = false;
			} else if(e.getKeyCode() == KeyEvent.VK_S) {
				objectManager.player.moveDown = false;
			} else if(e.getKeyCode() == KeyEvent.VK_D) {
				objectManager.player.moveRight = false;
			}
		}
		
	}
	
//–––––––––––––––––––––––––––––Testing KeyBindings––––––––––––––––––––––––––//

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Called 60 times per second by timers (Specifically, frameDraw)
		if(!pause) {
			if(currentState == TITLE){
			    updateTitleState();
			}else if(currentState == GAME){
			    updateGameState();
			}else if(currentState == END){
			    updateEndState();
			}
		} else {
			updatePauseSubstate();
		}
		
		//Essentially calls paintComponent()
		repaint();
	}
}
