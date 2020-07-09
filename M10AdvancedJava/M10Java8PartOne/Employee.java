
public class Employee extends Person {
	
	private String id;

	public Employee(String name, String id) {
		super(name);
		this.id = id;
	}
	
	@Override
	public void pay() {
		System.out.println("Paying " + getName());
	}
	
	@Override
	public void benefits() {
		System.out.println("Processing benefits for " + getName());
	}
	
	/*
	@Override
	public void review() {
	    System.out.println("Reviewing employee " + getName());
	}
    */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (ID: " + id + ")";
	}

}
