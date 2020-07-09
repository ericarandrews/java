
public class Intern extends Employee {
	
	public Intern(int id, String name) {
		super(id, name, new NoPayer());
	}

	@Override
	public void benefits() {
		System.out.println("Interns receive only the benefit of experience.");
		
	}

	
	@Override
	public void timeOff() {
		System.out.println("Interns do not receive time off.");		
	}

	@Override
	public void process() {
		System.out.println("Processing Intern " + super.getId());
		
	}
	
	

}
