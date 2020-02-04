public class terrestrial extends ecosystems {
	private String name;
	private String type;
	//constructor
	public terrestrial(String name, String type) {
		super(name, type);
	}
	//getters
	public String getName(){
		return super.getName();
	}
	public String getType(){
		return super.getType();
	}
	//setters
	public void setName(String name){
		super.setName(name);
	}
	public void setType(String type){
		super.setType(type);
	}
	//Overridden toString Method
	@Override
	public String toString(){
		return super.toString();
	}
	//Overridden Equals Method
	@Override
	public boolean equals(Object x){
		return super.equals(x);
	}
	//prints main type of Ecosystem associated with Ecosystem entered 
	public void printType(String name){
		super.printType(name);
	}
	//prints names of Ecosystems of main types
	public void printNamesOfType(String type){
		super.printNamesOfType(type);
	}
	//prints information on main type Ecosystems
	public void infoOnType(String type){
		super.infoOnType(type);
	}
	//prints information on ecosystem entered 
	public void terrestrial(String name){
		System.out.println("This method will return information on Ecosystems of Main Type, Terrestrial.");
	}
}
