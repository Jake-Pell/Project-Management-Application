import java.util.ArrayList;

/**
 * Represents a column containing tasks.
 *
 * @author Cocky 4
 * @since 2023
 */
public class Column {

    private String name;
    private ArrayList<Task> tasks;

    /**
     * Constructs a column with a given name.
     *
     * @param name The name of the column.
     */
    public Column(String name) {
        this.name = name;
        tasks = new ArrayList<Task>();
    }

    // Constructor called by DataLoader
    /**
     * Constructs a column with a given name and existing tasks.
     *
     * @param name  The name of the column.
     * @param tasks The existing tasks to be added to the column.
     */
    public Column(String name, ArrayList<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    /**
     * Retrieves the name of the column.
     *
     * @return The name of the column.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the tasks in the column.
     *
     * @return The list of tasks in the column.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a new task to the column.
     *
     * @param name        The name of the task.
     * @param description The description of the task.
     * @param priority    The priority of the task.
     * @return True if the task was added successfully.
     */
    public boolean addTask(String name, String description, int priority) {
        return tasks.add(new Task(name, description, priority));
    }

    /**
     * Adds an existing task to the column.
     *
     * @param task The task to be added.
     * @return True if the task was added successfully.
     */
    public boolean addTask(Task task) {
        return tasks.add(task);
    }

    /**
     * Removes a specified task from the column.
     *
     * @param task The task to be removed.
     * @return The task that was removed.
     */
    public Task removeTask(Task task) {
        tasks.remove(task);
        return task;
    }

    /**
     * Sets the name of the column.
     *
     * @param name The new name for the column.
     * @return True if the name was set successfully.
     */
    public boolean setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name The name of the task to retrieve.
     * @return The task with the specified name, or null if not found.
     */
    public Task getTask(String name) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }
        for (Task t : tasks) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Checks if the column contains a specific task.
     *
     * @param task The task to check for.
     * @return True if the task is present in the column.
     */
    public boolean hasTask(Task task) {
        return tasks.contains(task);
    }
}