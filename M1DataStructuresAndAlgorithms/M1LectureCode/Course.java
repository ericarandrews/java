import java.util.*;

public class Course {
	
	private String name;
	private int maxEnrollment;
	private List<Student> studentList;
	
	public Course(String name, int maxEnrollment) {
		this.name = name;
		this.maxEnrollment = maxEnrollment;
		this.studentList = new ArrayList<Student>();
	}
	
	public boolean enrollStudent(Student student) {
		if(studentList.size() < maxEnrollment) {
			studentList.add(student);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isStudentEnrolled(Student student) {
		return studentList.contains(student);
	}

	public boolean dropStudent(Student student) {
		return studentList.remove(student);
	}
	
	public void printRoster() {
		/*
		for(int i=0; i<studentList.size(); i++) { // traditional for loop
			Student s = studentList.get(i);
			System.out.println(s);
		}
		*/
		for(Student student : studentList) {
			System.out.println(student); // can also explicitly call student.toString()
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberEnrolled() {
		return studentList.size();
	}
	public int getMaxEnrollment() {
		return maxEnrollment;
	}
	public void setMaxEnrollment(int maxEnrollment) {
		if(maxEnrollment > 0) {
			this.maxEnrollment = maxEnrollment;			
		}
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	
	@Override
	public String toString() {
		return name + "\t" + studentList.size() + " students enrolled\t(" + maxEnrollment + " students allowed)";
	}

	
}
