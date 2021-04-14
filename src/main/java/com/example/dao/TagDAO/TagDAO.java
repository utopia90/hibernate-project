package com.example.dao.TagDAO;

import com.example.model.Tag;
import com.example.model.TagColor;
import com.example.model.Task;

import java.util.List;

public interface TagDAO {
    List<Tag> findAllFromRepository();

    Tag findTagById(Long id);

    Tag findTagByName(String name);

    String postTagsFromRepository();

    void updateTag(Long id);

    List<Tag> findTagsByColor(TagColor color);
}
