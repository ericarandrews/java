import java.util.Objects;

public class Student {

	private final static int MAX_STUDENTS = 99999;
	
	private int id;
	private String name;
		
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		if(id>0 && id<=MAX_STUDENTS) {
			this.id = id;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return name + " (ID: " + id + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student other = (Student) obj;
			return name.equals(other.name) && id==other.id;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}
	
}
