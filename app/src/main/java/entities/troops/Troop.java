package entities.troops;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import animations.Animation;
import entities.Entity;

public class Troop extends Entity {
	
	private final int maxHealth;
	private int currentHealth;
	private final int attackStrength;
	private final int cost;
	private final Animation troopAnimation;
	private final Texture texture;
	
	/* controlli mancanti */
	public Troop(Vector2 coord, int health, int strength, int cost, Texture texture, Membership membership) {
		super(new Rectangle(coord.x, coord.y, texture.getWidth() / 2, texture.getHeight()), membership);
		this.maxHealth = health;
		this.currentHealth = this.maxHealth;
		this.attackStrength = strength;
		this.cost = cost;
		this.troopAnimation = new Animation(new TextureRegion(texture), 2, 0.5d);
		this.texture = texture;
	}

	public void update(double dt) {
		this.troopAnimation.update(dt);
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth < 0 ? 
				0 : currentHealth > this.maxHealth ?
						this.maxHealth : currentHealth;
	}

	public int getAttackStrength() {
		return attackStrength;
	}

	public int getCost() {
		return cost;
	}

	public TextureRegion getTexture() {
		return this.troopAnimation.getFrame();
	}
	
	public void dispose() {
		this.texture.dispose();
	}
}
