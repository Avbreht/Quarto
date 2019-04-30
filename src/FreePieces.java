
import java.awt.Graphics;
import java.util.LinkedList;

public class FreePieces {
	
	public LinkedList<Piece> freePieces = new LinkedList<Piece>();  
	
	public void addPiece(Piece piece) {
		this.freePieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		this.freePieces.remove(piece); 
	}
	
	public void draw(Graphics g) {
		for (Piece piece : freePieces) {
			piece.draw(g);
		}
	}
}