// Copyright 2023 Cocky 4

import java.util.UUID;
import java.util.ArrayList;

public class Project {

  private UUID id;
  private String name;
  private ArrayList<User> users;
  private ArrayList<Column> columns;
  private ArrayList<Comment> comments;

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

  // constructor called by DataLoader
  public Project(String id, String name, ArrayList<User> users,
      ArrayList<Column> columns, ArrayList<Comment> comments) {
    this.id = UUID.fromString(id);
    this.users = users;
    this.columns = columns;
    this.comments = comments;
  }

  public boolean setName(String newName) {
    if (!newName.isEmpty()) {
      this.name = newName;
      return true;
    } else {
      return false;
    }

  }

  // Column related methods
  public boolean addColumn(String columnName) {
    return columns.add(new Column(columnName));
  }

  public boolean moveColumn(Column column, int endIndex) {

    int start = columns.indexOf(column);
    return swapColumn(column, start, endIndex);

  }

  private boolean swapColumn(Column column, int start, int end) {
    Column temp = column;
    columns.set(start, columns.get(end));
    columns.set(end, temp);
    return true;
  }

  // User related methods
  public boolean containUser(User user) {
    if (users.contains(user)) {
      return true;
    }
    return false;
  }

  public boolean addUser(User user) {
    return users.add(user);
  }

  public boolean addComment(User user, String description) {
    Comment comment = new Comment(user, description);
    return comments.add(comment);
  }

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

  private boolean swapTask(Task task, int start, int end) {
    columns.get(start).removeTask(task);
    columns.get(end).addTask(task);
    return true;
  }

}
