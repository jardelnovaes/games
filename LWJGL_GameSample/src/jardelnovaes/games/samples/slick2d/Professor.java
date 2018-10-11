package jardelnovaes.games.samples.slick2d;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Professor {
	private static final int PROF_VELOCITY = 70;
	private static final int PROF_DISTANCE = 10;
	
	private GameContainer gc; 
	private Graphics g;
	private Image prof = null;
	private int profSize = 64;
	private SpriteSheet profSheet = null;
	private SpriteDirectionEnum direction = null;
	private ArrayList<GameItem> items;
	private int step = 0;
	private int actualX = 0;
	private int actualY = 0;	
	
	public Professor(GameContainer gc) throws SlickException{
		this.gc = gc;
		
		prof = new Image("gamedata/professor.png");
		profSheet = new SpriteSheet(prof, profSize, profSize);
		items = new ArrayList<GameItem>();
		
		direction = SpriteDirectionEnum.RIGHT;
		step = 1;
		actualX = 40;
		actualY = gc.getHeight() - profSize - 30;
	}
	
	private int getDirectionValue(SpriteDirectionEnum dir){
		switch (dir) {
			case UP:
				return 0;
			case DOWN:
				return 2;
			case LEFT:
				return 1;
			case RIGHT:
				return 3;
			default:
				return -1;
		}
		
	}
	
	public void setGraphic(Graphics g){
		this.g = g;
	}
	
	public void drawSprite(int x, int y, int w, int h){
		profSheet.getSprite(x, y).draw(w, h);
		
	}
	
	public void render(){
		//int h = gc.getHeight();
		//int w = gc.getWidth();
		
		//profSheet.getSprite(1, 3).draw(80, h-profSize-30);
		int h = profSheet.getSprite(step, getDirectionValue(direction)).getHeight();
		int w = profSheet.getSprite(step, getDirectionValue(direction)).getWidth();
		
		//profSheet.getSprite(step, getDirectionValue(direction)).draw(80 * step, h-profSize-30);
		profSheet.getSprite(step, getDirectionValue(direction)).draw(actualX, actualY);
		updateInventory();
		
	}

	public SpriteDirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(SpriteDirectionEnum direction) {		
		this.direction = direction;
		//System.out.println(direction);
	}
	
	private void updateXY(){
		
		switch (direction) {
			case UP:
				if ((actualY - PROF_DISTANCE) > 390-profSize)
					actualY -= PROF_DISTANCE;				
				break;
			case DOWN:
				if(actualY + PROF_DISTANCE < gc.getHeight()-profSize)
					actualY += PROF_DISTANCE;
				break;
			case LEFT:
				if(actualX > 10)
					actualX -= PROF_DISTANCE;
				break;
			case RIGHT:
				if(actualX < gc.getWidth()-profSize)
					actualX += PROF_DISTANCE;
				break;
			
		}
	}
	
	public void increaseStep(){
		if((step++) > 7)
			step = 0;
		
		try{
			Thread.sleep(PROF_VELOCITY);
		}
		catch(Exception e){}
		updateXY();
		//System.out.println("prof - step: " + step);
	}
	
	public void decreaseStep(){
		if((step--) < 0)
			step = 8;
		
		try{
			Thread.sleep(PROF_VELOCITY);
		}
		catch(Exception e){}
		updateXY();
		//System.out.println("prof - step: " + step);
	}

	public String getXY(){
		return "Professor X/Y: " + actualX + "/" + actualY;
	}
	
	public void updateInventory(){
		int x = 400;
		for(GameItem iItem: items ){
			iItem.getItem().draw(x+=iItem.getItemSize(), 20);			
		}
		
	}
	
	public boolean pickItem(GameItem item){
		if ((actualX > item.getActualX()-item.getItemSize()) && (actualX < item.getActualX()+item.getItemSize())){
			items.add(item);
			updateInventory();			
			return true;
		}
		return false;
	}
	
}
