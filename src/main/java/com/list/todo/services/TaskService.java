package com.list.todo.services;

import com.list.todo.dto.TaskRequestDTO;
import com.list.todo.dto.TaskResponseDTO;
import com.list.todo.dto.UserRequestDTO;
import com.list.todo.dto.UserResponseDTO;
import com.list.todo.entities.Status;
import com.list.todo.entities.Task;
import com.list.todo.entities.User;
import com.list.todo.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> getTasks(TaskRequestDTO userRequestDTO) {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDTO> taskResponseDTOs = tasks.stream().map(TaskResponseDTO::new).toList();
        return taskResponseDTOs;
    }

    public TaskResponseDTO addTask(TaskRequestDTO taskRequestDTO) {
        Task task = new Task(taskRequestDTO);
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
