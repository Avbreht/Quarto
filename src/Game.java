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
	
//	private TileArray tilesA;
	private TileArray tiles; 
	
	public enum state{
		Choice, 
		Placement, 
		End; 
	}
	
	public Game() {
		
		tiles = new TileArray();
		
		new Window (width, height, "Quarto", this);
		
		tiles.addTile(0, 0, new Tile(475, 50));
		tiles.addTile(0, 1, new Tile(595, 170));
		tiles.addTile(0, 2, new Tile(715, 290));
		tiles.addTile(0, 3, new Tile(835, 410));
		tiles.addTile(1, 0, new Tile(355, 170));
		tiles.addTile(1, 1, new Tile(475, 290));
		tiles.addTile(1, 2, new Tile(595, 410));
		tiles.addTile(1, 3, new Tile(715, 530));
		tiles.addTile(2, 0, new Tile(235, 290));
		tiles.addTile(2, 1, new Tile(355, 410));
		tiles.addTile(2, 2, new Tile(475, 530));
		tiles.addTile(2, 3, new Tile(595, 650));
		tiles.addTile(3, 0, new Tile(115, 410));
		tiles.addTile(3, 1, new Tile(235, 530));
		tiles.addTile(3, 2, new Tile(355, 650));
		tiles.addTile(3, 3, new Tile(475, 770));
		
		// if we choose to use TileList:
	//	tiles.add(new Tile(475, 770)); 
	//	tiles.add(new Tile(595, 650));
	//	tiles.add(new Tile(355, 650));
	//	tiles.add(new Tile(475, 530));
	//	tiles.add(new Tile(715, 530));
	//	tiles.add(new Tile(835, 410));
	//	tiles.add(new Tile(115, 410));
	//	tiles.add(new Tile(235, 530));
	//	tiles.add(new Tile(715, 290));
	//	tiles.add(new Tile(235, 290));
	//	tiles.add(new Tile(595, 410));
	//	tiles.add(new Tile(355, 410));
	//	tiles.add(new Tile(475, 290));
	//	tiles.add(new Tile(595, 170));
	//	tiles.add(new Tile(355, 170));
	//	tiles.add(new Tile(475, 50));
		
		
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
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.white);
		g.drawOval(110, 45, 880, 880);
		g.drawLine(1100, 1000, 1100, 0);
		
		// tiles (indexed)
	//	g.drawOval(475, 50, 150, 150); g.drawString("1, 1", 515, 90);
	//	g.drawOval(595, 170, 150, 150); g.drawString("1, 2", 635, 210);
	//	g.drawOval(715, 290, 150, 150); g.drawString("1, 3", 745, 330);
	//	g.drawOval(835, 410, 150, 150); g.drawString("1, 4", 875, 450);
	//	g.drawOval(355, 170, 150, 150); g.drawString("2, 1", 395, 210);
	//	g.drawOval(475, 290, 150, 150); g.drawString("2, 2", 515, 330);
	//	g.drawOval(595, 410, 150, 150); g.drawString("2, 3", 635, 450);
	//	g.drawOval(715, 530, 150, 150); g.drawString("2, 4", 755, 570);
	//	g.drawOval(235, 290, 150, 150); g.drawString("3, 1", 275, 330);
	//	g.drawOval(355, 410, 150, 150); g.drawString("3, 2", 395, 450);
	//	g.drawOval(475, 530, 150, 150); g.drawString("3, 3", 515, 570);
	//	g.drawOval(595, 650, 150, 150); g.drawString("3, 4", 635, 690);
	//	g.drawOval(115, 410, 150, 150); g.drawString("4, 1", 155, 450);
	//	g.drawOval(235, 530, 150, 150); g.drawString("4, 2", 275, 570);
	//	g.drawOval(355, 650, 150, 150); g.drawString("4, 3", 395, 690);
	//	g.drawOval(475, 770, 150, 150); g.drawString("4, 4", 515, 810);		
		
		
		tiles.draw(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game(); 
	}
}