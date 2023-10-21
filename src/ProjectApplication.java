import java.util.*;

public class ProjectApplication {

    private User currentUser;

    public ArrayList<Project> getMyProjects() {
		return null;
	}

    public ProjectApplication() {

    }

    public boolean login(String userName, String password) {
        currentUser = UserList.getInstance().getUser(userName, password);
        return currentUser != null;
    }

    public void logout(){
        UserList.getInstance().saveUsers();
    }

    public boolean signUp(String firstName, String lastName, String userName, String password) {
        return UserList.getInstance().addUser(firstName, lastName, userName, password);
    }

    public boolean addProject(String projectName) {
        return ProjectList.getInstance().addProject(projectName, currentUser);
    }

    public boolean editProjectName(Project project, String title) {
        return false;
    }

    public boolean addColumn(Project project, String columnName) {
        return false;
    }

    public boolean editColumnName(Column column, String columnName) {
        return false;
    }

    public void moveColumn(Column column, Direction direction) {

    }

    public void createTask(Project project, Column column, String taskname, String descriprion, int priority) {

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
