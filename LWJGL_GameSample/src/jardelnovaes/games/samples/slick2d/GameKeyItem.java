package jardelnovaes.games.samples.slick2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class GameKeyItem extends GameItem {

	private GameContainer gc; 
	private Graphics g;	
	
		
	
	public GameKeyItem(GameContainer gc) throws SlickException{
		this.gc = gc;
		
		super.setItem("gamedata/keyitem.gif");		
		super.setItemSize(24);
		
	}
	
	public void render(int x, int y){
		super.setActualX(x);
		super.setActualY(y);
		getItem().draw(x, y);		
	}
}
