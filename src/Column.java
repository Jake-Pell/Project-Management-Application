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


}
