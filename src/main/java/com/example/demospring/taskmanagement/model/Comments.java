package com.example.demospring.taskmanagement.model;

import com.example.demospring.taskmanagement.model.response.TasksResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comments {
    private Long commentId;
    private String content;
    private Tasks tasks;
}
