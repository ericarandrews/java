import java.util.ArrayList;
import java.util.Collections;

public class Department {

	private ArrayList<Employee> empList;
	
	public Department() {
		empList = new ArrayList<>();
	}
	
	public void addEmployee(Employee e) {
		empList.add(e);
	}
	
	public ArrayList<Employee> getEmployeeList() {
		Collections.sort(empList);
		return empList;
	}
}
