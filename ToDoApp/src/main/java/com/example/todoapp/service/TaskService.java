package com.example.todoapp.service;

import com.example.todoapp.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task getById(Long id);
    Task create(Task task);
    Task update(Long id, Task task);
    void delete(Long id);
    List<Task> getByStatus(Task.Status status);
}
