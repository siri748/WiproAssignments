package com.example.todoapp.repository;

import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByPriorityOrderByCreatedAtDesc(Priority priority);
    List<Task> findByCompletedOrderByCreatedAtDesc(Boolean completed);
    List<Task> findAllByOrderByCreatedAtDesc();
}