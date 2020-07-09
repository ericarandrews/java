
public class EmployeeTester {

	public static void main(String[] args) {
		/*
		Employee employee01 = new Employee(123, "Wally Worker");
		Employee employee02 = new Employee("Tanya Temp");	
		
		System.out.println("id is " + employee01.getId());
		employee01.setId(-44);
		System.out.println("id is " + employee01.getId());
		employee01.setId(0);
		System.out.println("id is " + employee01.getId());
		employee01.setId(456);
		System.out.println("id is " + employee01.getId());
		
		
		System.out.println(employee01);
		System.out.println(employee02.toString());
		
		Employee dupEmp = new Employee(456, "wally worker");

		System.out.println(employee01==dupEmp);
		System.out.println(employee01.equals(dupEmp));
		
		employee02.pay();
		employee01.benefits();
		*/
		
		FullTimeEmployee full01 = new FullTimeEmployee(789, "Betty Boss");
		PartTimeEmployee part01 = new PartTimeEmployee(413, "Paul Partimer", 15);
		
		System.out.println(full01.getName());
		part01.review();
		
		System.out.println(full01);
		System.out.println(part01.toString());

		
	}

}
