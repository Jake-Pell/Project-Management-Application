import java.util.UUID;

public class User {

	private UUID id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;

	public User(String firstName, String lastName, String username, String password) {
		id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public UUID getID() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean checkPassword() {
		return true;
	}

	public String toString() {
		return firstName + " " + lastName + " (" + username + ")";
	}

	


}