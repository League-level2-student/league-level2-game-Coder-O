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
	int currentState = END;
	
	Timer frameDraw;
	
	Font titleFont = new Font("Zapfino", Font.PLAIN, 48);
	Font headerFont = new Font("Apple Chancery", Font.PLAIN, 35);
	Font endFont = new Font("", Font.BOLD, 48);
	
	GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	
	//Update methods update the CODE's version of the game.
	void updateTitleState() {
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	
	//Draw method's update the USER'S DISPLAY's version of the game
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
	}
	void drawEndState(Graphics g) {
		g.setColor(new Color(60,0,60));
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
		
		g.setColor(new Color(100,0,100));
		g.setFont(headerFont);
		g.drawString("GAME OVER", 169, 175);
	}
	
	@Override
	public void paintComponent(Graphics g){
		//Called 60 times per second by actionPerformed. Paints and Repaints each state, this is what updates the user's display.
		if(currentState == TITLE){
		    drawTitleState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			//Switches the state
			System.out.println("Enter");
			if (currentState == END) {
				currentState = TITLE;
			} else {
				currentState++;
			}
				
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Called 60 times per second by timers (Specifically, frameDraw)
		if(currentState == TITLE){
		    updateTitleState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		//Essentially calls paintComponent()
		repaint();
	}
}
