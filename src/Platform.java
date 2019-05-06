import java.awt.Graphics;
import java.util.LinkedList;

public class Platform {
	
	protected int plx = 1275, ply = 175;

	LinkedList<Piece> pieces = new LinkedList<Piece>();
	
	public void draw(Graphics g) {
		for (Piece piece : pieces) {
			piece.draw(g);
		}  
		
	}
	
	public boolean ready () {
		return (this.pieces.size() == 1);
	}
	
	public void addPiece(Piece piece) {
		if (!this.ready()) { 
			this.pieces.add(piece);
		}
	}
	
	public void clear() {
		this.pieces = new LinkedList<Piece>(); 
	}
	
	public Piece getPiece() {
		return this.pieces.get(0);   
	}
	
}
