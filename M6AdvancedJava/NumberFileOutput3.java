import java.io.*;
import java.util.*;

public class NumberFileOutput3 {

	public static void main(String[] args)  {
		writeRandomNumbers();
		
	}
	
	public static void writeRandomNumbers()  {

		try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("RandomNumbers.txt")))) {
		
			Random generator = new Random();
			for(int i=0; i<100; i++) {
				int number = generator.nextInt(501);
				output.print(number + " ");
			}		
			
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Done!");
	}

}
