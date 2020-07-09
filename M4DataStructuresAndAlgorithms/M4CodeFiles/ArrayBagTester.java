
public class ArrayBagTester {
	
	public static void main(String[] args) {
		
		BagInterface<Integer> numberBag = new ArrayBag<>();
		
		numberBag.add(1);
		numberBag.add(2);
		numberBag.add(3);

		/*
		if(numberBag instanceof ArrayBag<?>)
			System.out.println( ((ArrayBag<Integer>)numberBag).removeRandom() );
		 */		
		
		BagInterface<Integer> numberBag2 = new ArrayBag<>();
		numberBag2.add(3);
		numberBag2.add(2);
		numberBag2.add(1);
		numberBag2.add(4);
		
		System.out.println(numberBag.equals(numberBag2));
		
		BagInterface<String> wordBag = new ArrayBag<>();
		wordBag.add("apple");
		wordBag.add("banana");
		wordBag.add("pear");
		
		System.out.println(numberBag.equals(wordBag));
		

	}

}
