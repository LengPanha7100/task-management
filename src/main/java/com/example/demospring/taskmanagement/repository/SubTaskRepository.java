package com.example.demospring.taskmanagement.repository;

import com.example.demospring.taskmanagement.model.SubTask;
import com.example.demospring.taskmanagement.model.enumTask.EStatus;
import com.example.demospring.taskmanagement.model.request.SubTaskRequest;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SubTaskRepository {
    @Results(id = "subTaskId" , value = {
            @Result(property = "subTaskId" , column = "subTask_id"),
            @Result(property = "subTaskName" , column = "name"),
            @Result(property = "tasks" , column = "task_id",
            one = @One(select="com.example.demospring.taskmanagement.repository.TaskRepository.getTaskById")
            )
    })
    @Select("""
    SELECT * FROM subtasks WHERE subtask_id = #{id};
    """)
    SubTask getSubTaskById(Long id);

    @Select("""
    INSERT INTO subtasks(name, status, task_id)
    VALUES (#{subTask.subTaskName}, #{eStatus}, #{taskId} )
    returning *;
    """)
    @ResultMap("subTaskId")
    SubTask createSubTask(@Param("subTask") SubTaskRequest subTaskRequest , Long taskId , EStatus eStatus);

    @Select("""
    UPDATE subtasks
    SET name= #{subTask.subTaskName} , status = #{status} , task_id = #{taskId}
    WHERE subtask_id = #{id}
    returning *;
    """)
    @ResultMap("subTaskId")
    SubTask updateSubTaskById(@Param("subTask") SubTaskRequest subTaskRequest, Long id , EStatus status , Long taskId);

    @Delete("""
    DELETE FROM subtasks WHERE subtask_id = #{id};
    """)
    @ResultMap("subTaskId")
    void deleteSubTaskById(Long id);
}
