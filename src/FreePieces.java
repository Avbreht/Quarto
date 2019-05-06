
import java.awt.Graphics;
import java.util.LinkedList;

public class FreePieces {
	
	LinkedList<Piece> pieces = new LinkedList<Piece>();
	private Platform platform; 
	
	public FreePieces(Platform platform) {
		this.platform = platform;
	}
	
/*	public void tick() {
		
	}   */
	
	public void draw(Graphics g) {
		for (Piece piece : pieces) {
			piece.draw(g);
		}
	}
	
	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		this.pieces.remove(piece); 
	}
	
/*	public Piece getPiece (int x, int y) {
		for (Piece piece : pieces) {
			if (piece.x == x && piece.y == y) {
				return piece; 
			}
		}
	}  */
	
	public int coordError (Piece p) {
		if (p.size == Piece.SIZE.big) return 25;
		else return 40;
		
	}
	
	public void removeOnClick (int mx, int my) {
		
			LinkedList<Piece> auxiliary = new LinkedList<Piece>(); 
			for (Piece piece : pieces) {
				int px = piece.getX();
				int py = piece.getY();
				int ce = coordError(piece);
				int pl = Piece.pieceLength(piece);
				if (MouseInput.inBounds(mx, my, px + ce, py + ce, pl, pl)) {
					piece.setX(1275);
					piece.setY(175);
					platform.addPiece(piece);
					if (Game.gameState == Game.STATE.P1_Choose) Game.gameState = Game.STATE.P2_Placement;
					else if (Game.gameState == Game.STATE.P2_Choose) Game.gameState = Game.STATE.P1_Placement;
				}
				else auxiliary.add(piece);
			}
			this.pieces = auxiliary; 	
	}
}




















