import java.util.Random;

public class Account {
	
	private String username, password;
	
	public Account(String username) {
		this.username = username; 
		password = generatePasswordHelper();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void generatePassword() {
		this.password = generatePasswordHelper();
	}
	
	private final String generatePasswordHelper() {
		return Integer.toString(Math.abs((new Random()).nextInt()));
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + "]";
	}
	

}
