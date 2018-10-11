package jardelnovaes.games.samples.slick2d;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
//import org.newdawn.slick.geom.Rectangle;

public class SimpleSlickGame extends BasicGame {

	private Boolean started = false;
	private Boolean displayInfo = true;
	private int displayInfoY = 10;
	private String displayInfoKeyPressed = "";
		
	private Image bg = null;
	private Image gameName = null;
	private Image btnStart = null;
	private Circle pointer = null;

	private Professor prof = null;
	private GameKeyItem keyitem = null;
	
	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		pointer = new Circle(0, 0, 1);
		gameName = new Image("gamedata/gamename.png");
		btnStart = new Image("gamedata/btnStart.png");
		bg = new Image("gamedata/bg_001_001.jpg");
	
		prof = new Professor(gc);
		keyitem = new GameKeyItem(gc);
		gc.getInput().enableKeyRepeat();
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Input in = gc.getInput();
		pointer.setLocation(in.getMouseX(), in.getMouseY());
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Jarda Test Game!", 200, 10);
		
		prof.setGraphic(g);
		
		renderBG(gc, g);
		if(!started){
			renderSplash(gc, g);
			prof.drawSprite(3, 3, 250, 200);
		}
		else{
			if(keyitem != null)
				keyitem.render(gc.getWidth()-50, gc.getHeight()-50);
			prof.render();
			
		}
		
		/*
		for(int i=0; i<9; i++)
			for(int j=0; j<4; j++)
				profSheet.getSprite(i, j).draw(200 + i*profSize, 200 + j * profSize);
		*/
		
		
				
		if(displayInfo)
			displayInfo(gc, g);
		
		g.draw(pointer);
		
	}
	
	@Override
    public void keyPressed(int key, char c) {
		
		displayInfoKeyPressed = "Key Pressed: " + key + "["+ c + "]";
		
        if(!started){
        	if(key == Input.KEY_S){
        		started = true;
        	}
        }
        else{
        	if(SpriteDirectionEnum.isValidKeyCode(key)){
        		prof.setDirection(SpriteDirectionEnum.fromInt(key));
        		prof.increaseStep();
        	}
        	else{
        		if((key == Input.KEY_SPACE) && (keyitem != null)){
        			prof.pickItem(keyitem);   
        			keyitem = null;
        		}
        	}
        }
        
        
        if(key == Input.KEY_ESCAPE){
    		System.exit(0);
    	}
    }

	private void displayInfo(GameContainer gc, Graphics g){		
		displayInfoY = 10;
		
		g.drawString("Height: " + gc.getHeight(), 10, (displayInfoY+=20));
		g.drawString("Width: " + gc.getWidth(), 10, (displayInfoY+=20));
		
		g.drawString("Mouse X: " + gc.getInput().getAbsoluteMouseX(), 10, (displayInfoY+=20));
		g.drawString("Mouse Y: " + gc.getInput().getAbsoluteMouseY(), 10, (displayInfoY+=20));
		
		g.drawString(displayInfoKeyPressed, 10, (displayInfoY+=20));
		
		g.drawString(prof.getXY(), 10, (displayInfoY+=20));
		
	}
	
	private void renderBG(GameContainer gc, Graphics g){
		if(!started)
			return;
		
		bg.draw();
	}
	
	
	private void renderSplash(GameContainer gc, Graphics g){
		
		int h = gc.getHeight();
		int w = gc.getWidth();
		
		//gameName.startUse();
		//gameName.draw(w/2-gameName.getWidth(), h/2-gameName.getHeight());
		//gameName.drawCentered(w, h);
		
		//gameName.draw(1000, 2000);
		//gameName.endUse();
		
		gameName.drawCentered(w/2, h/2);
		btnStart.drawCentered(w/2, h/2 + 100);
		
		/*
		Rectangle sq = new Rectangle(w/2, h/2 + 100, btnStart.getWidth(), btnStart.getHeight());
		g.draw(sq);
		if(sq.contains(pointer))
			g.drawString("ok", 10, 120);
		*/
		
	}
	
	private boolean XXAXAIsclickArea(int x, int y){
		boolean ret = false;
			
		return ret;
	}
	public static void main(String[] args) {
		try {
			//Trecho para fixar no codigo o caminho da lib e da native do LWJGL.
			System.setProperty("java.library.path", "lib");
		    System.setProperty("org.lwjgl.librarypath", new File("lib/native").getAbsolutePath());
		    
		    //Iniciando o jogo.
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(800, 600, false);			
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);

		}
		
	}
}