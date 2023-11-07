import java.util.ArrayList;

/**
 * Manages a list of projects and their related operations.
 */
public class ProjectList {

    private static ArrayList<Project> projects;
    private static ProjectList projectList;

    private ProjectList() {
        projects = DataLoader.getProjects();
    }

    /**
     * Retrieves the instance of the ProjectList.
     *
     * @return The singleton instance of ProjectList.
     */
    public static ProjectList getInstance() {
        if (projectList == null) {
            projectList = new ProjectList();
        }
        return projectList;
    }

    /**
     * Adds a new project to the list.
     *
     * @param projectName The name of the new project.
     * @param author      The user who creates the project.
     * @return True if the project is added successfully; otherwise, false.
     */
    public boolean addProject(String projectName, User author) {
        if (projectList == null)
            return false;
        return projects.add(new Project(projectName, author));
    }

    /**
     * Saves the projects.
     *
     * @return True if the projects are successfully saved.
     */
    public boolean saveProjects() {
        return DataWriter.saveProjects();
    }

    /**
     * Retrieves the list of projects.
     *
     * @return The list of projects.
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }

    /**
     * Retrieves a project by name.
     *
     * @param name The name of the project to retrieve.
     * @return The project with the specified name; otherwise, null.
     */
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