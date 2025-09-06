package com.example.todoapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.example.todoapp.model.Task;

public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 2000)
    private String description;

    private Task.Status status = Task.Status.PENDING;

    // getters & setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Task.Status getStatus() { return status; }
    public void setStatus(Task.Status status) { this.status = status; }
}
