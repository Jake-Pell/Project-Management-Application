<<<<<<< HEAD
package src;
=======
import java.util.ArrayList;
import java.util.UUID;
>>>>>>> d6f4e18591febb9cc8c3fa14de2fb81dea1a9a26

public class User {

	private UUID id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;

	public User(String firstName, String lastName, String username, String password) {
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

	public ArrayList<UUID> getProjectIDs() {
		ArrayList<UUID> projectIDs = new ArrayList<UUID>();
		for (Project p : projects) {
			projectIDs.add(p.getID());
		}
		return projectIDs;
	}





}