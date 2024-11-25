package com.example.demospring.taskmanagement.controller;

import com.example.demospring.taskmanagement.model.SubTask;
import com.example.demospring.taskmanagement.model.enumTask.EStatus;
import com.example.demospring.taskmanagement.model.request.SubTaskRequest;
import com.example.demospring.taskmanagement.model.response.APIResponse;
import com.example.demospring.taskmanagement.service.SubTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/subTask")
public class SubTaskController {

    private final SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<SubTask>> getSubTaskById(@PathVariable Long id){
        SubTask  subTasks = subTaskService.getSubTaskById(id);
        APIResponse<SubTask> apiResponse = APIResponse.<SubTask>builder()
                .message("Get subTask by id successfully!")
                .status(HttpStatus.OK)
                .payload(subTasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/{taskId}")
    public ResponseEntity<APIResponse<SubTask>> createSubTask(@RequestBody SubTaskRequest subTaskRequest,
                                                              @PathVariable Long taskId ,
                                                              @RequestParam EStatus status){
        SubTask  subTasks = subTaskService.createSubTask(subTaskRequest,taskId,status);
        APIResponse<SubTask> apiResponse = APIResponse.<SubTask>builder()
                .message("Created subTask successfully!")
                .status(HttpStatus.CREATED)
                .payload(subTasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @PutMapping("/{id}/And/{taskId}")
    public ResponseEntity<APIResponse<SubTask>> updateSubTaskById(@PathVariable Long id ,
                                                                  @RequestBody SubTaskRequest subTaskRequest,
                                                                  @RequestParam EStatus status,
                                                                  @PathVariable Long taskId){
        SubTask  subTasks = subTaskService.updateSubTaskById(subTaskRequest, id,status , taskId);
        APIResponse<SubTask> apiResponse = APIResponse.<SubTask>builder()
                .message("Updated subTask by id successfully!")
                .status(HttpStatus.OK)
                .payload(subTasks)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<SubTask>> deleteSubTaskById(@PathVariable Long id ){
        subTaskService.deleteSubTaskById( id);
        APIResponse<SubTask> apiResponse = APIResponse.<SubTask>builder()
                .message("Deleted subTask by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }



}
