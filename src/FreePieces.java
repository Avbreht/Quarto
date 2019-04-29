
import java.awt.Graphics;
import java.util.LinkedList;

public class FreePieces {
	
	public LinkedList<Piece> freePieces = new LinkedList<Piece>();  
	
	public void draw(Graphics g) {
		for (Piece piece : freePieces) {
			piece.draw(g);
		}
	}
	
	public void removePiece(Piece piece) {
		this.freePieces.remove(piece); 
	}

}