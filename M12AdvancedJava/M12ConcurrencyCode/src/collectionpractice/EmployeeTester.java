package collectionpractice;

public class EmployeeTester {

	public static void main(String[] args) {
		Address a1 = new Address("1000 Phelan Ave", "CA");	
		EmployeeIM emp1 = new EmployeeIM("Jane Doe", 123, a1);

		System.out.println("original employee: \t" + emp1);
			
		
        // change the employee object by changing an instance data variable that is a primitive?
		int id = emp1.getId();
		id = 99;
        System.out.println("modified? employee: \t" + emp1);
        
        
      
        // change the employee object by changing an instance data variable that is also immutable?
		String name = emp1.getName();
		name.toUpperCase();
		name = "hahaha";
		name = name.toUpperCase();
        System.out.println("modified? employee: \t" + emp1);		
		
       
        // change the employee object by changing an instance data variable that is an object?
        Address add = emp1.getAddress();
        add.setState("HAHAHA");
        System.out.println("modified address: \t" + add);
        System.out.println("modified? employee: \t" + emp1);

      
        // change the employee object by changing objects used to create the object
		a1.setState("WUHHOO");
        System.out.println("modified address: \t" + a1);
        System.out.println("modified? employee: \t" + emp1);
		
     
        // create a new employee
		emp1 = new EmployeeIM(emp1.getName(), 456, emp1.getAddress());
        System.out.println("new employee: \t\t" + emp1);
		
	}

}
