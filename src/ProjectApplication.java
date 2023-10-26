public class ProjectApplication {

    private User currentUser;
    private Project currentProject;
    private UserList userList;
    private ProjectList projectList;
    private Task currentTask;
    private Column currentColumn;

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
        currentUser = userList.getUser(userName, password);
        return currentUser != null;
    }


    public void logout(){
        userList.saveUsers();
    }


    public boolean signUp(String firstName, String lastName, String userName, String password) {
        return userList.addUser(firstName, lastName, userName, password);
    }

    public boolean addProject(String projectName) {
        return projectList.addProject(projectName, currentUser);
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

    // Column related functions
    public boolean addColumn(String columnName) {
        return currentProject.addColumn(new Column(columnName));
    }

    public boolean editColumnName(String columnName) {
        return currentColumn.setName(columnName);
    }

    // TODO ask about direction
    public boolean moveColumn(int endIndex) {
        return currentProject.moveColumn(currentColumn, endIndex);
    }

    public boolean addProjectComment(String description) {
        return currentProject.addComment(new Comment(currentUser, description));
    }

    public boolean setCurrentColumn(String name) {
        if (currentProject == null)
            return false;
        currentColumn = currentProject.getColumn(name);
        return currentColumn != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // Task related functions
    public boolean createTask(String taskname, String descriprion, int priority) {
        if (currentColumn == null)
            return false;
        return currentColumn.addTask(new Task(taskname, descriprion, priority));
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

    public boolean setCurrentTask(String name) {
        if (currentColumn == null)
            return false;
        currentTask = currentColumn.getTask(name);
        return currentTask != null;
    }
}
