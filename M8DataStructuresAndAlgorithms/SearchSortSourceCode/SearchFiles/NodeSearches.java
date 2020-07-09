public class NodeSearches {
	
	// finds the first location of a target
	public static int linearSearchIterative(Node<Integer> firstNode, int target) {
		int foundLocation = -1;
		int currentLocation = 0;
		boolean found = false; 
		int comparisonCount = 0;
	
		Node<Integer> currentNode = firstNode;
		while(currentNode!=null && !found) {
			comparisonCount++;
			if(currentNode.data.equals(target)) {
				found = true;
				foundLocation = currentLocation;
			}
			currentNode = currentNode.next;
			currentLocation++;
		}
		System.out.println("In linear search iterative, comparison count is \t" + comparisonCount);

		return foundLocation;
	}

	public static int linearSearchRecursive(Node<Integer> firstNode, int target) {
		comparisonCountLinearRecursive = 0;
		int answer = linearSearchRecursiveHelper(firstNode, target, 0);
		System.out.println("In linear search recursive, comparison count is \t" + comparisonCountLinearRecursive);
		return answer;
	}
	
	private static int comparisonCountLinearRecursive = 0;

	private static int linearSearchRecursiveHelper(Node<Integer> node, int target, int position) {
		comparisonCountLinearRecursive++;
		if(node==null) {
			return -1;
		} else if(node.data.equals(target)) {
			return position;
		} else { 
			return linearSearchRecursiveHelper(node.next, target, position+1);		
		}
	}

}
