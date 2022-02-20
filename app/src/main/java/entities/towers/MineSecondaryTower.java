package entities.towers;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

import entities.Entity;

public class MineSecondaryTower extends Entity {
	
	public final static int WIDTH = 50;
	public final static int HEIGHT = 68;
	
	private final Texture texture;
	
	public MineSecondaryTower(int x, int y) {
		super(new Rectangle(x, y, WIDTH, HEIGHT), Entity.Membership.FRIENDLY);
		this.texture = new Texture("Models/Towers/secondaryMineTower.png");
	}
	
	public Texture getTexture() {
		return this.texture;
	}
	
	public void dispose() {
		this.texture.dispose();
	}
	
}
