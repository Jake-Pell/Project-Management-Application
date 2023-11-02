// Copyright 2023 Cocky 4

import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Project {

  private UUID id;
  private String name;
  private ArrayList<User> users;
  private ArrayList<Column> columns;
  private ArrayList<Comment> comments;
/**
 * 
 * @param name is the name of the project
 * @param user is the user that created the project
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
   * @param id this the the uid of the project  
   * @param name  this is the name of the project
   * @param users  user that are on the project
   * @param columns how many cloums the project has like todo doing and done
   * @param comments this is the comments on the projects
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
 * @param newName to change name of the project
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
 * Adds a new column to the project with the given column name.
 *
 * @param columnName The name of the column to be added.
 * @return {@code true} if the column is successfully added to the project; {@code false} otherwise.
 */
public boolean addColumn(String columnName) {
  return columns.add(new Column(columnName));
}
/**
 * Moves the specified column to a new position indicated by the endIndex.
 *
 * @param column    The column to be moved within the project.
 * @param endIndex  The index representing the new position for the column in the list of columns.
 * @return {@code true} if the column is successfully moved to the new position;
 *         {@code false} if the column cannot be moved due to an invalid endIndex.
 */


  public boolean moveColumn(Column column, int endIndex) {

    int start = columns.indexOf(column);
    return swapColumn(column, start, endIndex);

  }
 /**
 * Swaps the position of a column within the project's column list.
 *
 * @param column The column to be repositioned.
 * @param start  The starting index of the column.
 * @param end    The ending index where the column will be moved.
 * @return {@code true} indicating successful repositioning of the column within the list.
 */

  private boolean swapColumn(Column column, int start, int end) {
    Column temp = column;
    columns.set(start, columns.get(end));
    columns.set(end, temp);
    return true;
  }

  // User related methods
 /**
 * Checks if the provided user is contained within the project's user list.
 *
 * @param user The user to check for within the project.
 * @return {@code true} if the user is found within the project's user list, {@code false} otherwise.
 */
  public boolean containUser(User user) {
    if (users.contains(user)) {
      return true;
    }
    return false;
  }
/**
 * Adds a user to the project.
 *
 * @param user The user to be added to the project.
 * @return {@code true} if the user is successfully added to the project's user list; {@code false} otherwise.
 */
  public boolean addUser(User user) {
    return users.add(user);
  }
/**
 * Adds a comment to the project.
 *
 * @param user        The user creating the comment.
 * @param description The content of the comment.
 * @return {@code true} if the comment is successfully added to the project's comments; {@code false} otherwise.
 */

  public boolean addComment(User user, String description) {
    Comment comment = new Comment(user, description);
    return comments.add(comment);
  }
/**
 * Adds a column to the project.
 *
 * @param column The column to be added to the project.
 * @return {@code true} if the column is successfully added; {@code false} otherwise.
 */
  public boolean addColumn(Column column) {
    return columns.add(column);
  }
/**
 * Retrieves the Name of the project.
 *
 * @return The Name representing the  of the project.
 */
  public String getName() {
    return name;
  }
/**
 * Retrieves the unique identifier (UUID) of the project.
 *
 * @return The UUID representing the unique identifier of the project.
 */
  public UUID getID() {
    return id;
  }
/**
 * Retrieves the list of Users associated with the project.
 *
 * @return An ArrayList containing the Users linked to this project. 
 *         This list may be empty if no Users are present.
 */
  public ArrayList<User> getUsers() {
    return users;
  }
/**
 * Retrieves the list of Columns associated with the project.
 *
 * @return An ArrayList containing the Columns linked to this project. 
 *         This list may be empty if no Columns are present.
 */
  public ArrayList<Column> getColumns() {
    return columns;
  }
/**
 * Retrieves the list of comments associated with the project.
 *
 * @return An ArrayList containing the comments linked to this project. 
 *         This list may be empty if no comments are present.
 */
  public ArrayList<Comment> getComments() {
    return comments;
  }
/**
 * Retrieves a column by its name within the project.
 *
 * @param name The name of the column to retrieve.
 * @return The column object with the specified name if found, otherwise returns {@code null}.
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
 * @param task     The task to be moved.
 * @param endIndex he index representing the new position in the list of columns.
 * @return {@code flase} if the task cannot be moved, typically due to an invalid endIndex.
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
 * @return {@code true} when task has been stawped 
 */
  private boolean swapTask(Task task, int start, int end) {
    columns.get(start).removeTask(task);
    columns.get(end).addTask(task);
    return true;
  }

  public boolean writeToFile(String fileName) {
    try (FileWriter writer = new FileWriter(fileName)) { 
			writer.write(toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
  }
/**
 * Retrieves a comment by matching the author and description within the project or its tasks.
 *
 * @param author       The username of the author of the comment.
 * @param description  The content or description of the comment.
 * @return The comment matching the provided author and description, or {@code null} if not found.
 */
  public Comment getComment(String author, String description) {
    for (Comment c : comments) {
      if (c.getAuthor().getUsername().equals(author) && c.getDescription().equals(description))
        return c;
    }
    for (Column c : columns) {
      for (Task t : c.getTasks()) {
        Comment comment = t.getComment(author, description);
        if (comment != null)
          return comment;
      }
    }
    return null;
  }
/**
 /**
 * Generates a string representation of the project comments.
 * The string includes a section header for project comments and appends each comment's string representation.
 *
 * @return A string containing the representation of project comments, including each individual comment.
 */
 
  public String toString() {
    // name
    String projectString = "Project: " + name + "\n\nAssigned Users: \n";

    // users
    for (User u : users)
      projectString += u.toString() + "\n";
    projectString += "\n---------------------------------\n";

    // columns
    projectString += "\nColumns: \n\n";
    for (Column c : columns)
      projectString += c.toString() + "\n";
    projectString += "---------------------------------\n";

    // comments
    
   
    projectString += "\nProject Comments:\n";
    for (Comment c : comments)
      projectString += c.toString() + "\n";
    return projectString;
  }

}
