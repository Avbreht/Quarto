
import java.awt.Color;
import java.awt.Graphics;

public class Tile extends BoardObject{

	public Tile(float x, float y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.drawOval((int) x,(int) y, 100, 100);
		
	}

}