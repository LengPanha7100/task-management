package com.example.demospring.taskmanagement.service.serviceImp;

import com.example.demospring.taskmanagement.exception.NotFoundException;
import com.example.demospring.taskmanagement.model.SubTask;
import com.example.demospring.taskmanagement.model.enumTask.EStatus;
import com.example.demospring.taskmanagement.model.request.SubTaskRequest;
import com.example.demospring.taskmanagement.repository.SubTaskRepository;
import com.example.demospring.taskmanagement.service.SubTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskServiceImp implements SubTaskService {
    private final SubTaskRepository subTaskRepository;

    public SubTaskServiceImp(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }

    @Override
    public SubTask getSubTaskById(Long id) {
        SubTask subTask = subTaskRepository.getSubTaskById(id);
        if(subTask == null){
            throw new NotFoundException("SubTask id "+id+" not found");
        }
        return subTask;
    }

    @Override
    public SubTask createSubTask(SubTaskRequest subTaskRequest , Long taskId , EStatus status) {
        return subTaskRepository.createSubTask(subTaskRequest,taskId , status);
    }

    @Override
    public SubTask updateSubTaskById(SubTaskRequest subTaskRequest, Long id ,EStatus status , Long taskId) {
        getSubTaskById(id);
        return subTaskRepository.updateSubTaskById(subTaskRequest,id , status,taskId);
    }

    @Override
    public void deleteSubTaskById(Long id) {
        getSubTaskById(id);
        subTaskRepository.deleteSubTaskById(id);
    }
}
