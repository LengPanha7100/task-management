package com.example.demospring.taskmanagement.service;

import com.example.demospring.taskmanagement.model.SubTask;
import com.example.demospring.taskmanagement.model.enumTask.EStatus;
import com.example.demospring.taskmanagement.model.request.SubTaskRequest;

import java.util.List;

public interface SubTaskService {

    SubTask getSubTaskById(Long id);

    SubTask createSubTask(SubTaskRequest subTaskRequest, Long taskId , EStatus eStatus);

    SubTask updateSubTaskById(SubTaskRequest subTaskRequest, Long id,EStatus eStatus , Long taskId);

    void deleteSubTaskById(Long id);
}
