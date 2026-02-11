package com.list.todo.services;

import com.list.todo.dto.TaskRequestDTO;
import com.list.todo.dto.TaskResponseDTO;
import com.list.todo.dto.UserRequestDTO;
import com.list.todo.dto.UserResponseDTO;
import com.list.todo.entities.Status;
import com.list.todo.entities.Task;
import com.list.todo.entities.User;
import com.list.todo.repository.TaskRepository;
import com.list.todo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskResponseDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDTO> taskResponseDTOs = tasks.stream().map(TaskResponseDTO::new).toList();
        return taskResponseDTOs;
    }
    public TaskResponseDTO getTasksByUser(int user_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User o found"));
        return new TaskResponseDTO(taskRepository.findByUser(user));
    }

    public TaskResponseDTO addTask(TaskRequestDTO taskRequestDTO, int user_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User o found"));
        Task task = new Task(taskRequestDTO);
        task.setUser(user);
        taskRepository.save(task);
        return new TaskResponseDTO(task);

    }

    public String updateName(int id, TaskRequestDTO taskRequestDTO) {
        Task task = taskRepository.getById(id);
        if (task == null) {
            return "tarefa não encontrada";
        } else {
            task.setName(taskRequestDTO.getName());
            taskRepository.save(task);
            return "tarefa atualizado com sucesso";
        }
    }
    public String deleteTask(int id) {
        Task task = taskRepository.getById(id);
        if (task == null) {
            return "tarefa não encontrada";
        } else  {
            taskRepository.delete(task);
            return "tarefa deletado com sucesso";
        }
    }
}
