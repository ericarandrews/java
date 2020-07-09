
public class Customer {
	
	private String firstName, lastName, id;
	private String state;
	private boolean priority; 
	private double amountSpent;

	public Customer(String firstName, String lastName, String id, 
			String state, boolean priority, double amountSpent) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.state = state;
		this.priority = priority;
		this.amountSpent = amountSpent;
	}
	public int getInt() { return 0;}
	public double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "" + lastName + ", " + firstName + " (ID: " + id + ")" +
				(priority ? " (Priority Customer)" : "");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer) {
			Customer other = (Customer) obj;
			return firstName.equals(other.firstName) &&
					id.equals(other.id) &&
					lastName.equals(other.lastName) &&
					state.equals(other.state) &&
					priority==other.priority &&
					Math.abs(amountSpent-other.amountSpent)<0.0001;
		} else {
			return false;
		}					
	}
	
	

}
