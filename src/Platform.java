import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

public class Platform {
	
	protected int plx = 1275, ply = 175;

	LinkedList<Piece> pieces = new LinkedList<Piece>();
	
	public void draw(Graphics g) {
		for (Piece piece : pieces) {
			piece.draw(g);
		}
		
		if (Game.gameState == Game.STATE.P1_Choose) {

			Font custom = new Font("arial", 1, 30);
			g.setFont(custom);
			g.setColor(Color.WHITE);
			g.drawString("Player 1, choose a piece", 1180, 70);
			
		}
		
		else if (Game.gameState == Game.STATE.P2_Choose) {

			Font custom  = new Font("arial", 1, 30);
			g.setFont(custom);
			g.setColor(Color.WHITE);
			g.drawString("Player 2, choose a piece", 1180, 70);
			
		} 
		
		else if (Game.gameState == Game.STATE.P1_Placement) {

			Font custom = new Font("arial", 1, 30);
			g.setFont(custom);
			g.setColor(Color.WHITE);
			g.drawString("Player 1, place your piece", 1170, 70);
			
		} 
		
		else if (Game.gameState == Game.STATE.P2_Placement) {

			Font custom = new Font("arial", 1, 30);
			g.setFont(custom);
			g.setColor(Color.WHITE);
			g.drawString("Player 2, place your piece", 1170, 70);
			
		} 
		
	}
	
	public boolean ready () {
		return (pieces.size() == 1);
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
		return pieces.get(0);   
	}
	
}
