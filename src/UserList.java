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

	public boolean addUser(String firstName, String lastName,
			String username, String password) {
		if (userList == null)
			return false;
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

	public boolean saveUsers() {
		return DataWriter.saveUsers();
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}