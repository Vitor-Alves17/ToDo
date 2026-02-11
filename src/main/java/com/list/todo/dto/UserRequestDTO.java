package com.list.todo.dto;

import com.list.todo.entities.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Nome vazio")
    @Size(min = 1, max = 50)
    private String name;
    @Column(unique = true)
    @Size(min = 1, max = 50, message = "")
    @NotBlank(message = "Email vazio")
    private String email;
    @NotBlank(message = "Senha vazia")
    @Size(min = 6, max = 20, message = "Senha muito grande ou muito pequena")
    private String password;


}
