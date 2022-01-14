package shapes;

import java.util.Random;

public class Shapes {

	private char[] shapes = {'O', 'I', 'S', 'Z', 'L', 'J', 'T'};
	private Random rand = new Random();
	
	public char getShape() {
		return shapes[rand.nextInt(shapes.length)];
	}
	
	public int getRotation() {
		return rand.nextInt(4) + 1;
	}
	
}
