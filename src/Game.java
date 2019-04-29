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
	
	public Game() {
		
		// initialize he board objects:
		oList = new ObjectList();
		
		// initialize the game window:
		new Window (width, height, "Quarto", this);
		
		oList.add(new Tile(500, 800, ID.Tile));
		
		oList.add(new Tile(620, 700, ID.Tile));
		oList.add(new Tile(720, 600, ID.Tile));
		oList.add(new Tile(820, 500, ID.Tile));
		oList.add(new Tile(720, 400, ID.Tile));
		oList.add(new Tile(620, 300, ID.Tile));
		
		oList.add(new Tile(380, 700, ID.Tile));
		oList.add(new Tile(280, 600, ID.Tile));
		oList.add(new Tile(180, 500, ID.Tile));
		oList.add(new Tile(280, 400, ID.Tile));
		oList.add(new Tile(380, 300, ID.Tile));
		
		oList.add(new Tile(500, 200, ID.Tile));
		
		oList.add(new Tile(500, 400, ID.Tile));
		oList.add(new Tile(500, 600, ID.Tile));
		oList.add(new Tile(620, 500, ID.Tile));
		oList.add(new Tile(380, 500, ID.Tile));
		
		
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
		g.drawOval(150, 150, 800, 800);
		g.drawLine(1100, 1000, 1100, 0);
		
		oList.draw(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game(); 
	}
}