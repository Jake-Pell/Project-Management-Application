import java.util.ArrayList;

public class UserList {

	private static ArrayList<User> users;
	private static UserList userList;

	private UserList() {
		users = DataLoader.getUsers();
	}

	public static UserList getInstance() {
		if (userList == null) {
			userList = new UserList();
		}
		return userList;
	}

	// all parameters must not be empty or null
	// username must not be taken, and must be at least 4 characters
	// password must have at least 8 characters, a number, and a special character
	public boolean addUser(String firstName, String lastName,
			String username, String password) {

		if (userList == null){
			return false;
		}
		
		if (firstName == null || lastName == null ||
		 username == null || password == null){
			return false;
		}
		if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()){
			return false;
		}
		if (firstName.contains(" ") || lastName.contains(" ") || username.contains(" ") || password.contains(" ")){
			return false;
		}

		return users.add(new User(firstName, lastName, username, password));
	}

	public User getUser(String username, String password) {
		for (User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}

	// Get user by only username, for interacting with other
	// users purposes
	public User getUser(String username){
		for(User u : users)	{
			if (u.getUsername().equals(username)){
				return u;
			}
		}
		return null;	
	}

	// get user by UUID
	// used by DataLoader
	public User getUserByID(String id) {
		for(User u : users)	{
			if (u.getID().toString().equals(id)){
				return u;
			}
		}
		return null;	
	}

	public boolean saveUsers() {
		return DataWriter.saveUsers();
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}