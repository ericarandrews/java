import java.util.*;

public class Department {

    private List<Employee> employeeList;
    
    public Department() {
        employeeList = new ArrayList<>();
    }
    
    public void addEmployee(Employee e) {
        employeeList.add(e);
        e.process();
    }
    
    public void addEmployee(String type, int id, String name, Payer payer) {
       Employee e = EmployeeFactory.newEmployee(type, id, name, payer);        
       addEmployee(e);
    }

    public void runPayroll() {
        for(Employee emp : employeeList) {
            emp.pay();
        }
    }
    
}
