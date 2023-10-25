public class UI {
    public static void main(String[] args) {
        ProjectApplication test = new ProjectApplication();
        System.out.println("Login: " + test.login("rwhite@gmail.com", "803-565-4433"));
        System.out.println("Add Project: " + test.addProject("new project"));
        System.out.println("Set Current Project: " + test.setCurrentProject("new project"));
        System.out.println("Create Task: " + test.createTask("test", "test description", 3));

        ProjectList.saveProjects();
       }
}