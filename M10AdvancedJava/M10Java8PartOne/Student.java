import java.time.LocalDate;
import java.util.Comparator;

public class Student implements Comparable<Student>{

	private String firstName, lastName, id;
	private LocalDate registrationDate;
	
	public static final Comparator<Student> NAME_COMPARATOR = new NameComparator();
	
	public Student(String firstName, String lastName, String id, LocalDate registrationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.registrationDate = registrationDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "\nStudent [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", registrationDate="
				+ registrationDate + "]";
	}

	
	@Override
	public int compareTo(Student otherStudent) {
		return id.compareTo(otherStudent.id);
	}
	
	public static class NameComparator implements Comparator<Student> {
	    
	    public int compare(Student s1, Student s2) {
	        if(s1.getLastName().equals(s2.getLastName())) {
	            return s1.getFirstName().compareTo(s2.getFirstName());
	        } else {
	            return s1.getLastName().compareTo(s2.getLastName());
	        }
	    }
	}
	
	public static class RegistrationDateComparator implements Comparator<Student> {
	    public int compare(Student s1, Student s2) {
	        return s1.getRegistrationDate().compareTo(s2.getRegistrationDate());
	    }
	}
	
	


}
