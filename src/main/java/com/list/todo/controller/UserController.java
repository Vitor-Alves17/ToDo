package com.list.todo.controller;

import com.list.todo.dto.UserRequestDTO;
import com.list.todo.dto.UserResponseDTO;
import com.list.todo.repository.UserRepository;
import com.list.todo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getusers")
    public List<UserResponseDTO> getUsers(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userService.getUsers(userRequestDTO);
    }
    @PostMapping("/user/cadatrar")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.cadastrarUser(userRequestDTO));
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.loginUser(userRequestDTO));
    }
    @PutMapping("/user/update/{name}")
    public ResponseEntity<?> updateUser(@PathVariable String name, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.atualizarNome(name, userRequestDTO));
    }
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.DeletarPorId(id));
    }
}
