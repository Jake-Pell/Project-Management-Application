// Copyright 2023 Cocky 4

public abstract class DataConstants {
  protected final static String ID = "id";
  // User
	protected final static String USER_FILE_NAME = "json/users.json";
	protected final static String USER_FIRST_NAME = "firstName";
	protected final static String USER_LAST_NAME = "lastName";
	protected final static String USER_UNAME = "username";
	protected final static String USER_PASSWORD = "password";
	protected final static String USER_PROJECTS = "projects";

  // Project
  protected final static String PROJECT_FILE_NAME = "json/projects.json";
  protected final static String PROJECT_NAME = "project_name";
  protected final static String PROJECT_USERS = "users";
  protected final static String PROJECT_COLUMNS = "columns";
  protected final static String PROJECT_COMMENTS = "comments";

  // Column
  protected final static String COLUMN_NAME = "name";
  protected final static String COLUMN_TASKS = "tasks";

  // Comment
  protected final static String COMMENT_AUTHOR = "author";
  protected final static String COMMENT_DESCRIPTION = "description";
  protected final static String COMMENT_DATE = "date";
  protected final static String COMMENT_REPLIES = "replies";

  //Task
  protected final static String TASK_NAME = "name";
  protected final static String TASK_PRIORITY = "priority";
  protected final static String TASK_USERS = "users";
  protected final static String TASK_DESCRIPTION = "description";
  protected final static String TASK_COMMENTS = "comments";
}
