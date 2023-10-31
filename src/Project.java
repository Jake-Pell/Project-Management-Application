// Copyright 2023 Cocky 4

import java.util.UUID;
import java.util.ArrayList;

public class Project {

  private UUID id;
  private String name;
  private ArrayList<User> users;
  private ArrayList<Column> columns;
  private ArrayList<Comment> comments;
/**
 * 
 * @param name
 * @param user
 */
  public Project(String name, User user) {
    id = UUID.randomUUID();
    this.name = name;
    users = new ArrayList<User>();
    columns = new ArrayList<Column>();
    comments = new ArrayList<Comment>();

    addUser(user);

    // default project columns
    addColumn("Backlog");
    addColumn("To Do");
    addColumn("In Progress");
    addColumn("Completed");

  }

  /**
   * 
   * @param id
   * @param name
   * @param users
   * @param columns
   * @param comments
   */
  // constructor called by DataLoader
  public Project(String id, String name, ArrayList<User> users,
      ArrayList<Column> columns, ArrayList<Comment> comments) {
    this.id = UUID.fromString(id);
    this.name = name;
    this.users = users;
    this.columns = columns;
    this.comments = comments;
  }

/**
 * 
 * @param newName
 * @return {@code true} if the name is set successfully; {@code false} if the provided 
 *         name is an empty string and, therefore, not set.

 */
  public boolean setName(String newName) {
    if (!newName.isEmpty()) {
      this.name = newName;
      return true;
    } else {
      return false;
    }

  }

  // Column related methods
  /**
   * 
   * @param columnName
   * @return columns.add(new Column(columnName))
   */
  public boolean addColumn(String columnName) {
    return columns.add(new Column(columnName));
  }
/**
 * 
 * @param column
 * @param endIndex
 * @return swapColumn(column, start, endIndex)
 */

  public boolean moveColumn(Column column, int endIndex) {

    int start = columns.indexOf(column);
    return swapColumn(column, start, endIndex);

  }
  /**
   * 
   * @param column
   * @param start
   * @param end
   * @return true
   */

  private boolean swapColumn(Column column, int start, int end) {
    Column temp = column;
    columns.set(start, columns.get(end));
    columns.set(end, temp);
    return true;
  }

  // User related methods
  /**
   * 
   * @param user
   * @return true if the user was successfully added, false otherwise.
   */
  public boolean containUser(User user) {
    if (users.contains(user)) {
      return true;
    }
    return false;
  }
/**
 * 
 * @param user
 * @return {@}
 */
  public boolean addUser(User user) {
    return users.add(user);
  }
  /**
   * 
   * @param user
   * @param description
   * @return comments.add(commment)
   */

  public boolean addComment(User user, String description) {
    Comment comment = new Comment(user, description);
    return comments.add(comment);
  }
/**
 * 
 * @param column
 * @return comments.add(commment)
 */
  public boolean addColumn(Column column) {
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
/**
 * 
 * @param name
 * @return null
 */
  public Column getColumn(String name) {
    if (columns == null || columns.isEmpty())
      return null;
    for (Column c : columns) {
      if (c.getName().equals(name))
        return c;
    }
    return null;
  }

  // Task related classes
/**
 * 
 * @param task
 * @param endIndex
 * @return flase/ true
 */
  public boolean moveTask(Task task, int endIndex) {

    // int start = columns.indexOf(currCol);
    Column colOfTask = null;
    for (Column column : columns) {
      if (column.hasTask(task)) {
        colOfTask = column;
        break;
      }
    }
    int start = columns.indexOf(colOfTask);
    if (endIndex < 0 || endIndex > columns.size()) {
      return false;
    }
    // Moving from column start to column endInde
    return swapTask(task, start, endIndex);

  }
/**
 * 
 * @param task
 * @param start
 * @param end
 * @return true
 */
  private boolean swapTask(Task task, int start, int end) {
    columns.get(start).removeTask(task);
    columns.get(end).addTask(task);
    return true;
  }

}
