
public class NodeRecursion {

	public static void main(String[] args) {
		Node<Integer> chain = 
				new Node<Integer>(Integer.valueOf(3),	
				  new Node<Integer>(Integer.valueOf(6), 
				    new Node<Integer>(Integer.valueOf(7),	
				      new Node<Integer>(Integer.valueOf(12)))));
		// sets up the chain 3->6->7->12
		printChain(chain);
		printChainIterative(chain);
		printChainReverse(chain);
	}
	
	public static void printChain(Node<Integer> firstNode) {
		if(firstNode!=null) { // recursive case
			System.out.println(firstNode.data); // small part to solve now
			printChain(firstNode.next); // recursive call
		}
		// implicit base case- when the node parameter is null, we're done
	}
	public static void printChainIterative(Node<Integer> firstNode) {
		Node<Integer> current = firstNode;
		while(current!=null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public static void printChainReverse(Node<Integer> firstNode) {
		if(firstNode!=null) { // recursive call
			printChainReverse(firstNode.next); // solving the rest of the problem first
			System.out.println(firstNode.data); // coming back to add on the small part of the solution
		}
		// implicit base case- recursion stops when we reach the end of the chain (a null node)
	}
	
	
}
