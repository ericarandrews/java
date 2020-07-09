
public class PartTimeEmployee extends Employee {
		
	public PartTimeEmployee(int id, String name, Payer payer) {
		super(id, name, payer);
	}
	

	
	
	@Override
	public void process() {
		System.out.println(super.getId() + " has been part-time processed.");
	}
	
	
	@Override
	public void benefits() {
		System.out.println(super.getId() + " receives no benefits.");
	}
	
	@Override
	public void timeOff() {
		System.out.println(super.getId() + " earns hourly paid time off (PTO).");
	}
	
}
