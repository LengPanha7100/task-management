package com.example.demospring.taskmanagement.repository;

import com.example.demospring.taskmanagement.model.Tags;
import com.example.demospring.taskmanagement.model.request.TagRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagRepository {
    @Result(property = "tagId" , column = "tag_id")
    @Select("""
    SELECT * FROM tags;
    """)
    List<Tags> getAllTag();

    @Select("""
    SELECT * FROM tags WHERE tag_id = #{id};
    """)
    @Result(property = "tagId" , column = "tag_id")
    Tags getTagById(Long id);

    @Select("""
    INSERT INTO tags(name)
    VALUES (#{tag.name})
    returning *;
    """)
    @Result(property = "tagId" , column = "tag_id")
    Tags createTag(@Param("tag") TagRequest tagRequest);


    @Delete("""
    DELETE FROM task_tag WHERE tag_id = #{tagId} AND task_id = #{taskId} ;
    """)
    void deleteTagById(Long taskId , Long tagId);

    @Insert("""
    INSERT INTO task_tag(task_id, tag_id) VALUES (#{taskId},#{tagId});
    """)
    void assignTagToTask(Long tagId, Long taskId);
}
