import java.time.Duration;
import java.time.Instant;

public class ProjectDPartADriver {

	public static void main(String[] args) {	
		System.out.println("*****TESTING TRADITIONAL BINARY SEARCH TREE FUNCTIONALITY STILL WORKING");
		BinarySearchTreeWithDups<String> nonDupTree = new BinarySearchTreeWithDups<String>();
		String[] insertStrings = {"E", "B", "C", "A", "H", "D", "F", "G"};
		for(String text : insertStrings) {
			nonDupTree.add(text);
		}
		System.out.println("Inorder should print \nA B C D E F G H");
		nonDupTree.recursiveInorderTraverse();
		System.out.println("\nPreorder should print \nE B A C D H F G");
		nonDupTree.recursivePreorderTraverse();
		System.out.println("\nPostorder should print \nA D C B G F H E");
		nonDupTree.recursivePostorderTraverse();
		

		System.out.println("\n\n*****TESTING DUPLICATE FUNCTIONALITY");
		BinarySearchTreeWithDups<Integer> dupTree = new BinarySearchTreeWithDups<Integer>();
		int[] insertNumbers = {6, 3, 10, 1, 6, 8, 11, 5, 7, 9, 4, 6, 8, 5, 6};
		for(int number : insertNumbers) {
			dupTree.add(number);
		}
		System.out.println("Inorder should print \n1 3 4 5 5 6 6 6 6 7 8 8 9 10 11");
		dupTree.recursiveInorderTraverse();
		System.out.println("\nPreorder should print \n6 3 1 6 5 4 5 6 6 10 8 7 8 9 11");
		dupTree.recursivePreorderTraverse();
		System.out.println("\nPostorder should print \n1 5 4 6 6 5 6 3 8 7 9 8 11 10 6");
		dupTree.recursivePostorderTraverse();
		System.out.println("\n\nThe left child of the root 6 is  3: " + dupTree.getRootNode().getLeftChild().getData());
		System.out.println("The left child of the 3 node is  1: " + dupTree.getRootNode().getLeftChild().getLeftChild().getData());
		System.out.println("The right child of the 3 node is 6: " + dupTree.getRootNode().getLeftChild().getRightChild().getData());
	
		
		System.out.println("\n\n*****TESTING COUNT ENTRIES");
		System.out.println("Number of 1s \t1:  " + dupTree.countEntriesNonRecursive(1));
		System.out.println("Number of 4s \t1:  " + dupTree.countEntriesNonRecursive(4));
		System.out.println("Number of 5s \t2:  " + dupTree.countEntriesNonRecursive(5));
		System.out.println("Number of 6s \t4:  " + dupTree.countEntriesNonRecursive(6));
		System.out.println("Number of 8s \t2:  " + dupTree.countEntriesNonRecursive(8));
		System.out.println("Number of 11s \t1:  " + dupTree.countEntriesNonRecursive(11));
		System.out.println("Number of As \t1:  " + nonDupTree.countEntriesNonRecursive(new String("A")));
		System.out.println("Number of Fs \t1:  " + nonDupTree.countEntriesNonRecursive(new String("F")));
		System.out.println("Number of 0s \t0:  " + dupTree.countEntriesNonRecursive(0));
		System.out.println("Number of 12s \t0:  " + dupTree.countEntriesNonRecursive(12));
		System.out.println("Number of Qs \t0:  " + nonDupTree.countEntriesNonRecursive(new String("Q")));

		System.out.println("\n*****TESTING COUNT GREATER THAN WITH STACK");
		System.out.println("Numbers greater than 0 \t\t15: " + dupTree.countGreaterWithStack(0));
		System.out.println("Numbers greater than 1 \t\t14: " + dupTree.countGreaterWithStack(1));
		System.out.println("Numbers greater than 5 \t\t10: " + dupTree.countGreaterWithStack(5));
		System.out.println("Numbers greater than 6 \t\t6: " + dupTree.countGreaterWithStack(6));
		System.out.println("Numbers greater than 8 \t\t3: " + dupTree.countGreaterWithStack(8));
		System.out.println("Numbers greater than 10 \t1: " + dupTree.countGreaterWithStack(10));		
		System.out.println("Numbers greater than 11 \t0: " + dupTree.countGreaterWithStack(11));
		System.out.println("Numbers greater than 12 \t0: " + dupTree.countGreaterWithStack(12));

		System.out.println("\n*****TESTING COUNT GREATER RECURSIVE");
		System.out.println("Numbers greater than 0 \t\t15: " + dupTree.countGreaterRecursive(0));
		System.out.println("Numbers greater than 1 \t\t14: " + dupTree.countGreaterRecursive(1));
		System.out.println("Numbers greater than 5 \t\t10: " + dupTree.countGreaterRecursive(5));
		System.out.println("Numbers greater than 6 \t\t6: " + dupTree.countGreaterRecursive(6));
		System.out.println("Numbers greater than 8 \t\t3: " + dupTree.countGreaterRecursive(8));
		System.out.println("Numbers greater than 10 \t1: " + dupTree.countGreaterRecursive(10));		
		System.out.println("Numbers greater than 11 \t0: " + dupTree.countGreaterRecursive(11));
		System.out.println("Numbers greater than 12 \t0: " + dupTree.countGreaterRecursive(12));

		System.out.println("\n*****TESTING EXTRA CREDIT COUNT UNIQUE VALUES");
		System.out.println("Unique values \t10: " + dupTree.countUniqueValues());
		System.out.println("Unique values \t 8: " + nonDupTree.countUniqueValues());
		
		System.out.println("\n*****EVALUATING METHOD DESIGN");
		methodEvaluator();
	}
	private static void methodEvaluator() {
		System.out.println("This method is designed to help you figure out if you are fully taking advantage of the sorted nature of a BST.");
		System.out.println("\n***IMPORTANT***: In order to use these tests, you must add code to the method you are evaluating.");
		System.out.println("The code should count how many iterations the method took- loops or recursion. Print that total count.");
		System.out.println("\nEach test below will then show two counts.");
		System.out.println("\tIf the two counts are very differnt: you might be okay for that method.");
		System.out.println("\tIf the two iteration counts are equal or very close to each other... ALERT! You might not be fully taking advantage of the sorted nature of the BST for countEntriesNonRecursive.");
		System.out.println("\nDon't forget to remove the test code before submission! :)");
		
		final int SMALL_NUM = -1;
		final int SIZE = 5000;
		final int LARGE_NUM = SIZE*2;

		BinarySearchTreeWithDups<Integer> lotsOfDups; 

		System.out.println("\nTesting countEntriesNonRecursive Test A...");
		lotsOfDups = new BinarySearchTreeWithDups<Integer>();
		for(int i=0, num=0; i<SIZE; i++) {
			lotsOfDups.add(num);
			if(i%5==0) {
				num++;
			}
		}
		lotsOfDups.countEntriesNonRecursive(SMALL_NUM);
		
		lotsOfDups = new BinarySearchTreeWithDups<Integer>();
		for(int i=0; i<SIZE; i++) {
			lotsOfDups.add(LARGE_NUM);
		}
		lotsOfDups.countEntriesNonRecursive(SMALL_NUM);
		
		System.out.println("\nTesting countEntriesNonRecursive Test B...");
		lotsOfDups = new BinarySearchTreeWithDups<Integer>();
		for(int i=0; i<SIZE; i++) {
			lotsOfDups.add(SMALL_NUM);
		}
		lotsOfDups.countEntriesNonRecursive(SMALL_NUM);
		lotsOfDups.countEntriesNonRecursive(LARGE_NUM);


		System.out.println("\nTesting countGreaterWithStack...");
		lotsOfDups = new BinarySearchTreeWithDups<Integer>();
		for(int i=0; i<SIZE; i++) {
			lotsOfDups.add(SMALL_NUM);
		}
		lotsOfDups.countGreaterWithStack(LARGE_NUM);
		lotsOfDups.countGreaterWithStack(SMALL_NUM-1);

		System.out.println("\nTesting countGreaterRecursive...");
		lotsOfDups = new BinarySearchTreeWithDups<Integer>();
		for(int i=0; i<SIZE; i++) {
			lotsOfDups.add(SMALL_NUM);
		}
		lotsOfDups.countGreaterRecursive(LARGE_NUM);
		lotsOfDups.countGreaterRecursive(SMALL_NUM-1);

		
	
	}
	
}
