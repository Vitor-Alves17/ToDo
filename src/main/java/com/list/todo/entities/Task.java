package com.list.todo.entities;


import com.list.todo.dto.TaskRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(TaskRequestDTO taskRequestDTO) {
        this.name = taskRequestDTO.getName();
        this.description = taskRequestDTO.getDescription();
        this.status = Status.PENDING;
        this.startDate = LocalDate.now();
        this.user = taskRequestDTO.getUser();
    }
}