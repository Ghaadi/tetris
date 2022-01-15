package game;
import edu.aub.cmps.*;
import java.awt.Color;
public class Game {
	static GameBoard board;
	public static void main(String[] args) throws CellCollisionException {
		board = GameBoard.createInstance("Tetris", 24, 10, Color.lightGray);
//		board.setBackColor(Color.black);
		
//		board.setCellColor(2, 5, Color.red);
		var th = new GameThread(board);
		board.addKeyListener(th);
		th.start();
	}
}
