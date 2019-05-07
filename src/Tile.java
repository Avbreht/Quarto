
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Tile {
	
	public enum STATE {
		empty,
		taken;
	}
	
	protected int x, y; 
	protected STATE state;
	private Platform platform;
	private PiecesInPlay piecesInPlay;
	LinkedList<Piece> onTile = new LinkedList<Piece>();
	
	public Tile(int x, int y, STATE state, Platform platform, LinkedList<Piece> onTile) {
		this.x = x; 
		this.y = y; 
		this.state = state;
		this.platform = platform;
		this.onTile = onTile;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Piece getPiece(){
		return this.onTile.get(0);
	}

	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.drawOval(x, y, 150, 150);
		if (this.state == STATE.taken) {
			this.getPiece().draw(g);
		}
		
	}
	
	public boolean clicked(int mx, int my) {
		return MouseInput.inBounds(mx, my, this.x, this.y, 150, 150);
	}
	
	public void place () {
		Piece beingPlayed = platform.getPiece();
		beingPlayed.setX(this.getX()); 
		beingPlayed.setY(this.getY());
		this.onTile.add(beingPlayed);
		this.state = STATE.taken;
	} 

	
	/* Change the constructor of the tile so that it also has an initially empty list
	 * in which the piece placed on the tile is added.
	 * Then make a method to get the piece saved in that list.
	 * Add the piece in the list with the place() method.
	 * In the TileArray class make the draw() method also look at the 
	 * individual lists of the tiles.
	 * If it contains a game piece the method should also draw the piece.
	 * With this the PiecesInPlay class could become redundant */
	
	
	
}











































