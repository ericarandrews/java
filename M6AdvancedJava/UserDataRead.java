import java.util.*;
import java.io.*;

public class UserDataRead {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<User> userList = new ArrayList<User>();
		
		Scanner fileScan = new Scanner(new FileInputStream(new File("userdata.csv")));
		
		fileScan.nextLine(); // read/skip the column headers

		/* IMPORTANT NOTE: you can only use this approach if the
		 * file is well-formatted and clean (e.g., no missing cells);
		 * in the real world, this is unlikely!!
		 */
		
		while(fileScan.hasNext()) { // outer loop reads one file line
			String oneLine = fileScan.nextLine();
			// System.out.println(oneLine);
			
			Scanner lineScan = new Scanner(oneLine);
			lineScan.useDelimiter(",");
			
			/*
			while(lineScan.hasNext()) { // inner loop parses that single line into tokens
				String token = lineScan.next();
				System.out.println(token);
			}
			*/
			
			String firstName = lineScan.next();
			String lastName = lineScan.next();
			String email = lineScan.next();
			String phone = lineScan.next();
			/* IMPORTANT NOTE! see above- this only works with perfectly formed data */
			
			User user = new User(firstName, lastName, email, phone);
			userList.add(user);
			
		}
		
		fileScan.close();
		
		for(User user : userList) {
			System.out.println(user);
		}
	}

}
