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
 
  public boolean setName(String newName){
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

  public boolean moveColumn(Column column, int endIndex){  

    int start = columns.indexOf(column);
    return swapColumn(column, start, endIndex);
  
  }


  private boolean swapColumn(Column column, int start, int end){
    Column temp = column;
    columns.set(start, columns.get(end));
    columns.set(end,temp);
    return true;
  }


  public boolean addComment(Comment comment){
    return comments.add(comment);
  }
  
  public boolean addColumn(Column column){
    return columns.add(column);
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

  // I dont think we need this anymore
  // Changed createTask to add to current column in the facade
  public boolean addTask(Task task) {
    return columns.get(0).addTask(task);
  }

  public Column getColumn(String name) {
    if (columns == null || columns.isEmpty())
      return null;
    for (Column c : columns) {
      if (c.getName().equals(name))
        return c;
    }
    return null;
  }
}



