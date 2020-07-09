import java.util.*;

/**
 * A class that implements the ADT directed graph.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class DirectedGraph<T> implements GraphInterface<T> {
	private Map<T, Vertex<T>> vertices;
	private int edgeCount;

	public DirectedGraph() {
		vertices = new HashMap<>();
		edgeCount = 0;
	}

	public boolean addVertex(T vertexData) {
		Vertex<T> addOutcome = vertices.put(vertexData, new Vertex<>(vertexData));
		return addOutcome == null; // Was addition to dictionary successful? if this is a new vertex, this returns true
		// if the vertex is already in the map (graph), this returns false
	}

	public boolean addEdge(T begin, T end, double edgeWeight) {
		boolean result = false;
		Vertex<T> beginVertex = vertices.get(begin);
		Vertex<T> endVertex = vertices.get(end);
		if ((beginVertex != null) && (endVertex != null)) {
			result = beginVertex.connect(endVertex, edgeWeight);
		}
		if (result) {
			edgeCount++;
		}
		return result;
	}

	public boolean addEdge(T begin, T end) {
		return addEdge(begin, end, 0);
	}

	public boolean hasEdge(T begin, T end) {
		boolean found = false;
		Vertex<T> beginVertex = vertices.get(begin);
		Vertex<T> endVertex = vertices.get(end);
		if ((beginVertex != null) && (endVertex != null)) {
			Iterator<Vertex<T>> neighbors = beginVertex.getNeighborIterator();
			while (!found && neighbors.hasNext()) {
				Vertex<T> nextNeighbor = neighbors.next();
				if (endVertex.equals(nextNeighbor)) {
					found = true;
				}
			}
		}

		return found;
	}

	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	public void clear() {
		vertices.clear();
		edgeCount = 0;
	}

	public int getNumberOfVertices() {
		return vertices.size();
	}

	public int getNumberOfEdges() {
		return edgeCount;
	}

	protected void resetVertices() {
		Iterator<Vertex<T>> vertexIterator = vertices.values().iterator();
		while (vertexIterator.hasNext()) {
			Vertex<T> nextVertex = vertexIterator.next();
			nextVertex.unvisit();
		}
	}

	public Queue<T> getBreadthFirstTraversal(T origin) {
		resetVertices();
		Queue<T> traversalOrder = new LinkedList<>();
		Queue<Vertex<T>> vertexQueue = new LinkedList<>();

		Vertex<T> originVertex = vertices.get(origin);
		originVertex.visit();
		traversalOrder.add(origin); // Enqueue vertex label
		vertexQueue.add(originVertex); // Enqueue vertex

		while (!vertexQueue.isEmpty()) {
			Vertex<T> frontVertex = vertexQueue.remove();
			Iterator<Vertex<T>> neighbors = frontVertex.getNeighborIterator();

			while (neighbors.hasNext()) {
				Vertex<T> nextNeighbor = neighbors.next();
				if (!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					traversalOrder.add(nextNeighbor.getData());
					vertexQueue.add(nextNeighbor);
				}
			}
		}

		return traversalOrder;
	}

	public Queue<T> getDepthFirstTraversal(T origin) {
		// Assumes graph is not empty
		resetVertices();
		Queue<T> traversalOrder = new LinkedList<T>();
		Stack<Vertex<T>> vertexStack = new Stack<>();

		Vertex<T> originVertex = vertices.get(origin);
		originVertex.visit();
		traversalOrder.add(origin); // Enqueue vertex label
		vertexStack.push(originVertex); // Enqueue vertex

		while (!vertexStack.isEmpty()) {
			Vertex<T> topVertex = vertexStack.peek();
			Vertex<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

			if (nextNeighbor != null) {
				nextNeighbor.visit();
				traversalOrder.add(nextNeighbor.getData());
				vertexStack.push(nextNeighbor);
			} else {// All neighbors are visited
				vertexStack.pop();
			}
		}

		return traversalOrder;
	}

	public Stack<T> getTopologicalOrder() {
		resetVertices();

		Stack<T> vertexStack = new Stack<>();
		int numberOfVertices = getNumberOfVertices();
		for (int counter = 1; counter <= numberOfVertices; counter++) {
			Vertex<T> nextVertex = findTerminal();
			nextVertex.visit();
			vertexStack.push(nextVertex.getData());
		}

		return vertexStack;
	}

	protected Vertex<T> findTerminal() {
		boolean found = false;
		Vertex<T> result = null;

		Iterator<Vertex<T>> vertexIterator = vertices.values().iterator();

		while (!found && vertexIterator.hasNext()) {
			Vertex<T> nextVertex = vertexIterator.next();
			// If nextVertex is unvisited AND has only visited neighbors)
			if (!nextVertex.isVisited()) {
				if (nextVertex.getUnvisitedNeighbor() == null) {
					found = true;
					result = nextVertex;
				} 
			} 
		}

		return result;
	}

	public void display() {
		System.out.println("Graph has " + getNumberOfVertices() + " vertices and " + getNumberOfEdges() + " edges.");
		Iterator<Vertex<T>> vertexIterator = vertices.values().iterator();
		while (vertexIterator.hasNext()) {
			((Vertex<T>) (vertexIterator.next())).display();
		}
		System.out.println();
	}

}
