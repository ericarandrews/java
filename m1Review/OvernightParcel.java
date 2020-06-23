package m1Review;

public class OvernightParcel extends Parcel {
	private String id = super.getId();
	private Double weight = super.getWeight();
	private String name = super.getName();
	private String street = super.getStreet();
	private String city = super.getCity();
	private String state = super.getState();
	private String zip = super.getZip();
	private String signature;

	public OvernightParcel(String id, Double weight, String name, String street, String city, String state, String zip, String signature){
		super(id, weight, name, street, city, state, zip);
		this.signature = signature;
	}
}
