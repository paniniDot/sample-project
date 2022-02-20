package utilities;

import com.badlogic.gdx.math.Vector2;

import entities.Entity;
import entities.towers.EnemyCenterTower;
import entities.towers.EnemyLeftTower;
import entities.towers.EnemyRightTower;
import entities.towers.MyCenterTower;
import entities.towers.MyLeftTower;
import entities.towers.MyRightTower;
import entities.troops.Troop;

import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;

public class EntitiesGraph {
	
	private static class PrintableWeightedEdge extends DefaultWeightedEdge {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public double getWeight() {
			return super.getWeight();
		}
		
	}

	private final Graph<Entity, PrintableWeightedEdge> entities;
	
	public EntitiesGraph() {
		this.entities = GraphTypeBuilder
				.<Entity, PrintableWeightedEdge>directed()
				.allowingMultipleEdges(false)
				.allowingSelfLoops(false)
				.weighted(true)
				.buildGraph();
		
		// Add self towers
		this.entities.addVertex(new MyLeftTower());
		this.entities.addVertex(new MyRightTower());
		this.entities.addVertex(new MyCenterTower());

		// Add bridges
		//this.entities.addVertex(new Entity(new Rectangle(225, 450, 37, 50), Entity.Membership.SHARED));
		//this.entities.addVertex(new Entity(new Rectangle(431, 450, 37, 50), Entity.Membership.SHARED));
		
		//Add enemy towers
		this.entities.addVertex(new EnemyLeftTower());
		this.entities.addVertex(new EnemyRightTower());
		this.entities.addVertex(new EnemyCenterTower());

	}
	
	public boolean touchedEntity(int x, int y) {
		return this.entities.vertexSet().stream()
				.filter(r -> r.getBounds().contains(new Vector2(x, y)))
				.findAny()
				.isPresent();
	}
	
	
	private Entity.Membership getOppositeMembership(Entity.Membership memb) {
		return memb.equals(Entity.Membership.FRIENDLY) ? Entity.Membership.ENEMY : Entity.Membership.FRIENDLY;
	}
 	
	public void addEntity(Entity entity) {
		this.entities.addVertex(entity);
		this.entities.vertexSet().stream()
			.filter(e -> e.getMembership().equals(this.getOppositeMembership(entity.getMembership())))
			.forEach(e -> {
				this.entities.addEdge(entity, e, new PrintableWeightedEdge());
				this.entities.setEdgeWeight(entity, e, this.getDistanceBeetweenPoints(entity, e));
			});
	}
	
	private double getDistanceBeetweenPoints(Entity entity, Entity e) {
		return Utilities.euclideanDistance(entity.getPosition(), e.getPosition());
	}

	public void removeEntity(Entity entity) {
		this.entities.removeVertex(entity);
	} 
 
	public Set<Troop> getTroops() {
		return this.entities.vertexSet().stream()
				.filter(e -> e instanceof Troop)
				.map(e -> ((Troop)e))
				.collect(Collectors.toSet());
	}
	
	public void printAllEdges() {
		this.entities.edgeSet().forEach(e -> System.out.println(e + "Weight = " + e.getWeight()));
	}
	
}
