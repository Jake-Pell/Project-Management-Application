import java.util.*;

public class ProjectApplication {

    private User currentUser;
    private Project currentProject;
    private UserList userList;
    private ProjectList projectList;
    private Task currentTask;
    private Column currentColumn;
    private Comment currentComment;

    public ProjectApplication() {
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();
    }
/**
 * Constructs a Project Application setting up the application with a specific project and user.
 *
 * @param project The project associated with the application.
 * @param user    The user logged into the application.
 */
    public ProjectApplication(Project project, User user) {
        this.currentUser = user;
        this.currentProject = project;
        userList = UserList.getInstance();
        projectList = ProjectList.getInstance();

    }

    // Login related methods //
    /**
 * Attempts to log in a user with the provided username and password.
 *
 * @param userName The username of the user trying to log in.
 * @param password The password corresponding to the username.
 * @return {@code true} if the login attempt is successful, {@code false} if unsuccessful.
 */
    public boolean login(String userName, String password) {
        currentUser = userList.getUser(userName, password);
        return currentUser != null;
    }

/**
 * Saves any modified user and project information before logging out.
 * Calls methods to save user and project data.
 */    public void logout() {
        userList.saveUsers();
        projectList.saveProjects();
    }
/**
 * Registers a new user by creating a user account with provided details.
 *
 * @param firstName The first name of the new user.
 * @param lastName  The last name of the new user.
 * @param userName  The desired username for the new user account.
 * @param password  The password chosen for the new user account.
 * @return {@code true} if the user account is successfully created, {@code false} if unsuccessful.
 */
    public boolean signUp(String firstName, String lastName, String userName, String password) {
        return userList.addUser(firstName, lastName, userName, password);
    }
    // ---End of Login methods---

    // Project related methods

    // Make a new project and change current to new one
    public boolean addProject(String projectName) {
        projectList.addProject(projectName, currentUser);
        return setCurrentProject(projectName);
    }

    public boolean setCurrentProject(String name) {
        currentProject = projectList.getProject(name);
        return currentProject != null;
    }

    public boolean editProjectName(String title) {
        return currentProject.setName(title);
    }

    public void saveProjects() {
        projectList.saveProjects();
    }

    public String currentProjectToString() {
        if (currentProject == null)
            return null;
        return currentProject.toString();
    }

    public boolean writeProjectToFile(String fileName) {
        if (currentProject == null)
            return false;
        return currentProject.writeToFile(fileName);
    }


    // Returns projects that currentUser is inside
    public ArrayList<Project> getUserProjects() {
        ArrayList<Project> currProjects = projectList.getProjects();
        ArrayList<Project> ans = new ArrayList<Project>();

        for (Project project : currProjects) {
            if (project.containUser(currentUser)) {
                ans.add(project);

            }
        }
        return ans;
    }

    // ---End of project---

    // Column related functions
    public boolean addColumn(String columnName) {
        currentProject.addColumn(columnName);
        return setCurrentColumn(columnName);
        // return currentProject.addColumn(columnName);
    }

    public boolean editColumnName(String columnName) {
        return currentColumn.setName(columnName);
    }

    // Assume the end index to be valid
    public boolean moveColumn(int endIndex) {
        return currentProject.moveColumn(currentColumn, endIndex);
    }

    public boolean addProjectComment(String description) {
        return currentProject.addComment(currentUser, description);
    }

    public boolean setCurrentColumn(String name) {
        if (currentProject == null)
            return false;
        currentColumn = currentProject.getColumn(name);
        return currentColumn != null;
    }

    // ---End of Column---

    // User methods

    public User getCurrentUser() {
        return currentUser;
    }

    // Current User wants to add newUser to currentProject
    // Has to check authority before calling this method
    // It will add using its username
    public User addUserToProject(String username){
        User newUser = userList.getUser(username);
        currentProject.addUser(newUser);
        return newUser;
    }

    // ---End of User---

    // Start Task 
    public boolean createTask(String taskname, String descriprion, int priority) {
        if (currentColumn == null)
            return false;
        return currentColumn.addTask(taskname, descriprion, priority);
    }

    public boolean editTaskDescription(String description) {
        return currentTask.setDescription(description);
    }

    public boolean editTaskPriority(int priority) {
        return currentTask.setPriority(priority);
    }

    public boolean editTaskName(String name) {
        if (!ifNull(currentTask)) {
            return currentTask.setTaskName(name);
        }

        return false;
    }

    public boolean addTaskComment(String description) {
        if (!ifNull(currentTask)) {
            return currentTask.addComment(currentUser, description);
        }
        return false;
    }

    public boolean moveTask(int endIndex) {
        return currentProject.moveTask(currentTask, endIndex);
    }

    public boolean setCurrentTask(String name) {
        if (currentColumn == null) 
            return false;
        currentTask = currentColumn.getTask(name);
        return currentTask != null;
    }

    public boolean addTask(String name, String description, int priority){
        currentColumn.addTask(name,description, priority);
        return setCurrentTask(name);
    }

    public boolean addUserToTask(String username){
        User newUser = userList.getUser(username);
        if (currentTask != null && newUser != null)
            return currentTask.assignUser(newUser);
        return false;
    }
    // ---End of Task---

    // Reply methods
    public boolean setCurrentComment(String author, String description) {
        if (currentProject == null)
            return false;
        currentComment = currentProject.getComment(author, description);
        return currentComment != null;
    }

    public boolean addReply(String description) {
        if (currentComment == null || currentUser == null)
            return false;
        return currentComment.addReply(currentUser, description);
    }

/**
 * Checks if the provided object is null.
 *
 * @param o The object to be checked for null.
 * @return {@code true} if the provided object is null, otherwise {@code false}.
 */
    private boolean ifNull(Object o) {
        if (o == null) {
            return true;
        }
        return false;
    }
}
