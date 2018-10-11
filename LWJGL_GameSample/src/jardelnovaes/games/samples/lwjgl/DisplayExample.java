package jardelnovaes.games.samples.lwjgl;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
 
public class DisplayExample {
 
    public void start() {
        try {
        	MessageWindow msg = new MessageWindow();
        	msg.showMessage("Starting the game, please wait!");
        	
        	DisplayMode actualDisplayMode = null;
        	int maxHeight = 0;
        	int actualHeight = 0;
        	
            for (DisplayMode displayMode : Display.getAvailableDisplayModes()) {
            	
                if( displayMode.isFullscreenCapable() ){
                    
                	actualHeight = displayMode.getHeight();
                	if(maxHeight<actualHeight){
                		maxHeight = actualHeight;
                		actualDisplayMode = displayMode;
                	}
                }
            }
            
            if(actualDisplayMode == null)
            	throw new Exception("Display mode is not capable");
            
            Display.setDisplayModeAndFullscreen(actualDisplayMode);
            
            Display.create();
            msg.close();
 
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
 
        boolean escape = false;
 
        while( !Display.isCloseRequested() && !escape ){
            int x = Mouse.getX();
            int y = Mouse.getY();
 
            String additional = "";
 
            while( Keyboard.next() ){
                int key = Keyboard.getEventKey();
                additional += " key " + key;
 
                if( key == Keyboard.KEY_ESCAPE){
                    escape = true;
                }
            }
 
            if( Keyboard.isKeyDown( Keyboard.KEY_SPACE )){
                additional+= " space";
            }
 
            additional += GL11.glGetString( GL11.GL_VERSION );
 
            additional += (Display.getDisplayMode().isFullscreenCapable() ? "" : "not ") +
                    "capable of fullscreen";
 
            Display.setTitle( "(" + x + ", " + y + ")"  + additional );
 
            // init OpenGL here
            GL11.glClearColor(0, x / 800.0f, y / 600.0f, 0.3f);
 
            // render OpenGL here
            GL11.glClear( GL11.GL_COLOR_BUFFER_BIT );
 
            Display.update();
        }
 
        Display.destroy();
    }
 
    public static void main(String[] args) {
        DisplayExample displayExample = new DisplayExample();
        displayExample.start();
    }
 
}