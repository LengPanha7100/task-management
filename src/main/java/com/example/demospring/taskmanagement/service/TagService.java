package com.example.demospring.taskmanagement.service;

import com.example.demospring.taskmanagement.model.Tags;
import com.example.demospring.taskmanagement.model.request.TagRequest;

import java.util.List;

public interface TagService {
    List<Tags> getAllTags();



    Tags createTag(TagRequest tagRequest);


    void deleteTagById(Long taskId, Long tagId);

    void assignTagToTask(Long taskId, Long tagId);
}
