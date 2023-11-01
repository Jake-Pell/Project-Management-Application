// Copyright 2023 Cocky 4

import java.util.ArrayList;
public class Column {
    
    private String name;
    private ArrayList<Task> tasks;
/***
 * 
 * @param name
 */
    public Column(String name){
        
        this.name = name;
        tasks = new ArrayList<Task>();
    }

    // constructor called by DataLoader
    /**
     * 
     * @param name
     * @param tasks
     */
    public Column(String name, ArrayList<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }
        // setters
        /**
         * 
         * @return  name
         */
    public String getName(){
        return name;
    }
/**
 * 
 * @return tasks
 */
    public ArrayList<Task> getTasks(){
        return tasks;
    }
/**
 * 
 * @param name
 * @param description
 * @param priority
 * @return task.add it makes a new task with the description and the priority
 */
    public boolean addTask(String name, String description, int priority){
        return tasks.add(new Task(name, description, priority));
    }
/**
 * 
 * @param task
 * @return task.add adds task
 */
    public boolean addTask(Task task){
        return tasks.add(task);
    }
/**
 * 
 * @param task
 * @return task 
 */
    public Task removeTask(Task task){
        tasks.remove(task);
        return task;
    }

    public boolean setName(String name) {
        if (!name.isEmpty()){
            this.name = name;
            return true;
        } else {
            return false;
        }
    }
            /**
             * 
             * @param Task
             * @return t
             */
    public Task getTask(String name) {
      
        /**
         * 
         *  @
         * 
         */
        if (tasks == null || tasks.isEmpty())
            return null;
        for (Task t : tasks) {
            if (t.getName().equals(name))
                return t;
        }
        return null;
    }

    public boolean hasTask(Task task){
        if(tasks.contains(task)){
            return true;
        }
        return false;
    }

}
