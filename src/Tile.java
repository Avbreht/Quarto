
import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	
	public enum STATE {
		empty,
		takem;
	}
	
	protected int x, y; 
	protected STATE state;
	private Platform platform;
	private PiecesInPlay piecesInPlay;
	
	public Tile(int x, int y, STATE state, Platform platform, PiecesInPlay piecesInPlay) {
		this.x = x; 
		this.y = y; 
		this.state = state;
		this.platform = platform;
		this.piecesInPlay = piecesInPlay;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.drawOval(x, y, 150, 150);
		
	}
	
	public boolean clicked(int mx, int my) {
		return MouseInput.inBounds(mx, my, this.x, this.y, 150, 150);
	}
	
	public void place () {
		Piece beingPlayed = platform.getPiece();
		beingPlayed.setX(this.getX()); 
		beingPlayed.setY(this.getY());
		piecesInPlay.addPiece(beingPlayed);
	} 

}











































