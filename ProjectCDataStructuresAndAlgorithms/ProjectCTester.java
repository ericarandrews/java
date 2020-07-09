
public class ProjectCTester {

	public static void main(String[] args) {
		HeadTailListInterface<Integer> list = new LinkedHeadTailList<Integer>();
		
		System.out.println("********TESTING ISEMPTY AND EMPTY DISPLAY");
		System.out.println("Empty is true: " + list.isEmpty());
		System.out.println();
		System.out.println("Should display:\n[]");
		list.display();
		System.out.println();
		
		System.out.println("\n\n********TESTING ADD TO FRONT");
		// test addFront to emtpy
		list.addFront(2);
		System.out.println("Should display:\n[2] \thead=2 tail=2");
		list.display();
		System.out.println();
		
		// test addFront to singleton
		list.addFront(4);
		System.out.println("Should display:\n[4, 2] \thead=4 tail=2");
		list.display();
		System.out.println();
		
		// test addFront 
		list.addFront(3);
		list.addFront(6);
		System.out.println("Should display:\n[6, 3, 4, 2] \thead=6 tail=2");
		list.display();
		System.out.println();
		
		System.out.println("Empty is false: " + list.isEmpty());
		
		System.out.println("\n\n********TESTING CLEAR");
		list.clear();
		System.out.println("Should display:\n[]");
		list.display();
		
		System.out.println("\n\n********TESTING ADD TO BACK");
		// test addBack to empty
		list.addBack(7);
		System.out.println("Should display:\n[7] \thead=7 tail=7");
		list.display();
		System.out.println();
		
		// test addBack to singleton
		list.addBack(9);
		System.out.println("Should display:\n[7, 9] \thead=7 tail=9");
		list.display();
		
		// test addBack
		list.addBack(10);
		list.addBack(5);
		System.out.println("Should display:\n[7, 9, 10, 5] \thead=7 tail=5");
		list.display();
		
		System.out.println("\n\n********TESTING CONTAINS");
		System.out.println("Contains 7 true:  "+list.contains(7));
		System.out.println("Contains 5 true:  "+list.contains(5));
		System.out.println("Contains 10 true:  "+list.contains(10));
		System.out.println("Contains 4 false: "+list.contains(4));
		
		System.out.println("\n\n********TESTING INDEX OF");
		list.clear();
		for(int i=0; i<32; i++) {
			list.addBack(i);
		}
		System.out.println("Should display:\n[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31] \thead=0 tail=31");
		list.display();

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
		System.out.println("Element in position 33 is  5: "+list.getEntry(33));
		System.out.println("Element in position 39 is null: "+list.getEntry(39));
		System.out.println("Element in position -1 is null: "+list.getEntry(-1));
		
		System.out.println("\n\n********TESTING REMOVES");
		// test removes from nonEmpty
		System.out.println("Remove front element 3: "+list.removeFront());
		System.out.println("Remove back element  5 :"+list.removeBack());
		System.out.println("Remove front element 0: "+list.removeFront());
		System.out.println("Remove back element 31: "+list.removeBack());
		System.out.println();
		System.out.println("Should display:\n[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]\thead=1 tail=30");
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
		System.out.println("Should display:\n[]");
		list.display();
		System.out.println();
		System.out.println();
		list.addBack(1);
		System.out.println("Remove element 1: "+list.removeFront());
		System.out.println("Should display:\n[]");
		list.display();
		System.out.println();
		System.out.println();
		list.addFront(1);
		System.out.println("Remove element 1: "+list.removeBack());
		System.out.println("Should display:\n[]");
		list.display();
		System.out.println();
		System.out.println();
		list.addBack(1);
		System.out.println("Remove element 1: "+list.removeBack());
		System.out.println("Should display:\n[]");
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
		System.out.println("Should display:\n[5, 4, 3, 2, 3, 8, 9]\thead=5 tail=9");
		list.display();
		System.out.println();
	
		list.removeFront();
		list.removeBack();
		System.out.println("Should display:\n[4, 3, 2, 3, 8]\thead=4 tail=8");
		list.display();
		System.out.println();
		
		System.out.println("********TESTING WITH STRINGS");
		HeadTailListInterface<String> wordList = new LinkedHeadTailList<String>();
		wordList.addFront("job!");
		wordList.addFront("Nice");
		wordList.addFront("it!");
		wordList.addFront("did");
		wordList.addFront("You");
		System.out.println("Should display:\n[You, did, it!, Nice, job!] \thead=You tail=job!");
		wordList.display();
		System.out.println();
		System.out.println("Contains \"Nice\" is true: "+ wordList.contains(new String("Nice")));
		System.out.println("Contains \"You\"  is true: "+ wordList.contains(new String("You")));
		System.out.println("Contains \"you\"  is false: "+ wordList.contains(new String("you")));
		System.out.println();
		System.out.println("Index of \"it!\" is 2: "+ wordList.indexOf(new String("it!")));
		System.out.println("Last index of \"it!\" is 2: "+ wordList.lastIndexOf(new String("it!")));
		
		/*// UNCOMMENT IF COMPLETING THE EXTRA CREDIT
		System.out.println("\n\n********EXTRA CREDIT");
		LinkedHeadTailList<Integer> listA = new LinkedHeadTailList<Integer>();
		LinkedHeadTailList<Integer> listB = new LinkedHeadTailList<Integer>();

		// both empty lists []
		System.out.println("Comparison result: 0: "+ listA.compareTo(listB)); 
		
		// no mismatched elements found and listA [1] is longer than listB [] 
		listA.addFront(1); 		
		System.out.println("Comparison result: positive number: "+ listA.compareTo(listB)); 
		
		// no mismatched elements found and listA [1] is shorter than listB [1, 2]
		listB.addFront(1);
		listB.addBack(2); 	
		System.out.println("Comparison result: negative number: "+ listA.compareTo(listB)); 
		
		// no mismatched elements found [1, 2], equal length 
		listA.addBack(2); 		
		System.out.println("Comparison result: 0: "+ listA.compareTo(listB));
		
		// for first mismatched element, the listA element [1, 2, 3] is smaller than the listB element [1, 2, 4]
		listA.addBack(3);
		listB.addBack(4); 		
		System.out.println("Comparison result: negative number: "+ listA.compareTo(listB));

		// for first mismatched element, the listA element [1, 2, 6] is larger than the listB element [1, 2, 4] 
		listA.removeBack();
		listA.addBack(6); 		
		System.out.println("Comparison result: positive number: "+ listA.compareTo(listB)); 
		
		// for first mismatched element, the listA element [1, 2, 3, 4, 7] is smaller than the listB element [7]
		listA.clear();
		listB.clear();
		listA.addBack(1);
		listA.addBack(2);
		listA.addBack(3);
		listA.addBack(4);
		listB.addBack(7);
		System.out.println("Comparison result: negative number: "+ listA.compareTo(listB));	
	
		// for first mismatched element, the listA element [7] is larger than the listB element [1, 2, 3, 4, 7]
		listA.clear();
		listB.clear();
		listB.addBack(1);
		listB.addBack(2);
		listB.addBack(3);
		listB.addBack(4);
		listA.addBack(7);
		System.out.println("Comparison result: postitive number: "+ listA.compareTo(listB));	
		*/
	
	}

}
