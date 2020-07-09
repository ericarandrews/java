/**
 * A class that implements the ADT binary search tree by extending BinaryTree.
 * Recursive version.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	public BinarySearchTree() {
		super();
	} 

	public BinarySearchTree(T rootEntry) {
		super(rootEntry);
	} 

	// Disable setTree (see Segment 26.6)
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	} 

	public T getEntry(T anEntry) {
		return findEntry(getRootNode(), anEntry);
	} 

	private T findEntry(BinaryNode<T> currentRootNode, T anEntry) {
		T result = null;

		if (currentRootNode != null) {
			T rootEntry = currentRootNode.getData();

			if (anEntry.equals(rootEntry)) {
				result = rootEntry;
			} else if (anEntry.compareTo(rootEntry) < 0) {
				result = findEntry(currentRootNode.getLeftChild(), anEntry);
			} else { // anEntry.compareTo(rootEntry) > 0
				result = findEntry(currentRootNode.getRightChild(), anEntry);
			}
		} 
		return result;
	} 

	public boolean contains(T entry) {
		return getEntry(entry) != null;
	} 

	public T add(T newEntry) {
		T result = null;

		if (isEmpty()) {
			setRootNode(new BinaryNode<>(newEntry)); // inherited from BinaryTree
		} else {
			result = addEntry(getRootNode(), newEntry);
		}

		return result;
	} 

	// Adds anEntry to the nonempty subtree rooted at currentRootNode.
	private T addEntry(BinaryNode<T> currentRootNode, T anEntry) {
		// Assertion: currentRootNode != null
		T result = null;
		BinaryNode<T> newNodeToAdd = new BinaryNode<>(anEntry);
		int comparison = anEntry.compareTo(currentRootNode.getData());

		if (comparison == 0) { // anEntry == currentRootNode.data
			result = currentRootNode.getData();
			currentRootNode.setData(anEntry);
		} else if (comparison < 0) { // anEntry < currentRootNode.data
			if (currentRootNode.hasLeftChild()) {
				result = addEntry(currentRootNode.getLeftChild(), anEntry);
			} else {
				currentRootNode.setLeftChild(newNodeToAdd);
			}
		} else { // anEntry > currentRootNode.data
			if (currentRootNode.hasRightChild()) {
				result = addEntry(currentRootNode.getRightChild(), anEntry);
			} else {
				currentRootNode.setRightChild(newNodeToAdd);
			}
		} 

		return result;
	} // end addEntry

	public T remove(T anEntry) {
		ReturnObject oldEntry = new ReturnObject(null);
		BinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
		setRootNode(newRoot);

		return oldEntry.get();
	} // end remove

	// Removes an entry from the tree rooted at a given node.
	// Returns: The root node of the resulting tree; 
	//    if anEntry matched an entry in the tree, oldEntry's 
	//    data field is the entry that was removed from the tree; 
	//    otherwise it is null.
	private BinaryNode<T> removeEntry(BinaryNode<T> currentRootNode, T anEntry, ReturnObject oldEntry) {
		if (currentRootNode != null) {
			T currentRootData = currentRootNode.getData();
			int comparison = anEntry.compareTo(currentRootData);

			if (comparison == 0) {// anEntry == root entry
				oldEntry.set(currentRootData);
				BinaryNode<T> newRoot = removeRoot(currentRootNode);
				return newRoot;
			} else if (comparison < 0) { // anEntry < root entry
				BinaryNode<T> leftChild = currentRootNode.getLeftChild();
				BinaryNode<T> leftSubtreeNewRoot = removeEntry(leftChild, anEntry, oldEntry);
				currentRootNode.setLeftChild(leftSubtreeNewRoot);
				return currentRootNode;
			} else {// anEntry > root entry
				BinaryNode<T> rightChild = currentRootNode.getRightChild();
				BinaryNode<T> righSubtreeNewRoot = removeEntry(rightChild, anEntry, oldEntry);
				currentRootNode.setRightChild(righSubtreeNewRoot);
				return currentRootNode;
			} 
		} else { // currentRootNode is null
			return currentRootNode;
		}
	} // end removeEntry

	// Removes the entry in a given root node of a subtree.
	// Returns the root node of the revised subtree.
	private BinaryNode<T> removeRoot(BinaryNode<T> currentRootNode) {

		// Case 1: rootNode has two children
		if (currentRootNode.hasLeftChild() && currentRootNode.hasRightChild()) {
			// Find node with largest entry in left subtree (Option B from our notes)
			BinaryNode<T> leftSubtreeRoot = currentRootNode.getLeftChild();
			BinaryNode<T> largestNodeInLeft = findLargest(leftSubtreeRoot);
			T largestDataInLeft = largestNodeInLeft.getData();

			// Replace entry in root
			currentRootNode.setData(largestDataInLeft);

			// Remove node with largest entry in left subtree
			BinaryNode<T> newRootOfLeftSubtreeWithLargestRemoved = removeLargest(leftSubtreeRoot);
			currentRootNode.setLeftChild(newRootOfLeftSubtreeWithLargestRemoved);
		} 
		// Case 2: rootNode has at most one child
		else if (currentRootNode.hasRightChild()) {
			currentRootNode = currentRootNode.getRightChild();
		} else { // Case 3: currentNode has left child or is a leaf
			currentRootNode = currentRootNode.getLeftChild();
		}
		

		return currentRootNode;
	} // end removeFromRoot


	private BinaryNode<T> findLargest(BinaryNode<T> currentRootNode) {
		if (currentRootNode.hasRightChild()) {
			return findLargest(currentRootNode.getRightChild());
		} else {
			return currentRootNode;			
		}
	} 

	// Removes the node containing the largest entry in a given tree.
	// Returns the root node of the revised tree.
	private BinaryNode<T> removeLargest(BinaryNode<T> currentRootNode) {
		if (currentRootNode.hasRightChild()) {
			BinaryNode<T> rightChild = currentRootNode.getRightChild();
			BinaryNode<T> newRightChild = removeLargest(rightChild);
			currentRootNode.setRightChild(newRightChild);
			return currentRootNode;
		} else {
			return currentRootNode.getLeftChild();
		}
	} 

	private class ReturnObject {
		private T item;

		private ReturnObject(T entry) {
			item = entry;
		} 

		public T get() {
			return item;
		} 

		public void set(T entry) {
			item = entry;
		} 
	} 
	
}
