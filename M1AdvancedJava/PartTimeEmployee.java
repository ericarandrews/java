
public class PartTimeEmployee extends Employee {
	
	private int numHours;
	
	public static final int DEFAULT_NUM_HOURS = 20;
	public static final int MAX_NUM_HOURS = 39;
	
	public PartTimeEmployee(int id, String name, int numHours) {
		super(id, name);
		this.numHours = numHours;
	}
	
	public PartTimeEmployee(int id, String name) {
		this(id, name, DEFAULT_NUM_HOURS);
	}
	
	public PartTimeEmployee(String name, int numHours) {
		super(name);
		this.numHours = numHours;
	}

	public PartTimeEmployee(String name) {
		this(name, DEFAULT_NUM_HOURS);
	}

	public int getNumHours() {
		return numHours;
	}

	public void setNumHours(int numHours) {
		if(numHours > 0 && numHours <= MAX_NUM_HOURS) {
			this.numHours = numHours;
		}
	}
	
	
	@Override
	public String toString() {
		String s = super.toString();
		s += " (" + numHours + " hours per week)";
		return s;
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PartTimeEmployee) {
			PartTimeEmployee otherEmp = (PartTimeEmployee) obj;
			return super.equals(obj) && numHours == otherEmp.numHours;
		} else {
			return false;
		}
	}
	
	@Override
	public void pay() {
		super.pay();
		System.out.println("\tPaid for " + numHours + " hours");
	}
	
	@Override
	public void benefits() {
		System.out.println(super.getName() + " receives no benefits.");
	}
	
	@Override
	public void timeOff() {
		System.out.println(super.getName() + " earns hourly paid time off (PTO).");
	}
	
}
