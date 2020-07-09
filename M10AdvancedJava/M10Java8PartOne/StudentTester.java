import java.time.*;
import java.util.*;

public class StudentTester {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Annie", "Adams", "Z123", 	LocalDate.of(2018, 1, 15)));
		students.add(new Student("Bertie", "Barkal", "M491", LocalDate.of(2018, 2, 15)));
		students.add(new Student("Linda", "Smith", "B901",  LocalDate.of(2018, 4, 15)));
		students.add(new Student("Tommy", "Smith", "K416", 	LocalDate.of(2018, 3, 15)));
		
		System.out.println(students);
		
		// use the natural ordering- meaning the compareTo method (sorts by ID)
		Collections.sort(students);
		
		System.out.println(students);
		
		Collections.sort(students, Student.NAME_COMPARATOR);
	    System.out.println(students);
	    
	    Collections.sort(students, new Student.RegistrationDateComparator());
        System.out.println(students);
        
        // let's pretend that RegistrationDateComparator doesn't exist
        // we'll use an anonymous class to create that comparator
        Collections.sort(students, new Comparator<Student>() {
     
            // body of our anonymous class
            // for a functional interface (one abstract method)- this will just be one method
            public int compare(Student s1, Student s2) {
                return s1.getRegistrationDate().compareTo(s2.getRegistrationDate());
            }
            
                
        } // close bracket of the anonymous class    
        ); // close parens of the .sort() method and the semicolon for the statement
        System.out.println(students);
        
        // let's use a lambda where an object of a functional interface is required
        Collections.sort(students, 
            (s1, s2) -> s1.getRegistrationDate().compareTo(s2.getRegistrationDate())     
         );
        // (Student s1, Student s2) is the parameter list
        // the type is optional- because it can be inferred- Java knows that a Comparator<Student>
        //     type is required, so it knows that the two parameters must be Student
        // so we can list "Student s1, Student s2" or just "s1, s2"
        // the body has one statement- it returns a value- we omit the "return" keyword
        System.out.println(students);
        
        
        // use a lambda to create the name comparator
        Collections.sort(students,
                
                (Student s1, Student s2) -> { // bracket for the lambda body
                    if(s1.getLastName().equals(s2.getLastName())) {
                        return s1.getFirstName().compareTo(s2.getFirstName());
                    } else {
                        return s1.getLastName().compareTo(s2.getLastName());
                    }
                    
                } // closing lambda bracket
                ); // closing method parens
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}
	

}
