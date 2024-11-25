package com.example.demospring.taskmanagement.model.response;

import com.example.demospring.taskmanagement.model.*;
import com.example.demospring.taskmanagement.model.enumTask.EPriority;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksResponse {
    private Long taskId;
    private String title;
    private String description;
    private EPriority priority;
    private LocalDate dueDate;
    private Project project;
    private List<Tags> tags;
    private List<SubTask> subTasks;
    private List<Comments> comments;

}
