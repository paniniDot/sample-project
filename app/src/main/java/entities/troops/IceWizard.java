package entities.troops;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import entities.Entity;

public class IceWizard extends Troop {
	
	public static final int HEALTH = 569;
	public static final int DAMAGE_PER_HIT = 44;
	public static final int COST = 4;

	public IceWizard(Vector2 coord, Entity.Membership memb) {
		super(coord, IceWizard.HEALTH, IceWizard.DAMAGE_PER_HIT, IceWizard.COST, new Texture("Models/Sprites/IceWizard/N.png"), memb);
	}

}
