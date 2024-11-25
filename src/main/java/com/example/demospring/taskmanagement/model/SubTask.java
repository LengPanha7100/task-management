package com.example.demospring.taskmanagement.model;

import com.example.demospring.taskmanagement.model.enumTask.EStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubTask {
    private Long subTaskId;
    private String subTaskName;
    private EStatus status;
    private Tasks tasks;
}
