package m1Review;

public class Parcel {
	
	private String id;
	private Double weight;
	private String name, street, city, state, zip;
	
	public Parcel(String id, Double weight, String name, String street, String city, String state, String zip){
		this.id = id;
		this.weight = weight;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Parcel(String id, String name, String street, String city, String state, String zip){
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		weight = (double) 1;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
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
		return "ID: "+ id + "\nWeight: " + weight + "\nName: " + name + "\nStreet: " + street + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip;
	}
	
	@Override
	public boolean equals(Object x) {
		if(x instanceof Parcel) {
			Parcel y = (Parcel) x;
			String a = y.id.toLowerCase();
			String b = this.id.toLowerCase();	
			return a.equals(b);
		}	
		return false;
	}
	
	public boolean meetsCriteria(String id, char first, char second, int numberTimesSecondAfterFirst) {
		int countx = 0;
		int county = 0;
		for(int i = 0; i < id.length(); i++){
			char x = id.charAt(i);
			if(x==first){
				int [] arr = new int [id.length()];
				arr[countx] = i;
				countx++;
				int firstPosition = arr[0];
				for(int j = firstPosition+1; j<id.length();j++){
					char y = id.charAt(j);
					if(y==second){
					county++;
					};	
				}
			}
			if(numberTimesSecondAfterFirst == county){return true;};
		}
		return false;
	}

	public boolean isValidEmail(String email) {	
		char a = email.charAt(0);
		String lastThreeCharacters = email.substring(email.length() - 4);
		char periodBeforeLastThreeCharacters=lastThreeCharacters.charAt(0);
		if(email.contains("@") && a!='@' && email.contains(".") && periodBeforeLastThreeCharacters == '.'){return true;}
		return false;
	}
	
}
