import java.util.*;

public class StudentTester {

	public static void main(String[] args) {
		
		Student[] studentArray = new Student[7];
		
		studentArray[0] = new Student("Sally", "Studier", 1234);
		studentArray[1] = new Student("Pete", "Procrastinator", 5264);
		studentArray[2] = new Student("Alan", "Asksalot", 3671);
		studentArray[3] = new Student("Gretta", "Graduate", 1672);
		studentArray[5] = new Student("Greg", "Graduate", 9673);
		studentArray[4] = new Student("Uma", "Uncertain", 8941);
		studentArray[6] = new Student("Uma", "Uncertain", 3217);
		
		printArray(studentArray);
		Arrays.sort(studentArray);
		System.out.println();
		printArray(studentArray);
		
		
		List<Student> studentList = Arrays.asList(studentArray);
		Collections.sort(studentList);
		System.out.println();
		printArray(studentList.toArray());
		

	}
	
	private static void printArray(Object[] array) {
		for(Object obj : array) {
			System.out.println(obj);
		}
	}

}
