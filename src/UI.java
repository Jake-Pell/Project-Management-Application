public class UI {
    public static void main(String[] args) {
        scenario1();
        scenario2();
        scenario3();
        
// Add scenarios, put tests into method

       }

    public static void scenario1() { 
        ProjectApplication test1 = new ProjectApplication();
        
        System.out.println("Login: " + test1.login("rwhite@gmail.com", "803-565-4433") +
                            "\nAdd Project: " + test1.addProject("new project") +
                            "\nSet Current Project: " + test1.setCurrentProject("new project") +
                            "\nSet Current Column: " + test1.setCurrentColumn("Backlog") +
                            "\nCreate Task: " + test1.createTask("test", "test description", 3) +
                            "\nSet Current Column: " + test1.setCurrentColumn("In Progress") +
                            "\nCreate Task 2: " + test1.createTask("test", "test description", 3) +
                            "\nAdd Project Comment: " + test1.addProjectComment("this is my comment"));

        test1.saveProjects();
    }

    public static void scenario2() {
        ProjectApplication test2 = new ProjectApplication();

        System.out.println("Login: " + test2.login("rwhite@gmail.com", "803-565-4433") +
                            "\nAdd Project: " + test2.addProject("new project") +
                            "\nSet Current Project: " + test2.setCurrentProject("new project") +
                            "\nSet Current Column: " + test2.setCurrentColumn("Backlog") +
                            "\nCreate Task: " + test2.createTask("test", "test description", 3) +
                            "\nSet Current Column: " + test2.setCurrentColumn("In Progress") +
                            "\nCreate Task 2: " + test2.createTask("test", "test description", 3) +
                            "\nAdd Project Comment: " + test2.addProjectComment("this is my comment"));

        test2.saveProjects();
    }

    public static void scenario3() {
        ProjectApplication test3 = new ProjectApplication();

        System.out.println("Login: " + test3.login("rwhite@gmail.com", "803-565-4433") +
                            "\nAdd Project: " + test3.addProject("new project") +
                            "\nSet Current Project: " + test3.setCurrentProject("new project") +
                            "\nSet Current Column: " + test3.setCurrentColumn("Backlog") +
                            "\nCreate Task: " + test3.createTask("test", "test description", 3) +
                            "\nSet Current Column: " + test3.setCurrentColumn("In Progress") +
                            "\nCreate Task 2: " + test3.createTask("test", "test description", 3) +
                            "\nAdd Project Comment: " + test3.addProjectComment("this is my comment"));

        test3.saveProjects();
    }

}