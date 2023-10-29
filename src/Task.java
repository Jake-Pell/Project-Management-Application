// Copyright 2023 Cocky 4

import java.util.ArrayList;

public class Task {
    private String taskName;
    private int priority;
    private String description;
    private ArrayList<User> users;
    private ArrayList<Comment> comments;

  public Task(String taskName, String description, int priority){
    this.taskName = taskName;
    this.description = description;
    this.priority = priority;
    users = new ArrayList<User>();
    comments = new ArrayList<Comment>();
  }
  

  public User assignUser(User user){
    users.add(user);
    return user;
  }

  public User removeUser(User user){
    users.remove(user);
    return user;
  }

  public boolean addComment(User user, String description){
    Comment comment = new Comment(user, description);
    return comments.add(comment);
  }
  
  // Setters 
  public boolean setTaskName(String taskName) {
    if(!taskName.isEmpty()){
      this.taskName = taskName;
      return true;
    }else{
      return false;
    }
  }
  public boolean setPriority(int newPriority){
    if(priority >= 0){
      this.priority = newPriority;
      return true;
    }else {
      return false;
    }
  }

  public boolean setDescription(String description) {
    if(!description.isEmpty()){
      this.description = description;
      return true;
    }else {
      return false;
    }
  }

  // getters
  public String getName() {
    return taskName;
  }


  public String getTaskName() {
    return taskName;
  }


  public int getPriority() {
    return priority;
  }


  public String getDescription() {
    return description;
  }


  public ArrayList<User> getUsers() {
    return users;
  }


  public ArrayList<Comment> getComments() {
    return comments;
  }

  
  
}
