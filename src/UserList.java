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

	public static boolean addUser(String firstName, String lastName, 
								String username, String password) {
		if (userList == null) 
			return false;
		return users.add(new User(firstName, lastName, username, password));
	}

	public static User getUser(String username, String password) {
		for (User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}