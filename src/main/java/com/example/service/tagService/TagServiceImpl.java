package com.example.service.tagService;

import com.example.dao.TagDAO.TagDAO;
import com.example.dao.taskDAO.TaskDAO;
import com.example.model.Tag;
import com.example.model.TagColor;
import com.example.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    private final TagDAO tagDao;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDao = tagDAO;
    }


    @Override
    public List<Tag> findAllFromRepository() {
        return this.tagDao.findAllFromRepository();
    }

    @Override
    public Tag findTagById(@PathVariable Long id) {
        return this.tagDao.findTagById(id);
    }

    @Override
    public Tag findTagByName(@PathVariable String name) {
        return this.tagDao.findTagByName(name);
    }

    @Override
    public String postTagsFromRepository() {
        return this.tagDao.postTagsFromRepository();
    }

    @Override
    public void updateTagById(@PathVariable Long id) {
        this.tagDao.updateTag(id);
    }

    @Override
    public List<Tag> findTagByColor(@PathVariable TagColor color) {
        return this.tagDao.findTagsByColor(color);
    }
}
