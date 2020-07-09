import java.util.*;

public class ListAsParameterExample {


	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<>();

		// assume we want to write a method that creates a local
		// copy of a list and then modifies that list to use it internally somehow; 
		// but we don't want to change the original list that is passed in 
		/*			
		numberList.add(1);
		numberList.add(1);
		numberList.add(1);
		System.out.println("******INCORRECT METHOD- WE DON'T CREATE A COPY AT ALL");
		System.out.println("**In main, before method");
		System.out.println(numberList);
		incorrectNonCopyMethod(numberList);
		System.out.println("**In main, after method");
		System.out.println(numberList);		
*/
		numberList.clear();
		numberList.add(1);
		numberList.add(1);
		numberList.add(1);
		System.out.println("\n\n******CORRECT METHOD");
		System.out.println("**In main, before method");
		System.out.println(numberList);
		correctCopyMethod(numberList);
		System.out.println("**In main, after method");
		System.out.println(numberList);
	
/*			
		numberList.clear();
		numberList.add(1);
		numberList.add(1);
		numberList.add(1);
	
		System.out.println("\n\n******INCORRECT COPY METHOD A- DIRECT ASSIGNMENT TO CREATE THE COPY");
		System.out.println("**In main, before method");
		System.out.println(numberList);
		incorrectCopyMethodA(numberList);
		System.out.println("**In main, after method");
		System.out.println(numberList);

		
		numberList.clear();
		numberList.add(1);
		numberList.add(1);
		numberList.add(1);
		
		System.out.println("\n\n******INCORRECT COPY METHOD B- DIRECT ASSIGNMENT TO RESTORE THE ORIGINAL");
		System.out.println("***In main, before method");
		System.out.println(numberList);
		incorrectCopyMethodB(numberList);
		System.out.println("***In main, after method");
		System.out.println(numberList);
*/
	}
	
	// when invoked, we have formal = actual
	// for us: list = numberList
	public static void incorrectNonCopyMethod(List<Integer> list) {		
		for(int i=0; i<list.size(); i++) {
			list.set(i, 99);
		}
		// THIS IS THE ERROR!!! 
		// list is an alias with the actual parameter, so making changes here
		// also changes the list outside the method because it's the same object
		
		// in real world, here you would do something meaningful with the modified list
		
		System.out.println("***End of method");
		System.out.println("\tList: \t\t" + list);
	}
	
	public static void correctCopyMethod(List<Integer> list) {
		List<Integer> copyList = new ArrayList<Integer>();
		// correct code! the only way to create a new object (such as a copy)
		// is with the new operator (or some other method such as a factory method, clone method, etc.)
		
		for(int number : list) {
			copyList.add(number);
		}
		
		for(int i=0; i<list.size(); i++) {
			copyList.set(i, 99);
		}
		
		// in real world, do something meaningful with the copyList
		
		System.out.println("***End of method");
		System.out.println("\tList: \t\t" + list);
		System.out.println("\tCopy List: \t" + copyList);
	}
	
	public static void incorrectCopyMethodA(List<Integer> list) {
		List<Integer> copyList = list; // this is not a copy! it's just an alias
		// THIS IS THE ERROR!!! 
		// here, we use direct assignment to seemingly create a copy;
		// but a copy is not created- only an alias!
		// so changes to the copyList will be changes to the list also- it's the same object!
		
		for(int i=0; i<list.size(); i++) {
			copyList.set(i, 99);
		}
		
		System.out.println("***End of method");
		System.out.println("\tList: \t\t" + list);
		System.out.println("\tCopy List: \t" + copyList);
	}

	public static void incorrectCopyMethodB(List<Integer> list) {
		List<Integer> savedList = new ArrayList<Integer>();
		
		for(int number : list) {
			savedList.add(number);
		}
		// this is correct up to here- we've created a separate saved list to keep the contents
		
		for(int i=0; i<list.size(); i++) {
			list.set(i, 99);
		}
		
		// do something meaningful with the modified list before restoring
		
		list = savedList;
		// THIS IS THE ERROR!
		// the link between the formal parameter and the actual parameter is broken;
		// inside the method, the list is now restored, but outside the method it is not
		
		System.out.println("***End of method");
		System.out.println("\tList: \t\t" + list);
		System.out.println("\tSaved List: \t" + savedList);
	}
	
}
