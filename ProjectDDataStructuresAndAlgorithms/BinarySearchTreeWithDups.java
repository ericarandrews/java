import java.util.*;

import javax.swing.tree.TreeNode;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
		implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		// Assertion: rootNode != null

		BinaryNode<T> currentNode = getRootNode();
		BinaryNode<T> parentNode = null;

		while (currentNode != null) {
			int comparisonCurrent = newEntry.compareTo(currentNode.getData());
			parentNode = currentNode;

			if (comparisonCurrent > 0) {
				currentNode = currentNode.getRightChild();
			}

			else {
				currentNode = currentNode.getLeftChild();
			}

		}

		int comparisonParent = newEntry.compareTo(parentNode.getData());

		if (comparisonParent > 0) {
			parentNode.setRightChild(new BinaryNode<T>(newEntry));
		}

		else {
			parentNode.setLeftChild(new BinaryNode<T>(newEntry));
		}

	} // end addEntry

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countEntriesNonRecursive(T target) {

		int count = 0;
		BinaryNode<T> currentNode = getRootNode();

		while (currentNode != null) {
			int comparison = target.compareTo(currentNode.getData());

			if (comparison == 0) {
				count++;
				currentNode = currentNode.getLeftChild();
			}

			else if (comparison < 0) {
				currentNode = currentNode.getLeftChild();

			}

			else {
				currentNode = currentNode.getRightChild();
			}
		}
		return count;
	}

	// YOUR CODE HERE! MUST BE RECURSIVE! YOU ARE ALLOWED TO CREATE A PRIVATE
	// HELPER.
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	private int greaterRecursiveCounter;

	public int countGreaterRecursive(T target) {

		BinaryNode<T> rootNode = getRootNode();

		greaterRecursiveCounter = 0;

		return countGreaterRecursiveHelper(rootNode, target);

	}

	private int countGreaterRecursiveHelper(BinaryNode<T> node, T target) {
		if (node == null) {
			return greaterRecursiveCounter;
		}

		if (target.compareTo(node.getData()) < 0) {
			greaterRecursiveCounter++;
		}
		countGreaterRecursiveHelper(node.getLeftChild(), target);

		countGreaterRecursiveHelper(node.getRightChild(), target);

		return greaterRecursiveCounter;

	}

	// YOUR CODE HERE! MUST USE A STACK!! MUST NOT BE RECURSIVE!
	// MAKE SURE TO TAKE ADVANTAGE OF THE SORTED NATURE OF THE BST!
	public int countGreaterWithStack(T target) {

		int count = 0;
			BinaryNode<T> rootNode = getRootNode();

			Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
			
			while (true) {
				while (rootNode != null) {
					nodeStack.push(rootNode);
					rootNode = rootNode.getLeftChild();
				}
				if (nodeStack.isEmpty()) {
					return count;
				}

				rootNode =nodeStack.pop();
				int comparison = target.compareTo(rootNode.getData());
				if(comparison < 0) {
					count++;

				}
				rootNode = rootNode.getRightChild();
			}
		}

	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n).
	// YOU ARE ALLOWED TO USE A HELPER METHOD. THE METHOD CAN BE ITERATIVE OR
	// RECURSIVE.
	public int countUniqueValues() {
		int count = 0;
		BinaryNode<T> rootNode = getRootNode();
		if (rootNode != null) {
			List<T> uniqueValueList = new ArrayList<>();
			count = countUniqueHelper(rootNode, uniqueValueList);
		}
		return count;
	}

	private int countUniqueHelper(BinaryNode<T> node, List<T> uniqueValues) {
		while (node != null) {
			if (!uniqueValues.contains(node.getData())) {
				uniqueValues.add(node.getData());
			}
			countUniqueHelper(node.getRightChild(), uniqueValues);
			countUniqueHelper(node.getLeftChild(), uniqueValues);
			return uniqueValues.size();
		}
		return 0;
	}

	public int getLeftHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if (rootNode == null) {
			return 0;
		} else if (!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNode<T> rootNode = getRootNode();
		if (rootNode == null) {
			return 0;
		} else if (!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}

}