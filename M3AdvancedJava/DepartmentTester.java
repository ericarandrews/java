import java.util.*;

public class DepartmentTester {

    public static void main(String[] args) {
        /*
        Department salesDepartment = new Department();

        for (int i=0; i<2; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the employee id:");
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Enter the employee name:");
            String name = scan.nextLine();
            System.out.println("What type? full or part");
            String type = scan.nextLine();
            
            Payer payer = null;
            if(type.equalsIgnoreCase("PART")) {
                System.out.println("How paid? salary or hourly");
                String payType = scan.nextLine();
                if(payType.equalsIgnoreCase("salary")) {
                    payer = new SalaryPayer();
                }else if(payType.equalsIgnoreCase("hourly")) {
                    payer = new HourlyPayer();
                } else {
                throw new IllegalArgumentException();
                }
            }
            salesDepartment.addEmployee(type, id, name, payer);
           
        }
        
        salesDepartment.runPayroll();
        */
        
        ArrayList<Employee> empList = new ArrayList<>();
        for(int i=0; i<3; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the employee id:");
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Enter the employee name:");
            String name = scan.nextLine();
            System.out.println("What type? full or part");
            String type = scan.nextLine();
            
            Payer payer = null;
            if(type.equalsIgnoreCase("PART")) {
                System.out.println("How paid? salary or hourly");
                String payType = scan.nextLine();
                if(payType.equalsIgnoreCase("salary")) {
                    payer = new SalaryPayer();
                }else if(payType.equalsIgnoreCase("hourly")) {
                    payer = new HourlyPayer();
                } else {
                throw new IllegalArgumentException();
                }
            }
            Employee e = EmployeeFactory.newEmployee(type, id, name, payer); 
            empList.add(e);
        }
        for(Employee emp : empList) {
            emp.pay();
        }
        
        System.out.println(empList);
        Collections.sort(empList, Employee.NAME_ID_COMPARATOR);
        System.out.println(empList);


    }
    


}
