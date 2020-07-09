import java.util.Stack;

public class ExceptionTrace {
	
	public static void main(String[] args) {
		try {
			System.out.println("in main: before invoking firstMethod");
			firstMethod();
			System.out.println("in main: after invoking firstMethod");
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("in main: inside of ArrayIndexOutOfBoundsException catch");
		} finally {
			System.out.println("in main: inside of finally");
		}
		System.out.println("in main: outside of try/catch block");
	}

	public static void firstMethod() {
		try {
			System.out.println("in firstMethod: before invoking secondMethod");
			secondMethod();
			System.out.println("in firstMethod: after invoking secondMethod");
		} catch (ArithmeticException ex) {
			System.out.println("in firstMethod: inside of ArithmeticException catch");
		} finally {
			System.out.println("in firstMethod: inside of finally");
		}
		System.out.println("in firstMethod: outside of try/catch block");
	}

	public static void secondMethod() {
		try {

			//int[] nums = {1, 2, 3};
			//System.out.println(nums[4]);

			//System.out.println(4/0);

			// Object n = new Integer(4);
			// System.out.println((String) n);

			//Integer n = null;
			//System.out.println(n.toString());
			
			Stack stack = new Stack();
			System.out.println(stack.pop());

			System.out.println("in secondMethod: inside of try");
			
		} catch (ClassCastException ex) {
			System.out.println("in secondMethod: inside of ClassCastException catch");
		} catch (NullPointerException ex) {
			System.out.println("in secondMethod: inside of NullPointerException catch");
		} finally {
			System.out.println("in secondMethod: inside of finally");
		}
		System.out.println("in secondMethod: outside of try/catch block");
	}
}
