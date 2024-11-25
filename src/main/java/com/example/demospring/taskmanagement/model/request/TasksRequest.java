package com.example.demospring.taskmanagement.model.request;

import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksRequest {
    private String title;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime dueDate;
    private Long projectId;
}
