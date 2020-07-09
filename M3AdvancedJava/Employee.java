import java.util.Comparator;

public abstract class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	private Payer payer;
	
	private static int numEmployees = 0;
	
	public final static Comparator<Employee> NAME_COMPARATOR = new EmployeeNameComparator();
	public final static Comparator<Employee> NAME_ID_COMPARATOR = new EmployeeNameIDComparator();
	
	private static class EmployeeNameComparator implements Comparator<Employee> {
		
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.name.compareTo(e2.name);
			
		}
	}
	
	private static class EmployeeNameIDComparator implements Comparator<Employee> {
		
		@Override
		public int compare(Employee e1, Employee e2) {
			if(e1.name.compareToIgnoreCase(e2.name)==0) { // same name
				return Integer.compare(e1.id, e2.id);
			} else { // different names
				return e1.name.compareToIgnoreCase(e2.name);
			}
		}
	}

	
	public Employee(int id, String name, Payer payer) {
		this.id = id;		
		this.name = name;
		this.payer = payer;
		Employee.numEmployees++;
	}


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id >= 0) {
			this.id = id;
		}
	}
	
	public static int getNumberOfEmployees() {
		return Employee.numEmployees;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee otherEmployee = (Employee) obj;
			
			int otherEmployeeId = otherEmployee.id;
			
			return id==otherEmployeeId;
			
		} else {
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Employee emp) {
			return Integer.compare(id,  emp.id); 
	}
	
	public void pay() {
		System.out.println("Running payroll for " + id);
		payer.pay();
	}
	

	public void review() {
		System.out.println(id + " is undergoing annual review.");
	}
	public abstract void benefits();
	public abstract void timeOff();
	public abstract void process();
	
	
	
}
