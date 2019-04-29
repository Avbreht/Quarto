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
	private ObjectList oList; 
	
	public enum state{
		Choice, 
		Placement, 
		End; 
	}
	
	public Game() {
		
		// initialize he board objects:
		oList = new ObjectList();
		
		// initialize the game window:
		new Window (width, height, "Quarto", this);
		
		// initialize tiles: 
		oList.add(new Tile(475, 770, ID.Tile));
		oList.add(new Tile(595, 650, ID.Tile));
		oList.add(new Tile(355, 650, ID.Tile));
		oList.add(new Tile(475, 530, ID.Tile));
		oList.add(new Tile(715, 530, ID.Tile));
		oList.add(new Tile(835, 410, ID.Tile));
		oList.add(new Tile(115, 410, ID.Tile));
		oList.add(new Tile(235, 530, ID.Tile));
		oList.add(new Tile(715, 290, ID.Tile));
		oList.add(new Tile(235, 290, ID.Tile));
		oList.add(new Tile(595, 410, ID.Tile));
		oList.add(new Tile(355, 410, ID.Tile));
		oList.add(new Tile(475, 290, ID.Tile));
		oList.add(new Tile(595, 170, ID.Tile));
		oList.add(new Tile(355, 170, ID.Tile));
		oList.add(new Tile(475, 50, ID.Tile));
		
		
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
		
		// tiles (for debugging):
	//	g.drawOval(475, 770, 150, 150);
	//	g.drawOval(595, 650, 150, 150);
	//	g.drawOval(355, 650, 150, 150);
	//	g.drawOval(475, 530, 150, 150);
	//	g.drawOval(715, 530, 150, 150);
	//	g.drawOval(835, 410, 150, 150);
	//	g.drawOval(115, 410, 150, 150);
	//	g.drawOval(235, 530, 150, 150);
	//	g.drawOval(715, 290, 150, 150);
	//	g.drawOval(235, 290, 150, 150);
	//	g.drawOval(595, 410, 150, 150);
	//	g.drawOval(355, 410, 150, 150);
	//	g.drawOval(475, 290, 150, 150);
	//	g.drawOval(595, 170, 150, 150);
	//	g.drawOval(355, 170, 150, 150);
	//	g.drawOval(475, 50, 150, 150);
		
		oList.draw(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game(); 
	}
}