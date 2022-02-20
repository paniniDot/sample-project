package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	
	public static enum Membership {
		ENEMY, FRIENDLY;
	}
	
	private Rectangle bounds;
	private final Membership membership;
	
	public Entity(Rectangle area, Membership membership) {
		this.bounds = area;
		this.membership = membership;
	}

	public Rectangle getBounds() {
		return this.bounds;
	}

	public Membership getMembership() {
		return this.membership;
	}
	
	public Vector2 getPosition() {
		return new Vector2(this.bounds.x, this.bounds.y);
	}
	
	public void setPosition(Vector2 coords) {
		this.bounds = new Rectangle(coords.x, coords.y, this.bounds.width, this.bounds.height);
	}
	
}
