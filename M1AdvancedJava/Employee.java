
public abstract class Employee  {
	
	private int id;
	private String name;
	
	public static final int DEFAULT_ID = 0;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee(String name) {
		this(DEFAULT_ID, name);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		if(id >= 0) {
			this.id = id;
		}
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " (ID: " + id + ")";
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee otherEmployee = (Employee) obj;
			
			int otherEmployeeId = otherEmployee.id;
			String otherEmployeeName = otherEmployee.name;
			
			if(id==otherEmployeeId && name.equalsIgnoreCase(otherEmployeeName)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}
	
	public void pay() {
		System.out.println("Paying " + name);
	}
	public void review() {
		System.out.println(name + " is undergoing annual review.");
	}
	public void benefits() {
		System.out.println("Issuing benefits to " + name);
	}
	public abstract void timeOff();
	
	
	
}
