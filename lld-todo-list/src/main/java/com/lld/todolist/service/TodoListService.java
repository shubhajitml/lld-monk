package com.lld.todolist.service;

import com.lld.todolist.model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoListService {
    private Map<String, Task> tasks;
    private List<String> activityLog;

    public TodoListService(){
        this.tasks = new HashMap<>();
        this.activityLog = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.put(task.getTaskId(), task);
        activityLog.add("Task added: " + task.getTaskName());
    }

    public Task getTask(String taskId){
        return tasks.containsKey(taskId) ? tasks.get(taskId): null;
    }

    public void modifyTask(Task task){
        tasks.put(task.getTaskId(), task);
        activityLog.add("Task modified: " + task.getTaskName());
    }

    public void removeTask(String taskId){
        Task task = tasks.remove(taskId);
        if(task != null) {
            activityLog.add("Task removed: " + task.getTaskName());
        }else{
            activityLog.add("Couldn't find the task to remove");
        }

    }



}