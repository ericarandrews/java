import java.util.ArrayList;

public class EmployeePolymorphismTester {

	public static void main(String[] args) {
		
		// declared type: Employee, actual type: FullTimeEmployee
		// at compile time, I'm allowed to invoke any methods from Employee
		Employee e1 = new FullTimeEmployee(123, "Frannie FullTimer");
		
		e1.pay(); // allowed because pay is in the Employee class (declared type)
		// at runtime, the *version* will be used in FullTimeEmployee class (actual type)
		
		Employee e2 = new PartTimeEmployee(456, "Peter PartTimer");
		e2.pay();
		
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(new PartTimeEmployee("Paula Part"));
		employeeList.add(new FullTimeEmployee("Frank Full"));
		
		for(Employee emp : employeeList) {
		// equivalent to: 
		//	for(int i=0; i<employeeList.size(); i++) {
		//		Employee emp = employeeList.get(i);
			
			emp.pay(); 
			
			emp.timeOff(); // allowed because the method exists in Employee- even though it's abstract!
			// at run time, the appropriate child class version will be executed
			
			if(emp instanceof FullTimeEmployee) { // pay bonus only to full time employees
				( (FullTimeEmployee) emp).bonus();		

				// another way:
				// FullTimeEmployee ftEmp = (FullTimeEmployee) emp;
				// ftEmp.bonus();
			}

		}
		
		/*
		Employee[] empolyeeArray = new Employee[100];
		empolyeeArray[0] = new FullTimeEmployee("Frank Full");
		empolyeeArray[1] = new PartTimeEmployee("Paula Part");
		*/

	}

}
