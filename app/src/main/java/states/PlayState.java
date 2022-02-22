package states;

import java.util.List;
import java.util.stream.Collectors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.Entity;
import entities.towers.EnemyLeftTower;
import entities.troops.IceWizard;
import entities.troops.Troop;
import royale.view.Royale;
import utilities.ArenaPicker;
import utilities.EntitiesGraph;
import utilities.EntitySet;
import utilities.GameMap;
import utilities.PathFinder;
import utilities.RectDrawer;

public class PlayState extends State {

	private Texture arena;
	//private final EntitiesGraph entities;
	private final GameMap map;
	private final EntitySet entities;
	private final PathFinder pathFinder;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		this.arena = new ArenaPicker(0).get();
		//this.entities = new EntitiesGraph();
		this.map = new GameMap();
		this.pathFinder = new PathFinder();
		this.entities = new EntitySet();
	}

	@Override
	protected void handleInput() {
		if(Gdx.input.justTouched()) {
			var coord = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			System.out.println(coord);
			if(this.map.isPixelInMap(coord)) {
				if(this.map.getEntityType(coord).equals(GameMap.EntityType.OSTACOLO)) {
					System.out.println("Ostacolo");
					this.entities.addEntity(new IceWizard(coord, Entity.Membership.FRIENDLY));
				} else if(this.map.getEntityType(coord).equals(GameMap.EntityType.TORRE)) {
					System.out.println("Torre");				
				} else if(this.map.getEntityType(coord).equals(GameMap.EntityType.CAMPO)) {
					System.out.println("Campo");
					this.map.addTroop(coord);
				}
			}	
		}
	}

	@Override
	public void update(double dt) {
		this.handleInput();
		//this.entities.getTroops().forEach(t -> t.update(dt, this.pathFinder.findPath(this.map.getMap(), t.getPosition(), new EnemyLeftTower().getPosition()).get(0)));
		this.entities.getTroops().forEach(t -> t.update(dt));
	}
	
	private float getCenteredX(Troop t) {
		return t.getPosition().x - (t.getBounds().width / 2);
	}

	private float getCenteredY(Troop t) {
		return Royale.HEIGHT - t.getPosition().y - (t.getBounds().height / 2);
	}
	
	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(this.arena, 0, 0, Royale.WIDTH, Royale.HEIGHT);
		this.entities.getTroops().forEach(t -> sb.draw(t.getTexture(), this.getCenteredX(t), this.getCenteredY(t)));
		//this.map.adjustPosition(t.getPosition()).x, this.map.adjustPosition(t.getPosition()).y)
		sb.end();
		RectDrawer.showDebugBoundingBoxes(this.map.getMap().keySet().stream().map(k -> k.getBounds()).toList(), Color.BLUE);
		RectDrawer.showDebugBoundingBoxes(this.map.getTowers().stream().map(k -> k.getBounds()).toList(), Color.RED);
		RectDrawer.showDebugBoundingBoxes(this.map.getObs().stream().map(k -> k.getBounds()).toList(), Color.GREEN);
		RectDrawer.showDebugBoundingBoxes(List.of(new Rectangle(153, 471, 72, 26), new Rectangle(263, 471, 168, 26), new Rectangle(468, 471, 68, 26)), Color.MAGENTA);
	}

	@Override
	public void dispose() {
		this.arena.dispose();
		this.entities.getTroops().forEach(t -> t.dispose());
	}

}
