package com.example.service.tagService;

import com.example.model.Tag;
import com.example.model.TagColor;
import com.example.model.Task;

import java.util.List;

public interface TagService {
    List<Tag> findAllFromRepository();

    Tag findTagById(Long id);

    Tag findTagByName(String name);

    String postTagsFromRepository();

    void updateTagById(Long id);

    List<Tag> findTagByColor(TagColor color);
}
