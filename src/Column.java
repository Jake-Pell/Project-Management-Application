// Copyright 2023 Cocky 4

import java.util.UUID;
import java.util.ArrayList;
public class Column {
    
    private String name;
    private ArrayList<Task> tasks;

    public Column(String name){
        this.name = name;
    }

    public String getName(){
        return name;
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
