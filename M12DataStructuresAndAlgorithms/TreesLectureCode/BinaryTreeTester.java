import java.util.Iterator;

public class BinaryTreeTester {

	public static void main(String[] args) {
		
		//leaves
		BinaryTree<Integer> tree6 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> tree11 = new BinaryTree<Integer>(11);
		BinaryTree<Integer> tree14 = new BinaryTree<Integer>(14);
		BinaryTree<Integer> tree5 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> tree12 = new BinaryTree<Integer>(12);
		
		// next level up from leaves
		BinaryTree<Integer> tree7 = new BinaryTree<Integer>(7, tree6, tree11);
		BinaryTree<Integer> tree9 = new BinaryTree<Integer>(9, tree14, null);
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(2, tree5, null);

		// next level up
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(1, tree7, tree9);
		BinaryTree<Integer> tree3 = new BinaryTree<Integer>(3, tree2, tree12);
		
		// root
		BinaryTree<Integer> numberTree = new BinaryTree<Integer>(4, tree1, tree3);

		
		// print the traversals
		System.out.println("Pre-Order:");
		numberTree.recursivePreorderTraverse();

		System.out.println("In-Order:");
		numberTree.recursiveInorderTraverse();

		System.out.println("Post-Order:");
		numberTree.recursivePostorderTraverse();

		// find the sum of all numbers in the tree
		// note: for this task, you could use any of the three iterators
		Iterator<Integer> iterator = numberTree.getPreorderIterator();
		int sum = 0;
		while(iterator.hasNext()) {
			int nodeData = iterator.next();
			System.out.println("node: " + nodeData);
			sum += nodeData;
		}
		System.out.println("Sum is " + sum);
		
	}

}
