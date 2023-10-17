// Copyright 2023 Cocky 4

import java.util.UUID;
import java.util.ArrayList;

public class Project {

  private UUID id;
  private String name;
  private ArrayList<User> users;
  private ArrayList<Column> columns;
  private ArrayList<Comment> comments;

  public Project(String name, User user){

  }
  
  public boolean addColumn(Column column){
    return true;
  }
  
  public boolean addUser(User user){
    return true;
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
}



