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


		System.out.println(badName(firstName));

		if(badName(firstName)|| badName(lastName) || badUsername(username) || badPassword(password)){
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

	private boolean badPassword(String password) {
		if( password == null || password.isEmpty()){
			return true;
		}

		String[] badChar = {"=", " ", "+"};
		for (String s: badChar){
			if (password.contains(s)){
				return true;
			}
		}
		if (password.length() < 4){
			return true;
		}
		String[] goodNums = {"1", "2", "3", "4", 
					"5", "6", "7", "8", "9"};
		String[] goodChar = {"&", "!", "*", "%", "$", "#", "@"};
		boolean ifNum = false;
		boolean ifChar = false;
		for (String s: goodNums){
			if (password.contains(s)){
				ifNum = true;
				break;
			}
		}
		for (String s: goodChar){
			if (password.contains(s)){
				ifChar = true;
				break;
			}
		}
		if (ifChar && ifNum) {
			return false;
		} else{
			return true;
		}

	}

	private boolean badName(String name){
		String[] badChar = {"1", "2", "3", "4", " ", 
					"5", "6", "7", "8", "9","&", "!", "*", "%", "$", "#", "@"};
		
		if (name == null || name.isEmpty()){
			return true;
		}
		for (String s: badChar){
			if (name.contains(s)){
				return true;
			}
		}

		return false;
	}

	private boolean badUsername(String uName){
		if (uName == null || uName.isEmpty()){
			return true; 
		}
		if (uName.length() < 4 ){
			return true;
		}
		for (User u : users){
			if (u.getUsername().equals(uName)){
				return true;
			}
		}

		return false;
	}
}