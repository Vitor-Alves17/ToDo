package com.list.todo.dto;

import com.list.todo.entities.Status;
import com.list.todo.entities.Task;
import com.list.todo.entities.User;

import java.time.LocalDate;

public class TaskResponseDTO {

    private String name;
    private String description;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private User user;

    public TaskResponseDTO(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.startDate = task.getStartDate();
        this.endDate = task.getEndDate();
        this.user = task.getUser();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", user=" + user +
                '}';
    }
}
