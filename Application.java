import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Application{
	public static void main(String args[]){	
		int x;
		int y;
		
		int sum;
		int divide;
		int modules;
		
		int difference;
		int multiply;
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		x = stdin.nextInt();
		System.out.print("Enter second integer: ");
		y = stdin.nextInt();
		
		sum = x + y;
		divide = x / y;
		modules = x % y;
		difference = x - y;
		multiply = x * y;
		
		System.out.println("\nSum: " + sum);
		System.out.println("Division: " + divide);
		System.out.println("Modules: " + modules);
		System.out.println("Difference: " + difference);
		System.out.println("Multiplication: " + multiply);
		
		//First run: Enter values 80 and 30; Outputs should be 110, 2, 20,50 and 2400.
		//Second run: Enter 50 and 0; Outputs should cause the program to crash. 
	}
}
