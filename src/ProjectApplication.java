import java.util.*;

public class ProjectApplication {

    // tester main
    /*
    public static void main(String[] args) {
        ProjectApplication test = new ProjectApplication();
        UserList.getInstance();
        System.out.println(test.login("rwhite@gmail.com", "803-565-4433"));
    } */

    public ArrayList<Project> getMyProjects() {
		return null;
	}

    public ProjectApplication() {

    }

    public User login(String userName, String password) {
        return UserList.getUser(userName, password);
    }

    public User signUp(String firstName, String lastName, String userName, String password) {
        return null;
    }

    public boolean addProject(String projectName) {
        return false;
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
}
