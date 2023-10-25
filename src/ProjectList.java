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

	public boolean addTask(Task task){
		return true;
	}

	public boolean saveProjects() {
		return DataWriter.saveProjects();
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public Project getProject(String name) {
		if (projects == null || projects.isEmpty())
			return null;
		for (Project p : projects) {
			if (p.getName().equals(name))
				return p;
		}
		return null;
	}
}