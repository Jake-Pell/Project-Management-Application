import java.util.ArrayList;

public class ProjectList {

	private static ArrayList<Project> projects;
	private static ProjectList projectList;

	private ProjectList() {
		projects = DataLoader.getProjects();
	}

	public static ProjectList getInstance() {
		if (projectList == null) {
			projectList = new ProjectList();
		}
		return projectList;

	}

	public boolean addProject(String projectName, User author) {
		if (projectList == null)
			return false;
		return projects.add(new Project(projectName, author));
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}
}