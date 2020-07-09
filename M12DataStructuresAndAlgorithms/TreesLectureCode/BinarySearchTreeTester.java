
public class BinarySearchTreeTester {


	public static void main(String[] args) {

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		int[] insertionOrder1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] insertionOrder2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] insertionOrder3 = {5, 4, 6, 3, 7, 2, 8, 1, 9, 10};
		int[] insertionOrder4 = {6, 4, 2, 1, 3, 5, 8, 7, 10, 9};

		int[] insertion = insertionOrder4;
		
		for(int i=0; i<insertion.length; i++) {
			bst.add(insertion[i]);
		}	
		
		// print the traversals
		System.out.println("Pre-Order:");
		bst.recursivePreorderTraverse();

		System.out.println("In-Order:");
		bst.recursiveInorderTraverse();

		System.out.println("Post-Order:");
		bst.recursivePostorderTraverse();
		
		System.out.println("Height is " + bst.getHeight());
		
		bst.remove(4);
		bst.remove(2);
		bst.recursivePreorderTraverse();
		
		
	}

}
