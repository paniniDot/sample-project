package entities.towers;

import com.badlogic.gdx.math.Rectangle;

import entities.Entity;

public class EnemyRightTower extends Tower {

	public EnemyRightTower() {
		super(new Rectangle(429, 286, 50, 62), Entity.Membership.ENEMY);
	}

}
