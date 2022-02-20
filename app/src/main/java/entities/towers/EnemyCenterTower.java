package entities.towers;

import com.badlogic.gdx.math.Rectangle;

import entities.Entity;

public class EnemyCenterTower extends Tower {

	public EnemyCenterTower() {
		super(new Rectangle(316, 226, 62, 75), Entity.Membership.ENEMY);
	}

}
