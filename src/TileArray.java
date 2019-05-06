import java.awt.Graphics;

public class TileArray {

	private Tile[][] tiles = new Tile[4][4];	
	private Platform platform;
	
	public TileArray (Platform platform) {
		this.platform = platform;
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Tile tile = tiles[i][j]; 
				tile.draw(g);
			  //g.drawString("" + i + ", " + j, tile.x + 40, tile.y + 40);
			}
		}
	}
	
	public void addTile(int i, int j, Tile tile) {
		this.tiles[i][j] = tile;
	}
	
	public void addOnClick (int mx, int my) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Tile tile = tiles[i][j]; 
				int tx = tile.getX();
				int ty = tile.getY();
				if (MouseInput.inBounds(mx, my, tx, ty, 150, 150) && (tile.state == Tile.STATE.empty)) {
					 tile.place();
					 platform.clear();
					 if (Game.gameState == Game.STATE.P1_Placement) Game.gameState = Game.STATE.P1_Choose;
					 else if (Game.gameState == Game.STATE.P2_Placement) Game.gameState = Game.STATE.P2_Choose;
					 
				 }
			}
		}
	}   

/*	public void tick() {
		for (int i = 0; i < 4; i++) {
			Tile tile1 = tiles[i][1];
			Tile tile2 = tiles[i][2];
			Tile tile3 = tiles[i][3];
			Tile tile4 = tiles[i][4];
			
		}
	}   */


}
























