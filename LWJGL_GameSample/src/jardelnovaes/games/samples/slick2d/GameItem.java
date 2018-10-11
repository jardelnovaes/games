package jardelnovaes.games.samples.slick2d;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameItem {
	private int itemSize = 64;	
	
	private Image item = null;
	private int actualX = 0;
	private int actualY = 0;
	 
	public int getActualX() {
		return actualX;
	}
	
	
	protected void setActualX(int actualX) {
	
		this.actualX = actualX;
	}
		
	public int getActualY() {
		return actualY;
	}
	
	protected void setActualY(int actualY) {
		this.actualY = actualY;
	}
	

	public int getItemSize() {
		return itemSize;
	}

	protected void setItemSize(int itemSize) {
		this.itemSize = itemSize;
	}

	public Image getItem() {
		return item;
	}

	protected void setItem(String itemdata) throws SlickException  {
		this.item = new Image(itemdata);
	}
	
}
