package collectionpractice;


public class Employee {
	
	private String name;
	private int id;
	private Address address;
	
	public Employee(String name, int id, Address address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
		return name + " (" + id + ")" + "\n\t" + address.toString();
	}
	

}
