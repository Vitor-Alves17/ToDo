package com.list.todo.controller;

import com.list.todo.dto.TaskRequestDTO;
import com.list.todo.dto.TaskResponseDTO;
import com.list.todo.dto.UserRequestDTO;
import com.list.todo.dto.UserResponseDTO;
import com.list.todo.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/gettasks")
    public List<TaskResponseDTO> getTasks() {
        return taskService.getTasks();
    }
    @GetMapping("/user/{id}/task")
    public TaskResponseDTO getTaskByUser(@PathVariable int id){
        return taskService.getTasksByUser(id);
    }

    @PostMapping("/user/{userId}/task")
    public ResponseEntity<?> addTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO, @PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.addTask(taskRequestDTO, userId));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO, @PathVariable int id) {
        return ResponseEntity.ok(taskService.updateName(id, taskRequestDTO));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
