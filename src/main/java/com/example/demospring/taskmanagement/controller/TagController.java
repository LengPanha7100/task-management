package com.example.demospring.taskmanagement.controller;

import com.example.demospring.taskmanagement.model.Tags;
import com.example.demospring.taskmanagement.model.request.TagRequest;
import com.example.demospring.taskmanagement.model.response.APIResponse;
import com.example.demospring.taskmanagement.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tag")
public class TagController {
    private final TagService tagService ;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Tags>>> getAllTags(){
        List<Tags> tags = tagService.getAllTags();
        APIResponse<List<Tags>> apiResponse = APIResponse.<List<Tags>>builder()
                .message("Get all tags successfully!")
                .status(HttpStatus.OK)
                .payload(tags)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{taskId}/tags/{tagId}")
    public ResponseEntity<APIResponse<Tags>> assignTagToTask(@PathVariable Long taskId , @PathVariable Long tagId){
        tagService.assignTagToTask(taskId,tagId);
        APIResponse<Tags> apiResponse = APIResponse.<Tags>builder()
                .message("Assign Tag to Task successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Tags>> createTag(@RequestBody TagRequest tagRequest){
        Tags tags = tagService.createTag(tagRequest);
        APIResponse<Tags> apiResponse = APIResponse.<Tags>builder()
                .message("Created tags successfully!")
                .status(HttpStatus.CREATED)
                .payload(tags)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @DeleteMapping("/{taskId}/tags/{tagId}")
    public ResponseEntity<APIResponse<Tags>> deleteTagById(@PathVariable Long taskId , @PathVariable Long tagId){
        tagService.deleteTagById(taskId,tagId);
        APIResponse<Tags> apiResponse = APIResponse.<Tags>builder()
                .message("Remove Tag from Task successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
