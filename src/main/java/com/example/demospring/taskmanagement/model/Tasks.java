package com.example.demospring.taskmanagement.model;

import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    private Long taskId;
    private String title;
    private String description;
    private EPriority priority;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime dueDate;
    private Project project;

}