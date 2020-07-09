public class Student implements Comparable<Student> { 
	
	private String name;
	private String id;

	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		String s = "Name: " + name + " (" + id + ")";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student other = (Student) obj;
			return name.equals(other.name) && id.equals(other.id);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Student otherStudent) {
		return id.compareTo(otherStudent.id);
		//return name.compareTo(otherStudent.name);

	}
	
}
