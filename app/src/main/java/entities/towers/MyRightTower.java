package entities.towers;

import com.badlogic.gdx.math.Rectangle;

import entities.Entity;

public class MyRightTower extends Tower {

	public MyRightTower() {
		super(new Rectangle(426, 578, 50, 70), Entity.Membership.FRIENDLY);
	}

}
