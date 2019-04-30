
import java.awt.Graphics;
import java.util.LinkedList;

public class TileList {
	
	public LinkedList<Tile> tiles = new LinkedList<Tile>();  
	
	public void add(Tile tile) {
		this.tiles.add(tile); 
	}
	
	public void draw(Graphics g) {
		for (Tile tile : tiles) {
			tile.draw(g);
		}
	}
}