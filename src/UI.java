
// Copyright 2023 Cocky 4 
public class UI {
    public static void main(String[] args) {
        // scenario1();
        // UserListTest ut = new UserListTest();
        // ut.run();
    }

    public static void scenario1(){
        ProjectApplication app = new ProjectApplication();
        if (app.login("atticusM123", "password54321"))
            System.out.println("\nUser logged in: " + app.getCurrentUser());

        if (app.setCurrentProject("Electric Missiles"))
            System.out.println("\nSet current project to Electric Missiles\n");

        if (app.setCurrentColumn("To Do")) 
            System.out.println("Selected the To Do column\n");

        if (app.createTask("Initialize super algorithm to detonate at warp speed.", "", 1))
            System.out.println("Added new task\n"); 

        if (app.setCurrentTask("Initialize super algorithm to detonate at warp speed."))
            System.out.println("Selected new task\n");

        if (app.addUserToTask("jgb721")) 
            System.out.println("Assigned Jeff Goldblum to the task\n");
        
        if (app.addTaskComment("Avoid civilians Jeff!"));
            System.out.println("Added comment to task\n");

        if (app.setCurrentTask("Curve the metal to make a cylindrical shape")) 
            System.out.println("Selected Task: Curve the metal to make a cylindrical shape\n");

        if (app.moveTask(2))
            System.out.println("Moved task to the Doing column\n");

        if (app.setCurrentComment("jgb721", "Not cylindrical enough"))
            System.out.println("Selected comment: 'Not cylindrical enough' by Jeff Goldblum\n");

        if (app.addReply("How about you do it Jeff"))
            System.out.println("Added reply to selected comment\n");

        if (app.addUserToTask("jgb721"))
            System.out.println("Assigned Jeff to the task\n");

        if (app.addColumn("Abandoned"))
            System.out.println("Added Column: Abandoned\n");

        if (app.setCurrentColumn("Backlog"))
            System.out.println("Selected Column: Backlog\n");

        if (app.setCurrentTask("Make impossible burger possible"))
            System.out.println("Selected Task: Make impossible burger possible\n");

        if (app.moveTask(4))
            System.out.println("Moved selected task to Abandoned\n");

        
        if (app.writeProjectToFile("Project.txt"));
            System.out.println("Wrote project to the file Project.txt");
        

        //app.logout();
    }
}