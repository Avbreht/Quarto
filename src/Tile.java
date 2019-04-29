
import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	
	protected int x, y; 

	public Tile(int x, int y) {
		this.x = x; 
		this.y = y; 
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.drawOval((int) x,(int) y, 150, 150);
		
	}

}