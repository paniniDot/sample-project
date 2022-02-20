package entities.towers;

import com.badlogic.gdx.math.Rectangle;

import entities.Entity;

public class MyCenterTower extends Tower {

	public MyCenterTower() {
		super(new Rectangle(315, 621, 62, 80), Entity.Membership.FRIENDLY);
	}

}
