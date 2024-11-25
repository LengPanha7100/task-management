package com.example.demospring.taskmanagement.controller;

import com.example.demospring.taskmanagement.model.Tasks;
import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.example.demospring.taskmanagement.model.request.TasksRequest;
import com.example.demospring.taskmanagement.model.response.APIResponse;
import com.example.demospring.taskmanagement.model.response.TasksResponse;
import com.example.demospring.taskmanagement.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<TasksResponse>>> getAllTask(){
        List<TasksResponse> tasksResponses = taskService.getAllTask();
        APIResponse<List<TasksResponse>> apiResponse = APIResponse.<List<TasksResponse>>builder()
                .message("Get all task successfully!")
                .status(HttpStatus.OK)
                .payload(tasksResponses)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<TasksResponse>> getTaskById(@PathVariable Long id){
        TasksResponse tasksResponse = taskService.getTaskById(id);
        APIResponse<TasksResponse> apiResponse = APIResponse.<TasksResponse>builder()
                .message("Get task by id successfully!")
                .status(HttpStatus.OK)
                .payload(tasksResponse)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Tasks>> createTask(@RequestBody TasksRequest tasksRequest ,@RequestParam EPriority ePriority){
        Tasks tasks = taskService.createTask(tasksRequest , ePriority);
        APIResponse<Tasks> apiResponse = APIResponse.<Tasks>builder()
                .message("Created task successfully!")
                .status(HttpStatus.CREATED)
                .payload(tasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Tasks>> updateTask(@PathVariable Long id , @RequestBody TasksRequest tasksRequest , @RequestParam EPriority ePriority){
        Tasks tasks = taskService.updateTask(id,tasksRequest,ePriority);
        APIResponse<Tasks> apiResponse = APIResponse.<Tasks>builder()
                .message("Updated task by id successfully!")
                .status(HttpStatus.OK)
                .payload(tasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Tasks>> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        APIResponse<Tasks> apiResponse = APIResponse.<Tasks>builder()
                .message("Deleted task by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
