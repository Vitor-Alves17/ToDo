package com.list.todo.dto;

import com.list.todo.entities.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaskRequestDTO {

    @NotBlank(message = "Nome da tarefa vazio")
    @Size(min = 1, max = 25, message = "Tamanho invalido")
    private String name;
    @Size(max = 500)
    private String description;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String name, String description, Status status, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
