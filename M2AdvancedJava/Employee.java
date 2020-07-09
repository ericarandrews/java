
public abstract class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	
	private static int numEmployees = 0;
	
	public static final int DEFAULT_ID = 0;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		
		Employee.numEmployees++;
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
	
	public static int getNumberOfEmployees() {
		return Employee.numEmployees;
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
	
	@Override
	public int compareTo(Employee emp) {
		// approach 1 for comparing ids:
		/*
		if(id < emp.id) {
			return -10; // any negative number (meaningful perhaps, or not)
		} else if(id > emp.id) {
			return 10; // any positive number (meaningful perhaps, or not)
		} else {
			return 0;
		}
		*/
		// approach 2 for comparing ids:
		// return Integer.compare(id, emp.id);
		
		// approach for comparing based on two characteristics- name and id
		// outer conditional is the "main sorting" characteristic and the inner is then used to sort duplicate values from that first characteristic
		if(name.compareToIgnoreCase(emp.name)!=0) { // the two employees have different names (ignoring capitalization)
			return name.compareToIgnoreCase(emp.name); // order/compare based on those different names
		} else { // the two employees have the same name
			return Integer.compare(id,  emp.id); // order employees with the same name by their id
		}
		
	}
	
	public void pay() {
		System.out.println("Paying " + name);
	}
	public void review() {
		System.out.println(name + " is undergoing annual review.");
	}
	public abstract void benefits();
	public abstract void timeOff();
	
	
	
}
