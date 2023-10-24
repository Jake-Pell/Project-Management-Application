import java.util.*;

public class ProjectApplication {

    private User currentUser;
    private Project currentProject;
    private UserList userList;
    private ProjectList projectList;

    public ArrayList<Project> getMyProjects() {
		return null;
	}

    public ProjectApplication(){
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();
    }

    public ProjectApplication(Project project, User user) {
        this.currentUser = user;
        this.currentProject = project;
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();

    }

    public boolean login(String userName, String password) {
        // currentUser = UserList.getInstance().getUser(userName, password);
        currentUser = userList.getUser(userName, password);
        return currentUser != null;
    }

    public void logout(){
        // UserList.getInstance().saveUsers();
        userList.saveUsers();
    }

    public boolean signUp(String firstName, String lastName, String userName, String password) {
        // return UserList.getInstance().addUser(firstName, lastName, userName, password);
        return userList.addUser(firstName, lastName, userName, password);
    }

    public boolean addProject(String projectName) {
        // return ProjectList.getInstance().addProject(projectName, currentUser);
        return projectList.addProject(projectName, currentUser);
    }

    // Changing the project we are currently in 
    public boolean editProjectName(String title) {
        return currentProject.changeTitle(title);
    }

    public boolean addColumn(Project project, String columnName) {
        return false;
    }

    public boolean editColumnName(Column column, String columnName) {
        return false;
    }

    public void moveColumn(Column column, Direction direction) {

    }

    public boolean createTask(Column column, String taskname, String descriprion, int priority) {
        Task task = new Task(taskname, descriprion, priority);
        return currentProject.addTask(task);
    }

    public void editTaskDescription(Task task, String description) {

    }

    public void editTaskPriority(Task task, int priority) {

    }

    public void editTaskName(Task task, String name) {

    }

    public void addComment(Project project, String description) {

    }

    public void addComment(Task task, String description) {

    }

    public User getCurrentUser() {
        return currentUser;
    }
}
