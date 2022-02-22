package utilities;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashMap;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.towers.EnemyCenterTower;
import entities.towers.EnemyLeftTower;
import entities.towers.EnemyRightTower;
import entities.towers.MyCenterTower;
import entities.towers.MyLeftTower;
import entities.towers.MyRightTower;

public class GameMap {
	
	public enum EntityType {
		TORRE, CAMPO, TRUPPA, OSTACOLO;
	}
	
	public final static int X_START = 178;
	public final static int Y_START = 255;
	public final static int X_END = 516;
	public final static int Y_END = 706;
	
	private final Map<GridUnit, EntityType> map;

	public GameMap() {
		this.map = new HashMap<>();
		for(int i = GameMap.X_START; i < GameMap.X_END; i+= GridUnit.WIDTH) {
			for(int j = GameMap.Y_START; j < GameMap.Y_END; j+= GridUnit.HEIGHT) {
				var unit = new GridUnit(i, j);
				if(this.isFiume(unit)) {
					this.map.put(unit, EntityType.OSTACOLO);
				} else if(this.isTower(unit)){ 
					this.map.put(unit, EntityType.TORRE);
				} else {
					this.map.put(unit, EntityType.CAMPO);
				}
			}
		}
	}
	
	private boolean isCurt(GridUnit unit) {
		return !this.isTower(unit) && !this.isFiume(unit);
	}

	private boolean isFiume(GridUnit unit) {
		return new Rectangle(153, 471, 72, 26).overlaps(unit.getBounds()) 
				|| new Rectangle(263, 471, 168, 26).overlaps(unit.getBounds())
				|| new Rectangle(468, 471, 68, 26).overlaps(unit.getBounds());
	}
	
	private boolean isTower(GridUnit unit) {
		return new MyLeftTower().getBounds().overlaps(unit.getBounds())
				|| new MyCenterTower().getBounds().overlaps(unit.getBounds())
				|| new MyRightTower().getBounds().overlaps(unit.getBounds())
				|| new EnemyLeftTower().getBounds().overlaps(unit.getBounds()) 
				|| new EnemyCenterTower().getBounds().overlaps(unit.getBounds())  
				|| new EnemyRightTower().getBounds().overlaps(unit.getBounds()) ;
	}
	
	public EntityType getEntityType(Vector2 coord) {
		return this.map.get(this.getUnitFromPixel(coord));
	}
	
	public void addTroop(Vector2 coord) {
		if(this.isPixelInMap(coord) && this.isCurt(this.getUnitFromPixel(coord))) {
			this.map.replace(this.getUnitFromPixel(coord), EntityType.TRUPPA);
		}
	}
	
	public Map<GridUnit, EntityType> getMap() {
		return this.map;
	}
	
	public boolean isPixelInMap(Vector2 vec) {
		return this.map.keySet().stream()
				.filter(k -> k.getBounds().contains(vec))
				.findAny()
				.isPresent();
	}
	
	private GridUnit getUnitFromPixel(Vector2 vec) {
		return this.map.keySet().stream()
				.filter(k -> k.getBounds().contains(vec))
				.findAny()
				.get();
	}
	
	public Set<Vector2> getTroopsCoordinates() {
//		return this.map.entrySet().stream()
//				.filter(e -> e.getValue().equals(EntityType.TRUPPA))
//				.map(e -> e.getKey().getCenter())
//				.collect(Collectors.toSet());
		return this.map.keySet().stream().map(GridUnit::getCenter).collect(Collectors.toSet());
	}
	
	public Set<GridUnit> getTowers() {
		return this.map.entrySet().stream()
				.filter(e -> e.getValue().equals(EntityType.TORRE))
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}
	
	public Set<GridUnit> getObs() {
		return this.map.entrySet().stream()
				.filter(e -> e.getValue().equals(EntityType.OSTACOLO))
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}
	
	public Vector2 adjustPosition(Vector2 vec) {
		return this.getUnitFromPixel(vec).getCenter();
	}
	
}
