// Copyright 2023 Cocky 4
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DataLoader extends DataConstants{

	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try{
				FileReader reader = new FileReader(USER_FILE_NAME);
				JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

				for (int i = 0; i < usersJSON.size(); ++i) {
					JSONObject userJSON = (JSONObject)usersJSON.get(i);
					String id = (String)userJSON.get(ID);
					String firstName = (String)userJSON.get(USER_FIRST_NAME);
					String lastName = (String)userJSON.get(USER_LAST_NAME);
					String userName = (String)userJSON.get(USER_UNAME);
					String password = (String)userJSON.get(USER_PASSWORD);

					users.add(new User(firstName, lastName, userName, password, id));

				}

		}catch (Exception e){
			e.printStackTrace();

		}
		return users;
	}

	public static ArrayList<Project> getProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();

		 try{
		 	FileReader reader = new FileReader(PROJECT_FILE_NAME);
		 	JSONArray projectsJSON = (JSONArray) new JSONParser().parse(reader);
		 	for (int i = 0; i < projectsJSON.size(); ++i) {
		 		JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
				// id
				String id = (String)projectJSON.get(ID);

				// project name
				String name = (String)projectJSON.get(PROJECT_NAME);

				// users
				JSONArray usersArray = (JSONArray) projectJSON.get(PROJECT_USERS);
				ArrayList<User> users = new ArrayList<User>();
				for (Object user : usersArray) {
					User nextUser = UserList.getInstance().getUser(user.toString());
					if (nextUser != null)
						users.add(nextUser);
				}


				projects.add(new Project(id, name, users, null, null));
		 	}

		 } catch (Exception e) {
		 	e.printStackTrace();	
		 }
		return projects;
	}




}






