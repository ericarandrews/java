
public class RecursiveMethodTrace {

	public static void main(String[] args) {
		int x = 1;
		Student s = new Student("Jess", 1);
		System.out.println("in main at the start\t\t\t\tx=" + x + "  id=" + s.getId());
		method(x, s, 1, 3);
		System.out.println("in main at the end\t\t\t\tx=" + x + "  id=" + s.getId());
	}
	
	
	private static void method(int x, Student s, int incValue, int maxInc) {
		if (incValue <= maxInc) { // recursive case
			System.out.println("in method incVal=" + incValue + " at the start\t\t\tx=" + x + "  id=" + s.getId());
			int newX = x + incValue;
			x = newX;
			s.setId(x);
			System.out.println("in method incVal=" + incValue + " before recursive call\tx=" + x + "  id=" + s.getId());
			method(x, s, incValue + 1, maxInc); // recursive method call
			System.out.println("in method incVal=" + incValue + " after recursive call\t\tx=" + x + "  id=" + s.getId());
			x = x + incValue;
			s.setId(s.getId()+1);
			System.out.println("in method incVal=" + incValue + " at the end\t\t\tx=" + x + "  id=" + s.getId());
		} else { // base case
			System.out.println("Recursion done.");
		}
	}
	
	/* with a helper method would look something like this
	public static void method(int x, Student s) {
		helperMethod(x, sc);
	}
	*/

}
