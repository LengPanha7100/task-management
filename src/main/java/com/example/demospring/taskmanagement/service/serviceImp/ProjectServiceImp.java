package com.example.demospring.taskmanagement.service.serviceImp;

import com.example.demospring.taskmanagement.exception.NotFoundException;
import com.example.demospring.taskmanagement.model.Project;
import com.example.demospring.taskmanagement.model.request.ProjectRequest;
import com.example.demospring.taskmanagement.repository.ProjectRepository;
import com.example.demospring.taskmanagement.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Project> getAllProject() {
        return projectRepository.getAllProject();
    }

    @Override
    public Project getProjectById(Long id) {
        Project project = projectRepository.getProjectById(id);
        if(project == null){
            throw new NotFoundException("Project get by id "+ id+" not found");
        }
        return project;
    }

    @Override
    public Project createProject(ProjectRequest projectRequest) {
        return projectRepository.createProject(projectRequest);
    }

    @Override
    public Project updateProject(Long id, ProjectRequest projectRequest) {
        getProjectById(id);
        return projectRepository.updateProject(id, projectRequest);
    }

    @Override
    public void deleteProject(Long id) {
        getProjectById(id);
        projectRepository.deleteProject(id);
    }
}
