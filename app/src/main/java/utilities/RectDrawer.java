package utilities;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class RectDrawer {
	private static ShapeRenderer debugShapeRenderer = new ShapeRenderer();

	public static void showDebugBoundingBoxes(List<Rectangle> boundingBoxes, Color color) {
	    debugShapeRenderer.begin(ShapeType.Line); // make sure to end the spritebatch before you call this line
	    debugShapeRenderer.setColor(color);
	    for (Rectangle rect : boundingBoxes) {
	        debugShapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
	    }
	    debugShapeRenderer.end();
	}
}
