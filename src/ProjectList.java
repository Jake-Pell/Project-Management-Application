import java.util.ArrayList;

public class ProjectList {

	private ArrayList<Project> projects;
	private ProjectList projectList;

	private ProjectList() {

	}

	public ProjectList getInstance() {
		return null;
	}

	public boolean addProject(Project newProject) {
		return true;
	}

	public Project getProject(String projectName) {
		return null;
	}
}