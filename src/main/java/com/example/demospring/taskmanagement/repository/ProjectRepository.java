package com.example.demospring.taskmanagement.repository;

import com.example.demospring.taskmanagement.model.Project;
import com.example.demospring.taskmanagement.model.request.ProjectRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectRepository {
    @Results(id = "projectId" ,value = {
            @Result(property = "projectId" , column = "project_id"),
            @Result(property = "projectName" , column = "project_name"),
    })
    @Select("""
    SELECT * FROM project;
    """)
    List<Project> getAllProject();

    @Select("""
    SELECT * FROM project WHERE project_id = #{id};
    """)
    @ResultMap("projectId")
    Project getProjectById(Long id);

    @Select("""
    INSERT INTO project(project_name, description)
    VALUES (#{project.projectName} ,#{project.description})
    returning *;
    """)
    @ResultMap("projectId")
    Project createProject(@Param("project") ProjectRequest ProjectRequest);

    @Select("""
    UPDATE project
    SET project_name = #{project.projectName} , description = #{project.description}
    WHERE project_id = #{id}
    returning *;
    """)
    @ResultMap("projectId")
    Project updateProject(Long id,@Param("project") ProjectRequest ProjectRequest);

    @Select("""
    DELETE FROM project WHERE project_id = #{id};
    """)
    @ResultMap("projectId")
    void deleteProject(Long id);
}
