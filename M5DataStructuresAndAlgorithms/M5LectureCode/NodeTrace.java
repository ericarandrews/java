
public class NodeTrace {

	public static void main(String[] args) {
		Node<Integer> nodeA = new Node<Integer>(92);
		Node<Integer> nodeB = new Node<Integer>(37, nodeA);
		Node<Integer> nodeC = new Node<Integer>(16, nodeB);
		Node<Integer> nodeD = new Node<Integer>(45, nodeC);
		
		Node<Integer> firstNode = nodeD;
		// equivalent code without named node variables:
		//Node<Integer> firstNode = new Node(45, new Node(16, new Node(37, new Node(92))));
		
		Node<Integer> current = firstNode;
		
		firstNode.data = 88;
		current = current.next;
		current.data = 40;
		firstNode.next.data = 13;
		firstNode = firstNode.next;
		firstNode.next = firstNode.next.next;
		current = current.next.next;
		System.out.println(current);
		current = current.next;
		

	}

}
