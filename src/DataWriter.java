import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
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
		ArrayList<User> users = userList.getUsers();
		JSONArray jsonUsers = new JSONArray();
		if (users != null && !users.isEmpty()) {
			for (User u : users)
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
		userDetails.put(ID, user.getID().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_UNAME, user.getUsername());
		userDetails.put(USER_PASSWORD, user.getPassword());

		return userDetails;
	}

	/**
	 * Converts ProjectList to JSON objects and
	 * Saves them to projects.json
	 * @return true if the save was successful, false if it fails
	 */
	public static boolean saveProjects() {
		ProjectList projectList = ProjectList.getInstance();
		ArrayList<Project> projects = projectList.getProjects();
		JSONArray jsonProjects = new JSONArray();
		if (projects != null && !projects.isEmpty()) {
			for (Project p : projects)
				jsonProjects.add(getProjectJSON(p));
		}

		// write to file
		try (FileWriter writer = new FileWriter("json/projectTest.json")) { // temp test file name
			writer.write(jsonProjects.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Takes a project object and creates a JSON Object with
	 * all of the project's information
	 * Called by the saveProjects method
	 * @param Project Project to be turned into a JSON Object
	 * @return A JSONObject that represents the given project's data
	 */
	public static JSONObject getProjectJSON(Project project) {
		JSONObject projectDetails = new JSONObject();

		// get id and name
		projectDetails.put(ID, project.getID().toString());
		projectDetails.put(PROJECT_NAME, project.getName());

		// get users
		JSONArray projectUsers = new JSONArray();
		ArrayList<User> users = project.getUsers();
		if (users != null && !users.isEmpty()) {
			for (User u : users) 
				projectUsers.add(u.getID().toString());
		}
		projectDetails.put(PROJECT_USERS, projectUsers);

		// get columns
		JSONArray projectColumns = new JSONArray();
		ArrayList<Column> columns = project.getColumns();
		if (columns != null && !columns.isEmpty()) {
			for (Column c : columns) 
				projectColumns.add(getColumnJSON(c));
		}
		projectDetails.put(PROJECT_COLUMNS, projectColumns);

		// get comments
		JSONArray projectComments = new JSONArray();
		ArrayList<Comment> comments = project.getComments();
		if (comments != null && !comments.isEmpty()) {
			for (Comment c : comments)
				projectComments.add(getCommentJSON(c));
		}
		projectDetails.put(PROJECT_COMMENTS, projectComments);

		return projectDetails;

	}

	public static JSONObject getColumnJSON(Column column) {
		JSONObject columnDetails = new JSONObject();
		columnDetails.put(PROJECT_NAME, column.getName());

		JSONArray columnTasks = new JSONArray();
		ArrayList<Task> tasks = column.getTasks();
		if (tasks != null && !tasks.isEmpty()) {
			for (Task t : tasks) {
				columnTasks.add(getTaskJSON(t));
			}
		}
		columnDetails.put(COLUMN_TASKS, columnTasks);
		return columnDetails;
	}

	public static JSONObject getCommentJSON(Comment comment) {
		JSONObject commentDetails = new JSONObject();

		// author, description, date
		commentDetails.put(COMMENT_AUTHOR, comment.getAuthor().getID().toString());
		commentDetails.put(COMMENT_DESCRIPTION, comment.getDescription());
		//commentDetails.put(COMMENT_DATE, comment.getDate().toString()); // need to add date still

		// replies
		JSONArray commentReplies = new JSONArray();
		ArrayList<Comment> replies = comment.getReplies();
		if (replies != null && !replies.isEmpty()) {
			for (Comment r : replies) {
				commentReplies.add(getCommentJSON(r));
			}
		}
		commentDetails.put(COMMENT_REPLIES, commentReplies);
		
		return commentDetails;
	}

	public static JSONObject getTaskJSON(Task task) {
		JSONObject taskDetails = new JSONObject();

		// name, priority, description
		taskDetails.put(TASK_NAME, task.getName());
		taskDetails.put(TASK_PRIORITY, task.getPriority());
		taskDetails.put(TASK_DESCRIPTION, task.getDescription());
		//users
		ArrayList<User> users = task.getUsers();
		JSONArray taskUsers = new JSONArray();
		if (users != null && !users.isEmpty()) {
			for (User u : users) 
				taskUsers.add(u.getID().toString());
		}
		taskDetails.put(TASK_USERS, taskUsers);

		//comments
		JSONArray taskComments = new JSONArray();
		ArrayList<Comment> comments = task.getComments();
		if (comments != null && !comments.isEmpty()) {
			for (Comment c : comments)
				taskComments.add(getCommentJSON(c));
		}
		taskDetails.put(PROJECT_COMMENTS, taskComments);


		return taskDetails;
	}
	
}