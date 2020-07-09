import java.util.*;

public class GradStudentTester {

	public static void main(String[] args) {
		
		/*
		GradStudent g1 = new GradStudent("Greta", "Grad", 4671, "The Fun of Java");
		GradStudent g2 = new GradStudent("Ursula", "Undeclared", 1567);
		
		System.out.println(g1);
		System.out.println(g1.getStudentID());
		System.out.println(g1.isThesisTopicDeclared());
		
		System.out.println(g2);
		System.out.println(g2.isThesisTopicDeclared());
		*/


		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Sally", "Studier", 1234));
		studentList.add(new GradStudent("Greta", "Grad", 4671, "The Fun of Java"));
		studentList.add(new Student("Pete", "Procrastinator", 5264));
		studentList.add(new GradStudent("Ursula", "Undeclared", 1567));
		studentList.add(new Student("Alan", "Asksalot", 3671));
		
		for(Student student : studentList) {
			System.out.println(student.toString());
			
			if(student instanceof GradStudent) {
				// GradStudent g = (GradStudent) student;
				boolean declared = ((GradStudent) student).isThesisTopicDeclared();
				if(!declared) {
					System.out.println("\tWarning! Topic not declared!");
				}
			}
		}
		
		
		
	}

}
