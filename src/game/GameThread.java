package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import edu.aub.cmps.*;
import shapes.Shapes;

import java.util.Random;

public class GameThread extends Thread implements KeyListener {
	
	GameBoard board;
	Shapes shapes = new Shapes();
	Random rand = new Random();
	private int x = rand.nextInt(9);
	private int y = 0;
	
	public GameThread(GameBoard board) {
		this.board=board;
	}
	
	@Override
	public void run() {
		try {
			int i = 0;
			for(int j = 0; j < 10; j++) {
				for(int top = 0;top<24-2;top++) {
					y = top;
					board.setCellState(top, x, Color.red, 5);
					board.setCellState(top+1, x, Color.red, 5);
					board.setCellState(top+2, x, Color.red, 5);
					board.setCellState(top+2, x+1, Color.red, 5);
					Thread.sleep(300);
					
					if(top<24-3){
						if(board.getCellColor(top+3, x).equals(Color.red) || board.getCellColor(top+3, x+1).equals(Color.red)) {
							break;
						}
						board.setCellState(top, x, Color.lightGray, 5);
						board.setCellState(top+1, x, Color.lightGray, 5);
						board.setCellState(top+2, x, Color.lightGray, 5);
						board.setCellState(top+2, x+1, Color.lightGray, 5);
					}
				}
				GameBoard.MediaPlayer.playKnock();
			}
		} catch (CellCollisionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void moveY(char shape) {
		
		if(shape == 'L') {
			
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
			case KeyEvent.VK_LEFT:
				if(x > 0) {
					if(board.getCellColor(y, x-1).equals(Color.red) ||     //checks if there's any block to the left
						board.getCellColor(y+1, x-1).equals(Color.red) ||  //if there is, don't move to the left
						board.getCellColor(y+2, x-1).equals(Color.red)) {
						break;
					}
					x--;
					if(y<24-3) {
						try {
							board.setCellState(y, x+1, Color.lightGray, 5);
							board.setCellState(y+1, x+1, Color.lightGray, 5);
							board.setCellState(y+2, x+1, Color.lightGray, 5);
							board.setCellState(y+2, x+2, Color.lightGray, 5);
						} catch (CellCollisionException e1) {
							e1.printStackTrace();
						}
					}
				}
				break;
			
			case KeyEvent.VK_RIGHT:
				if(x+1 < 9) {
					if(board.getCellColor(y, x+1).equals(Color.red) ||     //checks if there's any block to the right
						board.getCellColor(y+1, x+1).equals(Color.red) ||  //if there is, don't move to the right
						board.getCellColor(y+2, x+2).equals(Color.red)) {
						break;
					}
					x++;
					if(y<24-3) {
						try {
							board.setCellState(y, x-1, Color.lightGray, 5);
							board.setCellState(y+1, x-1, Color.lightGray, 5);
							board.setCellState(y+2, x-1, Color.lightGray, 5);
							board.setCellState(y+2, x, Color.lightGray, 5);
						} catch (CellCollisionException e1) {
							e1.printStackTrace();
						}
					}
				}
				break;
				
			case KeyEvent.VK_SPACE:
				break;

		}
		
	}
	
		
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
