package utilities;

import java.util.Objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import royale.view.Royale;

public class GridUnit {
	public final static int WIDTH = 19;
	public final static int HEIGHT = 15;
	
	private final Rectangle bounds;

	public GridUnit(final float x, final float y) {
		this.bounds = new Rectangle(x, y, GridUnit.WIDTH, GridUnit.HEIGHT);
	}
	
	public Rectangle getBounds() {
		return this.bounds;
	}
	
	public Vector2 getCenter() {
		var v = new Vector2();
		this.bounds.getCenter(v);
		return v;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bounds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridUnit other = (GridUnit) obj;
		return Objects.equals(bounds, other.bounds);
	}
}
