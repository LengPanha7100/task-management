package com.example.demospring.taskmanagement.controller;

import com.example.demospring.taskmanagement.model.Comments;
import com.example.demospring.taskmanagement.model.request.CommentsRequest;
import com.example.demospring.taskmanagement.model.response.APIResponse;
import com.example.demospring.taskmanagement.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Comments>> getCommentById(@PathVariable Long id){
        Comments comments = commentService.getCommentById(id);
        APIResponse<Comments> apiResponse = APIResponse.<Comments>builder()
                .message("Get comment by id successfully!")
                .status(HttpStatus.OK)
                .payload(comments)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<APIResponse<Comments>> createComment(@RequestBody CommentsRequest commentsRequest , @PathVariable Long taskId) {
        Comments comments = commentService.createComment(commentsRequest,taskId);
        APIResponse<Comments> apiResponse = APIResponse.<Comments>builder()
                .message("Created comment successfully!")
                .status(HttpStatus.CREATED)
                .payload(comments)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Comments>> deleteCommentById(@PathVariable Long id){
        commentService.deleteCommentById(id);
        APIResponse<Comments> apiResponse = APIResponse.<Comments>builder()
                .message("Deleted comment by id successfully!")
                .status(HttpStatus.OK)
                .payload(null)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
