//At least one parent class and at least three child/grandchild classes that form an "is a" relationship
//each class must contain (either directly OR inherited from a parent):
//instance data variables
//constructor(s)
//getters and setters
//overridden toString method
//overridden equals method 
//Your classes must have a total of at least three class-specific methods 
//These methods must represent functionality of objects - some action or behavior that the object takes or that is taken on the object
//The getters/setters do not count!
//These methods must be instance methods - this means they cannot be static.
//Write a driver program to demonstrate your classes:
//Create an array or ArrayList using the parent class as the declared type.
//Fill with several different child objects.
//Invoke at least two methods on the objects. If the method exists only in the child class, use instanceof and a downcast.
//Style: Your class should follow Java coding conventions and best practices. 
//Follow the principles of object-oriented class design, encapsulation, and inheritance. 
//Follow naming conventions for variables, classes, and methods. 
//Reduce duplicated code. 

import java.util.*;
public class classDesign {
public static void main(String[]args){
	String name;
	String type;
	String freshwater = "Freshwater";
	String terrestrial = "Terrestrial";
	String ocean = "Ocean";
	ArrayList<String> y = new ArrayList<String>();
	y.add("Pond");
	y.add("River");
	y.add("Rainforests");
	y.add("Tundras");
	y.add("Deserts");
	y.add("Savannas");
	y.add("Forests");
	y.add("Grasslands");
	y.add("Shallow Water");
	y.add("Deep Water");
	y.add("Warm Water");
	y.add("Cold Water");
	
	String adds = y.toString();
	System.out.println("The following are Ecosystems added to an ArrayList: \n"+adds);

	System.out.println("\nThe following is to test the toString Method of the parent class:");
	name = y.get(0);
	type = ocean;
	ecosystems x = new ecosystems(name, type);
	System.out.println(x.toString());
	
	System.out.println("\nThe following is to test the printType Method of the parent class:");
	x.printType(name);
	
	System.out.println("\nThe following is to test the printNamesOfType Method of the parent class:");
	x.printNamesOfType(type);
	
	System.out.println("\nThe following is to test the printNamesOfType Method of the parent class:");
	x.infoOnType(type);
	
	ecosystems z = new ecosystems(name, type);
	System.out.println("\nThe following is to test the equals Method of the parent class:");
	System.out.println(x.equals(z));
	System.out.println(x.equals(y));
	
	System.out.println("\nThe following is to test the toString Method for child class 'freshwater':");
	freshwater a = new freshwater(name, type);
	System.out.println(a.toString());
	
	System.out.println("\n....freshwater method:");
	a.freshwater(name);
	
	System.out.println("\nThe following is to test the toString Method for child class 'terrestrial':");
	terrestrial b = new terrestrial(name, type);
	System.out.println(b.toString());
	
	System.out.println("\n....terrestrial method:");
	b.terrestrial(name);
	
	System.out.println("\nThe following is to test the toString Method for child class 'ocean':");
	ocean c = new ocean(name, type);
	System.out.println(c.toString());
	
	System.out.println("\n....ocean method:");
	c.ocean(name);
	
}
}
