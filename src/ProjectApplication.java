import java.util.*;


public class ProjectApplication {

    private User currentUser;
    private Project currentProject;
    private UserList userList;
    private ProjectList projectList;
    private Task currentTask;
    private Column currentColumn;
    private Comment currentComment;

    /**
     *  Project Application constructor
     */
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

    /**
     * Login the user using its username and password 
     * @param userName The username of the user 
     * @param password The entered password of the user
     * @return if they were successful in logging in
     */
    public boolean login(String userName, String password) {
        currentUser = userList.getUser(userName, password);
        return currentUser != null;
    }

    /**
     * Logging out 
     */
    public void logout() {
        userList.saveUsers();
        projectList.saveProjects();
    }

    /**
     * Siging up new user using its information
     * @param firstName The first name of the new user
     * @param lastName The last name of the new user
     * @param userName The username of the new user
     * @param password The password of the new user
     * @return If we were able to succesfuly sign up
     */
    public boolean signUp(String firstName, String lastName, String userName, String password) {
        return userList.addUser(firstName, lastName, userName, password);
    }

    /**
     * Adding a project  
     * @param projectName The name of the new project
     * @return true if we were able to add the project
     */
    public boolean addProject(String projectName) {
        projectList.addProject(projectName, currentUser);
        return setCurrentProject(projectName);
    }

    /**
     * Change the current project
     * @param name The name of new current project
     * @return True if we were able to change current project
     */
    public boolean setCurrentProject(String name) {
        currentProject = projectList.getProject(name);
        return currentProject != null;
    }
/**
 * Edits the name of the current project.
 *
 * @param title The new title for the current project.
 * @return {@code true} if the project name is successfully updated, {@code false} otherwise.
 */
    public boolean editProjectName(String title) {
        return currentProject.setName(title);
    }
/**
 * Saves the current projects to a storage.
 */
    public void saveProjects() {
        projectList.saveProjects();
    }
/**
 * Retrieves the string representation of the current project.
 *
 * @return A string representation of the current project, or {@code null} if the current project is null.
 */
    public String currentProjectToString() {
        if (currentProject == null)
            return null;
        return currentProject.toString();
    }

    /**
     * Write current project into a file 
     * @param fileName The filename which we will save it to
     * @return True if we succesfuly wrote it to a file
     */
    public boolean writeProjectToFile(String fileName) {
        if (currentProject == null)
            return false;
        return currentProject.writeToFile(fileName);
    }


    // Returns projects that currentUser is inside
    /**
 * Retrieves the list of projects that the current user is associated with.
 *
 * @return A list of projects where the current user is involved, an empty list if there are no such projects.
 */
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


    /**
     * Add new Column
     * @param columnName The name of the new column
     * @return True if succesfuly added the column
     */
    public boolean addColumn(String columnName) {
        currentProject.addColumn(columnName);
        return setCurrentColumn(columnName);
    }

    /**
     * Edit the name of the column 
     * @param columnName The name of the column
     * @return True if succesfuly changed the name of column
     */
    public boolean editColumnName(String columnName) {
        return currentColumn.setName(columnName);
    }

    /**
     * Move column
     * @param endIndex The end position where column is going to end up
     * @return True if we succesfuly changed the location of the column
     */
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

    /**
     * Get the current user
     * @return current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Add a user to a project 
     * @param username The username of the user we want to add
     * @return The newUser we want to add
     */
    public User addUserToProject(String username){
        User newUser = userList.getUser(username);
        currentProject.addUser(newUser);
        return newUser;
    }

    // ---End of User---

    // Start Task 
    /**
 * Creates a new task in the current column with the provided details.
 *
 * @param taskName   The name of the new task.
 * @param description The description of the task.
 * @param priority   The priority of the task.
 * @return {@code true} if the task is successfully created, {@code false} otherwise.
 */
    public boolean createTask(String taskname, String descriprion, int priority) {
        if (currentColumn == null)
            return false;
        return currentColumn.addTask(taskname, descriprion, priority);
    }
/**
 * Edits the description of the current task.
 *
 * @param description The new description for the task.
 * @return {@code true} if the task description is successfully updated, {@code false} otherwise.
 */
    public boolean editTaskDescription(String description) {
        return currentTask.setDescription(description);
    }
/**
 * Edits the priority of the current task.
 *
 * @param priority The new priority for the task.
 * @return {@code true} if the task priority is successfully updated, {@code false} otherwise.
 */
    public boolean editTaskPriority(int priority) {
        return currentTask.setPriority(priority);
    }
/**
 * Edits the name of the current task.
 *
 * @param name The new name for the task.
 * @return {@code true} if the task name is successfully updated, {@code false} otherwise.
 */
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

    /**
     * Move the task between columns 
     * @param endIndex The ending location of the task
     * @return True if we succesfuly changed the location
     */
    public boolean moveTask(int endIndex) {
        return currentProject.moveTask(currentTask, endIndex);
    }

    /**
     * Set the current task
     * @param name The new task name
     * @return True if we successfuly changed the task
     */
    public boolean setCurrentTask(String name) {
        if (currentColumn == null) 
            return false;
        currentTask = currentColumn.getTask(name);
        return currentTask != null;
    }

    /**
     * Adding a new task
     * @param name The name of the new task
     * @param description The description of the new task
     * @param priority The priority of the new task
     * @return True if we successfuly added the task
     */
    public boolean addTask(String name, String description, int priority){
        currentColumn.addTask(name,description, priority);
        return setCurrentTask(name);
    }
/**
 * Assigns a user to the current task if both the current task and the provided user are not null.
 *
 * @param username The username of the user to be assigned to the task.
 * @return {@code true} if the user is successfully assigned to the task, {@code false} otherwise.
 */
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
     * Check if an object if null 
     * @param o The object we are checking
     * @return True if it is null
     */
    private boolean ifNull(Object o) {
        if (o == null) {
            return true;
        }
        return false;
    }
}
