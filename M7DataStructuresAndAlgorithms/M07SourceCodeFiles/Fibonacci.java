import java.time.*;

public class Fibonacci {

	public static void main(String[] args) {
		int fibNum = 50;
		Instant start = Instant.now();
		System.out.println(fibonacciIterative(fibNum));
		Instant end = Instant.now();
		System.out.println("Iterative solution in " + Duration.between(start, end).toMillis() + " milliseconds.");
		System.out.println(iterativeMethodCounter + " passes through the loop.");
		start = Instant.now();
		System.out.println(fibonacciRecusive(fibNum));
		end = Instant.now();
		System.out.println("Recursive solution in " + Duration.between(start, end).toMillis() + " milliseconds.");
		System.out.println(recursiveMethodCounter + " recursive calls.");
	}
	

	private static int recursiveMethodCounter = 0;
	
	public static long fibonacciRecusive(int n) {
		recursiveMethodCounter++;
		if (n < 2) {
			return n;
		} else {
			return fibonacciRecusive(n-1) + fibonacciRecusive(n-2);
		}
	}

	private static int iterativeMethodCounter = 0;
	
	public static long fibonacciIterative(int n) { 
		long sum1 = 0, sum2 = 1;

			
		for(int i=0; i<n; i++) { 
			iterativeMethodCounter++;
			
			long temp= sum1; 
			sum1 = sum2; 
			sum2 = temp + sum2; 
		} 
		return sum1; 
	} 


}
