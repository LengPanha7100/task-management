package com.example.demospring.taskmanagement.service;

import com.example.demospring.taskmanagement.model.Comments;
import com.example.demospring.taskmanagement.model.request.CommentsRequest;

public interface CommentService {

    Comments getCommentById(Long id);

    Comments createComment(CommentsRequest commentsRequest , Long taskId);

    void deleteCommentById(Long id);
}
