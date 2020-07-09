package collectionpractice;


public final class EmployeeIM {
    
    private final String name;
    private final int id;
    private final Address address; // MUTABLE!!
    
    public EmployeeIM(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        Address copyAdress = new Address(address.getStreet(), address.getState());
        this.address = copyAdress;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        Address addressCopy = new Address(address.getStreet(), address.getState());
        return addressCopy;
    }


    public String toString() {
        return name + " (" + id + ")" + "\t" + address.toString();
    }
    

}
