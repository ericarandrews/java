
public class ProjectBTester {

	public static void main(String[] args) {
		HeadTailListInterface<Integer> list = new ArrayHeadTailList<Integer>(10);
		
		// comment the line above and un-comment the line below to test the extra credit
		// NOTE: for the extra credit, all lines should match except for the capacity print out-
		// the capacity of an ArrayList is private, so this cannot be shown
		// HeadTailListInterface<Integer> list = new ListHeadTailList<Integer>(10);
		
		
		System.out.println("********TESTING ISEMPTY AND EMPTY DISPLAY");
		System.out.println("Empty is true: " + list.isEmpty());
		System.out.println();
		System.out.println("Should display:\n0 elements; capacity = 10");
		list.display();
		System.out.println();
		
		System.out.println("\n\n********TESTING ADD TO FRONT");
		// test addFront to emtpy
		list.addFront(2);
		System.out.println("Should display:\n1 elements; capacity = 10	[2]");
		list.display();
		System.out.println();
		
		// test addFront to not empty
		list.addFront(4);
		list.addFront(3);
		System.out.println("Should display:\n3 elements; capacity = 10	[3, 4, 2]");
		list.display();
		System.out.println();
		
		System.out.println("Empty is false: " + list.isEmpty());
		
		System.out.println("\n\n********TESTING CLEAR");
		list.clear();
		System.out.println("Should display:\n0 elements; capacity = 10");
		list.display();
		
		System.out.println("\n\n********TESTING ADD TO BACK");
		// test addBack to empty
		list.addBack(7);
		System.out.println("Should display:\n1 elements; capacity = 10	[7]");
		list.display();
		System.out.println();
		
		// test addBack to non empty
		list.addBack(10);
		list.addBack(5);
		System.out.println("Should display:\n3 elements; capacity = 10	[7, 10, 5]");
		list.display();
		
		System.out.println("\n\n********TESTING CONTAINS");
		System.out.println("Contains 5 true:  "+list.contains(5));
		System.out.println("Contains 7 true:  "+list.contains(7));
		System.out.println("Contains 4 false: "+list.contains(4));
		
		System.out.println("\n\n********TESTING ADD WITH EXPANSION");
		list.clear();
		for(int i=0; i<32; i++) {
			list.addBack(i);
		}
		System.out.println("Should display:\n32 elements; capacity = 40	[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31]");
		list.display();
		
		System.out.println("\n\n********TESTING INDEX OF");
		System.out.println("Index of 0  is  0: " + list.indexOf(0));
		System.out.println("Index of 31 is 31: " + list.indexOf(31));
		System.out.println("Index of -5 is -1: " + list.indexOf(-5));
		System.out.println("Index of 32 is -1: " + list.indexOf(32));
		list.addFront(3);
		list.addBack(5);
		System.out.println("Index of 3  is  0: " + list.indexOf(3));
		System.out.println("Index of 5  is  6: " + list.indexOf(5));
		
		System.out.println("\n\n********TESTING LAST INDEX OF");
		System.out.println("Last index of 0  is  1:  " + list.lastIndexOf(0));
		System.out.println("Last index of 31 is 32: " + list.lastIndexOf(31));
		System.out.println("Last index of -5 is -1: " + list.lastIndexOf(-5));
		System.out.println("Last index of 35 is -1: " + list.lastIndexOf(35));
		System.out.println("Last index of 3  is  4:  " + list.lastIndexOf(3));
		System.out.println("Last index of 5  is 33: " + list.lastIndexOf(5));
		
		
		System.out.println("\n\n********TESTING SIZE");
		System.out.println("Size is 34: " + list.size());
		System.out.println();
		
		System.out.println("\n********TESTING GET ENTRY");
		System.out.println("Element in position 15 is 14: "+list.getEntry(15));
		System.out.println("Element in position  0 is  3: "+list.getEntry(0));
		System.out.println("Element in position 39 is null: "+list.getEntry(39));
		System.out.println("Element in position -1 is null: "+list.getEntry(-1));
		
		System.out.println("\n\n********TESTING REMOVES");
		// test removes from nonEmpty
		System.out.println("Remove front element 3: "+list.removeFront());
		System.out.println("Remove back element  5 :"+list.removeBack());
		System.out.println("Remove front element 0: "+list.removeFront());
		System.out.println("Remove back element 31: "+list.removeBack());
		System.out.println();
		System.out.println("Should display:\n30 elements; capacity = 40	[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]");
		list.display();
		System.out.println();
		
		// test removes from empty
		list.clear();
		System.out.println("Remove element null: "+list.removeFront());
		System.out.println("Remove element null: "+list.removeBack());
		System.out.println();
		
		// test removes from singleton
		list.clear();
		list.addFront(1);
		System.out.println("Remove element 1: "+list.removeFront());
		System.out.println("Should display:\n0 elements; capacity = 40");
		list.display();
		System.out.println();
		System.out.println();
		list.addBack(1);
		System.out.println("Remove element 1: "+list.removeFront());
		System.out.println("Should display:\n0 elements; capacity = 40");
		list.display();
		System.out.println();
		System.out.println();
		list.addFront(1);
		System.out.println("Remove element 1: "+list.removeBack());
		System.out.println("Should display:\n0 elements; capacity = 40");
		list.display();
		System.out.println();
		System.out.println();
		list.addBack(1);
		System.out.println("Remove element 1: "+list.removeBack());
		System.out.println("Should display:\n0 elements; capacity = 40");
		list.display();
		System.out.println();
		System.out.println();
		
		System.out.println("\n\n********TESTING MIX OF ADDS AND REMOVES");
		list.addFront(3);
		list.addBack(2);
		list.addFront(4);
		list.addFront(5);
		list.addBack(3);
		list.addBack(8);
		list.addBack(9);
		System.out.println("Should display:\n7 elements; capacity = 40	[5, 4, 3, 2, 3, 8, 9]");
		list.display();
		System.out.println();
	
		list.removeFront();
		list.removeBack();
		System.out.println("Should display:\n5 elements; capacity = 40	[4, 3, 2, 3, 8]");
		list.display();
		System.out.println();
		
		System.out.println("********TESTING WITH STRINGS");
		HeadTailListInterface<String> wordList = new ArrayHeadTailList<String>(5);
		wordList.addFront("job!");
		wordList.addFront("Nice");
		wordList.addFront("it!");
		wordList.addFront("did");
		wordList.addFront("You");
		System.out.println("Should display:\n5 elements; capacity = 5	[You, did, it!, Nice, job!]");
		wordList.display();
		System.out.println();
		System.out.println("Contains \"Nice\" is true: "+ wordList.contains(new String("Nice")));
		System.out.println("Contains \"You\"  is true: "+ wordList.contains(new String("You")));
		System.out.println("Contains \"you\"  is false: "+ wordList.contains(new String("you")));
		System.out.println();
		System.out.println("Index of \"it!\" is 2: "+ wordList.indexOf(new String("it!")));
		System.out.println("Last index of \"it!\" is 2: "+ wordList.lastIndexOf(new String("it!")));
		
			
	
	}

}
