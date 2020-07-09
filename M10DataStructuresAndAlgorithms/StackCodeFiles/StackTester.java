import java.util.Arrays;
public class StackTester {

	public static void main(String[] args) {
		StackInterface<Integer> numberStack = new ArrayReverseStack<Integer>();
		// or ArrayStack LinkedStack ArrayReverseStack
		
		for(int i=0; i<10; i++) {
			System.out.println("Pushing " + i);
			numberStack.push(i);
			
			// use only for ArrayStack or ArrayReverseStack; change the cast accordingly
			// must make stack array and topIndex public first; (don't forget to change them back!!)
			// System.out.println("Top Index is " + ((ArrayReverseStack) numberStack).topIndex + " "+ Arrays.toString(((ArrayReverseStack) numberStack).stack));
		}
		System.out.println("\nDone!");
		System.out.println("Top of the stack is: " + numberStack.peek() + "\n");
		while(!numberStack.isEmpty()) {
			System.out.println("Popped: " + numberStack.pop()); // + " and the top is now " + numberStack.peek());

			// use only for ArrayStack or ArrayReverseStack; change the cast accordingly
			// must make stack array and topIndex public first; (don't forget to change them back!!)
			// System.out.println("Top Index is " + ((ArrayReverseStack) numberStack).topIndex + " "+ Arrays.toString(((ArrayReverseStack) numberStack).stack));

		}
		

	}

}
