package jardelnovaes.games.samples.slick2d;

public enum SpriteDirectionEnum {
	UP(200),
	DOWN(208),
	LEFT(203),
	RIGHT(205);
	
	private int keycode = -1;
	
	SpriteDirectionEnum(int key){
		this.keycode = key;
	}
	
	public static boolean isValidKeyCode(int key){
		for(SpriteDirectionEnum dir: SpriteDirectionEnum.values()){
			if(dir.keycode == key)
				return true;
		}
		return false;
	}
		
	public static SpriteDirectionEnum fromInt(int key){
		if(isValidKeyCode(key)){
			for(SpriteDirectionEnum dir: SpriteDirectionEnum.values()){
				if(dir.keycode == key)
					return dir;
			}
		}
		return null;
	}
	
}
