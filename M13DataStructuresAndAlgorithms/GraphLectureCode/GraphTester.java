import java.util.*;

public class GraphTester {

	public static void main(String[] args) {

		// this is the graph on slide 11
		GraphInterface<String> unweightedDigraph = new DirectedGraph<String>();
		buildUnweightedDigraph(unweightedDigraph);
		
		// this is the graph on slide 10
		GraphInterface<String> weightedUndirected = new UndirectedGraph<String>();
		buildWeightedUndirected(weightedUndirected);
		
		List<GraphInterface<String>> graphs = List.of(unweightedDigraph,weightedUndirected);
		
		for (GraphInterface<String> graph : graphs) {
			graph.display();

			System.out.println("Breadth-First starting at G:");
			System.out.println(graph.getBreadthFirstTraversal("G"));
			System.out.println("Breadth-First starting at K:");
			System.out.println(graph.getBreadthFirstTraversal("K"));

			System.out.println("Depth-First starting at M:");
			System.out.println(graph.getDepthFirstTraversal("M"));
			System.out.println("Depth-First starting at J:");
			System.out.println(graph.getDepthFirstTraversal("J"));
			/*
			// cannot run on this digraph because it is not a DAG; 
			// this code is here in case you want to create your own DAG to use!
			if(graph instanceof DirectedGraph<?>) {
				System.out.println("Topological Order");
				System.out.println(graph.getTopologicalOrder());
			}
			*/
			
			System.out.println("\n");
		}

	}
	
	private static void buildWeightedUndirected(GraphInterface<String> graph) { 
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("J");
		graph.addVertex("K");
		graph.addVertex("M");
		graph.addVertex("N");

		graph.addEdge("G","H", 3);
		graph.addEdge("G","K", 2);
		graph.addEdge("G","N", 2);
		graph.addEdge("H","J", 4);
		graph.addEdge("J","K", 6);
		graph.addEdge("K","M", 4);
		graph.addEdge("M","N", 5);
	}
	
	private static void buildUnweightedDigraph(GraphInterface<String> graph) {
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("J");
		graph.addVertex("K");
		graph.addVertex("M");
		graph.addVertex("N");
		graph.addVertex("P");
		
		graph.addEdge("G", "N");
		graph.addEdge("G", "H");
		graph.addEdge("H", "N");
		graph.addEdge("J", "H");
		graph.addEdge("J", "K");
		graph.addEdge("M", "N");
		graph.addEdge("N", "H");
		graph.addEdge("N", "K");
		graph.addEdge("N", "M");
		graph.addEdge("N", "P");
	}	

}
