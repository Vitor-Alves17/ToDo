package com.list.todo.services;

import com.list.todo.dto.UserRequestDTO;
import com.list.todo.dto.UserResponseDTO;
import com.list.todo.entities.User;
import com.list.todo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOs = users.stream().map(UserResponseDTO::new).toList();
        return userResponseDTOs;
    }
    public UserResponseDTO cadastrarUser(UserRequestDTO req) {
        User user = new User(req);
        userRepository.save(user);
        return new UserResponseDTO(user);
    }
    public ResponseEntity<?> loginUser(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByEmail(userRequestDTO.getEmail());
        if (user == null) {
            return ResponseEntity.ok("User not found");
        } else  {
            if (user.getPassword().equals(userRequestDTO.getPassword())) {
                return ResponseEntity.ok("Login Successful");
            }  else {
                return ResponseEntity.ok("Login Failed");
            }
        }
    }

    public String atualizarNome(String name, UserRequestDTO userRequestDTO) {
        User userExite = userRepository.findByName(name);

        if (userExite == null) {
            return "User not found";
        }else  {
            userExite.setName(userRequestDTO.getName());
            userRepository.save(userExite);
            return "User successfully updated";
        }
    }

    public String DeletarPorId(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User successfully deleted";
        } else {
            return "User not found";
        }
    }
}
