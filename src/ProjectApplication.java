import java.util.*;

public class ProjectApplication {

    private User currentUser;
    private Project currentProject;
    private UserList userList;
    private ProjectList projectList;
    private Task currentTask;

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

    // Column related functions
    public boolean addColumn(String columnName) {
        Column column = new Column(columnName);
        return currentProject.addColumn(column);
    }

    public boolean editColumnName(Column column, String columnName) {
        return false;
    }

    public boolean moveColumn(Column column, Direction direction) {
        return true;
    }

    public boolean addProjectComment(String description) {
        Comment comment = new Comment(currentUser, description);
        return currentProject.addComment(comment);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // Task related functions
    public boolean createTask(Column column, String taskname, String descriprion, int priority) {
        Task task = new Task(taskname, descriprion, priority);
        return currentProject.addTask(task);
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
        Comment comment = new Comment(currentUser, description);
        return currentTask.addComment(comment);
    }

    public boolean moveTask(Direction direction){
        return true;
    }
}
