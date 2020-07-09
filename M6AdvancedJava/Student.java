import java.io.Serializable;

public class Student implements Serializable { 

	private static final long serialVersionUID = 1L;

	private String name;
	private String id;
	private double tuition;
	private PhoneNumber phone;

	public Student(String name, String id, double tuition, PhoneNumber phone) {
		this.name = name;
		this.id = id;
		this.tuition = tuition;
		this.phone = phone;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public double getTuition() {
		return tuition;
	}
	@Override
	public String toString() {
		String s = "Name: " + name + "\n";
		s += "\tID: " + id + "\n";
		s += "\tTuition: " + tuition + "\n";
		s += "\tPhone: " + phone + "\n";
		return s;
	}
	
	
}
