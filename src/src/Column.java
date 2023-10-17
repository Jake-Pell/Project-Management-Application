package src;

// Copyright 2023 Cocky 4

import java.util.UUID;
import java.util.ArrayList;
public class Column {
    
    private String name;
    private UUID id;
    private ArrayList<Task> tasks;

    public Column(String name, Task taks){


    }

    public String getName(){
        return name;
    }

    public UUID getID(){
        return id;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public boolean addTasks(Task task){
        return true;
    }

    public Task removeTask(Task task){
        // Implementation
        return task;
    }

}
