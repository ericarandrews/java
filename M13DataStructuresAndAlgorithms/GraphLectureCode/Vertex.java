import java.util.*;

/**
 * A class of vertices for a graph.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
class Vertex<T> {
	private T data;
	private List<Edge<T>> edgeList; // Edges to neighbors
	private boolean visited; // true if visited

	public Vertex(T vertexData) {
		data = vertexData;
		edgeList = new LinkedList<>();
		visited = false;
	}

	public T getData() {
		return data;
	}

	public void visit() {
		visited = true;
	}

	public void unvisit() {
		visited = false;
	}

	public boolean isVisited() {
		return visited;
	} 

	public String toString() {
		return data.toString();
	}

	public boolean connect(Vertex<T> endVertex, double edgeWeight) {
		boolean result = false;

		if (!this.equals(endVertex)) { // Vertices are distinct- loops not allowed
			Iterator<Vertex<T>> neighbors = getNeighborIterator();
			boolean duplicateEdge = false;

			while (!duplicateEdge && neighbors.hasNext()) {
				Vertex<T> nextNeighbor = neighbors.next();
				if (endVertex.equals(nextNeighbor))
					duplicateEdge = true;
			} 

			if (!duplicateEdge) {
				edgeList.add(new Edge<T>(endVertex, edgeWeight));
				result = true;
			} 
		} 

		return result;
	} 

	public boolean connect(Vertex<T> endVertex) {
		return connect(endVertex, 0);
	}

	public Iterator<Vertex<T>> getNeighborIterator() {
		return new NeighborIterator();
	}

	public boolean hasNeighbor() {
		return !edgeList.isEmpty();
	}

	public Vertex<T> getUnvisitedNeighbor() {
		Vertex<T> result = null;

		Iterator<Vertex<T>> neighbors = getNeighborIterator();
		while (neighbors.hasNext() && (result == null)) {
			Vertex<T> nextNeighbor = neighbors.next();
			if (!nextNeighbor.isVisited())
				result = nextNeighbor;
		}

		return result;
	}

	public boolean equals(Object other) {
		boolean result;

		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			// The cast is safe within this else clause
			@SuppressWarnings("unchecked")
			Vertex<T> otherVertex = (Vertex<T>) other;
			result = data.equals(otherVertex.data);
		}

		return result;
	}

	private class NeighborIterator implements Iterator<Vertex<T>> {
		private Iterator<Edge<T>> edges;

		private NeighborIterator() {
			edges = edgeList.iterator();
		}

		public boolean hasNext() {
			return edges.hasNext();
		}

		public Vertex<T> next() {
			Vertex<T> nextNeighbor = null;

			if (edges.hasNext()) {
				Edge<T> edgeToNextNeighbor = edges.next();
				nextNeighbor = edgeToNextNeighbor.getEndVertex();
			} else
				throw new NoSuchElementException();

			return nextNeighbor;
		} 

		public void remove() {
			throw new UnsupportedOperationException();
		} 
	} 

	private class WeightIterator implements Iterator<Double> {
		private Iterator<Edge<T>> edges;

		private WeightIterator() {
			edges = edgeList.iterator();
		} 

		public boolean hasNext() {
			return edges.hasNext();
		} 

		public Double next() {
			Double edgeWeight = 0.0;
			if (edges.hasNext()) {
				Edge<T> edgeToNextNeighbor = edges.next();
				edgeWeight = edgeToNextNeighbor.getWeight();
			} else
				throw new NoSuchElementException();

			return edgeWeight;
		} 

		public void remove() {
			throw new UnsupportedOperationException();
		} 
	}

	public Iterator<Double> getWeightIterator() {
		return new WeightIterator();
	}

	public void display() {
		System.out.print(data + " -> ");
		Iterator<Vertex<T>> i = getNeighborIterator();
		Iterator<Double> w = getWeightIterator();

		while (i.hasNext()) {
			Vertex<T> v = (Vertex<T>) i.next();
			double weight = w.next();
			String weightString = (Math.abs(weight-0)<0.001) ? " " : "(" + Math.round(weight) + ") ";
			System.out.print(v + weightString);
		}

		System.out.println();
	}
}
