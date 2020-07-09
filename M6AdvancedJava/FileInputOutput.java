import java.util.Scanner;
import java.io.*;

public class FileInputOutput {

	public static void main(String[] args) {
		try {	
			helper();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void helper() throws FileNotFoundException {
			Scanner scan = new Scanner(new File("inputdata.txt"));

			while (scan.hasNext()) {
				String oneLine = scan.nextLine();

				Scanner lineScan = new Scanner(oneLine);
				lineScan.useDelimiter(",");

				String fName = lineScan.next();
				String lName = lineScan.next();
				String id = lineScan.next();

				System.out.println(lName + ", " + fName + " (" + id + ")");

			}
	}

}
