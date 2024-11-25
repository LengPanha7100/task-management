package com.example.demospring.taskmanagement.service.serviceImp;

import com.example.demospring.taskmanagement.exception.NotFoundException;
import com.example.demospring.taskmanagement.model.Tags;
import com.example.demospring.taskmanagement.model.Tasks;
import com.example.demospring.taskmanagement.model.request.TagRequest;
import com.example.demospring.taskmanagement.repository.TagRepository;
import com.example.demospring.taskmanagement.service.TagService;
import com.example.demospring.taskmanagement.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {

    private final TagRepository tagRepository;
    private final TaskService taskService;

    public TagServiceImp(TagRepository tagRepository, TaskService taskService) {
        this.tagRepository = tagRepository;
        this.taskService = taskService;
    }

    @Override
    public List<Tags> getAllTags() {
        return tagRepository.getAllTag();
    }


//    @Override
//    public Tags getTagById(Long id) {
//        Tags tags =tagRepository.getTagById(id);
//        if(tags == null){
//            throw new NotFoundException("Tag id "+id+ " not found");
//        }
//        return tags;
//    }

    @Override
    public Tags createTag(TagRequest tagRequest) {
        return tagRepository.createTag(tagRequest);
    }


    @Override
    public void deleteTagById(Long taskId , Long tagId) {
        Tags tags =tagRepository.getTagById(tagId);
        if(tags == null){
            throw new NotFoundException("Tag id "+tagId+ " not found");
        }
        taskService.getTaskById(taskId);
        tagRepository.deleteTagById(taskId,tagId);
    }

    @Override
    public void assignTagToTask(Long taskId, Long tagId) {
        Tags tags =tagRepository.getTagById(tagId);
        if(tags == null){
            throw new NotFoundException("Tag id "+tagId+ " not found");
        }
        taskService.getTaskById(taskId);
        tagRepository.assignTagToTask(tagId,taskId);
    }
}
