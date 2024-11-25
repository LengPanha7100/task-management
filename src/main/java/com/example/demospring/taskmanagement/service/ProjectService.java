package com.example.demospring.taskmanagement.service;

import com.example.demospring.taskmanagement.model.Project;
import com.example.demospring.taskmanagement.model.request.ProjectRequest;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();

    Project getProjectById(Long id);

    Project createProject(ProjectRequest projectRequest);

    Project updateProject(Long id, ProjectRequest projectRequest);

    void deleteProject(Long id);
}
