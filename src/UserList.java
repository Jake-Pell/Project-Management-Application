import java.util.ArrayList;

public class UserList {

	private ArrayList<User> users;
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

	public User getUser(String userID) {
		for (User u : users) {
			if (u.getID().equals(userID))
				return u;
		}
		return null;
	}
}