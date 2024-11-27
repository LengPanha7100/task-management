package com.example.demospring.taskmanagement.model;

import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tasks {
    private Long taskId;
    private String title;
    private String description;
    private EPriority priority;
    private LocalDate dueDate;
    private Project project;

}
