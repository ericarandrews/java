import java.util.*;
import java.io.*;

public class InputOutputPractice3 {

	public static void main(String[] args) {

		try (PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("output_alloneline.txt")));
				Scanner fileScan = new Scanner(new FileReader(new File("input_oneperline.txt"))) )	{
			
			while (fileScan.hasNext()) {
				String fileLine = fileScan.nextLine();
				// System.out.println(fileLine);
				fileOut.print(fileLine + " ");
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 

	}

}
