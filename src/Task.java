// Copyright 2023 Cocky 4

import java.util.ArrayList;

/**
 * Represents a task in the system with assigned users and comments.
 */
public class Task {
    private String taskName;
    private int priority;
    private String description;
    private ArrayList<User> users;
    private ArrayList<Comment> comments;

    /**
     * Constructs a task with the provided task name, description, and priority.
     *
     * @param taskName    The name of the task.
     * @param description The description of the task.
     * @param priority    The priority of the task.
     */
    public Task(String taskName, String description, int priority) {
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        users = new ArrayList<User>();
        comments = new ArrayList<Comment>();
    }

    /**
     * Constructs a task with the provided task name, description, priority, assigned users, and comments.
     *
     * @param taskName    The name of the task.
     * @param description The description of the task.
     * @param priority    The priority of the task.
     * @param users       The users assigned to the task.
     * @param comments    The comments associated with the task.
     */
    public Task(String taskName, String description, int priority, ArrayList<User> users, ArrayList<Comment> comments) {
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.users = users;
        this.comments = comments;
    }

    /**
     * Assigns a user to the task.
     *
     * @param user The user to be assigned.
     * @return The assigned user.
     */
    public User assignUser(User user) {
        users.add(user);
        return user;
    }

    /**
     * Removes a user from the task.
     *
     * @param user The user to be removed.
     * @return The removed user.
     */
    public User removeUser(User user) {
        users.remove(user);
        return user;
    }

    /**
     * Adds a comment to the task.
     *
     * @param user        The user adding the comment.
     * @param description The description of the comment.
     * @return True if the comment is added successfully; otherwise, false.
     */
    public boolean addComment(User user, String description) {
        Comment comment = new Comment(user, description);
        return comments.add(comment);
    }

    // Setters

    // Getters
    // Methods removed due to redundancy

    /**
     * Retrieves the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return taskName;
    }

   
}
