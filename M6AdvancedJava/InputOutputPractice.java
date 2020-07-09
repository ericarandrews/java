import java.util.*;
import java.io.*;

public class InputOutputPractice {

	public static void main(String[] args)  throws Exception {
		
		// read in from the file
		Scanner fileScan = new Scanner(new FileInputStream("input_oneperline.txt"));

		// write to the file
		PrintWriter out = new PrintWriter(new FileOutputStream("output_alloneline.txt", true));
		
		while(fileScan.hasNext()) {
			String oneLine = fileScan.nextLine();
			// System.out.println(oneLine);
			out.print(oneLine + " ");
		}
			
		fileScan.close();
		out.close();
		System.out.println("done!");
		
	}

}
