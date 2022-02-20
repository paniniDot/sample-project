package utilities;

import com.badlogic.gdx.math.Vector2;

public class Utilities {
	
	public static double euclideanDistance(Vector2 a, Vector2 b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
}
