package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import com.badlogic.gdx.math.Vector2;

public class PathFinder {
	
	public PathFinder() {
	}
	
	public List<Vector2> findPath(Map<Vector2, GameMap.EntityType> grid, Vector2 start, Vector2 dest) {
		List<Node> open = new  ArrayList<>();
		List<Node> closed = new ArrayList<>();
		
		var startNode = new Node(start, this.evaluateHeuristic(start, dest));
		open.add(startNode);
		startNode.costToReach = 0;
		
		while(!open.isEmpty()) {		
			var current = open.stream()
					.min((n1, n2) -> Double.compare(n1.valuedCost, n2.valuedCost))
					.get();
			if(current.coords.epsilonEquals(dest)) {
				return this.buildPath(current);
			}
			open.remove(current);
			closed.add(current);		
			for(var coord: this.getNeighbors(current.coords, new ArrayList<>(grid.keySet()))) {
				var neighbor = new Node(coord, this.evaluateHeuristic(coord, dest));
				if(closed.contains(neighbor) || !grid.get(coord).equals(GameMap.EntityType.CAMPO)) {
					continue;
				}
				
				/* controllo se con l'attuale current il costo g per raggiungere node è minore di
				 * quello precedentemente registrato (ovvero quello memorizzato in node.costToReach)
				 */
				var tentativeScore = current.costToReach + 1;
				
				/* se il nodo non è presente nella lista di quelli ancora da visitare (open) o il tentativeScore
				 * calcolato al punto precedente è minore di quello già registrato in iterazioni precedenti
				 * (effettuate con un altro nodo current che aveva un neighbor in comune al current attuale)
				 * allora aggiorno il padre e il costo.
				 */
				if(!open.contains(neighbor) || tentativeScore < neighbor.costToReach) {
					neighbor.parent = Optional.of(current);
					neighbor.costToReach = tentativeScore;
					neighbor.valuedCost = neighbor.costToReach + neighbor.heuristic;				
				}
				if(!open.contains(neighbor)) {
					open.add(neighbor);
				}
			}
		}
		return Collections.emptyList();
	}
	
	private List<Vector2> buildPath(Node target) {
		List<Vector2> path = new ArrayList<>();
		var current = target;
		while(current.parent.isPresent()) {
			path.add(current.coords);
			current = current.parent.get();
		}
		Collections.reverse(path);
		return path;
	}
	
	private List<Vector2> getNeighbors(Vector2 node, List<Vector2> map) {
		List<Vector2> neighbors = new ArrayList<>();
		for(var x = node.x - 1; x <= node.x + 1; x++) {
			for(var y = node.y - 1; y <= node.y + 1; y++) {
				var coord = new Vector2(x, y);
				if(map.contains(coord)) {
					neighbors.add(coord);
				}
			}
		}
		return neighbors;	
	}
	
	private double evaluateHeuristic(Vector2 node, Vector2 dest) {
		return Utilities.euclideanDistance(node, dest);
	}
	
	private static class Node {
		private final Vector2 coords;
		private final double heuristic; //h
		private double costToReach; //g
		private double valuedCost; //f
		private Optional<Node> parent;
		public Node(Vector2 coords, double heuristic) {
			this.coords = coords;
			this.heuristic = heuristic;
			this.valuedCost = this.costToReach + this.heuristic;
			this.parent = Optional.empty();
		}
		@Override
		public int hashCode() {
			return Objects.hash(coords, costToReach, heuristic, parent, valuedCost);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			return Objects.equals(coords, other.coords)
					&& Double.doubleToLongBits(costToReach) == Double.doubleToLongBits(other.costToReach)
					&& Double.doubleToLongBits(heuristic) == Double.doubleToLongBits(other.heuristic)
					&& Objects.equals(parent, other.parent)
					&& Double.doubleToLongBits(valuedCost) == Double.doubleToLongBits(other.valuedCost);
		}
		
		
	}
	
}
