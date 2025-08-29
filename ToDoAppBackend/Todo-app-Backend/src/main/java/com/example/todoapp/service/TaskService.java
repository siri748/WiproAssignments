package com.example.todoapp.service;

import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.Priority;
import com.example.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriorityOrderByCreatedAtDesc(priority);
    }
    
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskDesc(taskDetails.getTaskDesc());
            task.setPriority(taskDetails.getPriority());
            task.setCompleted(taskDetails.getCompleted());
            return taskRepository.save(task);
        }
        return null;
    }
    
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Task toggleTaskCompletion(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setCompleted(!task.getCompleted());
            return taskRepository.save(task);
        }
        return null;
    }
}