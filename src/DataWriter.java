package src;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

	/**
	 * Converts UserList to JSON objects and
	 * Saves them to users.json
	 * @return true if the save was successful, false if it fails
	 */
	public static boolean saveUsers() {
		UserList userList = UserList.getInstance();
		ArrayList<User> users = UserList.getUsers();
		JSONArray jsonUsers = new JSONArray();
		for (User u : users) {
			jsonUsers.add(getUserJSON(u));
		}

		// write to file
		try (FileWriter writer = new FileWriter(USER_FILE_NAME)) {
			writer.write(jsonUsers.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Takes a user object and creates a JSON Object with
	 * all of the user's information
	 * Called by the saveUsers method
	 * @param User User to be turned into a JSON Object
	 * @return A JSONObject that represents the given user's data
	 */
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, (String) user.getID());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_UNAME, user.getUsername());
		userDetails.put(USER_PASSWORD, user.getPassword());
		JSONArray userProjects = new JSONArray(user.getProjectIDs());
		userDetails.put(USER_PROJECTS, userProjects.toString());

		return userDetails;
	}

	public boolean saveProjects() {
		return true;
	}
}