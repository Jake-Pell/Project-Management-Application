// Copyright 2023 Cocky 4

import java.util.ArrayList;
public class Column {
    
    private String name;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public Column(String name){
        this.name = name;

    }

    public String getName(){
        return name;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public boolean addTask(String name, String description, int priority){
        return tasks.add(new Task(name, description, priority));
    }

    public boolean addTask(Task task){
        return tasks.add(task);
    }

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

    public Task getTask(String name) {
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
