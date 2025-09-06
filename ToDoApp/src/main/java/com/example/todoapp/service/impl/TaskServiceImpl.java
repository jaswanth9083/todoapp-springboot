package com.example.todoapp.service.impl;

import com.example.todoapp.model.Task;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.service.TaskService;
import com.example.todoapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Task> getAll() {
        return repo.findAll();
    }

    @Override
    public Task getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }

    @Override
    public Task create(Task task) {
        return repo.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Task existing = getById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setStatus(task.getStatus());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        Task existing = getById(id);
        repo.delete(existing);
    }

    @Override
    public List<Task> getByStatus(Task.Status status) {
        return repo.findByStatus(status);
    }
}
