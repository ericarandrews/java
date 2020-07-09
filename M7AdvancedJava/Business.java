import java.util.Comparator;
import java.util.Objects;

public class Business implements Comparable<Business>{
	
	private String id, ownerName, name, street, city, state, zip;
	
	public static final Comparator OWNER_NAME_COMPARATOR = new OwnerNameComparator();
	public static final Comparator OWNER_NAME_ID_COMPARATOR = new OwnerNameIDComparator();
	
	private static class OwnerNameComparator implements Comparator<Business> {
        public int compare(Business a, Business b) {
            return a.getOwnerName().compareTo(b.getOwnerName());
        }
	}
	private static class OwnerNameIDComparator implements Comparator<Business> {
	    public int compare(Business b1, Business b2) {
	        if(b1.getOwnerName().equals(b2.getOwnerName())) {
	            return b1.getId().compareTo(b2.getId());
	        } else {
	            return b1.getOwnerName().compareTo(b2.getOwnerName());
	        }
	    }
	}

	public Business(String id, String ownerName, String name, String street, String city, String state, String zip) {
		this.id = id;
		this.ownerName = ownerName;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return name + " (ID: " + id + ")" + 
				"\n\tOwner: " + ownerName +
				"\n\tAddress: " + street + "; " + city + ", " + state + " " + zip;
	}

	public void process() {
	    // code here to process a business
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, ownerName, street, city, state, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Business) {
			Business other = (Business) obj;
			return id.equals(other.id) &&
					name.equals(other.name) &&
					ownerName.equals(other.ownerName) &&
					street.equals(other.street) &&
					city.equals(other.city) &&
					state.equals(other.state) &&
					zip.equals(other.zip);
		} else {
			return false;
		}
	}

	// natural ordering is by ID
	@Override
	public int compareTo(Business otherBus) {
	    return id.compareTo(otherBus.id);
	}
	

}
