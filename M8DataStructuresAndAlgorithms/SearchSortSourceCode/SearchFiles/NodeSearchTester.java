import java.util.Arrays;
import java.util.Random;

public class NodeSearchTester {

	public static void main(String[] args) {

		Random generator = new Random();
		int[] numbers = new int[1000];
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = generator.nextInt(100);
		}
		
		Node<Integer> firstNode = new Node<>(numbers[0]);
		Node currentNode = firstNode;
		for(int i=1; i<numbers.length; i++) {
			Node<Integer> newNode = new Node<>(numbers[i]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}
		
		System.out.println("RANDOM TARGET IN THE ARRAY");
		int target = generator.nextInt(100);

//		System.out.println("RANDOM TARGET NOT IN THE ARRAY");
/*		target = generator.nextInt(100);
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] == target) {
				numbers[i]--;
			}
		}
		
		firstNode = new Node<>(numbers[0]);
		currentNode = firstNode;
		for(int i=1; i<numbers.length; i++) {
			Node<Integer> newNode = new Node<>(numbers[i]);
			currentNode.next = newNode;
			currentNode = currentNode.next;
		}
*/
//		System.out.println("TARGET IN THE ARRAY- LARGEST VALUE");
//		target = 99; // assuming this value is there!

//		System.out.println(" TARGET IN THE ARRAY- SMALLEST VALUE");
//		target = 0; // assuming this value is there!

		
//		System.out.println("TARGET NOT IN THE ARRAY- LARGER VALUE");	
//		target = 999;
		
//		System.out.println("TARGET NOT IN THE ARRAY- SMALLER VALUE");
//		target = -999;

		System.out.println("Target is " + target);
		
		System.out.println("SEARCHES ON UNSORTED ARRAY DATA");
		int location = Searches.linearSearchIterative(numbers,  target);
		System.out.println("Location is " + location);
		location = Searches.linearSearchRecursive(numbers, target);
		System.out.println("Location is " + location);

		System.out.println("SEARCHES ON UNSORTED NODE DATA");
		location = NodeSearches.linearSearchIterative(firstNode,  target);
		System.out.println("Location is " + location);
		location = NodeSearches.linearSearchRecursive(firstNode, target);
		System.out.println("Location is " + location);

	}
	

}
