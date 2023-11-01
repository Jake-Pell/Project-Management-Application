
// Copyright 2023 Cocky 4 
public class UI {
    public static void main(String[] args) {
        scenario1();
    }

    public static void scenario1(){
        ProjectApplication app = new ProjectApplication();
        app.login("jwilson@gmail.com", "803-945-3388");
        app.setCurrentProject("TESTING");
        app.setCurrentColumn("In Progress");
        //app.createTask("TASK NAME", "THIS IS A DESCRIPTION OF MY TASK", 1);
        app.setCurrentTask("TASK NAME");
        //app.addTaskComment("comment for this task");
        //app.addProjectComment("This is a comment for the project");
        System.out.println(app.setCurrentComment("jwilson@gmail.com", "comment for this task"));
        //app.addReply("This is a reply to this comment");
        app.writeProjectToFile("Project.txt");
        app.logout();
    }
}