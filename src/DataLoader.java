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
				// get id
				String id = (String)projectJSON.get(ID);

				// get project name
				String name = (String)projectJSON.get(PROJECT_NAME);

				// get users
				JSONArray usersArray = (JSONArray) projectJSON.get(PROJECT_USERS);
				ArrayList<User> users = new ArrayList<User>();
				for (Object user : usersArray) {
					User nextUser = UserList.getInstance().getUserByID(user.toString());
					if (nextUser != null)
						users.add(nextUser);
				}

				// get columns
				JSONArray columnsArray = (JSONArray) projectJSON.get(PROJECT_COLUMNS);
				ArrayList<Column> columns = new ArrayList<Column>();
				for (Object column : columnsArray) {
					JSONObject columnJSON = (JSONObject) column;
					columns.add(getColumn(columnJSON));
				}

				// get 


				projects.add(new Project(id, name, users, columns, null));
		 	}

		 } catch (Exception e) {
		 	e.printStackTrace();	
		 }
		return projects;
	}

	public static Column getColumn(JSONObject column) {
		// column name
		String name = (String) column.get(COLUMN_NAME);

		// column tasks
		ArrayList<Task> tasks = new ArrayList<Task>();
		JSONArray taskArray = (JSONArray) column.get(COLUMN_TASKS);
		for (Object task : taskArray) {
			JSONObject taskJSON = (JSONObject) task;
			tasks.add(getTask(taskJSON));
		}


		return new Column(name, tasks);
	}

	public static Task getTask(JSONObject task) {
		// name, description, priority
		String name = (String) task.get(TASK_NAME);
		String description = (String) task.get(TASK_DESCRIPTION);
		int priority = ((Long) task.get(TASK_PRIORITY)).intValue();

		// users
		JSONArray usersArray = (JSONArray) task.get(TASK_USERS);
			ArrayList<User> users = new ArrayList<User>();
			for (Object user : usersArray) {
				User nextUser = UserList.getInstance().getUserByID(user.toString());
				if (nextUser != null)
					System.out.println(users.add(nextUser));
			}


		return new Task(name, description, priority, users, null);
	}


}






