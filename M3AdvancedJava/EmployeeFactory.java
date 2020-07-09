
public class EmployeeFactory {
    
    // overloaded methods- one method allows the user to specify a Payer object, the
    // other does not; the first method invokes the second to reduce duplciated code
    
    public static Employee newEmployee(String type, int id, String name, Payer payer) {
        if(type.equalsIgnoreCase("PART")) {
            Employee e = new PartTimeEmployee(id, name, payer);
            return e;
        } else {
            return newEmployee(type, id, name);
        }
    }
    
    public static Employee newEmployee(String type, int id, String name) {
        Employee e;
        
        if(type.equalsIgnoreCase("FULL")) {
            e = new FullTimeEmployee(id, name);
        } else if(type.equalsIgnoreCase("PART")) {
            throw new IllegalArgumentException("Cannot create part-time employee without a payer");
        } else if(type.equalsIgnoreCase("INTERN")) {
            e = new Intern(id, name);
        } else {
            throw new IllegalArgumentException();
        }
        
        return e;
    }

}
