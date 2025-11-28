package com.list.todo.dto;

import com.list.todo.entities.*;

public class UserResponseDTO {

    private String name;
    private String email;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
