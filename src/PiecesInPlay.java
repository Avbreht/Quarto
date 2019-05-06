
import java.awt.Graphics;
import java.util.LinkedList;

public class PiecesInPlay {
	
	public LinkedList<Piece> pieces = new LinkedList<Piece>();  
	private Platform platform;
	private TileArray tiles; 
	
//	public PiecesInPlay(Platform platform, TileArray tiles) {
//		this.platform = platform; 
//		this.tiles = tiles; 
//		
//	}

	public void draw(Graphics g) {
		for (Piece piece : pieces) {
			piece.draw(g);
		}
	}
	
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		pieces.remove(piece);
	}
	

}