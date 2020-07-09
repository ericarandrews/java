import java.util.*;

public class HomeworkM10Driver {

    public static void main(String[] args) {   
    	
       	System.out.println("\n*****TESTING PRIORITY PUSH");
    	LinkedStack<Integer> numberStack = new LinkedStack<Integer>();
    	numberStack.push(2);
    	numberStack.push(4);
    	numberStack.push(6);
    	numberStack.push(8);
    	numberStack.push(10);
    	System.out.println("2 4 6 8 10\n" + numberStack + "\n");
    	
    	// push an element not in the stack
    	boolean prioritized = numberStack.priorityPush(12); 
    	System.out.println("2 4 6 8 10 12 prioritized=false\n" + numberStack + "prioritized=" + prioritized + "\n");

    	// push an element that on the bottom of the stack
    	prioritized = numberStack.priorityPush(2);
    	System.out.println("4 6 8 10 12 2 prioritized=true\n" + numberStack + "prioritized=" + prioritized + "\n");

    	// push an element that is at the top of the stack
    	prioritized = numberStack.priorityPush(2);
    	System.out.println("4 6 8 10 12 2 prioritized=true\n" + numberStack + "prioritized=" + prioritized + "\n");

    	// push an element that is in the middle of the stack
    	prioritized = numberStack.priorityPush(6);
    	System.out.println("4 8 10 12 2 6 prioritized=true\n" + numberStack + "prioritized=" + prioritized + "\n");
 
    	// push an element that is in the middle of the stack and repeated
    	numberStack.push(12);
    	numberStack.push(7);
    	numberStack.push(5);
    	prioritized = numberStack.priorityPush(12);
    	System.out.println("4 8 10 12 2 6 7 5 12 prioritized=true\n" + numberStack + "prioritized=" + prioritized + "\n");

    	// push on an empty stack
    	numberStack.clear();
    	prioritized = numberStack.priorityPush(6);
    	System.out.println("6 prioritized=false\n" + numberStack + "prioritized=" + prioritized + "\n");
    	
    	// push on a singleton stack with a match
    	prioritized = numberStack.priorityPush(6);
    	System.out.println("6 prioritized=true\n" + numberStack + "prioritized=" + prioritized + "\n");
  
       	// push on a singleton stack without a match
    	prioritized = numberStack.priorityPush(14);
    	System.out.println("6 14 prioritized=false\n" + numberStack + "prioritized=" + prioritized + "\n");
  
    	// test with Strings
    	LinkedStack<String> stringStack = new LinkedStack<String>();
    	stringStack.push("cat");
    	stringStack.push("dog");
    	stringStack.push("ant");
    	prioritized = stringStack.priorityPush(new String("dog"));
       	System.out.println("cat ant dog prioritized=true\n" + stringStack + "prioritized=" + prioritized + "\n");


    	
    	// UN-COMMENT FOR EXTRA CREDIT
    	/*
		System.out.println("\n\n*****TESTING PEEKNEXT IN LINKEDSTACAK");
    	LinkedStack<String> peekStackLinked = new LinkedStack<>();
    	try {
    		System.out.println("Should print null/throw exception: ");
    		System.out.println(peekStackLinked.peekNext());
    	} catch(Exception ex) { // normally this is bad practice to catch a general exception object. don't do this!! I had to do this here to make this general since you can choose different kinds of exceptions
    		System.out.println("Exception thrown of type " + ex.getClass());
    	}
    	peekStackLinked.push("hello");
    	try {
    		System.out.println("Should print null/throw exception: ");
    		System.out.println(peekStackLinked.peekNext());
       	} catch(Exception ex) { 
    		System.out.println("Exception thrown of type " + ex.getClass());
    	}
    	peekStackLinked.push("goodbye");
    	System.out.println("Should print hello: " + peekStackLinked.peekNext());
    	peekStackLinked.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackLinked.peekNext());
    	System.out.println();
    	
 		System.out.println("\n\n*****TESTING PEEK2 IN ARRAYSTACAK");
    	ArrayStack<String> peekStackArray = new ArrayStack<>();
    	try {
    		System.out.println("Should print null/throw exception: ");
    		System.out.println(peekStackArray.peekNext());
    	} catch(Exception ex) { 
    		System.out.println("Exception thrown of type " + ex.getClass());
    	}
    	peekStackArray.push("hello");
    	try {
    		System.out.println("Should print null/throw exception: ");
    		System.out.println(peekStackArray.peekNext());
    	} catch(Exception ex) { 
    		System.out.println("Exception thrown of type " + ex.getClass());
    	}
    	peekStackArray.push("goodbye");
    	System.out.println("Should print hello: " + peekStackArray.peekNext());
    	peekStackArray.push("and good night");
    	System.out.println("Should print goodbye: " + peekStackArray.peekNext());
    	System.out.println();
   	    */
    }       
    

	
	
    
  
    
}