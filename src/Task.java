// Copyright 2023 Cocky 4

import java.util.ArrayList;

public class Task {
    private String taskName;
    private int priority;
    private String description;
    private ArrayList<User> users;
    private ArrayList<Comment> comments;
/**
 * 
 * @param taskName 
 * @param description
 * @param priority
 */
  public Task(String taskName, String description, int priority){
    this.taskName = taskName;
    this.description = description;
    this.priority = priority;
    users = new ArrayList<User>();
    comments = new ArrayList<Comment>();
  }

  // constructor called by DataLoader
  /**
   * 
   * @param taskName
   * @param description
   * @param priority
   * @param users
   * @param comments
   */
  public Task(String taskName, String description, int priority,
              ArrayList<User> users, ArrayList<Comment> comments) {
    this.taskName = taskName;
    this.description = description;
    this.priority = priority;
    this.users = users;
    this.comments = comments;
  }
  
/**
 * 
 * @param user
 * @return add user to a task 
 */
  public boolean assignUser(User user){
    return users.add(user);
  }
/**
 * 
 * @param user
 * @return removes user from an assigend task
 */
  public User removeUser(User user){
    users.remove(user);
    return user;
  }
/**
 * 
 * @param user
 * @param description
 * @return
 */
  public boolean addComment(User user, String description){
    Comment comment = new Comment(user, description);
    return comments.add(comment);
  }
  
  // Setters 
  /**
   * 
   * @param taskName
   * @return checks and see if taskName is empty and changes it if true
   */
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

  /**
   * 
   * @return gets comments from array
   */
  public ArrayList<Comment> getComments() {
    return comments;
  }
/**
 * 
 * @param author
 * @param description
 * @return 
 */
  public Comment getComment(String author, String description) {
    for (Comment c : comments) {
      if (c.getAuthor().getUsername().equals(author) && c.getDescription().equals(description))
        return c;
    }
    return null;
  }

  public String toString() {
    String ret = taskName + " (Priority: " + priority + ")\n" + "Assigned Users: \n";
    for (User u : users) {
      ret += u.toString() + "\n";
    }
    ret += "Description: " + description;
    ret += "\n\nTask Comments: \n";
    for (Comment c : comments) {
      ret += c.toString() + "\n";
    }
    return ret;
  }

  
  
}