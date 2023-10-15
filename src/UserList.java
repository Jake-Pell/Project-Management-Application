import java.util.ArrayList;

public class UserList {

	private ArrayList<User> users;
	private static UserList userList;

	private UserList() {

	}

	public UserList getInstance() {
		return null;
	}

	public boolean addUser(User newUser) {
		return true;
	}

	public User getUser(String userName) {
		return null;
	}
}