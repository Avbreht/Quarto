import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1169216312278450738L;

	public static final int width = 1600; 
	public static final int height = 1000; 
	
	private Thread thread; 
	private boolean running = false; 
	
	private TileArray tiles; 
	private FreePieces freePieces; 
	
	private int A00x = 475, A00y = 50,  A01x = 595, A01y = 170, A02x = 715, A02y = 290, A03x = 835, A03y = 410;
	private int A10x = 355, A10y = 170, A11x = 475, A11y = 290, A12x = 595, A12y = 410, A13x = 715, A13y = 530;
	private int A20x = 235, A20y = 290, A21x = 355, A21y = 410, A22x = 475, A22y = 530, A23x = 595, A23y = 650;
	private int A30x = 115, A30y = 410, A31x = 235, A31y = 530, A32x = 355, A32y = 650, A33x = 475, A33y = 770;
	
	private static final Color boardColor = new Color(100, 30, 0);
	
	public enum STATE{
		Choice, 
		Placement, 
		End; 
	}
	
	public Color getBoardColor () {
		return boardColor; 
	}
	
	public Game() {
		
		tiles = new TileArray();
		freePieces = new FreePieces();
		
		new Window (width, height, "Quarto", this);
		
		tiles.addTile(0, 0, new Tile(A00x, A00y, false));
		tiles.addTile(0, 1, new Tile(A01x, A01y, false));
		tiles.addTile(0, 2, new Tile(A02x, A02y, false));
		tiles.addTile(0, 3, new Tile(A03x, A03y, false));
		tiles.addTile(1, 0, new Tile(A10x, A10y, false));
		tiles.addTile(1, 1, new Tile(A11x, A11y, false));
		tiles.addTile(1, 2, new Tile(A12x, A12y, false));
		tiles.addTile(1, 3, new Tile(A13x, A13y, false));
		tiles.addTile(2, 0, new Tile(A20x, A20y, false));
		tiles.addTile(2, 1, new Tile(A21x, A21y, false));
		tiles.addTile(2, 2, new Tile(A22x, A22y, false));
		tiles.addTile(2, 3, new Tile(A23x, A23y, false));
		tiles.addTile(3, 0, new Tile(A30x, A30y, false));
		tiles.addTile(3, 1, new Tile(A31x, A31y, false));
		tiles.addTile(3, 2, new Tile(A32x, A32y, false));
		tiles.addTile(3, 3, new Tile(A33x, A33y, false));
		
		
		freePieces.addPiece(new Piece(A33x, A33y, Piece.SIZE.big, Piece.COLOR.white, Piece.SHAPE.square, Piece.LOOP.without));
		freePieces.addPiece(new Piece(A22x, A22y, Piece.SIZE.big, Piece.COLOR.black, Piece.SHAPE.circle, Piece.LOOP.without));
		freePieces.addPiece(new Piece(A23x, A23y, Piece.SIZE.small, Piece.COLOR.white, Piece.SHAPE.square, Piece.LOOP.with));
		
	}

	public synchronized void start() {
		thread = new Thread(this); 
		thread.start(); 
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join(); 
			running = false; 
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	// the game loop: 
		public void run() {
			this.requestFocus(); // we won't need to click the window every time we open a new game
			long lastTime = System.nanoTime(); 
			double amountOfTricks = 60.0;
			double ns = 1000000000 / amountOfTricks; 
			double delta = 0; 
			long timer = System.currentTimeMillis();
			int frames = 0; 
			while(running) {
				long now = System.nanoTime(); 
				delta += (now - lastTime) / ns; 
				lastTime = now; 
				while(delta >= 1) {
					init(); 
					delta--; 
				}
				if(running)
					draw(); 
				frames++; 
				
			//	if(System.currentTimeMillis() - timer > 1000) {
			//		timer += 1000; 
			//		System.out.println("FPS: " + frames); 
			//		frames = 0;
			//	}
			}
			stop(); 
		}

	private void init() {
		
	}
		
	private void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3); 
			return; 
		}
		Graphics g = bs.getDrawGraphics(); 
		
		
		g.setColor(boardColor);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.yellow);
		g.drawOval(110, 45, 880, 880);
		g.drawLine(1100, 1000, 1100, 0);		
		
		//================================================
		
		g.setColor(Color.white);
		
		g.fillRect(A00x + 25, A00y + 25, 100, 100);
		g.setColor(boardColor);
		g.fillOval(A00x + 50, A00y + 50, 50, 50);
		
		g.setColor(Color.white);
		g.fillRect(A01x + 40, A01y + 40, 70, 70);
		
		g.setColor(Color.black);
		g.fillOval(A20x + 25, A20y + 25, 100, 100);
		g.fillOval(A11x + 40, A11y + 40, 70, 70);
		g.setColor(boardColor);
		g.fillOval(A11x + 60, A11y + 60, 30, 30);
		
		g.setColor(Color.white);
		
		
		// free pieces:
		g.fillRect(1120, 830, 100, 100);
		g.fillRect(1240, 830, 100, 100);
		g.setColor(boardColor);
		g.fillOval(1265, 855, 50, 50);
		
		g.setColor(Color.black);
		g.fillRect(1360, 830, 100, 100);
		g.fillRect(1480, 830, 100, 100);
		g.setColor(boardColor);
		g.fillOval(1505, 855, 50, 50);
		
		g.setColor(Color.white);
		g.fillOval(1120, 690, 100, 100);
		g.fillOval(1240, 690, 100, 100);
		g.setColor(boardColor);
		g.fillOval(1265, 715, 50, 50);
		
		g.setColor(Color.black);
		g.fillOval(1360, 690, 100, 100);
		g.fillOval(1480, 690, 100, 100);
		g.setColor(boardColor);
		g.fillOval(1505, 715, 50, 50);
		
		g.setColor(Color.white);
		g.fillRect(1135, 580, 70, 70);
		g.fillRect(1255, 580, 70, 70);
		g.setColor(boardColor);
		g.fillOval(1275, 600, 30, 30);
		
		g.setColor(Color.black);
		g.fillRect(1375, 580, 70, 70);
		g.fillRect(1495, 580, 70, 70);
		g.setColor(boardColor);
		g.fillOval(1515, 600, 30, 30);
		
		g.setColor(Color.white);
		g.fillOval(1135, 470, 70, 70);
		g.fillOval(1255, 470, 70, 70);
		g.setColor(boardColor);
		g.fillOval(1275, 490, 30, 30);
		
		g.setColor(Color.black);
		g.fillOval(1375, 470, 70, 70);
		g.fillOval(1495, 470, 70, 70);
		g.setColor(boardColor);
		g.fillOval(1515, 490, 30, 30);
		
		
		
		
		tiles.draw(g);
		freePieces.draw(g);
		
		
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game(); 
	}
}