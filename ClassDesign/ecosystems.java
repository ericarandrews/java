public class ecosystems {
private String name;
private String type;
private String freshwater = "Freshwater";
private String terrestrial = "Terrestrial";
private String ocean = "Ocean";
//constructor
public ecosystems(String name, String type){
	this.name = name;
	this.type = type;
}
//getters
public String getName(){
	return name;
}
public String getType(){
	return type;
}
//setters
public void setName(String name){
	this.name = name;
}
public void setType(String type){
	this .type = type;
}
//Overridden toString Method
@Override
public String toString(){
	return name + ": an Ecosystem of Main Type - Fresh Water, Terrestrial or Ocean.";
}
//Overridden Equals Method
@Override
public boolean equals(Object x){
	if(x instanceof ecosystems){
		ecosystems y = (ecosystems) x;
		return this.type == y.type;
	}else{
		return false;
	}
}
//prints main type of Ecosystem associated with Ecosystem entered 
public void printType(String name){
	if(name == "Pond"||name == "River"){System.out.println("This Ecosystem, "+name+", is of Main Type, Freshwater.");}
	if(name == "Rainforests"||name == "Tundras"||name == "Deserts"||name == "Savannas"||name == "Forests"||name == "Grasslands")
	{System.out.println("This Ecosystem, "+name+", is of Main Type, Terrestrial.");}
	if(name == "Shallow Water"||name == "Deep Water"||name == "Warm Water"||name == "Cold Water"){System.out.println("This Ecosystem, "+name+", is of Main Type, Ocean.");}
	//https://www.conserve-energy-future.com/what-is-an-ecosystem.php
}
//prints names of Ecosystems of main types
public void printNamesOfType(String type){
	if(type == freshwater){System.out.println("Type, "+type+ ", is a Main Type with Ecosystems, Pond and River, of this Main Type.");}
	if(type == terrestrial){System.out.println("Type, "+type+ ", is a Main Type with Ecosystems, Rainforests, Tundras, Deserts, Savannas, Forests, and Grasslands, of this Main Type.");}
	if(type == ocean){System.out.println("Type, "+type+ ", is a Main Type with Ecosystems, Shallow Waters, Deep water, Warm water, and Cold water, of this Main Type.");}
	//https://www.conserve-energy-future.com/what-is-an-ecosystem.php
}
//prints information on main type Ecosystems
public void infoOnType(String type){
	if(type == freshwater){System.out.println("Freshwater ecosystems are those that are contained to Freshwater environments.\n"
			+ "This includes, but is not limited to, Ponds, Rivers and other waterways that are not the sea\n"
			+ "(which is, of course, Saltwater and cannot support Freshwater creatures for very long).");}
	if(type == terrestrial){System.out.println("Because Terrestrial Ecosystems are so diverse, it is difficult to make generalizations about them.\n"
			+ "Some of the most common Terrestrial Ecosystems that are found are Rainforests, Tundras, Deserts, Savannas, Forests, and Grasslands.\n"
			+ "A lot of animals and plants that grow and live in Terrestrial Ecosystems also interact with freshwater and sometimes even Ocean Ecosystems.");}
	if(type == ocean){System.out.println("Ocean Ecosystems are amongst some of the most interesting in the world,\n"
			+ "especially in Warm Waters such as those of the Pacific Ocean.\n"
			+ "This is not the least because around 75% of the Earth is covered by the sea,\n"
			+ "which means that there is lots of space for all sorts of different creatures to live and thrive.\n"
			+ "There are actually three different types of Oceanic Ecosystems: \n"
			+ "Shallow Waters, Deep Waters and the Deep Ocean Surface, Warm Water and Cold Water.");}
	//https://www.conserve-energy-future.com/what-is-an-ecosystem.php
}
}
