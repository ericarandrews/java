import java.util.*;
import java.io.*;

public class UserDataRead3 {

	public static void main(String[] args) {

		ArrayList<User> userList = new ArrayList<User>();

		try (FileReader reader = new FileReader(new File("userdata.csv"));
				Scanner fileScan = new Scanner(reader)) {

			fileScan.nextLine();

			while (fileScan.hasNext()) {
				String oneLine = fileScan.nextLine();

				Scanner lineScan = new Scanner(oneLine);
				lineScan.useDelimiter(",");

				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String email = lineScan.next();
				String phone = lineScan.next();

				User user = new User(firstName, lastName, email, phone);
				userList.add(user);
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 

		for (User u : userList) {
			System.out.println(u);
		}
	}

}
