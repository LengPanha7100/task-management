package com.example.demospring.taskmanagement.model.request;

import com.example.demospring.taskmanagement.model.Tasks;
import com.example.demospring.taskmanagement.model.enumTask.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskRequest {
    private String subTaskName;
}
