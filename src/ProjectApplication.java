import java.util.*;

public class ProjectApplication {

    private User currentUser;
    private Project currentProject;
    private UserList userList;
    private ProjectList projectList;
    private Task currentTask;
    private Column currentColumn;

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
        currentUser = UserList.getUser(userName, password);
        return currentUser != null;
    }

    public void logout(){
        UserList.saveUsers();
    }

    public boolean signUp(String firstName, String lastName, String userName, String password) {
        return UserList.addUser(firstName, lastName, userName, password);
    }

    public boolean addProject(String projectName) {
        return ProjectList.addProject(projectName, currentUser);
    }

    public boolean setCurrentProject(String name) {
        currentProject = ProjectList.getProject(name);
        return currentProject != null;
    }

    public boolean editProjectName(String title) {
        return currentProject.changeTitle(title);
    }

    // Column related functions
    public boolean addColumn(String columnName) {
        return currentProject.addColumn(new Column(columnName));
    }

    public boolean editColumnName(String columnName) {
        return currentColumn.setName(columnName);
    }

    public boolean moveColumn(Column column, Direction direction) {
        return true;
    }

    public boolean addProjectComment(String description) {
        return currentProject.addComment(new Comment(currentUser, description));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // Task related functions
    public boolean createTask(String taskname, String descriprion, int priority) {
        return currentProject.addTask(new Task(taskname, descriprion, priority));
    }

    public boolean editTaskDescription(String description) {
        return currentTask.setDescription(description);
    }

    public boolean editTaskPriority(int priority) {
        return currentTask.setPriority(priority);
    }

    public boolean editTaskName(String name) {
        return currentTask.setTaskName(name);
    }

    public boolean addTaskComment(String description) {
        return currentTask.addComment(new Comment(currentUser, description));
    }

    public boolean moveTask(String direction){ 
        return true;
    }

    public void setTask(Task task) {
        currentTask = task;
    }
}
