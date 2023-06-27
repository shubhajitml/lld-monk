package com.lld.todolist.model;

import java.time.LocalDateTime;
import java.util.List;

public class Task {
//    taskId,taskName,deadline,tag,completed
    private String taskId;
    private String taskName;
    private LocalDateTime deadline;
    private List<String> tags;
    private boolean completed;
    public Task(String taskId, String taskName, LocalDateTime deadline, List<String> tags){
        this.taskId = taskId;
        this.taskName = taskName;
        this.deadline = deadline;
        this.tags = tags;
        this.completed = false;
    }

    public String getTaskId(){ return taskId; }
    public String getTaskName(){ return taskName; }
    public LocalDateTime getDeadline() { return deadline; }
    public List<String> getTags(){ return tags; }
    public boolean isCompleted(){ return completed; }
    public void setCompleted(){
        this.completed = true;
    }
}
