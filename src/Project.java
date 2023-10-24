// Copyright 2023 Cocky 4

import java.util.UUID;
import java.util.ArrayList;

public class Project {

  private UUID id;
  private String name;
  private ArrayList<User> users = new ArrayList<User>();
  private ArrayList<Column> columns = new ArrayList<Column>();
  private ArrayList<Comment> comments = new ArrayList<Comment>();

  public Project(String name, User user){
    id = UUID.randomUUID();
    this.name = name;
    addUser(user);

    // default project columns
    addColumn("Backlog");
    addColumn("To Do");
    addColumn("In Progress");
    addColumn("Completed");

  }
 
  public boolean changeTitle(String newName){
    if(!newName.isEmpty()){
      this.name = newName;
      return true;
    }else{
      return false;
    }

  }



  public boolean addColumn(String columnName){
    return columns.add(new Column(columnName));
  }
  
  public boolean addUser(User user){
    return users.add(user);
  }

  public boolean moveColumn(Column column, Direction direction){  
    return true;
  }

  public boolean addComment(User author, String description){
    return true;
  }

  public String getName() {
    return name;
  }

  public UUID getID() {
    return id;
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  public ArrayList<Column> getColumns() {
    return columns;
  }

  public ArrayList<Comment> getComments() {
    return comments;
  }

  public boolean addTask(Task task) {
    
  }
}



