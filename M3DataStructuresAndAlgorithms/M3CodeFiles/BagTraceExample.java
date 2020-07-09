import java.util.Arrays;

public class BagTraceExample {

	public static void main(String[] args) {
		BagInterface<String> animalBag = new ArrayBag();
		
			
		System.out.println(animalBag.isEmpty());
		animalBag.add("alligator");
		animalBag.add("bear");
		animalBag.add("bear");
		animalBag.add("cat");
		animalBag.add("dog");
		animalBag.add("elephant");
		System.out.println(animalBag.isEmpty());
		animalBag.add("cat");
		animalBag.add("cat");
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.remove("bear"));
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.remove("cat"));
		System.out.println(animalBag.remove("cat"));
		animalBag.add("cat");
		System.out.println(animalBag.remove("gorilla"));
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.getFrequencyOf("cat"));
		System.out.println(animalBag.contains("gorilla"));
		System.out.println(animalBag.getFrequencyOf("gorilla"));
		animalBag.clear();
		System.out.println(animalBag.getCurrentSize());
		System.out.println(animalBag.remove());

				
	}
}
