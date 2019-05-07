
import java.awt.Graphics;
import java.util.LinkedList;

public class FreePieces {
	
	// coordinates of the free pieces:
	public int c1 = 805, c2 = 665, c3 = 540, c4 = 430;
	public int r1 = 1095, r2 = 1215, r3 = 1335, r4 = 1455; 
	
	LinkedList<Piece> pieces = new LinkedList<Piece>();
	private Platform platform; 
	
	public FreePieces(Platform platform) {
		this.platform = platform;
	}
	
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
	
	public void clear() {
		pieces = new LinkedList<Piece>();
	}
	
	public int coordError (Piece p) {
		if (p.size == Piece.SIZE.big) return 25;
		else return 40;
		
	}
	
	public void removeOnClick (int mx, int my) {
		
			LinkedList<Piece> auxiliary = new LinkedList<Piece>(); 
			for (Piece piece : pieces) {
				int px = piece.getX();
				int py = piece.getY();
				int ce = coordError(piece);   // to get the right coordinates for the rectangle
				int ps = Piece.pieceSize(piece);
				if (MouseInput.inBounds(mx, my, px + ce, py + ce, ps, ps)) {
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
	
	public void initialize() {
		this.addPiece(new Piece(r1, c1, Piece.SIZE.big, Piece.COLOR.white, Piece.SHAPE.square, Piece.LOOP.without));
		this.addPiece(new Piece(r2, c1, Piece.SIZE.big, Piece.COLOR.white, Piece.SHAPE.square, Piece.LOOP.with));
		this.addPiece(new Piece(r3, c1, Piece.SIZE.big, Piece.COLOR.black, Piece.SHAPE.square, Piece.LOOP.without));
		this.addPiece(new Piece(r4, c1, Piece.SIZE.big, Piece.COLOR.black, Piece.SHAPE.square, Piece.LOOP.with));
		this.addPiece(new Piece(r1, c2, Piece.SIZE.big, Piece.COLOR.white, Piece.SHAPE.circle, Piece.LOOP.without));
		this.addPiece(new Piece(r2, c2, Piece.SIZE.big, Piece.COLOR.white, Piece.SHAPE.circle, Piece.LOOP.with));
		this.addPiece(new Piece(r3, c2, Piece.SIZE.big, Piece.COLOR.black, Piece.SHAPE.circle, Piece.LOOP.without));
		this.addPiece(new Piece(r4, c2, Piece.SIZE.big, Piece.COLOR.black, Piece.SHAPE.circle, Piece.LOOP.with));
		this.addPiece(new Piece(r1, c3, Piece.SIZE.small, Piece.COLOR.white, Piece.SHAPE.square, Piece.LOOP.without));
		this.addPiece(new Piece(r2, c3, Piece.SIZE.small, Piece.COLOR.white, Piece.SHAPE.square, Piece.LOOP.with));
		this.addPiece(new Piece(r3, c3, Piece.SIZE.small, Piece.COLOR.black, Piece.SHAPE.square, Piece.LOOP.without));
		this.addPiece(new Piece(r4, c3, Piece.SIZE.small, Piece.COLOR.black, Piece.SHAPE.square, Piece.LOOP.with));
		this.addPiece(new Piece(r1, c4, Piece.SIZE.small, Piece.COLOR.white, Piece.SHAPE.circle, Piece.LOOP.without));
		this.addPiece(new Piece(r2, c4, Piece.SIZE.small, Piece.COLOR.white, Piece.SHAPE.circle, Piece.LOOP.with));
		this.addPiece(new Piece(r3, c4, Piece.SIZE.small, Piece.COLOR.black, Piece.SHAPE.circle, Piece.LOOP.without));
		this.addPiece(new Piece(r4, c4, Piece.SIZE.small, Piece.COLOR.black, Piece.SHAPE.circle, Piece.LOOP.with));
	}
}




















