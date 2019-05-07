import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1169216312278450738L;

	public static final int width = 1600; 
	public static final int height = 1000; 
	
	private Thread thread; 
	private boolean running = false; 

	private Platform platform;
	private TileArray tiles; 
	private FreePieces freePieces; 
	
	// background:
	public static Color boardColor = new Color(100, 30, 0);
	
	public enum STATE{
		P1_Choose,
		P2_Choose,
		P1_Placement,
		P2_Placement,
		P1_Wins,
		P2_Wins; 
	}
	
	public static STATE gameState = STATE.P1_Choose;
	
	public Game() {
		
		platform = new Platform(); 
		tiles = new TileArray(platform);
		freePieces = new FreePieces(platform);
		
		new Window (width, height, "Quarto", this);
	
		this.addMouseListener(new MouseInput(this, freePieces, platform, tiles)); 
		
		// initial state of the tiles:
		tiles.initialize();
		
		// initial state of the game pieces:
		freePieces.initialize();
		
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
	
	public void restart() {
		gameState = STATE.P1_Choose;
		tiles.clear();
		freePieces.clear();
		tiles.initialize();
		freePieces.initialize();
	}
	
		// game loop: 
		public void run() {
			this.requestFocus(); // we won't need to click the window every time we open a new game
			long lastTime = System.nanoTime(); 
			double amountOfTricks = 60.0;
			double ns = 1000000000 / amountOfTricks; 
			double delta = 0; 
			while(running) {
				long now = System.nanoTime(); 
				delta += (now - lastTime) / ns; 
				lastTime = now; 
				while(delta >= 1) {
					tick(); 
					delta--; 
				}
				if(running)
					draw(); 
			}
			stop(); 
		}

	// update the game as we make changes:
	private void tick() {
		tiles.tick();
		if (gameState == STATE.P1_Wins || gameState == STATE.P2_Wins) this.freePieces.clear();
	}
		
	private void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3); 
			return; 
		}
		Graphics g = bs.getDrawGraphics(); 
		
		// Draw the game board:
		g.setColor(boardColor);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.yellow);
		g.drawOval(110, 45, 880, 880);
		
		// Separate the tiles from the side bar: 
		g.drawLine(1100, 1000, 1100, 0);	
		
		// Draw the piece to be placed: 
		platform.draw(g);
		
		//Draw the tiles:
		tiles.draw(g);
		
		// Draw the free pieces:
		freePieces.draw(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game(); 
	}
}