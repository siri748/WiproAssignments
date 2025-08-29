package com.example.todoapp.dto;

import com.example.todoapp.entity.Priority;

public class TaskRequest {
    private String taskDesc;
    private Priority priority;
    private Boolean completed;
    
    // Constructors
    public TaskRequest() {}
    
    public TaskRequest(String taskDesc, Priority priority) {
        this.taskDesc = taskDesc;
        this.priority = priority;
    }
    
    // Getters and Setters
    public String getTaskDesc() {
        return taskDesc;
    }
    
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    public Boolean getCompleted() {
        return completed;
    }
    
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}