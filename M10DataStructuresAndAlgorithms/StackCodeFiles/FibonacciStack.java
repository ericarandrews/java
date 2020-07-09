import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class FibonacciStack {
	
	public static void main(String[] args) {
		int n = 12;
			
		System.out.println(fibonacciRecursive(n));
		System.out.println(fibonacciStack(n));

	}
	
	public static int fibonacciRecursive(int n) {
		if(n==1 || n==2) { // base case
			return 1;
		} else { // recursive case
			return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
		}
	}


	public static int fibonacciStack(int n) {
		StackInterface<Integer> fibStack = new ArrayStack<>();
		
		int result = 0;
		fibStack.push(n);
		
		while(!fibStack.isEmpty()) {
			int currentNumber = fibStack.pop();
			
			if(currentNumber==1 || currentNumber==2) {
				 result += 1;
			} else {				
				fibStack.push(currentNumber-1);
				fibStack.push(currentNumber-2);
			}
		}
		
		return result;
		

	}

	
	
}
