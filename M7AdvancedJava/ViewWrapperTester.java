import java.io.*;
import java.time.*;
import java.util.*;

public class ViewWrapperTester {

	public static void main(String[] args) {
	    
	    // UNMODIFIABLE LISTS
	    List<Employee> empList = new ArrayList<>();
	    empList.add(new Employee("1"));
	    empList.add(new Employee("2"));
	    empList.add(new Employee("3"));
	    System.out.println(empList);
	    List<Employee> unmodifiableEmpList = Collections.unmodifiableList(empList);
	    System.out.println(unmodifiableEmpList);
	    //unmodifiableEmpList.remove(0); // ERROR
	    //unmodifiableEmpList.add(new Employee("4")); // ERROR
	    //unmodifiableEmpList.set(1,  new Employee("4")); // ERROR
	    unmodifiableEmpList.get(0).setId("4"); // BE CAREFUL!
	    System.out.println(unmodifiableEmpList);
	    
	    
        // IMMUTABLE  
        List<Integer> empty = Collections.emptyList();
        System.out.println(empty);
        //empty.add(4); // ERROR
        
        List<Integer> singleton = Collections.singletonList(4);
        System.out.println(singleton);
        //singleton.add(3); // ERROR
        //singleton.set(0, 44); // ERROR
        

	  
		// ARRAY VIEWS 	
		Integer[] numbers = {1, 2, 3, 4, 5};
		List<Integer> numList = Arrays.asList(numbers);
		System.out.println(numList);
	    System.out.println(Arrays.toString(numbers));
		//numList.add(4); // ERROR
		//numList.remove(5); // ERROR
		numList.set(0,  99);
		numbers[2] = 43;
		System.out.println(numList);
		System.out.println(Arrays.toString(numbers));
		
		 
		List<String> words = Arrays.asList("hi", "hello", "bye");
		//words.add("hola"); // ERROR
		words.set(1, "bonjour");
		System.out.println(words);
		
		
		// SUBRANGES AND BULK 
		List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		// IMPORTANT- CREATES A NEW ARRAYLIST! otherwise, this would only be a view and we couldn't modify it!
		System.out.println("Original List \t" + list);
		List subList = list.subList(5, 8);
		System.out.println("SubList \t" + subList);
		subList.remove(0); 
		System.out.println("Original List after remove all \t\t" + list);
	    System.out.println("Sub List after remove remove all \t" + subList);
	   
	   
	    List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		list2.removeAll(Arrays.asList(2,4,6));
	    System.out.println("List after remove all \t" + list2);
	    
		list2.retainAll(Arrays.asList(3,4,5)); 
        System.out.println("List after retain all \t" + list2);
      
		// OBTAINING ARRAYS 
		Object[] objects = list.toArray();
		//Integer[] objects2 = (Integer[]) list.toArray(); // ERROR
		Integer[] numberArray = list.toArray(new Integer[0]);
		System.out.println(Arrays.toString(numberArray));
		
	}
	

}
