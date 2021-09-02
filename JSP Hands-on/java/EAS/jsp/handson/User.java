package EAS.jsp.handson;

public class User {
	private String name, emailAddress;
	private boolean preference;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean getPreference() {
		return preference;
	}

	public void setPreference(boolean preference) {
		this.preference = preference;
	}

	public User(String name, String emailAddress, boolean preference) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.preference = preference;
	}

	public User() {
		super();
	}
}
