import java.util.*;
import java.time.*;

public class UserDataProgram {
	
	private static List<User> userList = 
			Arrays.asList(
				new User("Anabel", "Yelk", "anayelk", "ayelk@email.com", LocalDate.of(2000,11,12)),
				new User("Zachary", "Smith", "abcsmith", "zsmith@abc.com", LocalDate.of(1999,8,18)),
				new User("Brandon", "Mettle", "bmettle", "bmettle@gmail.com", LocalDate.of(2010,1,5)),
				new User("Walter", "Crane", "crane_w", "wcrane@abc.com", LocalDate.of(2018,3,11)),
				new User("Melinda", "Belter", "mebelt", "mbelter@email.com", LocalDate.of(2017,2,21)),
				new User("Dawn", "Lamont", "d_lamont", "dlamont@gmail.com", LocalDate.of(2010,11,18)),
				new User("Gregory", "French", "frenchg", "gfrench@email.com", LocalDate.of(2008,4,14)),
				new User("Trina", "Tompson", "ttompson", "ttompson@zmail.com", LocalDate.of(1997,5,13)),
				new User("Mike", "Smith", "msmith", "msmith@email.com", LocalDate.of(1999,6,19)),
				new User("Anabel", "Smith", "smith_anabel", "asmith@zmail.com", LocalDate.of(2005,7,6))
					);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the user data program.");
		System.out.println("Here are the users: ");
		Collections.sort(userList);
		printList(userList);
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println("Enter" +
					"\n\t1 to sort by first name, last name" +
					"\n\t2 to sort by last name, first name" +
					"\n\t3 to sort by username" +
					"\n\t4 to sort by email" +
					"\n\t5 to sort by email domain name" +
					"\n\t6 to sort by join date (oldest first)" +
					"\n\t7 to sort by join date (newest first)" +
					"\n\t8 to exit" );
			int choice = Integer.parseInt(scan.nextLine());

			switch(choice) {
			case 1: Collections.sort(userList, new User.FirstNameLastNameComparator()); break;
			case 2: Collections.sort(userList, new User.LastNameFirstNameComparator()); break;
			case 3: Collections.sort(userList, new User.UsernameComparator()); break;
			case 4: Collections.sort(userList, new User.EMailComparator()); break;
			case 5: Collections.sort(userList, new User.EMailDomainComparator()); break;
			case 6: Collections.sort(userList, new User.JoinDateComparator()); break;
			case 7: Collections.sort(userList, new User.JoinDateReverseComparator()); break;		
			case 8: System.out.println("Good bye."); keepGoing = false; break;
			default: System.out.println("Invalid Choice");
			}
	
			if(keepGoing) {
				printList(userList);
			}
		}

	}
	public static void printList(List<User> list) {
		for(User user : list) {
			System.out.println(user);
		}
		System.out.println();
	}

}
