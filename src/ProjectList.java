import java.util.ArrayList;

public class ProjectList {

	private ArrayList<Project> projects;
	private static ProjectList projectList;

	private ProjectList() {
		projects = DataLoader.getProjects();
	}

	public ProjectList getInstance() {
		if (projectList == null) {
			projectList = new ProjectList();
		}
		return projectList;

	}

	public boolean addProject(Project newProject) {
		if (projectList == null)
			return false;
		return projects.add(newProject);
	}

	public Project getProject(String projectName) {
		for (Project p : projects) {
			if (p.getName().equals(projectName))
				return p;
		}
		return null;
	}
}