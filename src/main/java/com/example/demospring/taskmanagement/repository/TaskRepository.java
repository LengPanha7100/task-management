package com.example.demospring.taskmanagement.repository;

import com.example.demospring.taskmanagement.model.Comments;
import com.example.demospring.taskmanagement.model.SubTask;
import com.example.demospring.taskmanagement.model.Tags;
import com.example.demospring.taskmanagement.model.Tasks;
import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.example.demospring.taskmanagement.model.request.TasksRequest;
import com.example.demospring.taskmanagement.model.response.TasksResponse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskRepository {
    @Results(id = "taskId" , value = {
            @Result(property = "taskId" , column = "task_id"),
            @Result(property = "dueDate" , column =  "due_date"),
            @Result(property = "project" , column = "project_id",
            one = @One(select = "com.example.demospring.taskmanagement.repository.ProjectRepository.getProjectById")
            ),
            @Result(property = "tags" , column = "task_id",
            many = @Many(select = "getAllTag")
            ),
            @Result(property = "subTasks" , column = "task_id",
            many =  @Many(select = "getAllSubTask")
            ),
            @Result(property = "comments" , column = "task_id",
            many = @Many(select = "getAllComment")
            )
    })
    @Select("""
    SELECT * FROM tasks;
    """)
    List<TasksResponse> getAllTask();

    @Select("""
    SELECT * FROM tasks WHERE task_id = #{id};
    """)
    @ResultMap("taskId")
    TasksResponse getTaskById(Long id);

    @Select("""
    SELECT t.tag_id,t.name FROM tags t
    JOIN task_tag tt on t.tag_id = tt.tag_id
    WHERE task_id = #{taskId};
    """)
    @Result(property = "tagId" , column = "tag_id")
    List<Tags> getAllTag(Long taskId);

    @Select("""
    SELECT * FROM subtasks;
    """)
    @Results(id = "subTaskId" , value = {
            @Result(property = "subTaskId" , column = "subTask_id"),
            @Result(property = "subTaskName" , column = "name"),
    })
    List<SubTask> getAllSubTask();

    @Select("""
    SELECT * FROM comments;
    """)
    @Result(property = "commentId" , column = "comment_id")
    List<Comments> getAllComment();

    @Select("""
    INSERT INTO tasks(title, description, due_date, priority, project_id)
    VALUES (#{task.title} ,#{task.description} , #{task.dueDate},#{ePriority},#{task.projectId})
    returning *;
    """)
    @Results(id = "newTaskId" , value = {
            @Result(property = "taskId" , column = "task_id"),
            @Result(property = "dueDate" , column =  "due_date"),
            @Result(property = "project" , column = "project_id",
                    one = @One(select = "com.example.demospring.taskmanagement.repository.ProjectRepository.getProjectById")
            ),
    })
    Tasks createTask(@Param("task") TasksRequest tasksRequest , EPriority ePriority);

    @Select("""
    UPDATE tasks
    SET title = #{task.title} , description = #{task.description} , due_date = #{task.dueDate} , priority = #{ePriority} , project_id = #{task.projectId}
    WHERE task_id = #{id}
    returning * ;
    """)
    @ResultMap("newTaskId")
    Tasks updateTask(Long id,@Param("task") TasksRequest tasksRequest , EPriority ePriority);

    @Delete("""
    DELETE FROM tasks WHERE task_id = #{id};
    """)
    @ResultMap("newTaskId")
    void deleteTask(Long id);
}
