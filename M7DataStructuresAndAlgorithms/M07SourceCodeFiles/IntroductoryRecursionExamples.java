

public class IntroductoryRecursionExamples {

	public static void main(String[] args) {
		//blastoffCountdown(10);
		System.out.println(factorial(6));
	}
	
	
	// this method assumes it is invoked with n >= 0 (if invoked n<0, we'll have infinite recursion!)
	public static void blastoffCountdown(int n) {
		if(n==0) { // base case- this is when the recursion stops
			System.out.println("Blastoff!");
		} else { // recursive case- this contains the recursive call
			System.out.println(n); // solve the small part now
			blastoffCountdown(n-1); // solve the rest of the problem later; this is the recursive call to the method
			// make sure the recursive call is moving us towards the base case
		}
	}
	
	public static void blastoffCountdownIterative(int n) {
		for(int i=n; i>=1; i--) {
			System.out.println(i);
		}
		System.out.println("Blastoff!");
	}
	
	// factorial is only defined for positive numbers, so we assume n is positive
	public static int factorial(int n) {
		if(n==1) { // base case: 1! = 1
			return 1;
		} else { // recursive case: n! = n * (n-1)!
			// recursive case is always moving us towards the base case- the problem keeps getting smaller until it reaches the base case
			return n * factorial(n-1);
		}
	}
	
	public static int factorialIterative(int n) {
		int solution = 1;
		for(int i=n; i>=1; i--) {
			solution = solution * i;
		}
		return solution;
	}
	
	
	
	
	
}
