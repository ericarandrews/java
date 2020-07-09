import java.time.*;
import java.util.*;

public class User implements Comparable<User> {

	private String firstName, lastName, username, email;
	private LocalDate joinDate;

	public User(String firstName, String lastName, String username, String email, LocalDate joinDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.joinDate = joinDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return firstName + "\t" + lastName + "\tUsername: " + username + "\t(" + email + ")" + "\tJoined in: "
				+ joinDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User other = (User) obj;
			return firstName.equals(other.firstName) && lastName.equals(other.lastName)
					&& username.equals(other.username) && email.equals(other.email) && joinDate.equals(other.joinDate);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(User other) {
		return username.compareTo(other.username);
	}
	
	
	public static class FirstNameLastNameComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			int firstNameComparison = user1.firstName.compareTo(user2.firstName);
			
			if(firstNameComparison==0) {
				return user1.lastName.compareTo(user2.lastName);
			} else {
				return firstNameComparison;
			}	
		}
	}
	
	public static class LastNameFirstNameComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			int lastNameComparison = user1.lastName.compareTo(user2.lastName);
			if(lastNameComparison!=0) {
				return lastNameComparison;
			} else {
				return user1.firstName.compareTo(user2.firstName);
			}
		}
	}
	
	public static class UsernameComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			// return user1.compareTo(user2); 
			return user1.username.compareTo(user2.username);
		}
	}
	public static class EMailComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			return user1.email.compareToIgnoreCase(user2.email);
		}
	}
	public static class EMailDomainComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			String domain1 = user1.email.substring(user1.email.indexOf("@")+1);
			String domain2 = user2.email.substring(user2.email.indexOf("@")+1);
			int domainComparison = domain1.compareToIgnoreCase(domain2);
			
			if(domainComparison==0) {
				return user1.email.compareToIgnoreCase(user2.email);
			} else {
				return domainComparison;
			}
			
		}
	}
	
	public static class JoinDateComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			return user1.joinDate.compareTo(user2.joinDate);
		}
	}
	public static class JoinDateReverseComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			return user2.joinDate.compareTo(user1.joinDate);
		}
	}
	
	
	
	
	
	
	
	
	
	


}
