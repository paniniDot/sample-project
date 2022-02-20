package entities.towers;

import com.badlogic.gdx.math.Rectangle;

import entities.Entity;

public class EnemyLeftTower extends Tower {

	public EnemyLeftTower() {
		super(new Rectangle(219, 286, 50, 62), Entity.Membership.ENEMY);
	}

}
