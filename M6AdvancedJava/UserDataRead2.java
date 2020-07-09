import java.util.*;
import java.io.*;

public class UserDataRead2 {

	public static void main(String[] args) {

		ArrayList<User> userList = new ArrayList<User>();

		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new FileReader(new File("userdata.csv")));

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

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if(fileScan!=null) {
				fileScan.close();
			}
		}

		for (User u : userList) {
			System.out.println(u);
		}
	}

}
