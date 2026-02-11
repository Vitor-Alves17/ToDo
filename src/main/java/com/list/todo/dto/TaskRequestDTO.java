package com.list.todo.dto;

import com.list.todo.entities.Status;
import com.list.todo.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRequestDTO {

    @NotBlank(message = "Nome da tarefa vazio")
    @Size(min = 1, max = 25, message = "Tamanho invalido")
    private String name;
    @Size(max = 500)
    private String description;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    @NotBlank
    private User user;


}
