
public class Edge<T> {

	private Vertex<T> vertex;
	private double weight;

	protected Edge(Vertex<T> endVertex, double edgeWeight) {
		vertex = endVertex;
		weight = edgeWeight;
	}

	protected Edge(Vertex<T> endVertex) {
		vertex = endVertex;
		weight = 0;
	}

	protected Vertex<T> getEndVertex() {
		return vertex;
	}

	protected double getWeight() {
		return weight;
	}
}
