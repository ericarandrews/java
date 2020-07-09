public class Student implements Comparable<Student> {

	private String firstName, lastName;
	private int studentID;

	public final static int MAX_ID = 99999;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setStudentID(int studentID) {
		if(studentID >= 0 && studentID <= MAX_ID) {
			this.studentID = studentID;
		}
	}
	
	@Override
	public String toString() {
		return lastName + ", " + firstName + " (" + studentID + ")";
	}
		
	@Override
	public boolean equals(Object other) {
		if(other instanceof Student) {
			Student otherStudent = (Student) other;			
			return this.studentID == otherStudent.studentID;		
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Student other) {
		// comparing by studentID: method 1
		/*
		if(this.studentID < other.studentID) { // this student is < other student
			return -1; // any negative number
		} else if(this.studentID > other.studentID) { // this student is > other student
			return 1; // any positive number
		} else { // this.studentID == other.studentID; this student is == other student
			return 0;
		}
		*/
		// comparing by studentID: method 2
		/*
		return Integer.compare(this.studentID, other.studentID); // returns negative if this is smaller, positive if this is greater, 0 otherwise
		*/
		// comparing by student last name only: method 3
		/*
		return this.lastName.compareTo(other.lastName);
		*/
		// comparing by student last name, then first name: method 4
		/*
		if(this.lastName.compareTo(other.lastName)==0) { // last names are the same (equal)
			return this.firstName.compareTo(other.firstName); // then compare by first names
		} else { // last names are different
			return this.lastName.compareTo(other.lastName);
		}
		*/
		/*
		if(this.lastName.compareTo(other.lastName)!=0) {
			return this.lastName.compareTo(other.lastName);
		} else {
			return this.firstName.compareTo(other.firstName);
		}
		*/
		/*
		int lastNameComparison = this.lastName.compareTo(other.lastName);
		if(lastNameComparison==0) {
			return this.firstName.compareTo(other.firstName);
		} else {
			return lastNameComparison; // return the positive or negative number
		}
		*/
		// compare by last name, then first name, then id: method 5
		int lastNameComparison = this.lastName.compareTo(other.lastName);
		if(lastNameComparison==0) {
			int firstNameComparison = this.firstName.compareTo(other.firstName);
			if(firstNameComparison==0) { // last and first names equal, compare by ID
				return Integer.compare(this.studentID, other.studentID);
			} else {
				return firstNameComparison; // last name equal, different first names
			}
		} else {
			return lastNameComparison; // different last names
		}
		
	}
		
	
}
