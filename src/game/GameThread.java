package game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import edu.aub.cmps.*;
import shapes.Shapes;

import java.util.Random;

public class GameThread extends Thread implements KeyListener {
	
	private GameBoard board;
	private Shapes shapes = new Shapes();
	private Random rand = new Random(System.nanoTime());
	private int x;
	private int y = 0;
	private char shape;
	
	public GameThread(GameBoard board) {
		this.board=board;
	}
	
	@Override
	public void run() {
		try {
//			int i = 0;
			for(int j = 0; j < 10; j++) {
//				shape = shapes.getShape();
				shape = 'T';
				moveDown(shape);
				GameBoard.MediaPlayer.playKnock();
			}
		} catch (CellCollisionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void moveDown(char shape) throws CellCollisionException, InterruptedException {

		if(shape == 'I') {
			x = rand.nextInt(10);
			for(int top = 0;top<24-3;top++) {
				y = top;
				board.setCellState(top, x, Color.cyan, 5);
				board.setCellState(top+1, x, Color.cyan, 5);
				board.setCellState(top+2, x, Color.cyan, 5);
				board.setCellState(top+3, x, Color.cyan, 5);
				Thread.sleep(300);
				
				if(top<24-4){
					if(!board.getCellColor(top+4, x).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top+1, x, Color.lightGray, 5);
					board.setCellState(top+2, x, Color.lightGray, 5);
					board.setCellState(top+3, x, Color.lightGray, 5);
				}
			}
		}
		
		else if(shape == 'O') {
			x = rand.nextInt(9);
			for(int top = 0;top<24-1;top++) {
				y = top;
				board.setCellState(top, x, Color.yellow, 5);
				board.setCellState(top, x+1, Color.yellow, 5);
				board.setCellState(top+1, x, Color.yellow, 5);
				board.setCellState(top+1, x+1, Color.yellow, 5);
				Thread.sleep(300);
				
				if(top<24-2){
					if(!board.getCellColor(top+2, x).equals(Color.lightGray) || !board.getCellColor(top+2, x+1).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top, x+1, Color.lightGray, 5);
					board.setCellState(top+1, x, Color.lightGray, 5);
					board.setCellState(top+1, x+1, Color.lightGray, 5);
				}
			}
		}
		
		else if(shape == 'S') {
			x = rand.nextInt(8) + 2;
			for(int top = 0;top<24-1;top++) {
				y = top;
				board.setCellState(top, x, Color.green, 5);
				board.setCellState(top, x-1, Color.green, 5);
				board.setCellState(top+1, x-1, Color.green, 5);
				board.setCellState(top+1, x-2, Color.green, 5);
				Thread.sleep(300);
				
				if(top<24-2){
					if(!board.getCellColor(top+1, x).equals(Color.lightGray) || !board.getCellColor(top+2, x-1).equals(Color.lightGray) || !board.getCellColor(top+2, x-2).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top, x-1, Color.lightGray, 5);
					board.setCellState(top+1, x-1, Color.lightGray, 5);
					board.setCellState(top+1, x-2, Color.lightGray, 5);
				}
			}
		}
		
		else if(shape == 'Z') {
			x = rand.nextInt(7) + 1;
			for(int top = 0;top<24-1;top++) {
				y = top;
				board.setCellState(top, x, Color.red, 5);
				board.setCellState(top, x+1, Color.red, 5);
				board.setCellState(top+1, x+1, Color.red, 5);
				board.setCellState(top+1, x+2, Color.red, 5);
				Thread.sleep(300);
				
				if(top<24-2){
					if(!board.getCellColor(top+1, x).equals(Color.lightGray) || !board.getCellColor(top+2, x+1).equals(Color.lightGray) || !board.getCellColor(top+2, x+2).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top, x+1, Color.lightGray, 5);
					board.setCellState(top+1, x+1, Color.lightGray, 5);
					board.setCellState(top+1, x+2, Color.lightGray, 5);
				}
			}
		}
		
		else if(shape == 'L') {
			x = rand.nextInt(9);
			for(int top = 0;top<24-2;top++) {
				y = top;
				board.setCellState(top, x, Color.orange, 5);
				board.setCellState(top+1, x, Color.orange, 5);
				board.setCellState(top+2, x, Color.orange, 5);
				board.setCellState(top+2, x+1, Color.orange, 5);
				Thread.sleep(300);
				
				if(top<24-3){
					if(!board.getCellColor(top+3, x).equals(Color.lightGray) || !board.getCellColor(top+3, x+1).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top+1, x, Color.lightGray, 5);
					board.setCellState(top+2, x, Color.lightGray, 5);
					board.setCellState(top+2, x+1, Color.lightGray, 5);
				}
			}
		}
		
		else if(shape == 'J') {
			x = rand.nextInt(8) + 1;
			for(int top = 0;top<24-2;top++) {
				y = top;
				board.setCellState(top, x, Color.blue, 5);
				board.setCellState(top+1, x, Color.blue, 5);
				board.setCellState(top+2, x, Color.blue, 5);
				board.setCellState(top+2, x-1, Color.blue, 5);
				Thread.sleep(300);
				
				if(top<24-3){
					if(!board.getCellColor(top+3, x).equals(Color.lightGray) || !board.getCellColor(top+3, x-1).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top+1, x, Color.lightGray, 5);
					board.setCellState(top+2, x, Color.lightGray, 5);
					board.setCellState(top+2, x-1, Color.lightGray, 5);
				}
			}
		}
		
		else if(shape == 'T') {
			x = rand.nextInt(8) + 1;
			for(int top = 0;top<24-1;top++) {
				y = top;
				board.setCellState(top, x, new Color(100, 0, 100), 5);
				board.setCellState(top, x-1, new Color(100, 0, 100), 5);
				board.setCellState(top, x+1, new Color(100, 0, 100), 5);
				board.setCellState(top+1, x, new Color(100, 0, 100), 5);
				Thread.sleep(300);
				
				if(top<24-2){
					if(!board.getCellColor(top+1, x-1).equals(Color.lightGray) || !board.getCellColor(top+2, x).equals(Color.lightGray) || !board.getCellColor(top+1, x+1).equals(Color.lightGray)) {
						break;
					}
					board.setCellState(top, x, Color.lightGray, 5);
					board.setCellState(top, x-1, Color.lightGray, 5);
					board.setCellState(top, x+1, Color.lightGray, 5);
					board.setCellState(top+1, x, Color.lightGray, 5);
				}
			}
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
				moveLeft(this.shape);
				break;
			
			case KeyEvent.VK_RIGHT:
				moveRight(this.shape);
				break;
				
			case KeyEvent.VK_SPACE:
				break;

		}
		
	}
	
	private void moveLeft(char shape) {
		
		if(shape == 'I') {
			if(x > 0) {
				if(!board.getCellColor(y, x-1).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x-1).equals(Color.lightGray) ||  //if there is, don't move to the left
					!board.getCellColor(y+2, x-1).equals(Color.lightGray) ||
					!board.getCellColor(y+3, x-1).equals(Color.lightGray)) {
					return;
				}
				x--;
				if(y<24-3) {
					try {
						board.setCellState(y, x+1, Color.lightGray, 5);
						board.setCellState(y+1, x+1, Color.lightGray, 5);
						board.setCellState(y+2, x+1, Color.lightGray, 5);
						board.setCellState(y+3, x+1, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'O') {
			if(x > 0) {
				if(!board.getCellColor(y, x-1).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x-1).equals(Color.lightGray)) {  //if there is, don't move to the left
					return;
				}
				x--;
				if(y<24-3) {
					try {
						board.setCellState(y, x+1, Color.lightGray, 5);
						board.setCellState(y, x+2, Color.lightGray, 5);
						board.setCellState(y+1, x+1, Color.lightGray, 5);
						board.setCellState(y+1, x+2, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'S') {
			if(x > 2) {
				if(!board.getCellColor(y, x-2).equals(Color.lightGray) ||  	     //checks if there's any block to the left
					!board.getCellColor(y+1, x-3).equals(Color.lightGray)) {     //if there is, don't move to the right
					return;
				}
				x--;
				if(y<24-3) {
					try {
						board.setCellState(y, x+1, Color.lightGray, 5);
						board.setCellState(y, x, Color.lightGray, 5);
						board.setCellState(y+1, x, Color.lightGray, 5);
						board.setCellState(y+1, x-1, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'Z') {
			if(x > 0) {
				if(!board.getCellColor(y, x-1).equals(Color.lightGray) ||  	  	//checks if there's any block to the left
					!board.getCellColor(y+1, x).equals(Color.lightGray)) {    //if there is, don't move to the right
					return;
				}
				x--;
				if(y<24-3) {
					try {
						board.setCellState(y, x+1, Color.lightGray, 5);
						board.setCellState(y, x+2, Color.lightGray, 5);
						board.setCellState(y+1, x+2, Color.lightGray, 5);
						board.setCellState(y+1, x+3, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'L') {
			if(x > 0) {
				if(!board.getCellColor(y, x-1).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x-1).equals(Color.lightGray) ||  //if there is, don't move to the left
					!board.getCellColor(y+2, x-1).equals(Color.lightGray)) {
					return;
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
		}
		
		else if(shape == 'J') {
			if(x > 1) {
				if(!board.getCellColor(y, x-1).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x-1).equals(Color.lightGray) ||  //if there is, don't move to the left
					!board.getCellColor(y+2, x-2).equals(Color.lightGray)) {
					return;
				}
				x--;
				if(y<24-3) {
					try {
						board.setCellState(y, x+1, Color.lightGray, 5);
						board.setCellState(y+1, x+1, Color.lightGray, 5);
						board.setCellState(y+2, x+1, Color.lightGray, 5);
						board.setCellState(y+2, x, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'T') {
			if(x > 1) {
				if(!board.getCellColor(y, x-2).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x-1).equals(Color.lightGray)) {  //if there is, don't move to the left
					return;
				}
				x--;
				if(y<24-3) {
					try {
						board.setCellState(y, x+1, Color.lightGray, 5);
						board.setCellState(y, x, Color.lightGray, 5);
						board.setCellState(y, x+2, Color.lightGray, 5);
						board.setCellState(y+1, x+1, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	
	private void moveRight(char shape) {
		
		if(shape == 'I') {
			if(x < 9) {
				if(!board.getCellColor(y, x+1).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x+1).equals(Color.lightGray) ||  //if there is, don't move to the left
					!board.getCellColor(y+2, x+1).equals(Color.lightGray) ||
					!board.getCellColor(y+3, x+1).equals(Color.lightGray)) {
					return;
				}
				x++;
				if(y<24-3) {
					try {
						board.setCellState(y, x-1, Color.lightGray, 5);
						board.setCellState(y+1, x-1, Color.lightGray, 5);
						board.setCellState(y+2, x-1, Color.lightGray, 5);
						board.setCellState(y+3, x-1, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'O') {
			if(x < 8) {
				if(!board.getCellColor(y, x+2).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x+2).equals(Color.lightGray)) {  //if there is, don't move to the left
					return;
				}
				x++;
				if(y<24-3) {
					try {
						board.setCellState(y, x-1, Color.lightGray, 5);
						board.setCellState(y, x, Color.lightGray, 5);
						board.setCellState(y+1, x-1, Color.lightGray, 5);
						board.setCellState(y+1, x, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'S') {
			if(x < 9) {
				if(!board.getCellColor(y, x+1).equals(Color.lightGray) ||  	     //checks if there's any block to the left
					!board.getCellColor(y+1, x).equals(Color.lightGray)) {     //if there is, don't move to the right
					return;
				}
				x++;
				if(y<24-3) {
					try {
						board.setCellState(y, x-1, Color.lightGray, 5);
						board.setCellState(y, x-2, Color.lightGray, 5);
						board.setCellState(y+1, x-2, Color.lightGray, 5);
						board.setCellState(y+1, x-3, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'Z') {
			if(x < 7) {
				if(!board.getCellColor(y, x+2).equals(Color.lightGray) ||  	  	//checks if there's any block to the left
					!board.getCellColor(y+1, x+3).equals(Color.lightGray)) {    //if there is, don't move to the right
					return;
				}
				x++;
				if(y<24-3) {
					try {
						board.setCellState(y, x-1, Color.lightGray, 5);
						board.setCellState(y, x, Color.lightGray, 5);
						board.setCellState(y+1, x, Color.lightGray, 5);
						board.setCellState(y+1, x+1, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'L') {
			if(x < 8) {
				if(!board.getCellColor(y, x+1).equals(Color.lightGray) ||     //checks if there's any block to the right
					!board.getCellColor(y+1, x+1).equals(Color.lightGray) ||  //if there is, don't move to the right
					!board.getCellColor(y+2, x+2).equals(Color.lightGray)) {
					return;
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
		}
		
		else if(shape == 'J') {
			if(x < 9) {
				if(!board.getCellColor(y, x+1).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x+1).equals(Color.lightGray) ||  //if there is, don't move to the left
					!board.getCellColor(y+2, x+1).equals(Color.lightGray)) {
					return;
				}
				x++;
				if(y<24-3) {
					try {
						board.setCellState(y, x-1, Color.lightGray, 5);
						board.setCellState(y+1, x-1, Color.lightGray, 5);
						board.setCellState(y+2, x-1, Color.lightGray, 5);
						board.setCellState(y+2, x-2, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		else if(shape == 'T') {
			if(x < 8) {
				if(!board.getCellColor(y, x+2).equals(Color.lightGray) ||     //checks if there's any block to the left
					!board.getCellColor(y+1, x+1).equals(Color.lightGray)) {  //if there is, don't move to the left
					return;
				}
				x++;
				if(y<24-3) {
					try {
						board.setCellState(y, x-1, Color.lightGray, 5);
						board.setCellState(y, x-2, Color.lightGray, 5);
						board.setCellState(y, x, Color.lightGray, 5);
						board.setCellState(y+1, x-1, Color.lightGray, 5);
					} catch (CellCollisionException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
