
public class FullTimeEmployee extends Employee {
	
	// id and name are inherited from Employee
	
	public FullTimeEmployee(int id, String name) {
		super(id, name); 
	}
	public FullTimeEmployee(String name) {
		super(name);
	}

	@Override
	public void pay() {
		super.pay();
		System.out.println("\tPaying based on full-time salary.");
		// bonus();
	}
	
	@Override
	public void timeOff() {
		System.out.println(super.getName() + " has paid vacation and sick days.");
	}
	
	public void bonus() {
		System.out.println(super.getName() + " is being paid a bonus.");
	}
}
