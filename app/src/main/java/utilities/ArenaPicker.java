package utilities;

import com.badlogic.gdx.graphics.Texture;

public class ArenaPicker {
	
	private final int trophies;
	
	public ArenaPicker(int trophies) {
		this.trophies = trophies;
	}
	
	private boolean isBeetween(int min, int max) {
		return this.trophies >= min && this.trophies < max; 
	}
	
	private int getArenaByTrophies() {
		if(this.isBeetween(0, 100)) {
			return 1;
		} else if(this.isBeetween(100, 200)) {
			return 2;
		} else if(this.isBeetween(200, 300)) {
			return 3;
		} else {
			return 4;
		}
	}
	
	public Texture get() {
		return new Texture("Models/Arenas/Arena" + this.getArenaByTrophies() +".png");
	}
	
}
