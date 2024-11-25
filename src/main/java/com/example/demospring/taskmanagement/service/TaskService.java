package com.example.demospring.taskmanagement.service;

import com.example.demospring.taskmanagement.model.Tasks;
import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.example.demospring.taskmanagement.model.request.TasksRequest;
import com.example.demospring.taskmanagement.model.response.TasksResponse;

import java.util.List;

public interface TaskService {
    List<TasksResponse> getAllTask();

    TasksResponse getTaskById(Long id);

    Tasks createTask(TasksRequest tasksRequest , EPriority ePriority);

    Tasks updateTask(Long id, TasksRequest tasksRequest,EPriority ePriority);

    void deleteTask(Long id);
}
