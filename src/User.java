package src;

public class User {

	private UUID id;
	private String firstName;
	private String lastName;
	private String username;
	private Sting password;
	private Project currentProject;
	private ArrayList<Project> projects;

	public User(String firstName, String lastName, String password,
				 Project currentProject) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		// might need to change this
		this.currentProject = currentProject;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public addProject()
}