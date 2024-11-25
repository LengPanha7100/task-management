package com.example.demospring.taskmanagement.service.serviceImp;

import com.example.demospring.taskmanagement.exception.NotFoundException;
import com.example.demospring.taskmanagement.model.Comments;
import com.example.demospring.taskmanagement.model.request.CommentsRequest;
import com.example.demospring.taskmanagement.repository.CommentRepository;
import com.example.demospring.taskmanagement.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImp(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comments getCommentById(Long id) {
        Comments comments = commentRepository.getCommentById(id);
        if(comments == null){
            throw new NotFoundException("Comment by id "+id+ " not found");
        }
        return comments;
    }

    @Override
    public Comments createComment(CommentsRequest commentsRequest , Long taskId) {
        return commentRepository.createComment(commentsRequest , taskId);
    }

    @Override
    public void deleteCommentById(Long id) {
        getCommentById(id);
        commentRepository.deleteCommentById(id);
    }
}
