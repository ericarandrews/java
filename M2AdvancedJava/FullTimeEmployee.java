
public class FullTimeEmployee extends Employee {
	
	//public enum Status { ACTIVE, INACTIVE_TEMP, INACTIVE_PERM };
	
	// id and name are inherited from Employee
	private Status status;
		
	public FullTimeEmployee(int id, String name, Status status) {
		super(id, name); 
		this.status = status;
	}
	public FullTimeEmployee(String name) {
		super(name);
		this.status = status;
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
	
	@Override
	public void benefits() {
		if(status==Status.ACTIVE) {
			System.out.println("Issuing benefits to " + super.getName());
		} else {
			System.out.println(super.getName() + ": Status " + status.getStatusCode() + " does not receive benefits");
		}
	}
	
	public void bonus() {
		System.out.println(super.getName() + " is being paid a bonus.");
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += " (Status: " + status.toString() + ")";
		return s;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
