import java.awt.Point;

public class JavaPassingParameterExample {

	public static void main(String[] args) {
		
/*
		int num = 0;
		System.out.println("In main, before method, num is "  + num);
		
		primitiveParam(num);	// num is the actual parameter	
		// it's as if behind the scenes, you have this statement:
		// formalParam = actualParam;
		// number = num;
		
		System.out.println("In main, after method, num is "  + num);
		
		*/
		/*		
		Point p = new Point(0,0);
		System.out.println("In main, before method, p is "  + p);
		
		objectParam(p); // actual parameter is p
		// it's as if behind the scenes, you have this statement:
		// formalParam = actualParam;
		// point = p; 
		// this creates an alias!!
		
		System.out.println("In main, after method, p is "  + p);
		
*/	

		Point p2 = new Point(0,0);
		System.out.println("In main, before method, p2 is "  + p2);
		objectParamReassign(p2);
		System.out.println("In main, after method, p2 is "  + p2);
		
	}

	// when this method is invoked, behind the scenes:
	// formal = actual
	// number = num
	public static void primitiveParam(int number) { // number is the formal parameter
		System.out.println("\tIn method, formal paramter number is " + number);
		number = 99;
		System.out.println("\tIn method, formal paramter number is " + number);
	}
	
	// behind the scenes: point = p;
	public static void objectParam(Point point) { // formal parameter is point
		System.out.println("\tIn method, formal paramter point is " + point);
		point.setLocation(99,99);
		System.out.println("\tIn method, formal paramter point is " + point);
	}
	
	
	// when invoked, behind the scenes: formal = actual
	// pointReassign = p2
	public static void objectParamReassign(Point pointReassign) { // pointReassign is the formal parameter
		System.out.println("\tIn method, formal paramter pointReassign is " + pointReassign);
		
		Point p3 = new Point(100,100);
		pointReassign = p3;
		// I'm using direct assignment to reassign pointRassign to a new value (an existing variable)
		
		pointReassign = new Point(100,100);
		pointReassign.setLocation(99,99); 
		// I'm using direct assignment to reassign pointRassign to a new value (a new object)
		
		System.out.println("\tIn method, formal paramter pointReassign is " + pointReassign);
	}
	
}
