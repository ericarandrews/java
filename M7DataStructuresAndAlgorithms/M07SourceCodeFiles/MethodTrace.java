
public class MethodTrace {

	public static void main(String[] args) {
		int x = 1;
		Student s = new Student("Jess", 1);
		System.out.println("in main at the start\t\tx=" + x + "  id=" + s.getId());
		methodA(x, s);
		System.out.println("in main at the end\t\tx=" + x + "  id=" + s.getId());
	}

	public static void methodA(int x, Student s) {
		System.out.println("in methodA at the start\t\tx=" + x + "  id=" + s.getId());
		int newX = x + 1;
		x = newX;
		s.setId(x);
		System.out.println("in methodA before methodB call\tx=" + x + "  id=" + s.getId());
		methodB(x, s);
		System.out.println("in methodA after methodB call\tx=" + x + "  id=" + s.getId());
		x = x + 1;
		s.setId(s.getId()+1);
		System.out.println("in methodA at the end\t\tx=" + x + "  id=" + s.getId());
	}
	
	public static void methodB(int x, Student s) {
		System.out.println("in methodB at the start\t\tx=" + x + "  id=" + s.getId());
		int newX = x + 2;
		x = newX;
		s.setId(x);
		System.out.println("in methodB before methodC call\tx=" + x + "  id=" + s.getId());
		methodC(x, s);
		System.out.println("in methodB after methodC call\tx=" + x + "  id=" + s.getId());
		x = x + 1;
		s.setId(s.getId()+1);
		System.out.println("in methodB at the end\t\tx=" + x + "  id=" + s.getId());
	}
	
	public static void methodC(int x, Student s) {
		System.out.println("in methodC at the start\t\tx=" + x + "  id=" + s.getId());
		int newX = x + 3;
		x = newX;
		s.setId(x);
		System.out.println("in methodC at the end\t\tx=" + x + "  id=" + s.getId());
	}
}
