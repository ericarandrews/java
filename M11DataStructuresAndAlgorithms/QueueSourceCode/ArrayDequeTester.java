import java.util.Arrays;

public class ArrayDequeTester {

	public static void main(String[] args) {
		// *** to use, temporarily make the deque in ArrayDeque public
		System.out.println("Create a deque: ");
		DequeInterface<String> myDeque = new ArrayDeque<String>();
		System.out.println("isEmpty() returns " + myDeque.isEmpty() + "\n");

		System.out.println("Add to front and back of deque to get\n" + "Joe Jess Jim Jill Jane Jerry");
		myDeque.addToFront("Jim");
		myDeque.addToFront("Jess");

		myDeque.addToBack("Jill");
		myDeque.addToBack("Jane");

		myDeque.addToFront("Joe");
		myDeque.addToBack("Jerry");

		System.out.println("isEmpty() returns " + myDeque.isEmpty());

		System.out.println("\nTesting getFront, getBack, removeFront, removeBack:\n");
		String front, back;
		front = myDeque.getFront();
		System.out.println("Joe is at the front of the deque: " + front);

		back = myDeque.getBack();
		System.out.println("Jerry is at the back of the deque: " + back);

		front = myDeque.removeFront();
		System.out.println("Joe is removed from the front of the deque: " + front);

		back = myDeque.removeBack();
		System.out.println("Jerry is removed from the back of the deque: " + back);

		front = myDeque.getFront();
		System.out.println("Jess is at the front of the deque: " + front);

		back = myDeque.getBack();
		System.out.println("Jane is at the back of the deque: " + back);

		System.out.println("\n\nTesting clear:");
		myDeque.clear();
		System.out.println("isEmpty() returns " + myDeque.isEmpty() + "\n\n");

		front = myDeque.removeFront();
		if (front == null)
			System.out.println("removeFront correctly finds deque empty");
		else
			System.out.println("removeFront incorrectly finds queue not empty");

		front = myDeque.removeBack();
		if (front == null)
			System.out.println("removeBack correctly finds deque empty");
		else
			System.out.println("removeBack incorrectly finds queue not empty");
		
		ArrayDeque<String> wordDeque = new ArrayDeque<String>(5);
		System.out.println("Add amps to front");
		wordDeque.addToFront("amps");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add bank to front");
		wordDeque.addToFront("bank");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add card to back");
		wordDeque.addToBack("card");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add door to front");
		wordDeque.addToFront("door");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add ever to back");
		wordDeque.addToBack("ever");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Remove back");
		wordDeque.removeBack();
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Remove front");
		wordDeque.removeFront();
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add frog to back");
		wordDeque.addToBack("frog");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add golf to front");
		wordDeque.addToFront("golf");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Remove back");
		wordDeque.removeBack();
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add hats to front");
		wordDeque.addToFront("hats");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());
		System.out.println("Add iris to front");
		wordDeque.addToFront("iris");
		System.out.println(Arrays.toString(wordDeque.deque) + "\tFront=" + wordDeque.getFront() + "\tBack=" + wordDeque.getBack());

				
		
	}

}
