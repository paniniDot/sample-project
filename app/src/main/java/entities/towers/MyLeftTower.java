package entities.towers;

import com.badlogic.gdx.math.Rectangle;

import entities.Entity;

public class MyLeftTower extends Tower {

	public MyLeftTower() {
		super(new Rectangle(218, 578, 50, 70), Entity.Membership.FRIENDLY);
	}

}
