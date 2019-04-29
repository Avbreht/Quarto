import java.awt.Graphics;

public abstract class BoardObject {
	
	protected float x, y; 
	protected ID id; 
	protected float velX, velY; 
	
	public BoardObject (float x, float y, ID id) {
		this.x = x; 
		this.y = y; 
		this.id = id;
	}
	
	public abstract void draw (Graphics g); 

}