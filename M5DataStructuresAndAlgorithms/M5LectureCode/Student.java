public class Student {

	private String name;
	private String id;

	public Student(String name, String studentID) {
		this.name = name;
		this.id = studentID;
	}

	public String getName() {
		return name;
	}

	public String getStudentID() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudentID(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name + " (" + id + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Student) {
			Student otherStudent = (Student) other;

			return this.id == otherStudent.id;
		} else {
			return false;
		}

	}


}
