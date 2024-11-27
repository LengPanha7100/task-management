package com.example.demospring.taskmanagement.repository;
import com.example.demospring.taskmanagement.model.Comments;
import com.example.demospring.taskmanagement.model.request.CommentsRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface CommentRepository {
    @Results(id = "commentId"  , value = {
            @Result(property = "commentId" , column = "comment_id"),
            @Result(property = "tasks" , column = "task_id",
            one = @One(select= "com.example.demospring.taskmanagement.repository.TaskRepository.getTaskByIdOne")
            )
    })
    @Select("""
    SELECT * FROM comments WHERE comment_id = #{id};
    """)
    Comments getCommentById(Long id);

    @Select("""
    INSERT INTO comments(content, task_id)
    VALUES (#{comment.content}, #{taskId})
    returning *;
    """)
    @ResultMap("commentId")
    Comments createComment(@Param("comment") CommentsRequest commentsRequest , Long taskId);

    @Delete("""
    DELETE FROM comments WHERE comment_id = 2;
    """)
    @ResultMap("commentId")
    void deleteCommentById(Long id);
}
