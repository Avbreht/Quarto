import java.awt.Color;
import java.awt.Graphics;

public class Piece {

	public enum SIZE {
		big, 
		small; 
	}
	public enum COLOR {
		white, 
		black; 
	}
	public enum SHAPE {
		circle, 
		square;
	}
	public enum LOOP {
		with,
		without; 
	}
	
	protected int x, y; 
	protected SIZE size; 
	protected COLOR color;
	protected SHAPE shape; 
	protected LOOP loop; 
	
	Game game; 
	
	public Piece (int x, int y, SIZE size, COLOR color, 
			SHAPE shape, LOOP loop) {
		this.x = x; 
		this.y = y;
		this.size = size; 
		this.color = color; 
		this.shape = shape; 
		this.loop = loop; 
	}
	
	// (big, square) = g.drawRect(Aijx + 25, Aijy + 25, 100, 100)
	// (big, round) = g.drawOval(Aijx + 25, Aijy + 25, 100, 100)
	// (small, square) = g.drawRect(Aijx + 40, Aijy + 40, 70, 70)
	// (small, round) = g.drawOval(Aijx + 40, Aijy + 40, 70, 70)
	// big loop = g.drawOval(Aijx + 50, Aijy + 50, 50, 50)
	// small loop = g.drawOval(Aijx + 60, Aijy + 60, 30, 30)	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	public void draw(Graphics g) {
		
		if (color == COLOR.black) g.setColor(Color.black);
		else if (color == COLOR.white) g.setColor(Color.white);
		g.fillRect(x+25, y+25, 100, 100);
		
	/*	// no loop:
		if (size == false && shape == false && loop == false) {
			g.fillRect(this.x + 40, this.y + 40, 70, 70);
		}
		else if (size == false && shape == true && loop == false) {
			g.fillOval(this.x + 40, this.y + 40, 70, 70);
		}
		else if (size == true && shape == false && loop == false) {
			g.fillRect(this.x + 25, this.y + 25, 100, 100);
		}
		else if (size == true && shape == true && loop == false) {
			g.fillOval(this.x + 25, this.y + 25, 100, 100);
		}
		
		// with loop:
		else if (size == false && shape == false && loop == true) {
			g.fillRect(this.x + 40, this.y + 40, 70, 70);
			g.setColor(game.getBoardColor());
			g.drawOval(this.x + 60, this.y + 60, 30, 30);
		}
		else if (size == false && shape == true && loop == true) {
			g.fillOval(this.x + 40, this.y + 40, 70, 70);
			g.setColor(game.getBoardColor());
			g.drawOval(this.x + 60, this.y + 60, 30, 30);
		}
		else if (size == true && shape == false && loop == true) {
			g.fillRect(this.x + 25, this.y + 25, 100, 100);
			g.setColor(game.getBoardColor());
			g.drawOval(this.x + 50, this.y + 50, 50, 50);
		}
		else if (size == true && shape == true && loop == true) {
			g.fillOval(this.x + 25, this.y + 25, 100, 100);
			g.setColor(game.getBoardColor());
			g.drawOval(this.x + 50, this.y + 50, 50, 50);
		
		} */
	} 
}

















