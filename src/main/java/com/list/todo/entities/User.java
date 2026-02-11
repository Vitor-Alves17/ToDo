package com.list.todo.entities;

import com.list.todo.dto.TaskRequestDTO;
import com.list.todo.dto.UserRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public User(UserRequestDTO userRequestDTO) {
        this.name = userRequestDTO.getName();
        this.email = userRequestDTO.getEmail();
        this.password = userRequestDTO.getPassword();
    }

}
