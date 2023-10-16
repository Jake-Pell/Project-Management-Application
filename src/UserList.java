import java.util.ArrayList;

public class UserList {

	private static ArrayList<User> users;
	private static UserList userList;

	private UserList() {
		users = DataLoader.getUsers();
	}

	public UserList getInstance() {
		if (userList == null) {
			userList = new UserList();
		}
		return userList;
	}

	public boolean addUser(User newUser) {
		if (userList == null) 
			return false;
		return users.add(newUser);
	}

	public ArrayList<User> getUsers() {
		return users;
	}
}