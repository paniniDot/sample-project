package utilities;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

import entities.Entity;
import entities.towers.EnemyCenterTower;
import entities.towers.EnemyLeftTower;
import entities.towers.EnemyRightTower;
import entities.towers.MyCenterTower;
import entities.towers.MyLeftTower;
import entities.towers.MyRightTower;
import entities.towers.Tower;
import entities.troops.Troop;

public class EntitySet {
	
	private Set<Entity> entities;
	
	public EntitySet() {
		this.entities = new HashSet<>();
		this.entities.add(new MyLeftTower());
		this.entities.add(new MyRightTower());
		this.entities.add(new MyCenterTower());		
		this.entities.add(new EnemyLeftTower());
		this.entities.add(new EnemyRightTower());
		this.entities.add(new EnemyCenterTower());
	}
 	
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}
	
	public Set<Troop> getTroops() {
		return this.entities.stream()
				.filter(e -> e instanceof Troop)
				.map(e -> ((Troop)e))
				.collect(Collectors.toSet());
	}
	
	public Set<Tower> getTowers() {
		return this.entities.stream()
				.filter(e -> e instanceof Tower)
				.map(e -> (Tower)e)
				.collect(Collectors.toSet());
	}
	
}
