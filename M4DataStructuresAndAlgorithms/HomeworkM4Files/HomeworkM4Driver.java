import java.util.Arrays;

public class HomeworkM4Driver {

	public static void main(String[] args) {

		System.out.println("******TESTING ARRAYBAG REPLACE ");
		ArrayBag<Integer> numbersBag = new ArrayBag<Integer>();
		int result = numbersBag.replaceEvery(1, 2);
		System.out.println("Result is 0: " + result);
		System.out.println("The bag contains[] \n\t\t" + Arrays.toString(numbersBag.toArray()));
		numbersBag.add(1);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		numbersBag.add(1);
		result = numbersBag.replaceEvery(6, 10);
		System.out.println("Result is 0: " + result);
		System.out.println("The bag contains[1, 2, 1, 4, 3, 1] \n\t\t" + Arrays.toString(numbersBag.toArray()));
		result = numbersBag.replaceEvery(1,7);
		System.out.println("Result is 3: " + result);
		System.out.println("The bag contains (in ANY order) [7, 2, 7, 4, 3, 7] \n\t\t\t\t" + Arrays.toString(numbersBag.toArray()));

		
		System.out.println("\n\n******TESTING ARRAYBAG REMOVE EVERY");
		numbersBag.clear();
		numbersBag.add(7);
		numbersBag.add(2);
		numbersBag.add(1);
		numbersBag.add(4);
		numbersBag.add(3);
		numbersBag.add(1);
		numbersBag.add(1);
		numbersBag.add(7);
		int numRemoved = numbersBag.removeEvery(1);
		System.out.println("Number removed is 3: " + numRemoved);
		System.out.println("The bag contains (in ANY order) [7, 2, 7, 4, 3]\n\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numRemoved = numbersBag.removeEvery(7);
		System.out.println("Number removed is 2: " + numRemoved);
		System.out.println("The bag contains (in ANY order) [3, 2, 4]\n\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numRemoved = numbersBag.removeEvery(8);
		System.out.println("Number removed is 0: " + numRemoved);
		System.out.println("The bag contains (in ANY order) [3, 2, 4]\n\t\t\t\t"+ Arrays.toString(numbersBag.toArray()));
		numbersBag.clear();
		numbersBag.add(1);
		numbersBag.add(1);
		numbersBag.add(1);
		numbersBag.add(1);
		numRemoved = numbersBag.removeEvery(1);
		System.out.println("Number removed is 4: " + numRemoved);
		System.out.println("The bag contains []\n\t\t "+ Arrays.toString(numbersBag.toArray()));
		
		
		System.out.println("\n\n******TESTING RESIZABLEARRAYBAG TRIM TO SIZE");
		ResizableArrayBag<Integer> resizableBag = new ResizableArrayBag<Integer>(20);
		for(int i=0; i<100; i++) {
			resizableBag.add(1);
		}
		System.out.println("The bag contains this many numbers 100: " + resizableBag.getCurrentSize());
		// NOTE: you need to modify ResizableArrayBag somehow to access and test the length of the array
		System.out.println("The length of the bag array is 160");
		resizableBag.trimToSize();
		System.out.println("The length of the bag array is 100");

		System.out.println("\n\n******TESTING ALIST REMOVE EVERY");
		AList<Integer> numbersList = new AList<>();
		numbersList.add(1);
		numbersList.add(2);
		numbersList.add(1);
		numbersList.add(1);		
		numbersList.add(4);
		numbersList.add(3);
		numbersList.add(7);
		numbersList.add(1);		
		numRemoved = numbersList.removeEvery(1);
		System.out.println("Number removed is 4: " + numRemoved);
		System.out.println("The list contains \n\t[2, 4, 3, 7]\n\t"+ Arrays.toString(numbersList.toArray()));
		numRemoved = numbersList.removeEvery(7);
		System.out.println("Number removed is 1: " + numRemoved);
		System.out.println("The list contains \n\t[2, 4, 3]\n\t"+ Arrays.toString(numbersList.toArray()));
		numRemoved = numbersList.removeEvery(8);
		System.out.println("Number removed is 0: " + numRemoved);
		System.out.println("The list contains \n\t[2, 4, 3]\n\t"+ Arrays.toString(numbersList.toArray()));
		numbersList.clear();
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numbersList.add(1);
		numRemoved = numbersList.removeEvery(1);
		System.out.println("Number removed is 4: " + numRemoved);
		System.out.println("The list contains \n\t[]\n\t"+ Arrays.toString(numbersList.toArray()));
		
		System.out.println("\n\n******TESTING ALIST EQUALS");		
		AList<String> produceList = new AList<String>();
		produceList.add("banana");
		produceList.add("date");
		produceList.add("grape");
		produceList.add("eggplant");
		AList<String> foodList = new AList<String>();
		foodList.add("banana");
		foodList.add("date");
		foodList.add("grape");
		System.out.println("Result is false: " + produceList.equals(foodList));
		foodList.add("eggplant");
		
		System.out.println("Result is true: " + produceList.equals(foodList));
		foodList.add("squash");
		System.out.println("Result is false: " + produceList.equals(foodList));
		produceList.add("squash");
		foodList.replace(1, "grape");
		foodList.replace(3, "banana");
		System.out.println("Result is false: " + produceList.equals(foodList));
		System.out.println("The produce list contains \n\t[banana, date, grape, eggplant, squash] \n\t"	+ Arrays.toString(produceList.toArray()));
		System.out.println("The food list contains \n\t[grape, date, banana, eggplant, squash] \n\t"	+ Arrays.toString(foodList.toArray()));

		/* un-comment this section if doing the extra credit */
		/*
		System.out.println("\n\n******TESTING EXTRA CREDIT ALIST COMPARABLE");	
		AList<Integer> numberListA = new AList<Integer>();
		numberListA.add(1);
		AList<Integer> numberListB = new AList<Integer>();
		System.out.println("List A is bigger (more elements)\n\tresult should be positive: " + numberListA.compareTo(numberListB));
		numberListB.add(1);
		numberListB.add(2);
		System.out.println("List A is smaller (fewer elements)\n\t result should be negative: " + numberListA.compareTo(numberListB));
		numberListA.add(2);
		System.out.println("List A and List B are the same size and have the same elemnets\n\t result should be 0: " + numberListA.compareTo(numberListB));
		numberListA.add(3);
		numberListB.add(4);
		System.out.println("List A is smaller (lists are the same size; for the first non-matching element, the a list element is smallern\n\tresult should be negative: " + numberListA.compareTo(numberListB));
		numberListB.replace(3,3);
		System.out.println("List A and List B are the same size and have the same elemnets\n\t result should be 0: " + numberListA.compareTo(numberListB));
		numberListA.add(4);
		numberListB.add(3);
		System.out.println("List A is bigger (lists are the same size; for the first non-matching element, the a list element is bigger\n\tresult should be positive: " + numberListA.compareTo(numberListB));
		
		AList<String> wordListA = new AList<String>();
		wordListA.add("a");
		wordListA.add("b");
		wordListA.add("c");
		AList<String> wordListB = new AList<String>();
		wordListB.add("a");
		wordListB.add("d");
		wordListB.add("c");
		System.out.println("List A is smaller (lists are the same size; for the first non-matching element, the a list element is smaller\n\tresult should be negative: " + wordListA.compareTo(wordListB));
		*/
		

	}

}
