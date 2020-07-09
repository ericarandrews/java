import java.util.Arrays;

public class ListTraceExample {

	public static void main(String[] args) {
		ListInterface<String> animalList = new AList<String>();

		
		System.out.println(animalList.isEmpty());
		animalList.add("alligator");
		animalList.add("bear");
		animalList.add("cat");
		animalList.add("dog");
		animalList.add("lemur");
		animalList.add(3, "elephant");
		animalList.add(1, "koala");
		animalList.add("dog");		
		System.out.println(animalList.isEmpty());
		System.out.println(animalList.getLength());
		System.out.println(animalList.remove(1));
		System.out.println(animalList.getEntry(2));
		System.out.println(animalList.remove(2));
		System.out.println(animalList.getLength());
		System.out.println(animalList.replace(1, "monkey"));
		System.out.println(animalList.getEntry(1));
		System.out.println(animalList.getEntry(2));
		animalList.clear();
		System.out.println(animalList.getLength());

	

	}

}
