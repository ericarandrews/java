
public class StudentTester {

	public static void main(String[] args) {
		
		
		Student s1 = new Student("Sally", "Studier", 1234);
		Student s2 = new Student("Pete", "Procrastinator", 5264);
		Student s3 = new Student("Alan", "Asksalot", 3671);
			
		Student s4 = new Student("Sally", "Studier", 1234);
	
		s3.setLastName("Asksaton");
		s3.setStudentID(999999);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("Are they equal? " + s1.equals(s4));
		System.out.println("Are they aliases? " + (s1==s4));
	}

}
