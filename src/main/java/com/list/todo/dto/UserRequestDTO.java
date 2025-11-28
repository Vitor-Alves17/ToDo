package com.list.todo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
