import java.util.ArrayList;
import java.util.UUID;

public class User {

	private UUID id;
	private String firstName;
	private String lastName;
	private String username;
	private Sting password;
	private Project currentProject;
	private ArrayList<Project> projects;

	public User(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public boolean addProject(String projectName) {
		return true;
	}

	public boolean editProjectName(String newName) {
		return true;
	}

	public boolean addColumn(String columnName) {
		return true;
	}

	public boolean editColumnName(Column column, String columnName) {
		return true;
	}

	public boolean moveColumn(Column column, Direction direction) {
		return true;
	}

	public boolean createTask(Column column, String taskName, String description,
								int priority) {
		return true;
	}

	public boolean editTaskDescription(Task task, String description) {
		return true;
	}

	public boolean editTaskPriority(Task task, int priority) {
		return true;
	}

	public boolean editTaskName(Task task, String name) {
		return true;
	}

	public boolean addComment(Project project, String description) {
		return true;
	}

	public boolean addComment(Task task, String description) {
		return true;
	}

	public boolean setCurrentProject(Project project) {
		return true;
	}

	public Project getCurrentProject() {
		return currentProject;
	}

	public UUID getID() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<UUID> getProjectIDs() {
		ArrayList<UUID> projectIDs = new ArrayList<UUID>();
		for (Project p : projects) {
			projectIDs.add(p.getID());
		}
		return projectIDs;
	}





}