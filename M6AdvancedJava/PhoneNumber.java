import java.io.Serializable;

public class PhoneNumber implements Serializable {
	
	private static final long serialVersionUID = 7651745596317148472L;

	private String phoneNumber;
	
	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return phoneNumber;
	}

}
