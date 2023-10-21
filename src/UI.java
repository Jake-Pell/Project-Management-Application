public class UI {
    public static void main(String[] args) {
        ProjectApplication test = new ProjectApplication();
        System.out.println(test.login("rwhite@gmail.com", "803-565-4433"));
        System.out.println(test.addProject("new project"));
        ProjectList.saveProjects();
       }
}