
import java.awt.Graphics;
import java.util.LinkedList;

public class ObjectList {
	
	LinkedList<BoardObject> bObjects = new LinkedList<BoardObject>();  
	
	public void draw(Graphics g) {
		for (BoardObject bObject : bObjects) {
			bObject.draw(g);
		}
	}
	
	public void add(BoardObject bObject) {
		this.bObjects.add(bObject); 
	}

}