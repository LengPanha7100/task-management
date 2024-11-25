package com.example.demospring.taskmanagement.service.serviceImp;

import com.example.demospring.taskmanagement.exception.NotFoundException;
import com.example.demospring.taskmanagement.model.Tasks;
import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.example.demospring.taskmanagement.model.request.TasksRequest;
import com.example.demospring.taskmanagement.model.response.TasksResponse;
import com.example.demospring.taskmanagement.repository.TaskRepository;
import com.example.demospring.taskmanagement.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TasksResponse> getAllTask() {
        return taskRepository.getAllTask() ;
    }

    @Override
    public TasksResponse getTaskById(Long id) {
        TasksResponse tasks = taskRepository.getTaskById(id);
        if(tasks == null){
            throw new NotFoundException("Task id "+id+ " not found");
        }
        return tasks;
    }

    @Override
    public Tasks createTask(TasksRequest tasksRequest , EPriority ePriority) {
        return taskRepository.createTask(tasksRequest,ePriority);
    }

    @Override
    public Tasks updateTask(Long id, TasksRequest tasksRequest , EPriority ePriority) {
        getTaskById(id);
        return taskRepository.updateTask(id,tasksRequest, ePriority);
    }

    @Override
    public void deleteTask(Long id) {
         getTaskById(id);
         taskRepository.deleteTask(id);
    }
}
