package com.list.todo.repository;

import com.list.todo.entities.Status;
import com.list.todo.entities.Task;
import com.list.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    public Task findByName(String name);
   public Task findByStatus(Status status);
   public Task findByUser(User user);
}
