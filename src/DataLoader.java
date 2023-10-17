// Copyright 2023 Cocky 4
import java.io.FileReader;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DataLoader extends DataConstants{

	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try{
				FileReader reader = new FileReader(USER_FILE_NAME);
				JSONParser parser = new JSONParser();
				JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

				for (int i = 0; i < usersJSON.size(); ++i) {
					JSONObject userJSON = (JSONObject)usersJSON.get(i);
					String firstName = (String)userJSON.get(USER_FIRST_NAME);
					String lastName = (String)userJSON.get(USER_LAST_NAME);
					String userName = (String)userJSON.get(USER_UNAME);
					String password = (String)userJSON.get(USER_PASSWORD);

					users.add(new User(firstName, lastName, userName, password));

				}

		}catch (Exception e){
			e.printStackTrace();

		}
		return users;
	}

	public static ArrayList<Project> getProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();

		// try{
		// 	FileReader reader = new FileReader(PROJECT_FILE_NAME);
		// 	JSONParser parser = new JSONParser();
		// 	JSONArray projectsJSON = new (JSONArray) new JSONParser().parse(reader);

		// 	for (int i = 0; i < projects.size(); ++i) {
		// 		JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
				
		// 	}

		// } catch (Exception e) {
		// 	e.printStackTrace();	
		// }
		return projects;
	}
}






