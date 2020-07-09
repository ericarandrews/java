import java.util.*;
import java.io.*;

public class InputOutputPractice2 {

	public static void main(String[] args) {

		PrintWriter fileOut = null;
		try {
			// the Scanner object will read from the file
			Scanner fileScan = new Scanner(new FileReader(new File("input_oneperline.txt")));

			// the PrintWriter object will write to a file
			fileOut = new PrintWriter(new BufferedWriter(new FileWriter("output_alloneline.txt")));

			while (fileScan.hasNext()) {
				String fileLine = fileScan.nextLine();
				// System.out.println(fileLine);
				fileOut.print(fileLine + " ");
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if(fileOut != null) {
				fileOut.close(); // CRITICAL!! you must close your output stream or you lose your output!
			}
		}

	}

}
