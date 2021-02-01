import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class GamePanel extends JPanel {
	final int TITLE = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = TITLE;
	
	Font titleFont = new Font("Zapfino", Font.PLAIN, 48);
	Font headerFont = new Font("Apple Chancery", Font.PLAIN, 35);
	
	GamePanel() {
		
	}
	
	void updateTitleState() {
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	
	void drawTitleState(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
		
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("Zelda Dungeon", 169, 150);
		
		g.setColor(Color.BLACK);
		g.setFont(headerFont);
		
		g.drawString(">Press ENTER to start<", 150, 400);
		
		
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, ZeldaDungeon.WIDTH, ZeldaDungeon.HEIGHT);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == TITLE){
		    drawTitleState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
}
